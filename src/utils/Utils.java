/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author migue
 */
public abstract class Utils {
    public static double randomizer(double min, double max){
        return (Math.random()*(max - min) + min);
    }
    public static void setSize(JComponent g, Dimension d){
        g.setSize(d);
        g.setMinimumSize(d);
        g.setPreferredSize(d);
        g.setMaximumSize(d);
        g.setBounds(new Rectangle(d));
    }
    public static void setPreferredSize(JComponent g, Dimension d){
        g.setPreferredSize(d);
    }
    public static void centerLabel(JLabel label){
        label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
        label.setVerticalAlignment((int) Component.CENTER_ALIGNMENT);
    }
    public static Icon resizeImageByPath(String path, int width, int height){
        return (new ImageIcon((new ImageIcon(path)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
    public static Color getRandomColor(){
        return new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
    }
}
