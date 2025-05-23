package com.example.Joblisting.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public class Post {
	private String profile;
	private String desc;
	private int exp;
	private String techs[];
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] tech) {
		this.techs = tech;
	}
	public Post() {
		
	}
	public Post(String profile, String desc, int exp, String[] tech) {
		super();
		this.profile = profile;
		this.desc = desc;
		this.exp = exp;
		this.techs = tech;
	}
	@Override
	public String toString() {
		return "Post [profile=" + profile + ", desc=" + desc + ", exp=" + exp + ", tech=" + Arrays.toString(techs) + "]";
	}
	

}
