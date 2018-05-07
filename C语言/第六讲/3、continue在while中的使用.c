/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //continue 跳出本次循环，继续下一次循环
    //continue 前面的内容仍然会执行，只是跳过continue后面的内容不执行
    
    int i=0;
    while(i<5){
    	printf("********************************************\n");
    	i++;
    	if(i%2==0){
    		continue;
    	}
    	printf("i = %d \n",i);
    }
}