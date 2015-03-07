package com.curryblur.rpgtool.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.curryblur.rpgtool.hero.Hero;
import com.curryblur.rpgtool.hero.HeroFactory;

public class HeroPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton newHero;
	BufferedImage Img1;
	Hero hero;
	JLabel labelName, labelHeroClass, labelGender, labelStrength, 
		labelTitle, labelIntelligence, labelHealth, labelDexterity;
	ImagePanel imgPanel1;
	
	public HeroPanel(){
		//set up initial status
		UIManager.put("Label.font", new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 20));
		hero = HeroFactory.getHero();
		labelTitle = new JLabel("Hero Generator");
		labelTitle.setFont(new javax.swing.plaf.FontUIResource("Serif", Font.PLAIN, 25));

		//set initial labels
		setInitialLabels();
		
		//get hero Img
		Img1 = hero.getImage();
		imgPanel1 = new ImagePanel(Img1, Color.DARK_GRAY, 0);
		
		//get dice button ready
		newHero = new JButton("New Hero!");
		newHero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				resetHero();
			}
		});
		
		//set overall layout
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setBackground(Color.DARK_GRAY);
		
		setUpLayout(c);
		
	}
	
	private void resetHero(){
		this.hero = HeroFactory.getHero();
		updateLabels();
		updateImage();
	}
	
	private void updateLabels(){
		labelName.setText("Name: " + hero.getName());
		labelHeroClass.setText("Class: " + hero.getHeroClass());
		labelGender.setText("Gender: " + hero.getGender());
		labelStrength.setText("Strength: " + hero.getStrength());
		labelIntelligence.setText("Intelligence: " + hero.getIntelligence());
		labelHealth.setText("Health: " + hero.getHealth());
		labelDexterity.setText("Dexterity: " +  hero.getDexterity());
	}
	
	private void updateImage(){
		Img1 = hero.getImage();
		imgPanel1.setImg(Img1);
		imgPanel1.repaint();
	}
	
	private void setInitialLabels(){
		labelName = new JLabel("Name: " + hero.getName());
		labelHeroClass = new JLabel("Class: " + hero.getHeroClass());
		labelGender= new JLabel("Gender: " + hero.getGender());
		labelStrength = new JLabel("Strength: " + hero.getStrength());
		labelIntelligence = new JLabel("Intelligence: " + hero.getIntelligence());
		labelHealth = new JLabel("Health: " + hero.getHealth());
		labelDexterity = new JLabel("Dexterity: " +  hero.getDexterity());
		labelName.setForeground(Color.white);
		labelHeroClass.setForeground(Color.white);
		labelGender.setForeground(Color.white);
		labelStrength.setForeground(Color.white);
		labelIntelligence.setForeground(Color.white);
		labelHealth.setForeground(Color.white);
		labelDexterity.setForeground(Color.white);
		labelTitle.setForeground(Color.white);
	}
	
	private void setUpLayout(GridBagConstraints c){
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
		
		c.gridheight = 1;
		c.gridx = 1;
		c.gridx = 1;
		this.add(labelName, c);
		
		c.gridy = 2;
		c.gridx = 1;
		this.add(labelHeroClass, c);
		
		c.gridy = 3;
		this.add(labelGender, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(labelStrength, c);
		
		c.gridx = 1;
		this.add(labelIntelligence, c);
		
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(labelDexterity, c);
		
		c.gridx = 1;
		this.add(labelHealth, c);
		
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 2;
		c.fill=GridBagConstraints.CENTER;
		this.add(newHero, c);
	}
}
