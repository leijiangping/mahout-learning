package cn.chaohi.recommend.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.chaohi.recommend.entity.RecommendMovie;
import cn.chaohi.recommend.service.MoviesService;
import cn.chaohi.recommend.service.RecommendService;

/**
 * Created by leijp 
 */
@RestController
@RequestMapping("/api/recommend")
public class RecommendController{

    private Logger logger = Logger.getLogger(RecommendController.class);

    @Autowired
    private RecommendService recommenderService;
    
    @Autowired
    private MoviesService moviesService;
    
   
    @RequestMapping(value="/getRecommendListBaseUserCF",method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRecommendListBaseUserCF(
    		@RequestParam(value = "userid", required = true) long useId,
    		@RequestParam(value = "howMany", required = true) int howMany) throws Exception{
    	List<RecommendedItem> items = recommenderService.baseUserCFRecommend(useId, howMany);
    	List<RecommendMovie> movieList =moviesService.getRecommendMovieList(items);
        Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", movieList);
		result.put("result_code","0");
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value="/getRecommendListBaseItemCF",method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRecommendListBaseItemCF(
    		@RequestParam(value = "userid", required = true) long useId,
    		@RequestParam(value = "howMany", required = true) int howMany) throws Exception{
    	List<RecommendedItem> items = recommenderService.baseItemCFRecommend(useId, howMany);
    	List<RecommendMovie> movieList =moviesService.getRecommendMovieList(items);
        Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", movieList);
		result.put("result_code","0");
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value="/getRecommendListSlopeOne",method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRecommendListSlopeOne(
    		@RequestParam(value = "userid", required = true) long useId,
    		@RequestParam(value = "howMany", required = true) int howMany) throws Exception{
    	List<RecommendedItem> items = recommenderService.slopeOneRecommender(useId, howMany);
    	List<RecommendMovie> movieList =moviesService.getRecommendMovieList(items);
        Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", movieList);
		result.put("result_code","0");
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
