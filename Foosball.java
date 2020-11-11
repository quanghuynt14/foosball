import javax.swing.JFrame;

public class Foosball {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Display gamePlay = new Display();
		frame.setBounds(10, 10, 1050, 700);
		frame.setTitle("Foosball");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamePlay);
	}
}
