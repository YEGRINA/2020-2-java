import java.awt.*;
import javax.swing.*;

class Calculator extends JFrame {
	private JPanel panel;
	private JButton[] buttons;
	private String[] labels = {"1","2","3",
			"4","5","6",
			"7","8","9",
			"*","0","#"
	};
	public Calculator() {
		setBounds(800, 400,300,200);
		setTitle("My Key Pad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,3));
		buttons = new JButton[12];
		int index = 0;
		for(int rows=0;rows<3;rows++) {
			for(int cols=0;cols<4;cols++) {
				buttons[index] = new JButton(labels[index]);
				panel.add(buttons[index]);
				index++;
			}
		}

		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}
}

public class report7 {

	public static void main(String[] args) {
		Calculator c = new Calculator();

	}
}
