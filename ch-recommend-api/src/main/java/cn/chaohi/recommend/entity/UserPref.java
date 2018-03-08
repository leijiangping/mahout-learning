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
public class UserPref implements Serializable{

	private  Integer  id;
	private  Integer  userId;
	private  Integer  itemId;
	private  Integer  actionType;
	private  Integer  preference;

	public  void  setId(Integer  id){
	  this.id=id;
	}
	
	public  Integer   getId(){
	 return id;
	}
	
	public  void  setUserId(Integer  userId){
	  this.userId=userId;
	}
	
	public  Integer   getUserId(){
	 return userId;
	}
	
	public  void  setItemId(Integer  itemId){
	  this.itemId=itemId;
	}
	
	public  Integer   getItemId(){
	 return itemId;
	}
	
	public  void  setActionType(Integer  actionType){
	  this.actionType=actionType;
	}
	
	public  Integer   getActionType(){
	 return actionType;
	}
	
	public  void  setPreference(Integer  preference){
	  this.preference=preference;
	}
	
	public  Integer   getPreference(){
	 return preference;
	}
	
} 