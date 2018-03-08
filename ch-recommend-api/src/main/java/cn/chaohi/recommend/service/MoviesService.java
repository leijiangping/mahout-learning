package cn.chaohi.recommend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chaohi.recommend.entity.Movies;
import cn.chaohi.recommend.entity.RecommendMovie;
import cn.chaohi.recommend.mapper.MoviesMapper;

@Service
public class MoviesService {
	
	@Autowired  
	MoviesMapper  mapper;
	
	/**
	 * 
	 * @param movieIDs
	 * @return
	 * @throws Exception
	 */
	public  Map<String, Movies> getMovieMap(List<String> movieIDs) throws Exception{
		Map<String, Movies> moviesMap = new HashMap<String, Movies>();
		List<Movies> list = mapper.findByIds(movieIDs);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Movies movies = (Movies) iterator.next();
			moviesMap.put(String.valueOf(movies.getId()), movies);
		}
		return moviesMap;
	}
	
	public List<RecommendMovie> getRecommendMovieList(List<RecommendedItem> items) throws Exception{
		List<RecommendMovie> recommendMovies = new ArrayList<RecommendMovie>();
		List<String> movieIDList = new ArrayList<String>();
		for (RecommendedItem item : items){
			movieIDList.add(String.valueOf(item.getItemID()));
		}
		if(movieIDList.size()>0) {
			Map<String, Movies> movies =getMovieMap(movieIDList);
			for (RecommendedItem item : items){
				String movieID = String.valueOf(item.getItemID());
				Movies movie = movies.get(movieID);
				if(movie != null){
					RecommendMovie rm = new RecommendMovie(movie, item.getValue());
					recommendMovies.add(rm);
				}
			}
		}
		return recommendMovies;
	}
}
