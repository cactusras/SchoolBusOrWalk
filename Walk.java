public class Walk extends Transportation{
	public Walk(int speed){//把speed設為5，name 是transportation name
		super("walker", speed);
	}
	public void traveltimeresult(int travelTime) {
		System.out.println("You need to spend "+travelTime+" on walk");
	}
}
