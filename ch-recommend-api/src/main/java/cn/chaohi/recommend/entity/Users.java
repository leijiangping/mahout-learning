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
public class Users implements Serializable{

	private  Integer  id;
	private  String  name;
	private  String  email;

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
	
	public  void  setEmail(String  email){
	  this.email=email;
	}
	
	public  String   getEmail(){
	 return email;
	}
	
} 