/**
 * 
 */
package cn.chaohi.recommend.datamodel;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

/**
 * @author Administrator
 *
 */
public class GoodsDataModel extends MySQLJDBCDataModel{
		 
		  
		// 保存用户对电影的评分的数据库表名
		   public final static String PERFERENCETABLE = "movie_preferences";  
		   public final static String USERID_COLUMN = "userID";   // 表中用户标识的列名
		   public final static String ITEMID_COLUMN = "movieID";  // 表中电影标识的列名
		   public final static String PERFERENCE_COLUMN = "preference";  // 表中评分的列名
		 
		   public GoodsDataModel(DataSource dataSource, String preferenceTable, String userIDColumn, String itemIDColumn,
					String preferenceColumn, String timestampColumn) {
				super(dataSource, preferenceTable, userIDColumn, itemIDColumn, preferenceColumn, timestampColumn);
			}
}
