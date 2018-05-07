/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //计算1+3+5+7+...+99 奇数和
    int i = 0,sum=0;
    do{
    	if(i%2==1){//奇数才要算和
    		sum+=i;
    	}
    	i++;
    }while(i<100);
    
    printf("结果是%d",sum);
}