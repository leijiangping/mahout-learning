package cn.chaohi.recommend.entity;

import cn.chaohi.recommend.entity.Movies;

public class RecommendMovie {
	private Movies movie;
	private float value;
	
	public RecommendMovie(Movies movie, float value){
		this.movie = movie;
		this.value = value;
	}
	
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Movie:\t" + movie.toString() + "\t");
		sb.append("Score:\t" + value);
		return sb.toString();
	}
}
