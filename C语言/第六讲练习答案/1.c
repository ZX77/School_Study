/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //1、编写程序，输出1~100中非6的倍数的数字（要求用while循环实现，每行输出8个）
    int i=0,count=0;
    while(i<100){
    	i++;
    	if(i%6==0){
    		continue;
    	}
    	printf("%d ",i);
    	count++;
    	if(count%8==0){
    		printf("\n");
    	}
    }
}