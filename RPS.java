/**""
   RPS.java
   
   This program is the driver for RPSGUI.java. It initializes its
   GUI and records the score from the game in the file, scores.txt.
   
   @Author: Thomas Rivera
   
   @Version: 10/16/2021
**/

public class RPS{
   public static void main(String[] arg) {
      
      //Initilizes GUI
      RPSGUI f = new RPSGUI();
      f.initializeGUI();
      f.setVisible(true);
      
   }
}