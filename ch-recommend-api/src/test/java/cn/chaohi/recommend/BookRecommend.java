package cn.chaohi.recommend;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.model.DataModel;

import cn.chaohi.recommend.common.DataModelHelp;
import cn.chaohi.recommend.common.RecommendResultHelp;

public class BookRecommend{

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static void main(String[] args) throws TasteException, IOException {
    	String basePath= System.getProperty("user.dir");
        String file = "/datafile/book/rating.csv";
        DataModel dataModel = DataModelHelp.buildDataModel(basePath+file);
        RecommenderBuilder rb1 = BookEvaluator.userEuclidean(dataModel);
        RecommenderBuilder rb2 = BookEvaluator.userLoglikelihood(dataModel);
        RecommenderBuilder rb3 = BookEvaluator.userEuclideanNoPref(dataModel);
        RecommenderBuilder rb4 = BookEvaluator.itemEuclidean(dataModel);
        RecommenderBuilder rb5 = BookEvaluator.itemLoglikelihood(dataModel);
        RecommenderBuilder rb6 = BookEvaluator.itemEuclideanNoPref(dataModel);
        RecommenderBuilder rb7 = BookEvaluator.slopeOne(dataModel);
        
        LongPrimitiveIterator iter = dataModel.getUserIDs();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            System.out.print("userEuclidean       =>");
            result(uid, rb1, dataModel);
            System.out.print("userLoglikelihood       =>");
            result(uid, rb2, dataModel);
            System.out.print("userEuclideanNoPref =>");
            result(uid, rb3, dataModel);
            System.out.print("itemEuclidean =>");
            result(uid, rb4, dataModel);
            System.out.print("itemLoglikelihood =>");
            result(uid, rb5, dataModel);
            System.out.print("itemEuclideanNoPref =>");
            result(uid, rb6, dataModel);
            System.out.print("slopeOne =>");
            result(uid, rb7, dataModel);
        }
    }

    public static void result(long uid, RecommenderBuilder recommenderBuilder, DataModel dataModel) throws TasteException {
        List list = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
        RecommendResultHelp.showItems(uid, list, false);
    }
}