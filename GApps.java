/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author raj
 */
public class GApps {

    
    public static void main(String[] args) throws IOException
    {
       
      
          String cmd = "reg add HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v " + "GControl"+ " /t REG_SZ /d \"" + new File("").getAbsolutePath() + "\\dist\\GApps.jar";
          Runtime.getRuntime().exec(cmd);
     try {     

        File f=new File(new File("").getAbsolutePath()+"\\files\\db.txt");
        StringTokenizer s1=new StringTokenizer("");
         DataInputStream in = new DataInputStream(new FileInputStream(f));
        String user="",pass="",s="",uid="";
        


        if(f.exists()&& f.isFile())
           {
   
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
    
    System.out.println(f.exists()?"File exist":"File not found");
    System.out.println("File is reading");

  String strLine="";
  //Read File Line By Line
  while ((strLine =br.readLine()) != null)
  {
      s=s+strLine;
      System.out.println(s);
  }
 
     in.close();
     
  System.out.println("File is reading is done"+s);
    s1=new StringTokenizer(s); 
 if(s1.hasMoreTokens()){
         user=s1.nextToken();
         pass=s1.nextToken();
         uid=s1.nextToken();
         System.out.println("user"+user);
         System.out.println("pass"+pass);
         CheckMail cm=new CheckMail();
         cm.run(user, pass,uid);
     }
 else{
     System.out.println("File has nothing");
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new AppFrame();
        }
        } );
 }
 
 } 
}
catch(java.io.FileNotFoundException e)
{
           File theDir = new File(new File("").getAbsolutePath()+"\\files");
             boolean result = theDir.mkdir();  
             if(result){    
             System.out.println("DIR created");  
              }

        FileWriter f1=new FileWriter(new File("").getAbsolutePath()+"\\files\\db.txt");
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new AppFrame();
        }
        } );
        }
     
}   
       
    }

