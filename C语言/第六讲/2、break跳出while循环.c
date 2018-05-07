/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //break; 跳出循环，改变循环次数，提前结束循环
    //break只能用在循环中
    int i=0;
    
    while(i<20){
    	if(i==5){
    		break; //break语句后面的代码全都不会执行
    	}
    	
    	printf("***************************\n");
    	i++;
    }
    
   
}