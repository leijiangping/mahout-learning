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
public class Movies implements Serializable{

	private  Integer  id;
	private  String  name;
	private  String  publishedYear;
	private  String  type;

	public  void  setId(Integer  id){
	  this.id=id;
	}
	
	public  Integer   getId(){
	 return id;
	}
	
	public  void  setName(String  name){
	  this.name=name;
	}
	
	public  String   getName(){
	 return name;
	}
	
	public  void  setPublishedYear(String  publishedYear){
	  this.publishedYear=publishedYear;
	}
	
	public  String   getPublishedYear(){
	 return publishedYear;
	}
	
	public  void  setType(String  type){
	  this.type=type;
	}
	
	public  String   getType(){
	 return type;
	}
} 