/**
 * 
 */
package cn.chaohi.recommend;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import cn.chaohi.recommend.common.DataModelHelp;
import cn.chaohi.recommend.common.EVALUATOR;
import cn.chaohi.recommend.common.EvaluatorHelp;
import cn.chaohi.recommend.common.NEIGHBORHOOD;
import cn.chaohi.recommend.common.NeighborhoodHelp;
import cn.chaohi.recommend.common.RecommenderBuilderFactory;
import cn.chaohi.recommend.common.SIMILARITY;
import cn.chaohi.recommend.common.SimilarityHelp;

public class BookEvaluator {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static RecommenderBuilder userEuclidean(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclidean");
        UserSimilarity userSimilarity = SimilarityHelp.userSimilarity(SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = NeighborhoodHelp.userNeighborhood(NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.userRecommender(userSimilarity, userNeighborhood, true);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }
    
    public static RecommenderBuilder userLoglikelihood(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userLoglikelihood");
        UserSimilarity userSimilarity = SimilarityHelp.userSimilarity(SIMILARITY.LOGLIKELIHOOD, dataModel);
        UserNeighborhood userNeighborhood = NeighborhoodHelp.userNeighborhood(NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.userRecommender(userSimilarity, userNeighborhood, true);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }
    
    public static RecommenderBuilder userEuclideanNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclideanNoPref");
        UserSimilarity userSimilarity = SimilarityHelp.userSimilarity(SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = NeighborhoodHelp.userNeighborhood(NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.userRecommender(userSimilarity, userNeighborhood, false);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }

    public static RecommenderBuilder itemEuclidean(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemEuclidean");
        ItemSimilarity itemSimilarity = SimilarityHelp.itemSimilarity(SIMILARITY.EUCLIDEAN, dataModel);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.itemRecommender(itemSimilarity, true);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }

    public static RecommenderBuilder itemLoglikelihood(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemLoglikelihood");
        ItemSimilarity itemSimilarity = SimilarityHelp.itemSimilarity(SIMILARITY.LOGLIKELIHOOD, dataModel);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.itemRecommender(itemSimilarity, true);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }
    
    public static RecommenderBuilder itemEuclideanNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemEuclideanNoPref");
        ItemSimilarity itemSimilarity = SimilarityHelp.itemSimilarity(SIMILARITY.EUCLIDEAN, dataModel);
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.itemRecommender(itemSimilarity, false);

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }

    public static RecommenderBuilder slopeOne(DataModel dataModel) throws TasteException, IOException {
        System.out.println("slopeOne");
        RecommenderBuilder recommenderBuilder = RecommenderBuilderFactory.slopeOneRecommender();

        EvaluatorHelp.evaluate(EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        EvaluatorHelp.statsEvaluator(recommenderBuilder, null, dataModel, 2);
        return recommenderBuilder;
    }
}