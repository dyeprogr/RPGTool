package com.curryblur.rpgtool.hero;

import java.util.Random;

import com.curryblur.rpgtool.hero.Hero;
import com.curryblur.rpgtool.hero.HeroType;

public class HeroFactory {
	private static Random r = new Random();

	public static Hero getHero() {
		HeroType type = getType();
		String name = getName(type);

		// output a new random hero
		return new Hero(type, name);
	}

	public static HeroType getType() {
		// get a random HeroType
		int randType = r.nextInt(8);
		switch (randType) {
		case 0:
			return HeroType.ARCHER;
		case 1:
			return HeroType.BERSERKER;
		case 2:
			return HeroType.ENCHANTRESS;
		case 3:
			return HeroType.KNIGHT;
		case 4:
			return HeroType.ROGUE;
		case 5:
			return HeroType.SWORDSMAN;
		case 6:
			return HeroType.WARRIOR;
		case 7:
			return HeroType.WIZARD;
		default:
			return HeroType.ARCHER;
		}
	}

	public static String getName(HeroType type) {
		String name;
		String[] maleNames = { "Trogdor ", "Thomas ", "Arthur ", "Phillip ",
				"Maximus ", "Vladimir ", "Grawg ", "Severus ", "Wheatley " };
		String[] femaleNames = { "Eliana ", "Jessica ", "Marie ", "Lisa ",
				"Stacey ", "Elpheba ", "GladOs ", "Tristana ", "Lulu " };
		String[] surNames = { " Brave", " Timid", " Bald", " Younger",
				" Elder", " Valiant", " Villainous", " Plump", " Vicious" };
		if (type.getGender().equalsIgnoreCase("Male")) {
			int male = r.nextInt(9); // add Male first name
			name = maleNames[male];
		} else {
			int female = r.nextInt(9); // add Female first name
			name = femaleNames[female];
		}
		// add suffix
		int sur = r.nextInt(9);
		name += "the" + surNames[sur];
		return name;
	}

}
