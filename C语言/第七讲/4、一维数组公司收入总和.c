/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入公司12个月的收入，并且求和
    float income[12],sum=0;
    int i;
    for(i=0;i<12;i++){
    	printf("请输入公司第%d个月的收入:",i+1);
    	scanf("%f",&income[i]);
    	sum+=income[i];//求和
    }
    
    printf("公司收入总和是%.2f",sum);
    
}