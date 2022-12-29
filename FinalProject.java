public class FinalProject {
	public static void main(String[]args) {
		Station a = new Station("A", 0);//m
		Station b = new Station("B", 5);//m
		Walk sam = new Walk(5);//m/min
		Walk bob = new Walk(10);//m/min
		Time samTravel = sam.travelTime(a, b);//00:01
		Time bobTravel = bob.travelTime(a, b);//00:00
		bobTravel.subtract(samTravel);//00:01
		System.out.printf("Sam spend %02d:%02d to travel from A to B\nBob spend %02d:%02d to travel from A to B\nBob is %02d:%02d faster than Sam"
							, samTravel.getHour(), samTravel.getMinute()
							, bobTravel.getHour(), bobTravel.getMinute()
							, bobTravel.getHour(), bobTravel.getMinute());
	}
}
//若距離比速度小會出問題(假設速度的時候要小心)，因為沒有計算到秒，minute又是整數