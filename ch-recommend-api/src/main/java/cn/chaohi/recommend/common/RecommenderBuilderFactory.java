/**
 * 
 */
package cn.chaohi.recommend.common;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.recommender.ClusterSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.TreeClusteringRecommender;
import org.apache.mahout.cf.taste.impl.recommender.knn.KnnItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.knn.Optimizer;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.Factorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author Administrator
 *
 */
public class RecommenderBuilderFactory {
    /**
     * 基于用户的推荐模型
     */
    public static RecommenderBuilder userRecommender(final UserSimilarity us, final UserNeighborhood un, boolean pref) throws TasteException {
        return pref ? model -> new GenericUserBasedRecommender(model, un, us) : model -> new GenericBooleanPrefUserBasedRecommender(model, un, us);
    }

    /**
     * 基于物品的推荐模型
     */
    public static RecommenderBuilder itemRecommender(final ItemSimilarity is, boolean pref) throws TasteException {
        return pref ? model -> new GenericItemBasedRecommender(model, is) : model -> new GenericBooleanPrefItemBasedRecommender(model, is);
    }

    public static RecommenderBuilder slopeOneRecommender() throws TasteException {
        return dataModel -> new SlopeOneRecommender(dataModel);
    }

    public static RecommenderBuilder svdRecommender(final Factorizer factorizer) throws TasteException {
        return dataModel -> new SVDRecommender(dataModel, factorizer);
    }

    public static RecommenderBuilder itemKNNRecommender(final ItemSimilarity is, final Optimizer op, final int n) throws TasteException {
        return dataModel -> new KnnItemBasedRecommender(dataModel, is, op, n);
    }

    public static RecommenderBuilder treeClusterRecommender(final ClusterSimilarity cs, final int n) throws TasteException {
        return dataModel -> new TreeClusteringRecommender(dataModel, cs, n);
    }
    
    public static  Recommender  getRecommender(String recommenderClassName) throws TasteException {
        if (recommenderClassName == null) {
          throw new IllegalArgumentException("Recommender class name is null");
        }
        try {
          Recommender recommender = Class.forName(recommenderClassName).asSubclass(Recommender.class).newInstance();
          return recommender;
        } catch (ClassNotFoundException cnfe) {
          throw new TasteException(cnfe);
        } catch (InstantiationException ie) {
          throw new TasteException(ie);
        } catch (IllegalAccessException iae) {
          throw new TasteException(iae);
        }
      }
}
