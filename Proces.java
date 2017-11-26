/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gapps;

public class Proces {
    
    void opp(int i)
    {
                if(i==1)
         {
             try{
         Runtime runtime = Runtime.getRuntime();
         java.lang.Process proc = runtime.exec("Rundll32.exe Powrprof.dll,SetSuspendState");
         System.exit(0);
         
         }
 catch(Exception e){
     } 
   }
      else if(i==2)
      {        
        try{
        Runtime runtime = Runtime.getRuntime();
        java.lang.Process proc = runtime.exec("shutdown -s -t 0");
        System.exit(0);
          }
 catch(Exception e){     
 }         
  }
    }    
    
}
