import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;

import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;

class Info extends JFrame {
   public Info() {
      setSize(770,700);
      setTitle("앨범");
      setLocationRelativeTo(null);  // 화면 중앙에 위치시킴
      setLayout(null);
      setVisible(true);
   }
}

class Frame extends JFrame {
   Container container;
   JScrollPane scrollPane;
   JPanel panel = new JPanel();
   JLabel[] imageLabel = new JLabel[200];   //이미지 라벨 배열 
   
   String directory_name = "C:/Jproject/";  // 이미지를 저장하는 디렉토리
   // 이미지를 로드할 때마다 새로 배열에 이름을 저장함
   String[] image_name;
   int image_name_num = 0;
   
   public Frame() {
      // 프레임 크기, 이름, 위치 설정
      setSize(715,750);
      setTitle("앨범");
      setLocationRelativeTo(null);  // 화면 중앙에 위치시킴

      container = getContentPane();
      container.setLayout(null);
      panel.setLayout(null);
       
      //directory_name이 가리키는 경로에  앨범 폴더가 없으면 생성
      File directory = new File(directory_name);
      if(!directory.exists()) {   //directory_name이 가리키는 위치에 폴더가 없으면
         try {
            directory.mkdir();   //폴더를 생성
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
      }
      
      //라벨 위치 지정
      for(int i = 0, x=0, y=0; i<imageLabel.length; i++) {      
         imageLabel[i] = new JLabel();
         imageLabel[i].setBounds(20+(220*x++),20+(220*y),200,200);
         if(x == 3) {
            x = 0;
            y++;
         }
         panel.add(imageLabel[i]);
      }
      
      scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setSize(new Dimension(700,687));
      container.add(scrollPane);
      
      createMenu();
      loadImage();
      
      setVisible(true);
   }
   
   // 메뉴바와 메뉴아이템을 생성
   void createMenu() {  
      JMenuBar mb = new JMenuBar();
      JMenu searchMenu = new JMenu("검색");
      JMenu addDeleteMenu = new JMenu("추가/삭제");
      JMenu editMenu = new JMenu("편집");
      JMenu lookMenu = new JMenu("보기");
      JMenuItem [] menuItem = new JMenuItem[9];
      String[] itemTitle = {"컴퓨터에서 검색", "앨범에서 검색","추가","삭제","텍스트 추가","텍스트 삭제","흑백","사진 정보","도움말"};
      
      MenuActionListener mal = new MenuActionListener();
      for(int i=0;i<menuItem.length;i++) {
         menuItem[i] = new JMenuItem(itemTitle[i]);
         menuItem[i].addActionListener(mal);
         if(i < 2)
            searchMenu.add(menuItem[i]);
         else if(i < 4)
            addDeleteMenu.add(menuItem[i]);
         else if(i < 7)
            editMenu.add(menuItem[i]);
         else if(i < 9)
            lookMenu.add(menuItem[i]);
      }
      mb.add(searchMenu);
      mb.add(addDeleteMenu);
      mb.add(editMenu);
      mb.add(lookMenu);
      
      setJMenuBar(mb);
   }
   
   class MenuActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String s = e.getActionCommand();
         switch(s) {
         case "컴퓨터에서 검색":
            searchInCom();
            break;
         case "앨범에서 검색":
            searchInAlbum();
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
         case "텍스트 삭제":
        	 deleteText();
        	 break;
         case "흑백":
            filter();
            break;
         case "사진 정보":
            imageInfo();
            break;
         case "도움말":
            help();
            break;
         }
      }
   }
   
