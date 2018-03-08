/**
 * 
 */
package cn.chaohi.recommend.common;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.ClusterSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.FarthestNeighborClusterSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.NearestNeighborClusterSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.SpearmanCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author Administrator
 *
 */
public class SimilarityHelp {
	 /**
     * 构建距离算法类 基於UserCF类
     */
    public static UserSimilarity userSimilarity(SIMILARITY type, DataModel m) throws TasteException {
        switch (type) {
            case PEARSON:
                return new PearsonCorrelationSimilarity(m);   //皮尔森相关度
            case COSINE:
                return new UncenteredCosineSimilarity(m);   //余弦相似度
            case TANIMOTO:
                return new TanimotoCoefficientSimilarity(m);   //Tanimoto系数
            case LOGLIKELIHOOD:
                return new LogLikelihoodSimilarity(m);   //对数似然相似度
            case SPEARMAN:
                return new SpearmanCorrelationSimilarity(m);   //Spearman秩相关系数
            case CITYBLOCK:
                return new CityBlockSimilarity(m);   //曼哈顿距离
            case EUCLIDEAN:
            default:
                return new EuclideanDistanceSimilarity(m);   //欧式距离相似度
        }
    }

    /**
     * 构建距离算法类 基于ItemCF类
     */
    public static ItemSimilarity itemSimilarity(SIMILARITY type, DataModel m) throws TasteException {
        switch (type) {
            case PEARSON:
                return new PearsonCorrelationSimilarity(m);
            case COSINE:
                return new UncenteredCosineSimilarity(m);
            case TANIMOTO:
                return new TanimotoCoefficientSimilarity(m);
            case LOGLIKELIHOOD:
                return new LogLikelihoodSimilarity(m);
            case CITYBLOCK:
                return new CityBlockSimilarity(m);
            case EUCLIDEAN:
            default:
                return new EuclideanDistanceSimilarity(m);
        }
    }

    /**
     * 定义相似度
     */
    public static ClusterSimilarity clusterSimilarity(SIMILARITY type, UserSimilarity us) throws TasteException {
        switch (type) {
            case NEAREST_NEIGHBOR_CLUSTER:
                return new NearestNeighborClusterSimilarity(us);
            case FARTHEST_NEIGHBOR_CLUSTER:
            default:
                return new FarthestNeighborClusterSimilarity(us);
        }
    }
}
