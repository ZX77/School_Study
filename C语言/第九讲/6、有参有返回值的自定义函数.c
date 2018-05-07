/* Note:Your choice is C IDE */
#include "stdio.h"

//有参有返回值的原型说明
int max(int ,int);

void main()
{
    //有参有返回值的函数
    //1、自定义函数的返回值类型要与定义时一致
    //2、接收返回值的变量类型要与定义时的返回值类型一致
    int a=5,b=4;
    int m;
    m = max(a,b);//有返回值的函数才能用变量去接收或输出
    
    printf("a和b中较大的数是%d\n",m);//定义变量接收返回值
    printf("a和b中较大的数是%d\n",max(a,b));//可以直接输出返回值
    
    
    
     printf("1和10中较大的数是%d\n",max(1,10));
     
     printf("****************************");
   
}


int max(int a,int b){
	//exit(1);中断整个C程序，不再执行
 	//break;用在循环中，中断循环
	return;//用在函数中，中断函数运行 return 语句后面的代码都不会执行(不会中断程序)
	
	if(a>b){
		return a; //有返回值的函数，需要用return 关键字来返回(如果返回值是 )
	}else{
		return b;
	}
}


