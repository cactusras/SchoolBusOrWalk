import java.util.*;

class Graph {
    private Map<Station, List<Edge>> adjList = new HashMap<>();

    public void addEdge(Station from, Station to, int travelTime) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(new Edge(to, travelTime));
        adjList.get(to).add(new Edge(from, travelTime)); // 無向圖
    }

    public Map<Station, Integer> dijkstra(Station start) {
        Map<Station, Integer> shortestTime = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.travelTime));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (shortestTime.containsKey(current.to)) continue;
            shortestTime.put(current.to, current.travelTime);

            for (Edge edge : adjList.getOrDefault(current.to, new ArrayList<>())) {
                if (!shortestTime.containsKey(edge.to)) {
                    pq.add(new Edge(edge.to, current.travelTime + edge.travelTime));
                }
            }
        }
        return shortestTime;
    }
}

class Edge {
    Station to;
    int travelTime;
    public Edge(Station to, int travelTime) {
        this.to = to;
        this.travelTime = travelTime;
    }
}

public class FinalProject {
    public static void main(String[] args) {
        // 建立地圖
        Station A = new Station("A", 0);
        Station B = new Station("B", 5);
        Station C = new Station("C", 10);
        Station D = new Station("D", 15);
        Station E = new Station("E", 20);
        Graph graph = new Graph();
        graph.addEdge(A, B, 10);
        graph.addEdge(B, C, 15);
        graph.addEdge(C, D, 5);
        graph.addEdge(A, C, 20);
        graph.addEdge(C, E, 10);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start station:");
        String startName = sc.next();
        System.out.println("Enter destination station:");
        String endName = sc.next();

        Map<String, Station> stationMap = Map.of(
            "A", A, "B", B, "C", C, "D", D, "E", E
        );

        if (!stationMap.containsKey(startName) || !stationMap.containsKey(endName)) {
            System.out.println("This station does not exist.");
            return;
        }

        Station start = stationMap.get(startName);
        Station end = stationMap.get(endName);
        Map<Station, Integer> shortestTimes = graph.dijkstra(start);

        if (shortestTimes.containsKey(end)) {
            System.out.printf("Fastest route from %s to %s takes %d minutes\n", 
                startName, endName, shortestTimes.get(end));
        } else {
            System.out.println("No route available.");
        }
    }
}


//import java.util.Scanner;
//import java.util.ArrayList;
//public class FinalProject {
//	public static void main(String[] args) {
//		//建立地圖
//		String[] stationName = {"A","B","C","D","E","F"};
//		Station[] stations = new Station[6];
//		int j = 0;
//		for(int i= 0 ; i < stationName.length; i++){
//				  stations[i]= new Station(stationName[i],j);
//				  j+=5;
//		}
//		ArrayList<Station> firstStop = new ArrayList<Station>();
//		ArrayList<Station> secondStop = new ArrayList<Station>();
//		//公車1停 A B C D 站
//		firstStop.add(stations[0]);
//		firstStop.add(stations[1]);
//		firstStop.add(stations[2]);
//		firstStop.add(stations[3]);
//		//公車1停 A C E 站
//		secondStop.add(stations[0]);
//		secondStop.add(stations[2]);
//		secondStop.add(stations[4]);
//		//公車們，速度5 m/min，營運時間：8點~18點
//		Bus bus1 = new Bus("bus1",5,firstStop,new Time(8,0),new Time(18,0),new Time(0,20));
//		Bus bus2 = new Bus("bus2",5,secondStop,new Time(8,0),new Time(18,0),new Time(0,30));
//		Transportation walker = new Transportation(1);
//		//輸入格式：起始點 目的地 現在時間-小時 現在時間-分鐘
//		Scanner sc = new Scanner(System.in);
//		String starts = sc.next();
//		String ends = sc.next();
//		Time now = new Time(sc.nextInt(),sc.nextInt());
//		//判斷使用者輸入的起始點與目的地在不在地圖上，不再則輸出"This station does not exist."
//		Station start = null;
//		Station end = null;
//		boolean findStart = false;
//		boolean findEnd = false;
//		for(Station s:stations){
//			if(starts.equals(s.getName())){
//				start=s;
//				findStart = true;
//			}
//			if(ends.equals(s.getName())){
//				end=s;
//				findEnd = true;
//			}
//		}
//		if(findStart!=true || findEnd!=true) {
//			System.out.printf("This station does not exist.\n");
//		}else {
//			//分別計算走路跟搭公車所需的時間
//			Time walkTime = walker.travelTime(now, start,end);
//			Time totalBus1 = new Time(0,0);
//			Time totalBus2 = new Time(0,0);
//			if (bus1.operate(now, walkTime, start, end)&& bus1.stop(start) && bus1.stop(end)){
//				totalBus1 = bus1.travelTime(now, start, end);
//			}
//			else{
//				totalBus1.setHour(24) ;
//			}
//			if (bus2.operate(now, walkTime, start, end)&& bus2.stop(start) && bus2.stop(end)){
//				totalBus2 = bus2.travelTime(now, start, end);
//			}
//			else{
//				totalBus2.setHour(24) ;			
//			}
//			//比較哪一個交通工具比較快
//			if (totalBus1.howManyMinute() < totalBus2.howManyMinute() 
//			&& totalBus1.howManyMinute()  <= walkTime.howManyMinute() ){
//				System.out.printf("You need to take %s, and arrive %s station after %02d hour %02d minute\n"
//						, bus1.getName(),ends, totalBus1.getHour(), totalBus1.getMinute());
//			}
//			 else if (totalBus2.howManyMinute() <= totalBus1.howManyMinute() 
//			&& totalBus2.howManyMinute() <= walkTime.howManyMinute()){
//				System.out.printf("You need to take %s, and arrive %s station after %02d hour %02d minute\n"
//						, bus2.getName(),ends, totalBus2.getHour(), totalBus2.getMinute());
//			}
//			 else if(walkTime.howManyMinute() < totalBus1.howManyMinute() 
//			&& walkTime.howManyMinute() < totalBus2.howManyMinute() ){
//				System.out.printf("You need to walk, and arrive %s station after %02d hour %02d minute\n"
//						,ends, walkTime.getHour(), walkTime.getMinute());
//			}
//		}
//		sc.close();
//	}
//}
