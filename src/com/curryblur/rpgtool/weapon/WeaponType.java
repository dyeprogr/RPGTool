/**
 * 
 */
package com.curryblur.rpgtool.weapon;


/**
 * @author Cory
 *
 */

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import com.curryblur.rpgtool.hero.*;

public enum WeaponType {

	BOW(
			3,
			15,
			"A sturdy bow, perfect for ranged battles",
			"/bow.png",
			HeroType.ARCHER,
			HeroType.WARRIOR,
			HeroType.ROGUE),
	BROADSWORD(
			10,
			30,
			"A two-handed sword, heavy but powerful",
			"/broadsword.png",
			HeroType.BERSERKER,
			HeroType.KNIGHT,
			HeroType.SWORDSMAN,
			HeroType.WARRIOR),
	ICESTAFF(
			8,
			25,
			"A staff imbued with frosty magic",
			"/icestaff.png",
			HeroType.ENCHANTRESS,
			HeroType.WIZARD),
	SWORD(
			8,
			20,
			"A one-handed sword, perfect for use with a shield",
			"/machete.png",
			HeroType.ROGUE,
			HeroType.WARRIOR,
			HeroType.SWORDSMAN,
			HeroType.KNIGHT),
	WARAXE(
			15,
			25,
			"A large axe, a favorite of the dwarves",
			"/waraxe.png",
			HeroType.WARRIOR,
			HeroType.BERSERKER),
	HAMMER(
			20,
			40,
			"A battle hammer, unwieldy but devastating",
			"/battlehammer.png",
			HeroType.BERSERKER,
			HeroType.WARRIOR),
	EARTHSTAFF(
			10,
			20,
			"An earthstaff, imbued with earth magic",
			"/earthstaff.png",
			HeroType.ENCHANTRESS,
			HeroType.WIZARD),
	ENCHANTEDBOW(
			8,
			20,
			"An enchanted bow, created by elves",
			"/enchantedbow.png",
			HeroType.ARCHER,
			HeroType.ROGUE),
	MACHETE(
			5,
			10,
			"A machete, quick and useful for stealthy heroes",
			"/machete.png",
			HeroType.ROGUE),
	HALBERD(
			15,
			25,
			"A halberd, useful for dealing damage at medium range",
			"/silverhalberd.png",
			HeroType.WARRIOR,
			HeroType.BERSERKER);

	private BufferedImage img;
	private int minDamage;
	private int maxDamage;
	private String desc;
	private String filepath;
	private ArrayList<HeroType> heroes;

	WeaponType(int minDamage, int maxDamage, String desc, String filepath,
			HeroType... heroes) {
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.desc = desc;
		this.filepath = filepath;
		this.heroes = new ArrayList<HeroType>();
		for (HeroType h : Arrays.asList(heroes)) {
			this.heroes.add(h);
		}
		img = loadImage();
	}

	private BufferedImage loadImage() {
		BufferedImage img;

		try {
			img = ImageIO.read(getClass().getResource(filepath));
		} catch (IOException e) {
			System.out.println("Unable to load file");
			img = null;
		}

		return img;
	}

	public BufferedImage getImage() {
		return this.img;
	}

	public int getMinDamage() {
		return this.minDamage;
	}

	public int getMaxDamage() {
		return this.maxDamage;
	}

	public String getDesc() {
		return this.desc;
	}

	public ArrayList<HeroType> getHeroes() {
		return this.heroes;
	}
}
