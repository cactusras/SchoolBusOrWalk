import java.util.ArrayList;

public class Route {
    private ArrayList <Time> timeTable0 = new ArrayList <Time>();
    public Route (ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
        Time add = startOperation;
        int comeTimes = startOperation.subtract(finishOperation).howManyMinute()/gap.howManyMinute();
        for(int i=0; i<comeTimes; i++){
            timeTable0.add(add);
            add.add1(gap);
        }
    }
  
    public ArrayList<Time> getStationTimeTable (Station station){
        int adjust = 5;
        ArrayList<Time> request = new ArrayList<Time>();
        if (station.getStation().equals("A station")) { 
            adjust*=1;
        }else if (station.getStation().equals("B station")){
            adjust*=2;
        }else if (station.getStation().equals("C station")){
            adjust*=3;
        }else if (station.getStation().equals("D station")){
            adjust*=4;
        }else if (station.getStation().equals("E station")){
            adjust*=5;
        }
        for(Time t:timeTable0){
            request.add(t.add(new Time(adjust)));
        }
        return request;
    }
}