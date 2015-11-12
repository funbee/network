
/**
 * This program displays the network frame.
 * 
 * @author (Olufunmbi Afeez Akande) 
 * @version (04/01/2014)
 */
import javax.swing.JFrame;

   
  public class NetworkViewer
   {
            public static void main(String[] args)
            {
                JFrame frame = new NetworkFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("A network display");
                frame.setVisible(true);
            }   
   }
    