import java.util.Scanner;
import java.util.ArrayList;
public class FinalProject {
	public static void main(String[] args) {
		//建立地圖
		String[] stationName = {"A","B","C","D","E","F"};
		Station[] stations = new Station[6];
		int j = 0;
		for(int i= 0 ; i < stationName.length; i++){
				stations[i]= new Station(stationName[i],j);
				j+=5;
		}
		ArrayList<Station> firstStop = new ArrayList<Station>();
		ArrayList<Station> secondStop = new ArrayList<Station>();
		firstStop.add(stations[0]);
		firstStop.add(stations[1]);
		firstStop.add(stations[2]);
		firstStop.add(stations[3]);
		secondStop.add(stations[0]);
		secondStop.add(stations[2]);
		secondStop.add(stations[4]);
		
		Bus bus1 = new Bus("first",5,firstStop,new Time(8,0),new Time(18,0),new Time(0,20));
		Bus bus2 = new Bus("second",5,secondStop,new Time(8,0),new Time(18,0),new Time(0,20));
		
		Walk walker = new Walk(5);
		
		Scanner sc = new Scanner(System.in);
		String starts = sc.next();
		String ends = sc.next();
		Time now = new Time(sc.nextInt(),sc.nextInt());
		Station start = null;
		Station end = null;
		for(Station s:stations){
			if(starts.equals(s.getStation())){
				start=s;
			}else{
				System.out.printf("This station does not exist.");
			}
		}
		for(Station e : stations){
			if(ends.equals(e.getStation())){
				end = e;
			}else{
				System.out.printf("This station does not exist.");
			}
		}
		Time walkTime = walker.travelTime(start,end);
		Time totalBus1 = new Time(0,0);
		Time totalBus2 = new Time(0,0);
		if (bus1.operate(now)&& bus1.stop(start) && bus1.stop(end)){
			totalBus1 = bus1.travelTime(start, end);
		}
		else{
			totalBus1.setHour(24) ;
		
		}
		if (bus2.operate(now)&& bus2.stop(start) && bus2.stop(end)){
			totalBus2 = bus2.travelTime(start, end);
		}
		else{
			totalBus2.setHour(24) ;
		
		}
		//to compare different route faster
		
		if (totalBus1.howManyMinute() <= totalBus2.howManyMinute()  && totalBus1.howManyMinute()  < walkTime.howManyMinute() ){
			System.out.printf("bus %s %02d:%02d", bus1.getName(), totalBus1.getHour(), totalBus1.getMinute());
		}
		else if (totalBus2.howManyMinute() <= totalBus1.howManyMinute() && totalBus2.howManyMinute() < walkTime.howManyMinute()){
			System.out.printf("bus %s %02d:%02d", bus2.getName(), totalBus2.getHour(), totalBus2.getMinute());
		}
		else if(walkTime.howManyMinute() <= totalBus1.howManyMinute() && walkTime.howManyMinute() <= totalBus2.howManyMinute() ){
			System.out.printf("walk %02d:%02d", walkTime.getHour(), walkTime.getMinute());
		}
		sc.close();
	}
}
//若距離比速度小會出問題(假設速度的時候要小心)，因為沒有計算到秒，minute又是整數