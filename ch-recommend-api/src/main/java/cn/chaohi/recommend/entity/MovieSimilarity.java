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
public class MovieSimilarity implements Serializable{

	private  Integer  movieid1;
	private  Integer  movieid2;
	private  Double  similarity;

	public  void  setMovieid1(Integer  movieid1){
	  this.movieid1=movieid1;
	}
	
	public  Integer   getMovieid1(){
	 return movieid1;
	}
	
	public  void  setMovieid2(Integer  movieid2){
	  this.movieid2=movieid2;
	}
	
	public  Integer   getMovieid2(){
	 return movieid2;
	}
	
	public  void  setSimilarity(Double  similarity){
	  this.similarity=similarity;
	}
	
	public  Double   getSimilarity(){
	 return similarity;
	}
	
} 