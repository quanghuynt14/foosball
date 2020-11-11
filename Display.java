import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Display extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;
	
	private Timer timer;
	private int delay = 10;
	
	private Player player1;
	private Player player2;
	
	private int ballX = 1050/2 - 15;
	private int ballY = 600/2 - 15;
	private int ballXdir = -2;
	private int ballYdir = -2;
	
	
	public Display() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
		player1 = new Player("Huy", false);
		player2 = new Player("AI", true);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// background
		g.setColor(Color.black);
		g.fillRect(0, 0, 1050, 600);
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(10F));
		g2.drawRect(30, 10, 980, 580);
		//g2.fillOval(974, 554, 30, 30);
		
		// ball
		g.setColor(Color.white);
		g.fillOval(ballX, ballY, 30, 30);
		
		// player1
		g.setColor(Color.green);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < player1.L[i].n; j++) {
				g.fillOval(player1.L[i].posX, player1.L[i].posY[j], 50, 50);
			}
		}
		
		// player2
		g.setColor(Color.red);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < player2.L[i].n; j++) {
				g.fillOval(player2.L[i].posX, player2.L[i].posY[j], 50, 50);
			}
		}
		
		g.dispose();
		g2.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
			ballX += ballXdir;
			ballY += ballYdir;
			if (ballX < 35) {
				ballXdir = -ballXdir;
			}
			if (ballY < 15) {
				ballYdir = -ballYdir;
			}
			if (ballX > 974) {
				ballXdir = -ballXdir;
			}
			if (ballY > 554) {
				ballYdir = -ballYdir;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < player1.L[i].n; j++) {
					int checkX = player1.L[i].posX + 25;
					int checkY = player1.L[i].posY[j] + 25;
					if (distance(ballX + 15, ballY + 15, checkX, checkY) < 40) {
						ballXdir = -ballXdir;
						ballYdir = -ballYdir;
						while (distance(ballX + ballXdir + 15, ballY + ballYdir + 15, checkX, checkY) < 40) {
							ballX += ballXdir;
							ballX += ballYdir;
						}
					}
					checkX = player2.L[i].posX + 25;
					checkY = player2.L[i].posY[j] + 25;
					if (distance(ballX + 15, ballY + 15, checkX, checkY) < 40) {
						ballXdir = -ballXdir;
						ballYdir = -ballYdir;
						while (distance(ballX + ballXdir + 15, ballY + ballYdir + 15, checkX, checkY) < 40) {
							ballX += ballXdir;
							ballX += ballYdir;
						}
					}
				}
			}
			
		}
		repaint();
	}
	
	public int distance(int x1, int y1, int x2, int y2) {
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		return (int)Math.sqrt(dx*dx + dy*dy);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (player1.L[0].canMoveUp()) {
				play = true;
				player1.L[0].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (player1.L[0].canMoveDown()) {
				play = true;
				player1.L[0].moveDown(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (player1.L[1].canMoveUp()) {
				play = true;
				player1.L[1].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (player1.L[1].canMoveDown()) {
				play = true;
				player1.L[1].moveDown(10);
			}
		}if (e.getKeyCode() == KeyEvent.VK_L) {
			if (player1.L[2].canMoveUp()) {
				play = true;
				player1.L[2].moveUp(4);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_J) {
			if (player1.L[2].canMoveDown()) {
				play = true;
				player1.L[2].moveDown(4);
			}
		}if (e.getKeyCode() == KeyEvent.VK_I) {
			if (player1.L[3].canMoveUp()) {
				play = true;
				player1.L[3].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_K) {
			if (player1.L[3].canMoveDown()) {
				play = true;
				player1.L[3].moveDown(10);
			}
		}if (e.getKeyCode() == KeyEvent.VK_D) {
			if (player2.L[0].canMoveUp()) {
				play = true;
				player2.L[0].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (player2.L[0].canMoveDown()) {
				play = true;
				player2.L[0].moveDown(10);
			}
		}if (e.getKeyCode() == KeyEvent.VK_W) {
			if (player2.L[1].canMoveUp()) {
				play = true;
				player2.L[1].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			if (player2.L[1].canMoveDown()) {
				play = true;
				player2.L[1].moveDown(10);
			}
		}if (e.getKeyCode() == KeyEvent.VK_H) {
			if (player2.L[2].canMoveUp()) {
				play = true;
				player2.L[2].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			if (player2.L[2].canMoveDown()) {
				play = true;
				player2.L[2].moveDown(10);
			}
		}if (e.getKeyCode() == KeyEvent.VK_T) {
			if (player2.L[3].canMoveUp()) {
				play = true;
				player2.L[3].moveUp(10);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_G) {
			if (player2.L[3].canMoveDown()) {
				play = true;
				player2.L[3].moveDown(10);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
