import java.util.ArrayList;

public class Route {
  ArrayList <Station> stop = new ArrayList <Station>();
  ArrayList <Time> timeTable0 = new ArrayList <Time>();
  Bus bus = new Bus//建立一個Bus物件才能判斷路線
  
  public Route (ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
    
  }
  
  public Time getStationATimeTable (){
    Time A ;
    int timeA = 480;
    if (bus.getName() == "first"){
      while (timeA <= 1080){
        timeA += 20;
        A = A.howManyMinute(timeA);
      }
    }
    
    if (bus.getName() == "second"){
      while (time <= 1080){
        time += 30;
        A = A.howManyMinute(timeA);
      }
    }
    
    return A;
  }
  
  public Time getStationBTimeTable (){
    
  }
  
  public Time getStationCTimeTable (){
    
  }
  
  public Time getStationDTimeTable (){
    
  }
  
  public Time getStationETimeTable (){
    
  }
  
  
}
