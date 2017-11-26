/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Sframe
{
    JFrame f=new JFrame("Connecting");
   
   public Sframe()
    {
  

       
        f.getContentPane().setLayout(new GridLayout(1,0));
       
         //    ImageIcon i =new ImageIcon(new File("").getAbsolutePath()+"\\phot\\newglobe.gif");
         
        JLabel j1=new JLabel("Connecting....",JLabel.LEFT);
        j1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/newglobe.png")));
        j1.setFont(new Font("Serif", Font.PLAIN, 24));
        j1.setForeground(Color.white);
        j1.setBounds(490,40,490,27);
        f.getContentPane().setBackground(Color.BLACK);
        f.getContentPane().add(j1);
        f.setUndecorated(true);
        f.setSize(510,185);
        f.setLocation(440,370);
        f.setVisible(true);
         
          
    }
public static void main(String args){
    
 
}
}
