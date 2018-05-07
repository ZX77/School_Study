/* Note:Your choice is C IDE */
#include "stdio.h"
void tt(int);

void main()
{
	//向自定义函数传递参数分为
	//传值调用：只是将变量的值传递过去，并没有改变变量的内存地址！
	//传址调用
	int a=0;
	tt(a);
	printf("a的值是%d",a);
}

void tt(int a){
	printf("a = %d",a);
	a=10;
}
