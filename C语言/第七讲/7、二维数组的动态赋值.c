/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[3][2];
    int i,j;
    a[0][0]=100;
    a[0][1]=200;
    a[1][0]=300;
    a[1][1]=400;
    
    printf("这个二维数组的第三个数是%d\n",a[1][0]);
    
    
    //
    for(i=0;i<3;i++){//外层循环（循环行）
    	for(j=0;j<2;j++){//内层循环（循环列）
    		a[i][j]=1000;
    	}
    }
    
    for(i=0;i<3;i++){
    	for(j=0;j<2;j++){
    		printf("%d[%d %d]\t",a[i][j],i,j);
    	}
    	printf("\n");
    }
}