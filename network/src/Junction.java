
/**
 * A junction network that  returns the junction name and the x and y co-ordinates
 * 
 * @author (Olufunmbi Afeez Akande. Msc IT.ID 12815447) 
 * @version (04/01/14)
 */
public class Junction
{
    
    private String name;
    private int x;
    private int y;
    

        /**
          Constructs a junction with name and x and y co-ordinates.
         */
            public Junction()
            {
                // initialise instance variables
                name = "";
                x = 0;
                y = 0;
            }
    
        /**
          Adds a string and two integers. 
          @param junctionName the name of the junction
          @param x1 the x coordinate of the junction
          @param y1 the y coordinate of the junction
         */
        public Junction(String junctionName, int x1, int y1)
            {
                name = junctionName;
                x = x1;
                y = y1;
         
            }
        
        /**
          Gets the name of the current junction.
          @return the name
         */
        public String GetName()
            {
                return name;
           
            } 
        
         /**
          Gets the x coordinate of the current junction.
          @return x
          */
         public int GetIntX()
            {
                return x;  
            }
    
         /** 
           sets the x coordinate of the current junction as x1
            @param SetX
          */
            public void SetX(int x1)
            {
                    x = x1;
            }
        
          /**
          Gets the y coordinate of the current junction.
          @return y
          */
         public int GetIntY()
            {
                return y;  
            }
    
        /** 
           sets the y coordinate of the current junction as x1
            @param SetY
          */
         public void SetY(int y1)
            {
                 y = y1;
            }
    
    
        /**
         convert the data to a string in the formart name + x coordinate + y cooordinate
         @param name
         @param x
         @param y
         */public String toString()
            {
            return name;       
        }
 
        public void display()
            {
            
                System.out.print( name +"" + x +"" + y);// display the year text
            }
}
