
/**
 * A pipe network that joins two junctions either horizontally or vertically
  (Olufunmbi Afeez Akande. Msc IT.ID 12815447) 
  (04/01/14)
 */
public class Pipe extends Connector
{
   
    private String direction;

    /**
     * 
     */
    public Pipe()
    {
         super();// calls parent constructor
        direction = "";
       
    }

    /**
      Constructs a Pipe as a subclass of Connector. 
      @param  JunctionOneName the name of the first junction
      @param  JunctionTwoName the name of the second junction
      @param junctionDirection  the direction the pipe is drawn
     */
    public Pipe(String JunctionOneName, String JunctionTwoName,String junctionDirection)
    {
        super(JunctionOneName,JunctionTwoName);
        
        if(junctionDirection.equals("vertical") || junctionDirection.equals("horizontal"))
        direction = junctionDirection;
    }
    
    /**
      Gets the direction of the pipe.
      @return the direction
     */
    public String GetDirection()
    {
        return direction;
    }
    
    /**
      Sets the direction of current pipe network.
      @param junctionDirection
     */public void SetDirection(String junctionDirection)
     {
        
        if(junctionDirection.equals("vertical") || junctionDirection.equals("horizontal"))
        direction = junctionDirection;
    }
    
}
