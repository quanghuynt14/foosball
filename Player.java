
public class Player {
	public int score;
	public String name;
	public Line [] L;
	public int h;
	
	public Player (String name, boolean direction) {
		this.score = 0;
		this.name = name;
		L = new Line[4];

		if (direction == true) { 
			L[0] = new Line(1, 80, 600);
			L[1] = new Line(2, 200, 600);
			L[2] = new Line(5, 440, 600);
			L[3] = new Line(3, 680, 600);
		} else {
			L[0] = new Line(1, 920, 600);
			L[1] = new Line(2, 800, 600);
			L[2] = new Line(5, 560, 600);
			L[3] = new Line(3, 320, 600);
		}
	}
	
}
