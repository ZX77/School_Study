/* Note:Your choice is C IDE */
#include "stdio.h"

void max(int []);//变量是数组 不要添加数据大小

void main()
{
    //传址调用：将变量的内存地址传递过去，所以原来变量的值会被改变
    //数组参数就是传址调用，其他类型都是传值调用
    int a[10]={1,2,3,4,5,6,7,3,4,5},i;
    max(a);//数组作为参数传递时只需要填变量名 不要数据大小
    
    for(i=0;i<10;i++){
    	printf("%d\t",a[i]);
    }
}

void max(int a[]){//形参不要加数组大小
	int m,i;
	for(i=0;i<10;i++){
		a[i]=10;
	}
	
	
}