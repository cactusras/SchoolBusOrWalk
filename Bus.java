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
        boolean op = false;
        if (time.getHour()<18 && time.getHour()>8){
            boolean = true;
        }//判斷是否在營運時間內
        
        return op;
    }
    
    public boolean stop (Station station){
        boolean st = false;
        for (Station st:stop){
            if (st = station){
                st = true;
            }
        }//判斷公車是否停靠此站
        
        return st;
    }
    
    public time waitNextBus (Time now){
        Time wait;
        
        
        
        return wait;
    }
    
    
    
}
