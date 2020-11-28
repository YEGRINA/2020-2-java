import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.Graphics;

class Frame extends JFrame {
	// 이미지 라벨 배열을 위한 건데 암튼 실패라,,
//	JLabel[] imageLabel = new JLabel[300];  // 이미지 추가를 위한 빈 라벨
//	int image_num = 0;
//	ImageIcon[] image = new ImageIcon[300];
	Container container;
	
	JLabel imageLabel1 = new JLabel();
	JLabel imageLabel2 = new JLabel();
	JLabel imageLabel3 = new JLabel();
	JLabel imageLabel4 = new JLabel();
	JLabel imageLabel5 = new JLabel();
	JLabel imageLabel6 = new JLabel();
	JLabel imageLabel7 = new JLabel();
	JLabel imageLabel8 = new JLabel();
	JLabel imageLabel9 = new JLabel();
	
	String[] image_name;
	int image_name_num = 0;
	
//	Object[] image = {};
//	image.이름 = 'haha';
//	console.log(image);
	
//	ImageIcon icon = new ImageIcon("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/지희토토로_작업01_채색_지희.jpg");
//	JLabel label1 = new JLabel();
	
	public Frame() {
		// 프레임 크기, 이름, 위치 설정
		setSize(700,750);
		setTitle("앨범");
		setLocationRelativeTo(null);  // 화면 중앙에 위치시킴
		// 컨테이너 생성
		container = getContentPane();
		container.setLayout(null);
		
		createMenu();
		loadImage();
		
		// 이미지 배열 실패,,
//		for(int i=0;i<image_num;i++) {
//			container.add(imageLabel[i]);
//		}
		
		imageLabel1.setBounds(20,20,200,200);
		imageLabel2.setBounds(240,20,200,200);
		imageLabel3.setBounds(460,20,200,200);
		imageLabel4.setBounds(20,240,200,200);
		imageLabel5.setBounds(240,240,200,200);
		imageLabel6.setBounds(460,240,200,200);
		imageLabel7.setBounds(20,460,200,200);
		imageLabel8.setBounds(240,460,200,200);
		imageLabel9.setBounds(460,460,200,200);
		
		container.add(imageLabel1);
		container.add(imageLabel2);
		container.add(imageLabel3);
		container.add(imageLabel4);
		container.add(imageLabel5);
		container.add(imageLabel6);
		container.add(imageLabel7);
		container.add(imageLabel8);
		container.add(imageLabel9);
		
		// 라벨 클릭하면 창 띄우려고 했으나 안될거 같아 다른 방법으로 시도해볼게,,
//		addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if(e.getSource() == imageLabel1) {
//					JOptionPane.showMessageDialog(null, "클릭");
//				}
//			}
//		});
		
		setVisible(true);
	}
	
	// 메뉴바와 메뉴아이템을 생성
	void createMenu() {  
		JMenuBar mb = new JMenuBar();
		JMenu searchMenu = new JMenu("검색");
		JMenu addDeleteMenu = new JMenu("추가/삭제");
		JMenu editMenu = new JMenu("편집");
		JMenuItem [] menuItem = new JMenuItem[6];
		String[] itemTitle = {"컴퓨터에서 검색", "앨범에서 검색","추가","삭제","텍스트 추가","필터"};
		
		MenuActionListener mal = new MenuActionListener();
		for(int i=0;i<menuItem.length;i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(mal);
			if(i < 2)
				searchMenu.add(menuItem[i]);
			else if(i < 4)
				addDeleteMenu.add(menuItem[i]);
			else if(i < 6)
				editMenu.add(menuItem[i]);
		}
		mb.add(searchMenu);
		mb.add(addDeleteMenu);
		mb.add(editMenu);
		
		setJMenuBar(mb);
	}
	
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			switch(s) {
			case "컴퓨터에서 검색":
				
				break;
			case "앨범에서 검색":
				
				break;
			case "추가":
				add();
				break;
			case "삭제":
				delete();
				break;
			case "텍스트 추가":
				addText();
				break;
			case "필터":
				filter();
			}
		}
	}
	
