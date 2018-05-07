/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //计算2017年每个月有多少天
    int m;
    printf("请输入月份：");
    scanf("%d",&m);
    switch(m){
    	case 1:
    		
    	case 3:
    		
    	case 5:
    		
    	case 7:
    		
    	case 8:
    		
    	case 10:
    		
    	case 12:
    		printf("这个月有31天!");break;
    	case 4:
    		
    	case 6:
    		
    	case 9:
    		printf("这个月有30天!");break;
    	case 11:
    		printf("这个月有30天!");break;
    	case 2:
    		printf("这个月有28天!");break;
    	default:
    		printf("请输入正确的月份！");
    }
}