/* Note:Your choice is C IDE */
#include "stdio.h"

void sums();

int sum=0;//全局变量

void main()
{
    //全局变量
    //1、在函数外面定义，作用范围是整个程序
    //2、全局变量是共享的
    //3、局部变量和全局变量可以同名，但优先获取局部变量的值！
    int sum=0;//局部变量
    sums();
    printf("主函数中sum的值是%d",sum);
}

void sums(){
	int a,b;
	printf("请输入两个数：");
	scanf("%d %d",&a,&b);
	sum=a+b;
	printf("sum的值是%d",sum);
}