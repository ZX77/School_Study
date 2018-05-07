/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[5],i;
    //相当于定义了5个变量：分别是
    //a[0] a[1] a[2] a[3] a[4] 
    
    a[0]=10;
    a[1]=20;
    a[2]=30;
    a[3]=40;
    a[4]=50;
    
    //a[5]=100;
    printf("数组的第1个元素是%d \n\n",a[4]);
    
    
    
    //循环给数组赋值（变量可以作为数组下标）
    for(i=0;i<5;i++){
    	a[i]=100;
    }
    
    for(i=0;i<5;i++){
    	printf("数组中的没一个数是：%d\n",a[i]);
    }
    
}