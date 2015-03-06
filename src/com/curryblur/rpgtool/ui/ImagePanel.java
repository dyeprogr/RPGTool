package com.curryblur.rpgtool.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BufferedImage img;
		private int padding;
		
		public ImagePanel(BufferedImage img, Color c, int padding){
			this.img = img;
			this.setBackground(c);
			this.padding = padding;
			this.setPreferredSize(new Dimension(125,125));
		}
		
		public void setImg(BufferedImage img){
			this.img = img;
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(this.img, padding, padding, this.getWidth()-(padding*2), 
					this.getHeight()-(padding*2),null);
		}
		
}
