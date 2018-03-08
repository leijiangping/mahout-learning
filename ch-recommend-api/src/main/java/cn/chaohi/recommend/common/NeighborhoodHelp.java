/**
 * 
 */
package cn.chaohi.recommend.common;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author Administrator
 *
 */
public class NeighborhoodHelp {
	
	  public static UserNeighborhood userNeighborhood(NEIGHBORHOOD type, UserSimilarity s, DataModel m, double num) throws TasteException {
	        switch (type) {
	            case NEAREST:
	                /**
	                 * 根据数量构建最近的距离
	                 */
	                return new NearestNUserNeighborhood((int) num, s, m);
	            case THRESHOLD:
	            default:
	                /**
	                 * 根据百分比去构建
	                 */
	                return new ThresholdUserNeighborhood(num, s, m);
	        }
	    }
}
