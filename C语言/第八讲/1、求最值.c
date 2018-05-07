/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //求最值
    int a[10];
    int i,max,min;
    printf("请输入十个整数，用空格隔开：");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    }
    
    //求最大值
    max = a[0];
    min = a[0];
    
    for(i=0;i<10;i++){
    	if(a[i] > max){
    		max = a[i];
    	}
    	
    	if(a[i] < min){
    		min = a[i];
    	}
    }
    
    printf("数组中的最大数是%d，最小数是 %d",max,min);
}