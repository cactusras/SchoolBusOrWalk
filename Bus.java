import java.util.ArrayList;

public class Transportation extends Bus {
    String name = " ";
    Route route = new Route (ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap);
    
    public Bus (String name, int speed, ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
        this.name = name;
        speed = 5;
    }
    
    public String getName (){
        return name;
    }
    
    public boolean operate (Time time){
        
    }
    
    public boolean stop (Station station){
        
    }
    
    public Time waitNextBus (Time now){
        
    }
    
    
    
}
