package cn.chaohi.recommend;

import java.io.File;
import java.util.List;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import cn.chaohi.recommend.common.NEIGHBORHOOD;
import cn.chaohi.recommend.common.NeighborhoodHelp;
import cn.chaohi.recommend.common.RecommendResultHelp;
import cn.chaohi.recommend.common.RecommenderBuilderFactory;
import cn.chaohi.recommend.common.SIMILARITY;
import cn.chaohi.recommend.common.SimilarityHelp;
public class RecommendTest 
 {
    public static void main( String[] args )
    {
        try {
             // 从文件加载数据
             DataModel model = new FileDataModel(new File("D:\\gitsource\\market\\ch-recommend-task\\datafile\\item.csv"));
            // 指定用户相似度计算方法，这里采用皮尔森相关度
             UserSimilarity similarity = SimilarityHelp.userSimilarity(SIMILARITY.PEARSON,model);
             // 指定用户邻居数量，这里为2
             UserNeighborhood neighborhood =NeighborhoodHelp.userNeighborhood(NEIGHBORHOOD.NEAREST,similarity, model,2);
              // 构建基于用户的推荐系统
             Recommender recommender = RecommenderBuilderFactory.userRecommender(similarity,neighborhood, false).buildRecommender(model);
            // 得到指定用户的推荐结果，这里是得到用户1的两个推荐
           List<RecommendedItem> recommendations = recommender.recommend(1, 2);
           // 打印推荐结果
           RecommendResultHelp.showItems(1, recommendations, false);
         } catch (Exception e) {
             System.out.println(e);
         }        
   }
 }