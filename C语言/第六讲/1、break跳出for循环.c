/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 	//��128~325֮��������15�ı������� 
 	int i,count=0;
 	for(i=128;i<=325;i++){
 		if(i%15==0){
 			printf("%d\t",i);
 			count++;
 		}
 		
 		if(count==3){
 			break;//�ҵ�3��������ѭ��
 		}
 	}
   
}