//	==================추가 함수 정의==================
	
	// 이미지 추가하는 함수, 파일 열면서 저장됨
	void add() {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		BufferedImage image_ = null;
		int width, height;  // 저장할 크기
		String name;  // 저장할 이름
		
		// 필터 작동 안함 왜지,,,?
//		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG File", "jpg", "png");  // filter 확장자 추가
//		fc.addChoosableFileFilter(filter);
//		fc.setFileFilter(filter);  // 파일 필터 추가
		
		// 파일 선택 안하면 name을 못 가져와서 에러뜸 딱히 다른거에 지장은 없음
		File file = fc.getSelectedFile();
		name = file.getName();
		
		image_name[image_name_num++] = name;
		createLabel(file);
		
		// 이미지라벨 배열로 만드는거 실패,,
//		for(int i=0;i<image_num;i++) {
//			if(imageLabel[i].getIcon() == null)
//				imageLabel[i].setIcon(resize_icon);
//		}
//		image[image_num] = new ImageIcon(file.getPath());	
//		imageLabel[image_num].setIcon(image[image_num]);
//		imageLabel[image_num].setIcon(new ImageIcon(file.getPath()));
//		image_num++;
//		imageLabel[0].setIcon(icon);
		
		// 이미지 읽기
		try {
			image_ = ImageIO.read(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		width = image_.getWidth();
		height = image_.getHeight();	
		// 이미지 저장
		try {
			BufferedImage bufferedimage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			bufferedimage.createGraphics().drawImage(image_, 0,0,null);
			ImageIO.write(bufferedimage, "jpg", new File("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/"+name));
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		loadImage();
	}
	
	// 이미지를 삭제하는 함수
	void delete() {
		String choice;
		choice = (String) JOptionPane.showInputDialog(null, "삭제할 사진을 선택하세요", "삭제하기", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
		File file = new File("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/"+choice);
		if(file.exists()) {
			file.delete();
		}
		loadImage();
	}
	
	// 라벨(이미지)에 텍스트 추가하는 함수
	void addText() {
		String choice, text = null;
		choice = (String) JOptionPane.showInputDialog(null, "텍스트를 추가할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
		File file = new File("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/"+choice);
		if(file.exists()) {
			text = JOptionPane.showInputDialog(null, "텍스트를 입력하세요", "텍스트 추가",JOptionPane.PLAIN_MESSAGE);
			JOptionPane.showMessageDialog(null, text, "입력된 텍스트", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	// 이미지에 필터를 적용하는 함수
	void filter() {
		String choice;
		choice = (String) JOptionPane.showInputDialog(null, "필터를 적용할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
		File file = new File("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/"+choice);
		
	}
	
	// 이미지 라벨을 만드는 함수
	void createLabel(File file) {
		// 아이콘 사이즈를 조절하기 위해 필요한 변수
		Image origin_image, resize_image;
		ImageIcon origin_icon, resize_icon;
		// 아이콘 사이즈 조절
		origin_icon = new ImageIcon(file.getPath());
		origin_image = origin_icon.getImage();
		resize_image = origin_image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		resize_icon = new ImageIcon(resize_image);

		inputImage(resize_icon);
	}
	
	// 라벨에 이미지 삽입
	void inputImage(ImageIcon resize_icon) {  
		
		if(imageLabel1.getIcon() == null)
			imageLabel1.setIcon(resize_icon);
		else if(imageLabel2.getIcon() == null)
			imageLabel2.setIcon(resize_icon);
		else if(imageLabel3.getIcon() == null)
			imageLabel3.setIcon(resize_icon);
		else if(imageLabel4.getIcon() == null)
			imageLabel4.setIcon(resize_icon);
		else if(imageLabel5.getIcon() == null)
			imageLabel5.setIcon(resize_icon);
		else if(imageLabel6.getIcon() == null)
			imageLabel6.setIcon(resize_icon);
		else if(imageLabel7.getIcon() == null)
			imageLabel7.setIcon(resize_icon);
		else if(imageLabel8.getIcon() == null)
			imageLabel8.setIcon(resize_icon);
		else if(imageLabel9.getIcon() == null)
			imageLabel9.setIcon(resize_icon);
	}
	
	// 폴더에 저장되어 있는 이미지를 불러옴
	void loadImage() {
		clear();
		image_name = new String[10];
		image_name_num = 0;
		String name;
		String directory_name = "C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/";
		File directory = new File(directory_name);
		File file[] = directory.listFiles();
		for(File f:file) {
			createLabel(f);
			name = f.getName();
			image_name[image_name_num++] = name;
		}
	}
	
	// 이미지 라벨을 비워주는 함수
	void clear() {
		imageLabel1.setIcon(null);
		imageLabel2.setIcon(null);
		imageLabel3.setIcon(null);
		imageLabel4.setIcon(null);
		imageLabel5.setIcon(null);
		imageLabel6.setIcon(null);
		imageLabel7.setIcon(null);
		imageLabel8.setIcon(null);
		imageLabel9.setIcon(null);
	}
	
	/*class FileChooser implements ActionListener {
		JFileChooser fc = new JFileChooser();
		int openValue = fc.showOpenDialog(null);
		String name, filePath;
		BufferedImage image_ = null;
		int width, height;
		
		
		public void actionPerformed(ActionEvent e) {
//			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG File", "jpg");  // filter 확장자 추가
//			fc.addChoosableFileFilter(filter);
//			fc.setFileFilter(filter);  // 파일 필터 추가
			
			if(openValue == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();  // 선택된 파일 가져옴
				image[image_num] = new ImageIcon(file.getPath());	
				imageLabel[image_num].setIcon(image[image_num++]);	
				
				
//				label1.setIcon(new ImageIcon("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/프로젝트/album/image/개뿔나른한오후_1920_1080.jpg"));

				try {
					image_ = ImageIO.read(file);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				width = image_.getWidth();
				height = image_.getHeight();
						
				// 이미지 저장
				try {
					BufferedImage bufferedimage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
					// null과 this 차이?
					bufferedimage.createGraphics().drawImage(image_, 0,0,null);
					ImageIO.write(bufferedimage, "jpg", new File("C:/Users/syn58/Desktop/2020-2학기/객체지향프로그래밍설계/Project/album/image/"+name));
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}*/
}

public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame();
		
	}
}
