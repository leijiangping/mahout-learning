/**
 * 
 */
package cn.chaohi.recommend.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chaohi.recommend.common.NEIGHBORHOOD;
import cn.chaohi.recommend.common.NeighborhoodHelp;
import cn.chaohi.recommend.common.RecommenderBuilderFactory;
import cn.chaohi.recommend.common.SIMILARITY;
import cn.chaohi.recommend.common.SimilarityHelp;
import cn.chaohi.recommend.datamodel.MovieDataModel;

/**
 * @author Administrator
 *
 */
@Service
public class RecommendService {
	
	@Autowired  DataSource  dataSource;
	
	private static final int K = 2;
	

	public List<RecommendedItem> baseUserCFRecommend(long useId, int howMany) throws TasteException {
		DataModel dataModel=new MovieDataModel(dataSource, MovieDataModel.PERFERENCETABLE, MovieDataModel.USERID_COLUMN, MovieDataModel.ITEMID_COLUMN, MovieDataModel.PERFERENCE_COLUMN, MovieDataModel.TIMESTAMP_COLUMN);
		// 1,计算相似度,这里采用皮尔森相关度
        UserSimilarity userSimilarity = SimilarityHelp.userSimilarity(SIMILARITY.PEARSON,dataModel);
		// 2,查找k紧邻
		UserNeighborhood neighborhood =NeighborhoodHelp.userNeighborhood(NEIGHBORHOOD.NEAREST,userSimilarity, dataModel,K);
		// 3,构造推荐引擎
		Recommender recommender =RecommenderBuilderFactory.userRecommender(userSimilarity,neighborhood, false).buildRecommender(dataModel);
		// 4,为用户userId推荐howMany个Item
		return recommender.recommend(useId, howMany);
	}


	public List<RecommendedItem> baseItemCFRecommend(long useId, int howMany) throws TasteException {
		DataModel dataModel=new MovieDataModel(dataSource, MovieDataModel.PERFERENCETABLE, MovieDataModel.USERID_COLUMN, MovieDataModel.ITEMID_COLUMN, MovieDataModel.PERFERENCE_COLUMN, MovieDataModel.TIMESTAMP_COLUMN);
		// 1,计算相似度,这里采用皮尔森相关度
        ItemSimilarity itemSimilarity = SimilarityHelp.itemSimilarity(SIMILARITY.EUCLIDEAN,dataModel);
		// 2,构造推荐引擎
		Recommender recommender =RecommenderBuilderFactory.itemRecommender(itemSimilarity, false).buildRecommender(dataModel);
		// 3,为用户userId推荐howMany个Item
		return recommender.recommend(useId, howMany);
	}
	
	public List<RecommendedItem> slopeOneRecommender(long useId, int howMany) throws TasteException {
		DataModel dataModel=new MovieDataModel(dataSource, MovieDataModel.PERFERENCETABLE, MovieDataModel.USERID_COLUMN, MovieDataModel.ITEMID_COLUMN, MovieDataModel.PERFERENCE_COLUMN, MovieDataModel.TIMESTAMP_COLUMN);
		// 1,构造推荐引擎
		Recommender recommender =RecommenderBuilderFactory.slopeOneRecommender().buildRecommender(dataModel);
		// 2,为用户userId推荐howMany个Item
		return recommender.recommend(useId, howMany);
	}

}
