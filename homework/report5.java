import java.util.*;

abstract class Animal {
	public String type;
	public String name;
	public String age;
	abstract void introduce();
}
interface Happy {
	public String play();
}

class Dog extends Animal implements Happy {
	{
		type = "푸들";
		name = "초코";
		age = "6살";
	}

	public String play() {return "술래잡기를 좋아해요.\n";}

	void introduce() {
		System.out.println("종:"+type+"\t이름:"+name+"\t나이:"+age);
		System.out.println("말썽꾸러기지만 사랑스러운 초코!");
		System.out.println(play());
	}
}
class Cat extends Animal implements Happy {
	{
		type = "코리안 숏 헤어";
		name = "치즈";
		age = "8살";
	}

	public String play() {return "공놀이를 좋아해요.\n";}

	void introduce() {
		System.out.println("종:"+type+"\t이름:"+name+"\t나이:"+age);
		System.out.println("계속 괴롭히고 싶은 귀여운 치즈!");
		System.out.println(play());
	}	
}
class Hamster extends Animal implements Happy {
	{
		type = "시리아햄스터";
		name = "리아";
		age = "3살";
	}

	public String play() {return "쳇바퀴 타는 것을 좋아해요.\n";}

	void introduce() {
		System.out.println("종:"+type+"\t이름:"+name+"\t나이:"+age);
		System.out.println("토실한 볼살이 매력인 리아!");
		System.out.println(play());
	}	
}

public class report5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		boolean [] check = {false, false, false};
		Dog d = new Dog();
		Cat c = new Cat();
		Hamster h = new Hamster();
		
		while(check[0] == false || check[1] == false || check[2] == false) {
			System.out.print("나의 반려 동물: 1.개\t2.고양이\t3.햄스터 (선택):");
			num = sc.nextInt();
			if(num == 1) {
				check[0] = true;
				d.introduce();
			}
			else if(num == 2) {
				check[1] = true;
				c.introduce();
			}
			else if(num == 3) {
				check[2] = true;
				h.introduce();
			}
		}
		sc.close();

	}
}
