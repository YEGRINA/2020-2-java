import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.event.*;
import java.awt.*;

class Frame extends JFrame {
	
	public Frame() {
		setTitle("앨범");
		createMenu();
//		getContentPane().add();
		setBounds(700,300,500,500);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu searchMenu = new JMenu("검색");
		JMenu addDeleteMenu = new JMenu("추가/삭제");
		JMenuItem [] menuItem = new JMenuItem[4];
		String[] itemTitle = {"컴퓨터에서 검색", "앨범에서 검색","추가","삭제"};
		
		MenuActionListener mal = new MenuActionListener();
		for(int i=0;i<menuItem.length;i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(mal);
			if(i < 2)
				searchMenu.add(menuItem[i]);
			else if(i < 4)
				addDeleteMenu.add(menuItem[i]);
		}
		mb.add(searchMenu);
		mb.add(addDeleteMenu);
		
		setJMenuBar(mb);  // 메뉴바에 붙이기
	}
	
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			switch(s) {
			case "컴퓨터에서 검색":
				FileChooser filechooser = new FileChooser();
				break;
			case "앨범에서 검색":
				
				break;
			case "추가":
				
				break;
			case "삭제":
				
				break;
			}
		}
	}
	
	class FileChooser implements ActionListener {
		JFileChooser fc = new JFileChooser();
		int returnValue = fc.showOpenDialog(null);
//		public FileChooser() {
//			fc = new JFileChooser();
//			
//		}
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images","jpg","gif");  // filter 확장자 추가
			fc.setFileFilter(filter);  // 파일 필터 추가
			if(returnValue == 0) {
			//if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame();
		
	}
}
