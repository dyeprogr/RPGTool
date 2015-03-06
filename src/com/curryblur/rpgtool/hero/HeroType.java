package com.curryblur.rpgtool.hero;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum HeroType {
	ARCHER(
			"Archer",
			"Female",
			"Art/Heroes/Archer.png",
			5,
			20,
			35,
			10),
	BERSERKER(
			"Berserker",
			"Male",
			"Art/Heroes/Berserker.png",
			25,
			35,
			15,
			5),
	ENCHANTRESS(
			"Enchantress",
			"Female",
			"Art/Heroes/Enchantress.png",
			5,
			15,
			15,
			35),
	KNIGHT(
			"Knight",
			"Male",
			"Art/Heroes/Knight.png",
			20,
			30,
			25,
			10),
	ROGUE(
			"Rogue",
			"Female",
			"Art/Heroes/Rogue.png",
			10,
			20,
			30,
			15),
	SWORDSMAN(
			"Swordsman",
			"Male",
			"Art/Heroes/Swordsman.png",
			25,
			25,
			25,
			15),
	WARRIOR(
			"Warrior",
			"Male",
			"Art/Heroes/Warrior.png",
			35,
			35,
			25,
			5),
	WIZARD(
			"Wizard",
			"Male",
			"Art/Heroes/Wizard.png",
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
		File file;
		BufferedImage img;
		file = new File(this.filePath);

		try {
			img = ImageIO.read(file);
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
