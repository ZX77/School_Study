/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //嵌套for循环
    //执行完一次外层循环后，会先执行完内层循环，然后再执行下一次外层循环
    int i,j;
    for(i=0;i<5;i++){//外层循环  (控制行数)
    	for(j=0;j<20;j++){//内层 (控制列数)
    		printf("*");	
    	}
    	printf("\n");
    }
}