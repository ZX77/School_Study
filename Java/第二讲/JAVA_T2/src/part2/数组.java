package part2;

public class 数组 {
	public static void main(String[] args){
		//一维数组
		
		int i = 10;
		int[] a1 =new int[5];//在声明的时候初始化数组大小
		
		
		int a2[];//先声明
		
		a2=new int[i];//再初始化数组大小 (可以用变量作为数组大小)
		
		
		//一维数组静态赋值
		int b[]={1,2,3,4};
		int b2[]=new int[]{1,2,3,4,5};
		
		for(int j=0;j<b.length;j++){
			System.out.println(b[j]);
		}
		
		
		
		int b3[];
		//b3[0]=10;// 错误 ！   数组使用之前要初始化
		
		
		
		//多维数组
		int c[][]=new int[3][4];
		
		//静态赋值
		int d[][]={{1,2,3},{1,34,3},{1,2,34}};
		
		
		//如何指定不规则多维数组
		int xx[][]=new int [3][];//先指定一个3行N列的数组
		xx[0]=new int[3];// 给第一行设置列数为3
		xx[1]=new int[1]; //给第二行设置列数为1
		xx[2]=new int[2]; //给第二行设置列数为2
		
		xx[1][1]=10;//错误！ 第二行只有1列
		
		System.out.println(xx[1][1]);
		
		
		
	}
}
