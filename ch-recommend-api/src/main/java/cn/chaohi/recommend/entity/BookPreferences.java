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
public class BookPreferences implements Serializable{

	private  Integer  userId;
	private  Integer  bookId;
	private  Integer  preference;
	private  Integer  timestamp;

	public  void  setUserId(Integer  userId){
	  this.userId=userId;
	}
	
	public  Integer   getUserId(){
	 return userId;
	}
	
	public  void  setBookId(Integer  bookId){
	  this.bookId=bookId;
	}
	
	public  Integer   getBookId(){
	 return bookId;
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