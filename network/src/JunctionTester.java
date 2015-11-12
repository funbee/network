import java.util.ArrayList;

/**Computes the name and direction of the objects in the network.
 *@param junctions an array of Junction objects
 *@param connectors an array of Connector objects
 *@param pipes an array of Pipe objects
 * @author (Olufunmbi Afeez Akande. Msc IT.ID 12815447) 
 * @version (04/01/14)
 */
public class JunctionTester
     {
        public static void main( String []args)
             {
                 ArrayList<Junction> junctions = new ArrayList<Junction>();
                 junctions.add(new Junction("start",50,50));
                 junctions.add(new Junction("J1",200,200));
                 junctions.add(new Junction("J2",120,280)); 
            
                 for( Junction junction : junctions)
                 System.out.println(junction.GetName() + " "+junction.GetIntX() +" "+ junction.GetIntY());// for every obj in the arraylist, get junction name,int x amnd int y
                 ArrayList<Connector>connectors = new ArrayList<Connector>();
                 String FirstJunctionName;
                 String SecondJunctionName;
                    for(int i = 1;i<junctions.size();i++)
                    {
                        FirstJunctionName = junctions.get(i-1).GetName();
                        SecondJunctionName = junctions.get(i).GetName();
           
                        connectors.add(new Connector(FirstJunctionName,SecondJunctionName));// for every obj in the arrayList Connector, loop through and get names of the first and second junction in network
          
                    }
                    FirstJunctionName = junctions.get(junctions.size()-1).GetName();
                    SecondJunctionName = junctions.get(0).GetName();
                    connectors.add(new Connector(FirstJunctionName,SecondJunctionName));
     
                    for(int i = 0; i<connectors.size();i++)
                    {
                        System.out.println(connectors.get(i).getFirstJunctionName());
                        System.out.println(connectors.get(i).getSecondJunctionName());
                    }

                    ArrayList<Pipe>pipes = new ArrayList<Pipe>();// loop through pipes arraylist  and get names of first and second junctions and direction of the pipes
                    for(int i = 1;i<junctions.size();i++)
                    {
                        FirstJunctionName = junctions.get(i-1).GetName();
                        SecondJunctionName = junctions.get(i).GetName();
           
                        pipes.add(new Pipe(FirstJunctionName,SecondJunctionName,"vertical" ));
          
                    }
                    FirstJunctionName = junctions.get(junctions.size()-1).GetName();
                    SecondJunctionName = junctions.get(0).GetName();
                    pipes.add(new Pipe(FirstJunctionName,SecondJunctionName,"horizontal"));
                    for(int i = 0; i<connectors.size();i++)
                    {
                        System.out.println(pipes.get(i).getFirstJunctionName());
                        System.out.println(pipes.get(i).getSecondJunctionName());
                        System.out.println(pipes.get(i).GetDirection());
                    }

    
                }
            }