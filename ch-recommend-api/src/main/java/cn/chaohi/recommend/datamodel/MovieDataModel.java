package cn.chaohi.recommend.datamodel;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

public class MovieDataModel extends MySQLJDBCDataModel{
	
	public final static String PERFERENCETABLE = "movie_preferences";
	public final static String USERID_COLUMN = "userID";
	public final static String ITEMID_COLUMN = "movieID";
	public final static String PERFERENCE_COLUMN = "preference";
	public final static String TIMESTAMP_COLUMN ="timestamp";
	
	public MovieDataModel(DataSource dataSource, String preferenceTable, String userIDColumn, String itemIDColumn,
			String preferenceColumn, String timestampColumn) {
		super(dataSource, preferenceTable, userIDColumn, itemIDColumn, preferenceColumn, timestampColumn);
	}

	public MovieDataModel() throws TasteException {
		super();
	}

	public MovieDataModel(DataSource dataSource) {
		super(dataSource);
	}

	public MovieDataModel(String dataSourceName) throws TasteException {
		super(dataSourceName);
	}
	
}
