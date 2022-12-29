import java.util.ArrayList;
public class Bus extends Transportation {
    private String name = "";
	private Route route;
    private ArrayList <Station> stop;
    private Time startOperation;
    private Time finishOperation;
    private Time gap;
    public String getName(){
        return name;
    }
    public Bus (String name, int speed, ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
    	super(speed);
        this.name = name;
    	this.stop = stop;
    	this.startOperation = startOperation;
    	this.finishOperation = finishOperation;
    	this.gap = gap;
    }    
    
  //判斷是否在營運時間內
    public boolean operate (Time time){
        boolean op = false;
        if (time.getHour()<18 && time.getHour()>8){
            op = true;
        }
        return op;
    }
    public boolean stop (Station station){
        boolean st = false;
        for (Station stations:stop){
            if (stations.equals(station)){
                st = true;
            }
        }//判斷公車是否停靠此站
        return st;
    }
    public Time travelTime (Time now, Station start, Station end){
    	Time travel = super.travelTime(start,end,getSpeed());//from transportation function:traveltime
		Time wait = new Time(0);
		ArrayList<Time> timeTableStart = route.getStationTimeTable(start);
		for (int i=0; i<timeTableStart.size(); i++){
			if ( now.howManyMinute() >= timeTableStart.get(i).howManyMinute() ){
				timeTableStart.remove(timeTableStart.get(i));
			}else {
				wait = timeTableStart.get(0).subtract(now);
			}
		}
		wait.add1(travel);
        return wait;
    }
}

