/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;

import java.io.FileWriter;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;
import java.io.*;

 class CheckMail extends Thread{
    
     //AppFrame af=new AppFrame();
  Thread t;
  File f=new File(new File("").getAbsolutePath()+"\\files\\db.txt"); 
  public void start()
  {
      if(t==null){
          t=new Thread(this);
          t.start();
      }
  }      
  
   public void run(String a,String b,String c)
    {
        
        if(a.equals(""))
        {           
        JOptionPane.showMessageDialog(null, "Please Enter The GmailAccount!");
        new AppFrame();
        
        }
        else if(b.equals(""))
        {
        JOptionPane.showMessageDialog(null, "Please Enter The Password!");
        new AppFrame();
        }
        
        else 
        {
            Sframe sf=new Sframe();
             
            try{
 
                
                boolean b1=false;
                Properties props = System.getProperties();
                t.sleep(1000);
                Session session = Session.getDefaultInstance(props, null);
                t.sleep(1000); 
                props.setProperty("mail.store.protocol", "imaps");              
                t.sleep(1000);
                 session.setDebug(true);

                Store store = session.getStore("imaps");
                 t.sleep(1000);
                store.connect("imap.gmail.com",a,b);
                t.sleep(1000);
                b1=store.isConnected();    
               t.sleep(1000);
                sf.f.dispose();
                                       
                  if(b1==true)
                    {
                        if(f.exists()&& f.isFile()){
                       
    try {              
         FileWriter fo = new FileWriter(f);
       //BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
                        fo.write(a+" "+b+" "+c);
                        fo.close();
    }catch(Exception e){
        
    }
                        System.out.println("File is written");
                        }  
                        Folder folder = store.getFolder("inbox"); 
                        folder.open(Folder.READ_WRITE);
                        Message message[]= folder.getMessages();             
                                                 
                        while(message.length==0)       
                           { 
                               t.sleep(1000);
                   message= folder.getMessages();
                           } 
                        
                        if(message.length>0) {                               
                         folder.close(true);
                         store.close();
                         t=null;
                          
                         new ReadMail().fmail(a, b,c);
                           }
                    }           
                 
        
        }
            
            
            catch(Exception e)
            {
               
                JOptionPane.showMessageDialog(null, "Couldn't Connect!..Please Check Email and Password.");
                sf.f.dispose();
                new AppFrame();              

            }
            
        }
    
}
  
   
   }
   
 

            


 