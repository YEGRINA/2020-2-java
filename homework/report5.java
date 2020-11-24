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
		type = "Ǫ��";
		name = "����";
		age = "6��";
	}

	public String play() {return "������⸦ �����ؿ�.\n";}

	void introduce() {
		System.out.println("��:"+type+"\t�̸�:"+name+"\t����:"+age);
		System.out.println("����ٷ������� ��������� ����!");
		System.out.println(play());
	}
}
class Cat extends Animal implements Happy {
	{
		type = "�ڸ��� �� ���";
		name = "ġ��";
		age = "8��";
	}

	public String play() {return "�����̸� �����ؿ�.\n";}

	void introduce() {
		System.out.println("��:"+type+"\t�̸�:"+name+"\t����:"+age);
		System.out.println("��� �������� ���� �Ϳ��� ġ��!");
		System.out.println(play());
	}	
}
class Hamster extends Animal implements Happy {
	{
		type = "�ø����ܽ���";
		name = "����";
		age = "3��";
	}

	public String play() {return "�¹��� Ÿ�� ���� �����ؿ�.\n";}

	void introduce() {
		System.out.println("��:"+type+"\t�̸�:"+name+"\t����:"+age);
		System.out.println("����� ������ �ŷ��� ����!");
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
			System.out.print("���� �ݷ� ����: 1.��\t2.�����\t3.�ܽ��� (����):");
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
