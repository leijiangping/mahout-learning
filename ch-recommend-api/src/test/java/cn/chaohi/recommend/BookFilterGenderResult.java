package cn.chaohi.recommend;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.FastIDSet;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.IDRescorer;

import cn.chaohi.recommend.common.DataModelHelp;
import cn.chaohi.recommend.common.RecommendResultHelp;

public class BookFilterGenderResult {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static void main(String[] args) throws TasteException, IOException {
    	String basePath= System.getProperty("user.dir");
        String file = "/datafile/book/rating.csv";
        DataModel dataModel = DataModelHelp.buildDataModel(basePath+file);
        RecommenderBuilder rb1 = BookEvaluator.userEuclidean(dataModel);
        RecommenderBuilder rb2 = BookEvaluator.itemEuclidean(dataModel);
        RecommenderBuilder rb3 = BookEvaluator.userEuclideanNoPref(dataModel);
        RecommenderBuilder rb4 = BookEvaluator.itemEuclideanNoPref(dataModel);
        
        long uid =2;
        System.out.print("userEuclidean       =>");
        filterGender(uid, rb1, dataModel);
        System.out.print("itemEuclidean       =>");
        filterGender(uid, rb2, dataModel);
        System.out.print("userEuclideanNoPref =>");
        filterGender(uid, rb3, dataModel);
        System.out.print("itemEuclideanNoPref =>");
        filterGender(uid, rb4, dataModel);
    }

    /**
     * 对用户性别进行过滤
     */
    public static void filterGender(long uid, RecommenderBuilder recommenderBuilder, DataModel dataModel) throws TasteException, IOException {
    	String basePath= System.getProperty("user.dir");
    	Set<Long> userids = getMale(basePath+"/datafile/book/user.csv");

        //计算男性用户打分过的图书
        Set bookids = new HashSet();
    	LongPrimitiveIterator scored_uids= dataModel.getUserIDs();
    	while (scored_uids.hasNext()) {
    		 long scored_uid = scored_uids.next();
    		 if(userids.contains(scored_uid)) {
    			 LongPrimitiveIterator iter= dataModel.getItemIDsFromUser(scored_uid).iterator();
    			 while (iter.hasNext()) {
    				 long bookid = iter.next();
    				 bookids.add(bookid);
    			 }
    		 }
    	}
    	System.out.println("------------------------------------------");
        IDRescorer rescorer = new FilterRescorer(bookids);
        List list = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM, rescorer);
        RecommendResultHelp.showItems(uid, list, false);
    }

    /**
     * 获得男性用户ID
     */
    public static Set<Long> getMale(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        Set<Long> userids = new HashSet<Long>();
        String s = null;
        while ((s = br.readLine()) != null) {
            String[] cols = s.split(",");
            if (cols[1].equals("M")) {// 推断男性用户
                userids.add(Long.parseLong(cols[0]));
            }
        }
        br.close();
        return userids;
    }

}

/**
* 对结果重计算
*/
class FilterRescorer implements IDRescorer {
    final private Set userids;

    public FilterRescorer(Set userids) {
        this.userids = userids;
    }

    @Override
    public double rescore(long id, double originalScore) {
        return isFiltered(id) ? Double.NaN : originalScore;
    }

    @Override
    public boolean isFiltered(long id) {
        return userids.contains(id);
    }
}