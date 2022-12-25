public class FinalProject {
	public static void main(String[]args) {
		Station a = new Station("A", 0);
		Station b = new Station("B", 10);
		Walk sam = new Walk(5);
		Walk bob = new Walk(10);
		Time samTravel = sam.travelTime(a, b);
		Time bobTravel = bob.travelTime(a, b);
		bobTravel.subtract(samTravel);
		System.out.printf("Sam spend %02d:%02d to travel from A to B\nBob spend %02d:%02d to travel from A to B\nBob is %02d:%02d faster than Sam"
							, samTravel.getHour(), samTravel.getMinute()
							, bobTravel.getHour(), bobTravel.getMinute()
							, bobTravel.getHour(), bobTravel.getMinute());
	}
}
//若距離比速度小會出問題