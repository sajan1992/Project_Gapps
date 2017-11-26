/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class AppFrame extends JFrame implements ActionListener
     {
            JFrame f=new JFrame("Test Mail");
            JLabel user=new JLabel("Enter GMail ID :");
            JButton b1=new JButton("OK");
            JButton b2=new JButton("CANCEL");
            String email=null,pwd=null,s=null;
           
            JTextField jt=new JTextField(15);
            JLabel pass=new JLabel("Password :");
           JPasswordField jpf=new JPasswordField(15);
           
           public AppFrame()
           {

           int op = f.getDefaultCloseOperation(); // HIDE_ON_CLOSE
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.getContentPane().setLayout(null);
           f.setResizable ( false );
           f.setLocation(430,370);
           user.setBounds(10,-10,120,70);
           pass.setBounds(10,50,120,70);
           jt.setBounds(10,40,150,27);
           jpf.setBounds(10,100,150,27);
           b1.setBounds(10,140,150,27);
           b2.setBounds(10,180,150,27);
           b1.addActionListener(this);
           b2.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e)
                 { 
  
                     f.dispose();

                 }
        });


           f.getContentPane().add(jpf);
           f.getContentPane().add(user);
           f.getContentPane().add(jt);
           f.getContentPane().add(pass);
           f.getContentPane().add(b1);
           f.getContentPane().add(b2);


           jt.requestFocus();
           f.setSize(200,270);
           f.setVisible(true);
           f.addWindowListener(new WindowAdapter() {
           
    // Set to exit on close
    
               public void WindowClosing(WindowEvent we) {
            System.exit(0);}
            });
           
       }
           public void actionPerformed(ActionEvent ae)

               {   
                   email=jt.getText();
                   pwd=new String(jpf.getPassword());
                   
                   if(ae.getSource()==b1)

                         {    
                               
                                s=new fex().uid(); 
                                System.out.println(s);
                              CheckMail m=new CheckMail();
                              if(email!=null && pwd!=null && s!=null){
                               f.dispose();
                           }
                              m.run(email,pwd,s);
                          
                         }
                  
    // Get default close operation
   
               
            }

           public static void main(String args[]){
               java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new AppFrame();
        }
        } );
           }
   }
