package com.curryblur.rpgtool.weapon;

import java.util.*;

public class WeaponFactory {
	private static Random r = new Random();

	public static Weapon getWeapon() {
		WeaponType type = getType();
		String name = getName(type);
		int min, max;
		while(true){
			min = r.nextInt((type.getMaxDamage()-type.getMinDamage())/2)+type.getMinDamage();
			max = type.getMaxDamage() - r.nextInt((type.getMaxDamage()-type.getMinDamage())/2);
			if(min<max){
				break;
			}
		}
		return new Weapon(min, max ,type, name);
	}

	public static WeaponType getType() {
		int randType = r.nextInt(9);
		switch (randType) {
		case 0:
			return WeaponType.BOW;
		case 1:
			return WeaponType.BROADSWORD;
		case 2:
			return WeaponType.ICESTAFF;
		case 3:
			return WeaponType.SWORD;
		case 4:
			return WeaponType.WARAXE;
		case 5:
			return WeaponType.HAMMER;
		case 6:
			return WeaponType.EARTHSTAFF;
		case 7:
			return WeaponType.ENCHANTEDBOW;
		case 8:
			return WeaponType.MACHETE;
		case 9:
			return WeaponType.HALBERD;
		default:
			return WeaponType.BOW;
		}
	}
	
	public static String getName(WeaponType type){
		String[] prefixes = {"Great ", "Immaculate ", "Powerful ", "Wonderful ", "Unbreakable ",
				"Magical ", "Mystic ", "Mysterious ", "Amazing "};
		String[] postfixes = {" Smashing", " Power", " Destruction", " Wonderment", " Annihilation",
				" Slaughter", " Carnage", " Ruin", " Lightning"};
		int pre = r.nextInt(9);
		int post = r.nextInt(9);
		String name = prefixes[pre];
		
		switch(type){
		case BOW: 
			name += "Bow ";
			break;
		case BROADSWORD: 
			name += "Broadsword ";
			break;
		case ICESTAFF: 
			name += "Ice Staff ";
			break;
		case SWORD: 
			name += "Sword ";
			break;
		case WARAXE: 
			name += "War Axe ";
			break;
		case HAMMER: 
			name += "War Hammer ";
			break;
		case EARTHSTAFF: 
			name += "Earth Staff ";
			break;
		case ENCHANTEDBOW: 
			name += "Enchanted Bow ";
			break;
		case MACHETE: 
			name += "Machete ";
			break;
		case HALBERD: 
			name += "Halberd ";
			break;
		default:
			name += "Bow ";
		}
		name += "of" + postfixes[post];
		return name;
	}
}
