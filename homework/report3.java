// 입력된 정수값들 정렬하여 출력하기

import java.util.Scanner;

class Sort
{
	Scanner sc = new Scanner(System.in);
	int[] a = new int[10];
	int tmp;
	public void input()
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print("Á¤¼ö"+(i+1)+" = ");
			a[i] = sc.nextInt();
		}
	}
	public void sort()
	{
		for(int i=0;i<a.length-1;i++)
			for(int j=i+1;j<a.length;j++)
				if(a[i]>a[j])
				{
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
	}
	public void output()
	{
		System.out.println();
		for(int i=0;i<a.length-1;i++)
			System.out.print(a[i]+", ");
		System.out.println(a[9]);
	}
}

public class report3 {

	public static void main(String[] args) {
		Sort x = new Sort();
		x.input();
		x.sort();
		x.output();

	}

}

