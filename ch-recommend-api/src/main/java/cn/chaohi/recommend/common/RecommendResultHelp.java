/**
 * 
 */
package cn.chaohi.recommend.common;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

/**
 * @author Administrator
 *
 */
public class RecommendResultHelp {
	 /**
     * 打印出推荐输出结果
     */
    public static void showItems(long uid, List<RecommendedItem> recommendations, boolean skip) {
        if (!skip || recommendations.size() > 0) {
            System.out.printf("uid:%s,", uid);
            for (RecommendedItem recommendation : recommendations) {
                System.out.printf("(%s,%f)", recommendation.getItemID(), recommendation.getValue());
            }
            System.out.println();
        }
    }
}
