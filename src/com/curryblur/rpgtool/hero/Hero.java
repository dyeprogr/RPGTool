package com.curryblur.rpgtool.hero;

import java.awt.image.BufferedImage;

public class Hero {
	private HeroType type;
	private String name;
	
	public Hero(HeroType type, String name){
		this.type = type;
		this.name = name;
	}
	
	public HeroType getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getHeroClass(){
		return this.type.getHeroClass();
	}
	
	public String getGender(){
		return this.type.getGender();
	}
	
	public BufferedImage getImage(){
		return this.type.getImage();
	}
	
	public int getStrength(){
		return this.type.getStr();
	}
	
	public int getHealth(){
		return this.type.getHP();
	}
	
	public int getDexterity(){
		return this.type.getDex();
	}
	
	public int getIntelligence(){
		return this.type.getInt();
	}
}
