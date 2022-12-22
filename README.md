# SchoolBusOrWalk
簡述：
簡略版google map。比較從出發點到目的地，是走路比較快還是搭公車比較快，以及各自要花多少時間。提供使用者推薦的通勤方式。

main class
Input：
出發點 目的地 現在時間(時) 現在時間(分)
Output：
最快的通勤方式 會花多久
例:
A C 12 2
walk 00:10
—-------------------------------------------------------------------//建立地圖
String[] stationName = {“A”, “B”, “C”, “D”, “E”, “F”};
Station[] stations = new Station[6];
int j=0;
for(int i=0; i<stations.length; i++){
	stations[i] = new Station(stationName[i], j);
	j+=5;
}
//建立公車們
ArrayList<Station> firstStop = new ArrayLIst<Station>();
firstStop.add(stations[0]);//重複一直到所有停靠站都加進去為止
Bus bus1 = new Bus(“first”, 5, firstStop, new Time(8,0), new Time(18,0), new Time(0,20))
//以此類推，建立bus2、bus3

//建立一個走路者
Walk walker = new Walk(5);

//處理輸入
Scanner sc = new Scanner(System.in);
String start = sc.next();
String end = sc.next();
Time now = new Time(sc.nextInt(), sc.nextInt())
//在station array 內找使用者輸入的start等不等於任何一個station的staionName，
等於的話Station start = stations[i]
不等於的話，叫使用者重新輸入
//Station end 的處理同上

//進行計算
Time walkTime = walker.travelTimeWalk(start, end)
Time totalBus = new Time(0,0);
if(bus1.operate(now) && bus1.stop(start) && bus1.stop(end))
//判斷公車有沒有開，跟有沒有停出發點跟目的地，如果有再計算
totalBus = totalBus.add(bus1.waitNextBus(now), bus1.travelTimeBus(start, end))
else
totalBus.setHour()=24//要把bus的時間設的最大不然比較會出問題
//比較哪個比較快並print out
if(totalBus.howManyMinute()-walkTime.howManyMinute() > 0)
printf("walk %02d:%02d", walkTime.getHour(), walkTime.getMinute())
else if 公車1最快(公車2同理)
printf("bus %s %02d:%02d", bus1.getName(), totalBus.getHour(), totalBus.getMinute())
else if (公車1=公車2>walk)
printf(“bus %s and bus %s %02d:%02d", bus1.getName(), bus2.getName(), totalBus.getHour(), totalBus.getMinute()”)
else(walk=bus1=bus2 || walk=bus1<bus2 || walk=bus2<bus1)
printf(“走路搭公車一樣快 %02d:%02d”, walkTime.getHour(), walkTime.getMinute())

Transportation class
計算一個行程會花多少時間
attribute:
int speed=0;
constructor:
Transportation (int speed)
method:
Time travelTime(Station start, Station end, int speed)//計算一個行程會花多少時間

Bus class(繼承 Transportation class)
attribute:
String name="";
Route route = new(ArrayList<Station> stop,Time startOperate,Time finishOperate,Time gap)
Constructor:
Bus(String name, int speed, ArrayList<Station> stop, Time startOperate, Time finishOperate, Time gap)//把speed設為5，name 是transportation name
method:
String getName()
boolean operate(Time time)//判斷在不在營運時間內
boolean stop(Station station)//判斷該公車有沒有停此站
Time waitNextBus(Time now)//計算下一班公車還要多久會來
//void busInfo()//print out

敘述:
bus: 5mins/per station
公車路線（單向）：
route1={A,B,C,D}20分鐘一班,營運時間8-18
route2={A,C,E}30分鐘一班,營運時間8-18


Route class
attribute:
ArrayList<Station> stop = new ArrayLIst<Station>();
ArrayList<Time> timeTable0 = new ArrayList<Time>();//總站的時刻表
Constructor:
Route(ArrayList<Station> stop, Time startOperate, Time finishOperate, Time gap)
method:
getStationATimeTable();//根據公車從總站開到A站所需的時間，推算A站時刻表並回傳
getStationBTimeTable();
getStationCTimeTable();
//以此類推

Walk class(繼承 Transportation class)
attribute:

Constructor:
Walk(int speed)//把speed設為5，name 是transportation name
method:
//void walkInfo()//print out

Time class
attribute:
int hour=0;
int minute=0;
Constructor:
Time(int hour, int minute)
method:
int getHour()
Int getMinute ()
int howManyMinute()//例：02:10 → 130 min
Time minuteToTime(int minute)//例：130 min → 02:10

//Time add(Time now, Time later)// 01:00+00:30=01:30
//Time subtract(Time now, Time before)// 01:00-00:30=00:30

敘述:
計算時間的加減

Station class
attribute:
String station；//站的名稱
int position = 0;//一維座標(eg.station A 在0, station B在5…依此類推)
Constructor:
Station(String station, int position)
method:
int distance(Station start, Station end)//計算兩點的距離，地圖更複雜才需要
