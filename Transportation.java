public class Transportation {
	String name="";
	int speed=0;
	public Transportation (String name, int speed) {
		this.name = name;
        this.speed = speed;
	}
	public Time travelTime(Station start, Station end){//not know Time type
		//計算一個行程會花多少時間
		Time taketime = new Time((end.getposition()-start.getposition())/speed);
		return taketime;
	}
}
