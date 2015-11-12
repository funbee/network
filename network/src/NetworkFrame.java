import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
/**
  * A frame that reads a user selected network text file that contains a description of a network and
  * displays the junctions,connector network(lines that connect junctions) or pipes network( additional form of connector
  * that can only be oriented horizontally or vertically)
  * @author (Olufunmbi Afeez Akande. Msc IT.ID 12815447) 
  * @version (04/01/14)
 */
public class NetworkFrame extends JFrame
{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JButton button;
        private JPanel panel;
        private DisplayPanel panel2;
        private ArrayList<Junction> junctions; //implement this class
        private ArrayList<Connector> connectors; //implement this class
        
        public NetworkFrame()
        {
        setLayout(new GridLayout(1, 2)); //Splits the frame vertically. Left hand side is
        //for your drawing, the right hand side is for the button
        panel = new JPanel();
        junctions = new ArrayList<Junction>();
        connectors = new ArrayList<Connector>();
        button = new JButton("choose file to load");
        panel.add(button);
        ClickListener listener = new ClickListener();
        button.addActionListener(listener);
        panel2 = new DisplayPanel();
        add(panel2); // This panel is used to display the image
        add(panel); // add your button to this panel
    }
    
    public static File LoadDialog()
    {
        File f = null;
        JFileChooser selectfile= new JFileChooser();
        int returnVal = selectfile.showOpenDialog(null);
        if (returnVal==JFileChooser.APPROVE_OPTION)
        {
            f = selectfile.getSelectedFile();
        }
        return f;
    }
   
    
      /**
      An action listener that loads file or returns error message for invalid files
      */
     class ClickListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent event)
     
        {
            File F = LoadDialog();
            try
            {
                readFile(F);
                repaint();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Cannot Handle this type of Network");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * A class that draws a network.
     */
    public class DisplayPanel extends JPanel
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g)
            {
           
                    @SuppressWarnings("unused")
					Graphics2D g2 = (Graphics2D) g;
                    
                    g.setColor(Color.YELLOW);// set junctions color to yellow
                    for(int i = 0;i<junctions.size();i++)
                    {
                        
                        g.fillOval(junctions.get(i).GetIntX(),junctions.get(i).GetIntY(),40,20);//draw and fill an oval
                       
                        g.setColor(Color.BLACK); //set junction name to black 
                        g.drawString(junctions.get(i).GetName(),junctions.get(i).GetIntX(),junctions.get(i).GetIntY()-10);// specify  junstion name location
                        repaint();
                        g.setColor(Color.YELLOW);
                    }
                
                   
                    g.setColor(Color.BLUE); // set connectors color to blue
                    /*
                     * a loop that returns junction name
                     * @param FirstJunction
                     * @param SecondJunction
                     */for(int i = 0;i<connectors.size();i++)
                    { 
                        String FirstJunction = connectors.get(i).getFirstJunctionName();
                        String SecondJunction = connectors.get(i).getSecondJunctionName();
                        int x1= 0,x2= 0,y1=0,y2= 0;
                        for(int j = 0;j<junctions.size();j++)
                        {
                     if (FirstJunction.equals(junctions.get(j).GetName()))
                        {
                            x1 = junctions.get(j).GetIntX();
                            y1 = junctions.get(j).GetIntY();
                        }
                    else if(SecondJunction.equals(junctions.get(j).GetName()))
                         {
                             x2 = junctions.get(j).GetIntX();
                             y2 = junctions.get(j).GetIntY();
                            }
                        }
                    if ( connectors.get(i) instanceof Pipe)// if network is of Pipe object
                    {
                        Pipe pp = (Pipe)connectors.get(i);
                    if( pp.GetDirection().equals("horizontal"))//check if pipe is horizontal or vertical and draw
                        {       g.drawLine(x1,y1,x2,y1);
                                g.drawLine(x2,y1,x2,y2);
                        }
                    else     {
                            g.drawLine(x1,y1,x1,y2);
                            g.drawLine(x1,y2,x2,y2);
                        }
                    
                    }
                    else     {
                            g.drawLine(x1,y1,x2,y2);
                        }
                
    
                    }
        
                }
            }
    
     public void readFile(File F)throws FileNotFoundException
       {
                 junctions = new ArrayList<Junction>();
                 connectors = new ArrayList<Connector>();
                 ArrayList<String> network = new ArrayList<String>();
                 File F1 = F;
                 @SuppressWarnings("resource")
				Scanner scanFile = new Scanner(F1);
                 while(scanFile.hasNext())
                    {
                        network.add(scanFile.nextLine());

              
                    }
                    if (network.get(0).equals("Connector Network") || network.get(0).equals("Pipe Network"));// the attributes of the Connector class are inherited by Pipe
    
            if (network.get(1).equals("Junctions"))//if loop starts at Junctions
                {
                    int i = 2; // current location in string
                    while( !network.get(i).equals("Junctions END"))//break loop at Junctions END
                    {
                        String S = network.get(i);
                             
                        String[] arrayJ = S.split(",");
                        Junction j1 = new Junction(arrayJ[0],Integer.parseInt( arrayJ[1]),Integer.parseInt(arrayJ[2]));
                        junctions.add(j1);
                        i++;
                    }
                    i =i + 1;
                    if(network.get(i).equals("Pipes"))//if loop starts at Pipes
                    {
                        i = i + 1;
                        while(!network.get(i).equals("Pipes END"))// read  data and break loop at Pipes END
                        {
                            String P = network.get(i);
                            String[] arrayP = P.split(",");
                            Pipe P1 = new Pipe(arrayP[0],arrayP[1],arrayP[2]);
                            connectors.add(P1);
                            i++;
        
                        }
                    }
                    else
                    if(network.get(i).equals("Connectors"))//if loop starts at Connectors
                    {
                        i = i + 1;
                        while(!network.get(i).equals("Connectors END"))// read data and break loop at Connectors END
                        {
                            String C = network.get(i);
                             
                            String[] arrayC = C.split(",");
                            Connector C1 = new Connector(arrayC[0],arrayC[1]);
                            connectors.add(C1);
                            i++;
        
                        }
                    }
        }
    }
}

    
    
