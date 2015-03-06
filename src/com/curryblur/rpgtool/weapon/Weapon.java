package com.curryblur.rpgtool.weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.curryblur.rpgtool.hero.*;


public class Weapon {
	private  WeaponType type;
	private int minDamage, maxDamage;
	private String name;
	
	public Weapon(int minDamage, int maxDamage, WeaponType type, String name){
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.type = type;
		this.name = name;
	}
	
	public WeaponType getType(){
		return this.type;
	}
	
	public int getMinDamage(){
		return this.minDamage;
	}
	
	public int getMaxDamage(){
		return this.maxDamage;
	}
	
	public String getName(){
		return this.name;
	}
	
	public BufferedImage getImage(){
		return this.type.getImage();
	}
	
	public String getDesc(){
		return this.type.getDesc();
	}
	
	public ArrayList<HeroType> getHeroes(){
		return this.type.getHeroes();
	}
	
}