//   ==================추가 함수 정의==================
   
   void searchInCom() {
	   File file = null;
	   JFileChooser fc = new JFileChooser();
	   // 아이콘 사이즈를 조절하기 위해 필요한 변수
	   Image origin_image, resize_image;
	   ImageIcon origin_icon, resize_icon;
      
	   JLabel label1 = new JLabel();
	   // 파일 필터 추가
	   FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG FILE","jpg","png");
	   fc.setFileFilter(filter);  
	   // 열기 버튼을 누를 경우만 실행됨
	   if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	       file = fc.getSelectedFile();
	       origin_icon = new ImageIcon(file.getPath());
		   origin_image = origin_icon.getImage();
	  	   resize_image = origin_image.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
	       resize_icon = new ImageIcon(resize_image);
	       label1.setIcon(resize_icon);
	       label1.setHorizontalAlignment(SwingConstants.CENTER);
	       label1.setBounds(0,10,750,550);
	       
	       Info info = new Info();
	       info.add(label1);
	      }
   }
   
   // 키워드를 통해 앨범 내 사진 검색하는 함수
   void searchInAlbum() {
	   String keyWord, line, image_name = null;
	   keyWord = JOptionPane.showInputDialog(null, "키워드를 입력하세요", "키워드 입력",JOptionPane.PLAIN_MESSAGE);
	   if(keyWord == null) return;
	   try {
		   FileReader fileReader = new FileReader(directory_name + "text.txt");
		   BufferedReader bufferedReader = new BufferedReader(fileReader);
		   
		   while((line = bufferedReader.readLine()) != null) {
			   image_name = line;
			   // 텍스트는 다음 줄에 저장되어 있으므로 한번 더 읽음
			   line = bufferedReader.readLine();
			   if(line.indexOf(keyWord) != -1) {
				   information(image_name);
			   }
			   else {
				   image_name = null;
			   }
		   }
		   fileReader.close();
	  	   bufferedReader.close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   if(image_name == null) {
		   JOptionPane.showMessageDialog(null, "사진이 존재하지 않습니다", "경고", JOptionPane.ERROR_MESSAGE);
	   }
   }
   
   // 이미지 추가하는 함수, 파일 열면서 저장됨
   void add() {
	  BufferedImage image_ = null;
	  int width = 0, height = 0;  // 이미지 크기
	  String name = null;  // 이미지 이름
      File file = null;
      JFileChooser fc = new JFileChooser();
      // 파일 필터 추가
      FileNameExtensionFilter filter = new FileNameExtensionFilter(
              "JPG & PNG FILE","jpg","png");
      fc.setFileFilter(filter);  
      // 열기 버튼을 누를 경우만 실행됨
      if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
          file = fc.getSelectedFile();
          name = file.getName();
          createLabel(file);
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
             ImageIO.write(bufferedimage, "jpg", new File(directory_name+name));
          }
          catch (Exception e1) {
             e1.printStackTrace();
          }
          loadImage();
    	  JOptionPane.showMessageDialog(null, "추가되었습니다", "추가 완료", JOptionPane.PLAIN_MESSAGE);
      }
   }
   
   // 이미지를 삭제하는 함수
   void delete() {
      String choice;
      choice = (String) JOptionPane.showInputDialog(null, "삭제할 사진을 선택하세요", "삭제하기", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
      File file = new File(directory_name + choice);
      if(file.exists()) {
         file.delete();
      }
      else return;
      cleanTxt(choice);
      loadImage();
	  JOptionPane.showMessageDialog(null, "삭제되었습니다", "삭제 완료", JOptionPane.PLAIN_MESSAGE);
   }
   
   // 사진 선택 후 텍스트 입력하는 함수
   void addText() {
      String choice, text = null;
      choice = (String) JOptionPane.showInputDialog(null, "텍스트를 추가할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
      File imageFile = new File(directory_name + choice);
      if(choice == null) return;
      if(imageFile.exists()) {
         text = JOptionPane.showInputDialog(null, "텍스트를 입력하세요", "텍스트 추가",JOptionPane.PLAIN_MESSAGE);
         JOptionPane.showMessageDialog(null, text, "입력된 텍스트", JOptionPane.PLAIN_MESSAGE);
      }
      try {
    	 FileWriter fileWriter = new FileWriter(directory_name + "text.txt", true);
    	 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
  	     
  	     cleanTxt(choice);
  	   
  	     bufferedWriter.write(choice);
  	     bufferedWriter.newLine();
  	     bufferedWriter.write(text);
  	     bufferedWriter.newLine();
  	     
  	     bufferedWriter.close();
  	     fileWriter.close();
      } catch (IOException e) {
  		e.printStackTrace();
      }
   }
   
   // 텍스트를 삭제하는 함수
   void deleteText() {
	   String choice;
	   choice = (String) JOptionPane.showInputDialog(null, "텍스트를 삭제할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
	   if(choice == null) return;
	   cleanTxt(choice);
	   JOptionPane.showMessageDialog(null, "삭제되었습니다", "삭제 완료", JOptionPane.PLAIN_MESSAGE);
   }
   
   // choice 빼고 저장하는 함수
   void cleanTxt(String choice) {
	   String text = null;
	   try {
		   // text.txt -> tmp.txt
		   FileReader fileReader = new FileReader(directory_name + "text.txt");
		   BufferedReader bufferedReader = new BufferedReader(fileReader);
		   FileWriter tmpFile = new FileWriter(directory_name + "tmp.txt");
		   BufferedWriter bufferedWriter = new BufferedWriter(tmpFile);
		   
		   while((text = bufferedReader.readLine()) != null) {
			   if(text.indexOf(choice) != -1) {
				   text = bufferedReader.readLine();
			   }
			   else {
				   bufferedWriter.write(text);
				   bufferedWriter.newLine();
			   }
		   }
		   fileReader.close();
	  	   bufferedReader.close();
	  	   bufferedWriter.close();
	  	   tmpFile.close();
	  	   
	  	   // tmp.txt -> text.txt
	  	   FileReader fileReader2 = new FileReader(directory_name + "tmp.txt");
		   BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
		   FileWriter textFile = new FileWriter(directory_name + "text.txt");
		   BufferedWriter bufferedWriter2 = new BufferedWriter(textFile);
		   
		   while((text = bufferedReader2.readLine()) != null) {
			   bufferedWriter2.write(text);
			   bufferedWriter2.newLine();
		   }
		   fileReader2.close();
	  	   bufferedReader2.close();
	  	   bufferedWriter2.close();
	  	   textFile.close();
	  	   
	  	   File tmp = new File(directory_name + "tmp.txt");
	  	   tmp.delete();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
   }
   
   // 이미지에 필터를 적용하는 함수
   void filter() {
      String choice;
      choice = (String) JOptionPane.showInputDialog(null, "필터를 적용할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);
      File file = new File(directory_name+choice);
      String name = file.getName();
      BufferedImage image = null;
      int width = 0, height = 0;
      try {
    	  image = ImageIO.read(file);
    	  width = image.getWidth();
    	  height = image.getHeight();
    	  for(int y=0;y<height;y++) {
    		  for(int x=0;x<width;x++) {
    			  Color color = new Color(image.getRGB(x, y));
    			  int red = (int)(color.getRed() * 0.299);
    			  int green = (int)(color.getGreen() * 0.587);
    			  int blue = (int)(color.getBlue() * 0.114);
    			  
    			  Color gray = new Color(red+green+blue, red+green+blue,red+green+blue);
    			  image.setRGB(x, y, gray.getRGB());
    		  }
    	  }
      } catch (IOException e) {
    	  e.printStackTrace();
      } 
      // 이미지 저장
      try {
         BufferedImage bufferedimage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
         bufferedimage.createGraphics().drawImage(image, 0,0,null);
         ImageIO.write(bufferedimage, "jpg", new File(directory_name+name));
      }
      catch (Exception e1) {
         e1.printStackTrace();
      }
      loadImage();
   }
   
   // 사진의 저장된 정보를 확인하는 함수
   void imageInfo() {
	   String choice;
	   choice = (String) JOptionPane.showInputDialog(null, "정보를 확인할 사진을 선택하세요", "사진 선택", JOptionPane.PLAIN_MESSAGE, null, image_name, image_name[0]);	   
	   if(choice == null) return;
	   information(choice);
   }
   
   // choice 이름의 사진 정보 화면에 띄워주는 함수
   void information(String choice) {
	   String text = null;
	   File file = new File(directory_name + choice);
	   File textFile = new File(directory_name + "text.txt");
	   // 아이콘 사이즈를 조절하기 위해 필요한 변수
	   Image origin_image, resize_image;
	   ImageIcon origin_icon, resize_icon;
      
	   JLabel label1 = new JLabel();
	   JLabel label2 = new JLabel();
	   JLabel label3 = new JLabel();
	   
	   // 텍스트 읽기
	   try {
		   FileReader fileReader = new FileReader(textFile);
		   BufferedReader bufferedReader = new BufferedReader(fileReader);

		   while((text = bufferedReader.readLine()) != null) {
			   if(text.indexOf(choice) != -1) {
				   text = bufferedReader.readLine();
				   break;
			   }
		   }
		   fileReader.close();
		   bufferedReader.close();
	   } catch (IOException e1) {
		   e1.printStackTrace();
	   }
      
	   // 아이콘 사이즈 조절
	   origin_icon = new ImageIcon(file.getPath());
	   origin_image = origin_icon.getImage();
  	   resize_image = origin_image.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
       resize_icon = new ImageIcon(resize_image);
       
       label1.setIcon(resize_icon);
       label2.setText("사진 이름 : " + choice);
       label3.setText("입력된 텍스트 : " + text);
       
       label1.setHorizontalAlignment(SwingConstants.CENTER);
       label2.setHorizontalAlignment(SwingConstants.CENTER);
       label3.setHorizontalAlignment(SwingConstants.CENTER);
       
       label1.setBounds(0,10,750,550);
       label2.setBounds(0,520,750,100);
       label3.setBounds(0,540,750,100);
            
       Info info = new Info();
       info.add(label1);
       info.add(label2);
       info.add(label3);
   }
   
   // 사용방법을 확인할 수 있는 함수
   void help() {
      JOptionPane.showMessageDialog(null, "컴퓨터에서 검색 : 컴퓨터 내 저장된 사진을 찾고 확인할 수 있습니다\n"
            + "앨범에서 검색 : 앨범에 저장된 사진을 텍스트의 키워드를 통해 검색할 수 있습니다\n"
            + "추가 : 사진을 컴퓨터에서 찾아 추가할 수 있습니다\n"
            + "삭제 : 앨범 내 저장된 사진을 선택하여 삭제할 수 있습니다\n"
            + "텍스트 추가 : 텍스트를 추가할 사진을 고르고 텍스트를 입력하면 추가됩니다\n"
            + "                        단, 여러번 입력할 경우 제일 마지막에 입력된 결과로 저장됩니다\n"
            + "흑백 : 선택한 사진을 흑백으로 만들 수 있습니다\n"
            + "사진 정보 : 사진 이름과 입력된 텍스트를 확인할 수 있습니다"
            ,"도움말",JOptionPane.PLAIN_MESSAGE);
   }
   
   // 아이콘 사이즈 조절 후 inputImage에 넘겨주는 함수
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
   
   // 라벨에 이미지 삽입하는 함수
   void inputImage(ImageIcon resize_icon) {  
      for(int i = 0; i < imageLabel.length; i++) {
         if( imageLabel[i].getIcon() == null) {
            imageLabel[i].setIcon(resize_icon);
            break;
         }
      }
   }
   
   // 폴더에 저장되어 있는 이미지를 불러오는 함수
   void loadImage() {
      clear();
      image_name = new String[200];
      image_name_num = 0;
      int y = 0;
      String name;
      File directory = new File(directory_name);
      File file[] = directory.listFiles();
      
      for(File f:file) {
         name = f.getName();
         // 확장자가 jpg, png 인 것만 저장     text파일도 포함되기 때문
         if(name.endsWith(".jpg") || name.endsWith(".png")) {
             createLabel(f);
             image_name[image_name_num++] = name;
         }
         if((image_name_num%3) == 0) {
        	 y++;
         }
      }
      if((image_name_num%3) == 2) y++;
      panel.setPreferredSize(new Dimension(715,20+(220*y)));
   }
   
   // 이미지 라벨을 비워주는 함수
   void clear() {
      for(int i = 0; i<imageLabel.length; i++)
            imageLabel[i].setIcon(null);
   }
   
}

public class Main {
   public static void main(String[] args) {
      Frame frame = new Frame();
      
   }
}
