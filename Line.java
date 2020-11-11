
public class Line {
	public int n;
	public int posX;
	public int [] posY;
	
	public Line (int n, int posX, int height) {
		this.n = n;
		this.posX = posX;
		posY = new int[n];
		for (int i = 0; i < n; i++) {
			posY[i] = ((i+1) * (height/(n+1))) - 25;
		}
	}
	
	public void moveDown(int x) {
		for (int i = 0; i < n; i++) {
			posY[i] += x;
		}
	}
	
	public void moveUp(int x) {
		for (int i = 0; i < n; i++) {
			posY[i] -= x;
		}
	}
	
	public boolean canMoveUp() {
		return (posY[0] > 15);
	}
	
	public boolean canMoveDown() {
		return  (posY[n-1] < 535);
	}
}
