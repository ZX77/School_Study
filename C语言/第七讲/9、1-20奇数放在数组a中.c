/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�����¶��壺int a[10];
	//�����forѭ����0~20֮��������������δ��������a�У�
	
	
	int i,j=0,a[10];
	for(i=0;i<=20;i++){
		if(i%2==1){//����
			a[j]=i; //j������±�
			j++;
		}
	}
	
	
	printf("�����е�������:");
	for(j=0;j<10;j++){
		printf("%d\t",a[j]);
	}
}