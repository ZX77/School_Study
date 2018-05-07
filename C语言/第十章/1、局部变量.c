/* Note:Your choice is C IDE */
#include "stdio.h"

void sums();


//局部变量
//1、定义在自定义函数或主函数中的变量！作用范围就是在本函数中！
//2、不同函数的局部变量互不影响，名称可以相同！
//3、局部变量是函数私有的
void main()
{
	int sum=0;
    sums();//调用函数
    printf("主函数中sum的值是%d",sum);
    
    {//复合语句：在函数中使用大括号指定的范围
    	int sum=5;//局部变量（复合语句的局部变量）
    	printf("复合语句中的sum %d",sum);
    }
}

void sums(){
	int a,b,sum=0;//局部变量
	printf("请输入两个数：");
	scanf("%d %d",&a,&b);
	sum=a+b;
	printf("sum的值是 %d",sum);
}