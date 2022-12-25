public class Station {
	String station;//站的名稱
	int position;//一維座標(eg.station A 在0, station B在5…依此類推)
	public Station(String station, int position) {
		this.station = station;
		this.position = position;
	}
	public String getstation() {
		return station;
	}
	public int getposition() {
		return position;
	}
}
