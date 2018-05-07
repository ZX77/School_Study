/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //计算1+2+3+4+...100的和
    int i=1,sum=0;
    while(i<=100){
    	
    	sum+=i;//累加i的和赋给sum   sum=sum+i;
    	i++;
    }
    
    printf("1+2+3+...+100的和是 %d \n",sum);
}