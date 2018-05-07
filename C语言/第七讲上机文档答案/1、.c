/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1、编写程序，让用户输入十个整数，将这十个整数写到数组中，同时从数组中读出这些数字并输出到屏幕，以便用户确认其输入的正确性。
    int a[5],i;
    printf("请输入5个数字，用空格隔开：");
    for(i=0;i<5;i++){
    	scanf("%d",&a[i]);
    }
    
    printf("您输入的数字是：\n");
    for(i=0;i<5;i++){
    	printf("%d\t",a[i]);
    }
    
}