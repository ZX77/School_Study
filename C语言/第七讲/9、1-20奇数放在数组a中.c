/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //有如下定义：int a[10];
	//如何用for循环将0~20之间的所有奇数依次存放在数组a中？
	
	
	int i,j=0,a[10];
	for(i=0;i<=20;i++){
		if(i%2==1){//奇数
			a[j]=i; //j数组的下标
			j++;
		}
	}
	
	
	printf("数组中的数字是:");
	for(j=0;j<10;j++){
		printf("%d\t",a[j]);
	}
}