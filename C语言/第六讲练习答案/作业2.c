/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //��ҵ2������1~50֮�����������ĺ� 
    int i=0,sum=0;
    for(i=1;i<=50;i++){
    	sum+=i;
    }
    printf("1+2+3+...+50=%d\n",sum);
    
    i=0;
    sum=0;
    
    while(i<=50){
    	sum+=i;
    	i++;
    }
    
     printf("1+2+3+...+50=%d",sum);
}