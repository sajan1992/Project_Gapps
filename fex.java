/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;

import javax.swing.JOptionPane;

class fex
{
    String str="";
 String uid(){
 str =JOptionPane.showInputDialog(null, "Enter Your UID Number : ","UID Number", 1);
 if(str != null){
 JOptionPane.showMessageDialog(null, "Your UID Number : " + str+" .Please Add Your UID Number After Each Query.","UID Number", 1);
return(str);
 }
else {
 JOptionPane.showMessageDialog(null, "Please Enter UID Number.","Error Message", 1);
 fex fx=new fex();
 fx.uid();
 return "";
   }
  } 
}

