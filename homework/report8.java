import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Point {
	int x, y;
}
class Panel extends JPanel implements MouseMotionListener, KeyListener {
	private int index = 0;
	Point[] array = new Point[1000];
	int w = 3, h = 3;  // ���� �β��� �����ϴ� ����
	// Ŭ���� Color(Red, Green, Blue) ���� ��(0~255)����
	// �ʱ� ���� ����
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
				c_ = 0;    // ����Ŭ ���������� 3�̵Ǹ� 0����
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
				c_ = 2;		// ����Ŭ ���������� -1�̸� 2��
				c = new Color(130,80,170);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(w>2) {	// ũ�Ⱑ 1���ϸ� ������ ����
				w--;
				h--;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(w<30) {  // 30�̻���� �þ�� �ʵ��� ����
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
		setTitle("���콺�� �׸� �׸���");
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
