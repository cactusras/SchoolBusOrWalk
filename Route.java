import java.util.ArrayList;

public class Route {
  ArrayList <Station> stop = new ArrayList <Station>();
  ArrayList <Time> timeTable0 = new ArrayList <Time>();
  Bus bus = new Bus//建立一個Bus物件才能判斷路線
  
  public Route (ArrayList <Station> stop, Time startOperation, Time finishOperation, Time gap){
    
  }
  
  public Time getStationATimeTable (){
    Time A;
    int timeA = 480;
    if (bus.getName().equals("first")){
      while (timeA <= 1080){
        timeA += 20;
        A = A.howManyMinute(timeA);
      }
    }
    
    if (bus.getName().equals("second")){
      while (timeA <= 1080){
        timeA += 30;
        A = A.howManyMinute(timeA);
      }
    }
    
    return A;
  }
  
  public Time getStationBTimeTable (){
    Time B;
    int timeB = 485;
    while (timeB <= 1085){
      timeB += 20;
      B = B.howManyMinute(timeB);
    }
    
    return B;
  }
  
  public Time getStationCTimeTable (){
    Time C;
    int timeC = 490;
    if (bus.getName().equals("first")){
      while (timeC <= 1090){
        timeC +=20;
        C = C.howManyMinute(timeC);
      }
    }
    
    if (bus.getName().equals("second")){
      while (timeC <= 1090){
        timeC += 30;
        C = C.howManyMinute(timeC);
      }
    }
    
    return C;
  }
  
  public Time getStationDTimeTable (){
    Time D;
    int timeD = 495;
    while (timeD <= 1095){
      timeD += 20;
      D = D.hoeManyMinute(timeD);
    }
    
    return D;
  }
  
  public Time getStationETimeTable (){
    Time E;
    int timeE = 500;
    while (timeE <= 1100){
      timeE += 30;
      E = E.howManyMinute(timeE);
    }
    
    return E;
  }
  
  
}
