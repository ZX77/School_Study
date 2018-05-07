/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入3个学生2个学期的成绩，并且输出
   	int a[3][2],i,j;
   	for(i=0;i<3;i++){//外层循环 循环学生
   		printf("输入学号%d两个学期的成绩：",i+1);
   		for(j=0;j<2;j++){ //内层循环 循环两个学期的成绩
   			scanf("%d",&a[i][j]);
   		}
   	}
   	
   	printf("学生的学号及两个学期的成绩如下：\n");
   	printf("学号\t第一学期\t第二学期\n");
   	for(i=0;i<3;i++){
   		printf("%d\t\t",i+1);
   		for(j=0;j<2;j++){
   			printf("%d\t\t",a[i][j]);
   		}
   		
   		printf("\n");
   	}
}