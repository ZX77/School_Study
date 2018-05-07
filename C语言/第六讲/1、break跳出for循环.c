/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 	//在128~325之间找三个15的倍数的数 
 	int i,count=0;
 	for(i=128;i<=325;i++){
 		if(i%15==0){
 			printf("%d\t",i);
 			count++;
 		}
 		
 		if(count==3){
 			break;//找到3个就跳出循环
 		}
 	}
   
}