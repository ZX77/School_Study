/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����3��ѧ��2��ѧ�ڵĳɼ����������
   	int a[3][2],i,j;
   	for(i=0;i<3;i++){//���ѭ�� ѭ��ѧ��
   		printf("����ѧ��%d����ѧ�ڵĳɼ���",i+1);
   		for(j=0;j<2;j++){ //�ڲ�ѭ�� ѭ������ѧ�ڵĳɼ�
   			scanf("%d",&a[i][j]);
   		}
   	}
   	
   	printf("ѧ����ѧ�ż�����ѧ�ڵĳɼ����£�\n");
   	printf("ѧ��\t��һѧ��\t�ڶ�ѧ��\n");
   	for(i=0;i<3;i++){
   		printf("%d\t\t",i+1);
   		for(j=0;j<2;j++){
   			printf("%d\t\t",a[i][j]);
   		}
   		
   		printf("\n");
   	}
}