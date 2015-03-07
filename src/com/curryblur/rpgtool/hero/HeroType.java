package com.curryblur.rpgtool.hero;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum HeroType {
	ARCHER(
			"Archer",
			"Female",
			"/Archer.png",
			5,
			20,
			35,
			10),
	BERSERKER(
			"Berserker",
			"Male",
			"/Berserker.png",
			25,
			35,
			15,
			5),
	ENCHANTRESS(
			"Enchantress",
			"Female",
			"/Enchantress.png",
			5,
			15,
			15,
			35),
	KNIGHT(
			"Knight",
			"Male",
			"/Knight.png",
			20,
			30,
			25,
			10),
	ROGUE(
			"Rogue",
			"Female",
			"/Rogue.png",
			10,
			20,
			30,
			15),
	SWORDSMAN(
			"Swordsman",
			"Male",
			"/Swordsman.png",
			25,
			25,
			25,
			15),
	WARRIOR(
			"Warrior",
			"Male",
			"/Warrior.png",
			35,
			35,
			25,
			5),
	WIZARD(
			"Wizard",
			"Male",
			"/Wizard.png",
			5,
			15,
			15,
			45);

	private String heroClass;
	private String gender;
	private String filePath;
	private BufferedImage img;
	private int Str, HP, Dex, Int;
	
	
	private HeroType(String heroClass, String gender, String filePath,
			int Str, int HP, int Dex, int Int) {
		this.heroClass = heroClass;
		this.gender = gender;
		this.filePath = filePath;
		this.Str = Str;
		this.HP = HP;
		this.Dex = Dex;
		this.Int = Int;
		this.img = loadImage();
	}
	
	private BufferedImage loadImage() {
		BufferedImage img;

		try {
			img = ImageIO.read(getClass().getResource(this.filePath));
		} catch (IOException e) {
			System.out.println("Unable to load file");
			img = null;
		}

		return img;
	}
	
	public String getHeroClass(){
		return this.heroClass;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public BufferedImage getImage(){
		return this.img;
	}
	
	public int getStr(){
		return this.Str;
	}
	
	public int getHP(){
		return this.HP;
	}
	
	public int getDex(){
		return this.Dex;
	}
	
	public int getInt(){
		return this.Int;
	}
}
