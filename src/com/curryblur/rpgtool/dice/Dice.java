package com.curryblur.rpgtool.dice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dice {
	private int number;
	private BufferedImage img;
	private int sides;
	
	public Dice(int sides){
		this.sides = sides;
		this.number = getNum(sides);
		this.img = loadImage(number);
	}
	
	public void reset(){
		this.number = getNum(this.sides);
		this.img = loadImage(number);
	}
	
	private int getNum(int sides){
		return (int)(Math.random()*sides)+1;
	}
	
	public BufferedImage getImage(){
		return this.img;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	private BufferedImage loadImage(int number) {
		File file;
		BufferedImage img;
		
		//check for bad inputs, no image for these numbers
		if(number > 6){
			number = 6;
		} else if (number < 1){
			number = 1;
		}
		
		//images are numbers 1-6
		String filepath = "Art/dado-" + number + ".png";
		file = new File(filepath);
		
		//load the file
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Unable to load file");
			img = null;
		}

		return img;
	}
	
}
