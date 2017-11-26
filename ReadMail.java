/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;


import com.sun.mail.imap.protocol.FLAGS;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import javax.swing.JOptionPane;




/**
 *
 * @author raj
 */
public class ReadMail extends Thread {

    Thread t;
     public void start()
  {
      if(t==null){
          t=new Thread(this);
          t.start();
      }
  }      
    void read(String a,String b,String c)
    {
    Properties props = System.getProperties();
    Session session = Session.getDefaultInstance(props, null);     
    
    try { 
        props.setProperty("mail.store.protocol", "imaps");              
        session.setDebug(true);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com",a,b);
        Folder folder = store.getFolder("inbox"); 
        folder.open(Folder.READ_WRITE);

  Message message[] = folder.getMessages();
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
    catch(Exception e){
        
    }
    
    }
    
    void fmail(String a,String b,String c)
  
   {        String v1,v2,v3;
   v1=a;
   v2=b;
   v3=c;
            Properties props = System.getProperties();
            Session session = Session.getDefaultInstance(props, null);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
            Date d1=new Date();
            //int t=0; 
  try { 
        props.setProperty("mail.store.protocol", "imaps");              
        session.setDebug(true);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com",a,b);
        Folder folder = store.getFolder("inbox"); 
        folder.open(Folder.READ_WRITE);

  Message message[] = folder.getMessages();

  for (int i = 0; message.length!=0 ; i++) {
     
      if (message[i].getSubject()== null) {
         System.out.println("This is Null");
message[i].setFlag(FLAGS.Flag.DELETED, true);

      }
      
      else if(((message[i].getSubject()).compareToIgnoreCase("Hibernate"+c)==0) && (dateFormat.format(message[i].getSentDate()).equals(dateFormat.format(d1))))
     {
         message[i].setFlag(FLAGS.Flag.DELETED, true);
         Proces p=new Proces();
         p.opp(1);
     }
      else if(((message[i].getSubject()).compareToIgnoreCase("Shutdown"+c)==0) && (dateFormat.format(message[i].getSentDate()).equals(dateFormat.format(d1))))
      {
      message[i].setFlag(FLAGS.Flag.DELETED, true);
      Proces p=new Proces();
      p.opp(2);
      }
             else
             message[i].setFlag(FLAGS.Flag.DELETED, true);
           
          
  }

  


  
  }
  catch(Exception e) {
 new ReadMail().read(a, b, c);
  }
  }
public static void main(String rags[]){
     java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        new ReadMail();
        }
        } );
}
}
