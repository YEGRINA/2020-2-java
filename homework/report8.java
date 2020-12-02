import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Point {
	int x, y;
}
class Panel extends JPanel implements MouseMotionListener, KeyListener {
	private int index = 0;
	Point[] array = new Point[1000];
	int w = 3, h = 3;  // 선의 두께를 결정하는 변수
	// 클래스 Color(Red, Green, Blue) 색의 값(0~255)사이
	// 초기 색은 검정
	Color c = new Color(0,0,0);
	int c_ = 0;
	
	public Panel() {
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Point p : array)
			if(p != null) {
				g.setColor(c);
				g.fillOval(p.x, p.y, w, h);
			}
	}
	// MouseMotion override
	public void mouseDragged(MouseEvent e) {
		if(index > 1000)
			return;
		array[index] = new Point();
		array[index].x = e.getX();
		array[index].y = e.getY();
		index++;
		repaint();
	}
	public void mouseMoved(MouseEvent arg0) {}
	// Key override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode) {
		case KeyEvent.VK_UP:
			c_++;
			if(c_ == 3) {   
				c_ = 0;    // 사이클 돌리기위해 3이되면 0으로
				c = new Color(0,0,0);
			}
			else if(c_ == 1) c = new Color(0,100,200);
			else if(c_ == 2) c = new Color(130,80,170);
			break;
		case KeyEvent.VK_DOWN:
			c_--;
			if(c_ == 0) c = new Color(0,0,0);
			else if(c_ == 1) c = new Color(0,100,200);
			else if(c_ == -1) {  
				c_ = 2;		// 사이클 돌리기위해 -1이면 2로
				c = new Color(130,80,170);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(w>2) {	// 크기가 1이하면 보이지 않음
				w--;
				h--;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(w<30) {  // 30이상까지 늘어나지 않도록 설정
			w++;
			h++;
			break;
		}}
		repaint();
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	//this.setFocusable(true);
}

class Draw extends JFrame {
	public Draw() {
		setBounds(700,300,500,500);
		setTitle("마우스로 그림 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Panel());
		setVisible(true);
	}
}

public class report8 {
	public static void main(String[] args) {
		Draw d = new Draw();
	
	}
}
