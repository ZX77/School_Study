/* Note:Your choice is C IDE */
#include "stdio.h"

//函数原型说明
void cube(int,int,int);

void main()
{
    //有参无返回值自定义函数
    //1、调用有参的自定义函数，需要传递和函数定义参数的个数、顺序、类型一致的参数
    //2、函数原型说明可以不写变量名称
    //3、实参和形参的名称可以不一致
    int x=1,y=2,z=3;
    
    
    //调用自定义函数
    //实参（实际参数，调用自定义函数时传递的参数）
    cube(x,y,z);
    cube(1,1,1);
    cube(4,6,7);
}

//自定义函数
void cube(int y,int x,int z){//形参（形式参数，函数定义的参数）
	//在自定义函数的函数体中需要使用形参
	int result=0;
	result=x*x*x+y*y*y+z*z*z;
	printf("立方和是%d\n",result);
}