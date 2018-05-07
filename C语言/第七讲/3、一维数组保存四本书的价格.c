/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //分别输入四本书的价格，并且输出
    float book[4];
    int i;
    printf("请输入4本书的价格：");
    for(i=0;i<4;i++){
    	scanf("%f",&book[i]);
    }
    printf("四本书的价格是：");
    for(i=0;i<4;i++){
    	printf("%f\t",book[i]);
    }
    
}