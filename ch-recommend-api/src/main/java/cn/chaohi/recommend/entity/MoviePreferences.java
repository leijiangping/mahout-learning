package cn.chaohi.recommend.entity;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
/**
 * 实体定义
 * @author leijp
 *
 */
public class MoviePreferences implements Serializable{

	private  Integer  userid;
	private  Integer  movieid;
	private  Integer  preference;
	private  Integer  timestamp;

	public  void  setUserid(Integer  userid){
	  this.userid=userid;
	}
	
	public  Integer   getUserid(){
	 return userid;
	}
	
	public  void  setMovieid(Integer  movieid){
	  this.movieid=movieid;
	}
	
	public  Integer   getMovieid(){
	 return movieid;
	}
	
	public  void  setPreference(Integer  preference){
	  this.preference=preference;
	}
	
	public  Integer   getPreference(){
	 return preference;
	}
	
	public  void  setTimestamp(Integer  timestamp){
	  this.timestamp=timestamp;
	}
	
	public  Integer   getTimestamp(){
	 return timestamp;
	}
	
} 