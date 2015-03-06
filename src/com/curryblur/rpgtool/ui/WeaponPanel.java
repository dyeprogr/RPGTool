package com.curryblur.rpgtool.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.curryblur.rpgtool.hero.HeroType;
import com.curryblur.rpgtool.weapon.Weapon;
import com.curryblur.rpgtool.weapon.WeaponFactory;

public class WeaponPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton newWeapon;
	BufferedImage Img1;
	Weapon weapon;
	JLabel labelName, labelDesc, labelDamage, 
		labelTitle, labelHeroes;
	ImagePanel imgPanel1;
	
	public WeaponPanel(){
		//set up initial status
		UIManager.put("Label.font", new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 20));
		weapon = WeaponFactory.getWeapon();
		labelTitle = new JLabel("Weapon Generator");
		labelTitle.setFont(new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 25));

		//set initial labels
		labelName = new JLabel("Name: " + weapon.getName());
		labelDesc = new JLabel(weapon.getDesc());
		labelDamage= new JLabel("Damage: " + weapon.getMinDamage() + 
				" - " + weapon.getMaxDamage());
		String heroString = getHeroesString(weapon);
		labelHeroes = new JLabel(heroString);
		
		labelName.setForeground(Color.white);
		labelDesc.setForeground(Color.white);
		labelDamage.setForeground(Color.white);
		labelHeroes.setForeground(Color.white);
		labelTitle.setForeground(Color.white);
		
		//get hero Img
		Img1 = weapon.getImage();
		imgPanel1 = new ImagePanel(Img1, Color.DARK_GRAY, 0);
		
		//get dice button ready
		newWeapon = new JButton("New Weapon!");
		newWeapon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				resetWeapon();
			}
		});
		
		//set overall layout
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setBackground(Color.DARK_GRAY);
			
		c.weightx = 2;
		c.weighty = 2;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.CENTER;
		this.add(labelTitle,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 3;
		c.gridwidth=1;
		c.fill = GridBagConstraints.WEST;
		this.add(imgPanel1, c);
		
		c.anchor = GridBagConstraints.WEST;
		c.gridheight = 1;
		c.gridx = 1;
		c.gridx = 1;
		this.add(labelName, c);
		
		c.gridy = 2;
		c.gridx = 1;
		this.add(labelDesc, c);
		
		c.gridy = 3;
		this.add(labelDamage, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.fill = GridBagConstraints.CENTER;
		this.add(labelHeroes, c);
		
		c.gridy = 5;
		c.gridx = 0;
		c.gridwidth = 2;
		c.fill=GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		this.add(newWeapon, c);
	}
	
	private void resetWeapon(){
		this.weapon = WeaponFactory.getWeapon();
		updateLabels();
		updateImage();
	}
	
	private void updateLabels(){
		labelName.setText("Name: " + weapon.getName());
		labelDesc.setText(weapon.getDesc());
		labelDamage.setText("Damage: " + weapon.getMinDamage() + 
				" - " + weapon.getMaxDamage());
		String heroString = getHeroesString(weapon);
		labelHeroes.setText(heroString);
	}
	
	private void updateImage(){
		Img1 = weapon.getImage();
		imgPanel1.setImg(Img1);
		imgPanel1.repaint();
	}
	
	private String getHeroesString(Weapon weapon){
		String returnString = "Used by: ";
		ArrayList<HeroType> heroList = weapon.getHeroes();
		for(int i = 0; i < heroList.size(); i++){
			returnString += heroList.get(i).getHeroClass();
			if(i==heroList.size()-1){
				break;
			} else {
				returnString += ", ";
			}
		}
		return returnString;
	}
}
