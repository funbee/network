
/**
 * 
 * 
 * @author (Olufunmbi Afeez Akande. Msc IT.ID 12815447) 
 * @version (04/01/14)
 */
public class Connector
{
    
    private String FirstJunctionName; // instance variable
    private String SecondJunctionName;// instance variable

    /**
      * Constructs a Connector with the first junction's name and the second junction's name
      */
    public Connector()
        {
            FirstJunctionName = "";// initialise instance variable with empty value
            SecondJunctionName = "";// initialise instance variables with empty value
        }
    public Connector(String JunctionOneName, String JunctionTwoName)
        {
            FirstJunctionName = JunctionOneName;// sets FirstJunctionName equal to JunctionOneName
            SecondJunctionName = JunctionTwoName;// sets SecondJunctionName equal JunctionTwoName
        }
    
    public String getFirstJunctionName()
        {
            return FirstJunctionName;// returns the first junctions name
        }
    
    public String getSecondJunctionName()
        {
            return SecondJunctionName;// returns the second junction name
        }
    
    public void setFirstJunctionName(String JunctionOneName)
        {
            FirstJunctionName = JunctionOneName;
        }
    
    public void setSecondJunctionName(String JunctionTwoName)
        {
            SecondJunctionName = JunctionTwoName;
        }
   
    public void clear ()
        {
            FirstJunctionName = ""; //clears data
            SecondJunctionName = "";// clears data
        } 
}
