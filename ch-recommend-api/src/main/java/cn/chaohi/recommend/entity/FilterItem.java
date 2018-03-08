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
public class FilterItem implements Serializable{

	private  Integer  id;

	public  void  setId(Integer  id){
	  this.id=id;
	}
	
	public  Integer   getId(){
	 return id;
	}
	
} 