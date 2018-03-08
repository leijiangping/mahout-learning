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
public class OrderBy implements Serializable{

	private  Integer  id;
	private  Integer  itemId;
	private  Integer  orderType;

	public  void  setId(Integer  id){
	  this.id=id;
	}
	
	public  Integer   getId(){
	 return id;
	}
	
	public  void  setItemId(Integer  itemId){
	  this.itemId=itemId;
	}
	
	public  Integer   getItemId(){
	 return itemId;
	}
	
	public  void  setOrderType(Integer  orderType){
	  this.orderType=orderType;
	}
	
	public  Integer   getOrderType(){
	 return orderType;
	}
	
} 