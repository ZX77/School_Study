 /* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[5][3],i,j,sum=0,max=0,xh=0;
    for(i=0;i<5;i++){
    	printf("������ѧ��Ϊ%d�����ģ���ѧ��Ӣ��ɼ����ո�������س�������",100+i);
    	for(j=0;j<3;j++){
    		scanf("%d",&a[i][j]);
    	}
    }
    
    printf("ѧ��\t����\t��ѧ\tӢ��\t�ܷ�\n");
    
    for(i=0;i<5;i++){
    	printf("%d\t",100+i);//ѧ��
    	for(j=0;j<3;j++){
    		printf("%d\t",a[i][j]);//�ɼ�
    		sum+=a[i][j];//ÿ��ѧ�����ܷ�
    	}
    
    	printf("%d",sum);//����ܷ�
    	//6 3 15 12 15
    	//�Ա���߷�
    	if(sum>max){
    		max=sum;
    		//xh=100+i;//��¼��߷ֵ�ѧ��(���ܵõ�������ͬ��ѧ��)
    	}
    	sum=0;//����Ҫ��ʼ����
    	printf("\n");//����
    }
    
   // printf("\n��߷ֵ�ѧ����%d,�ܷ���%d",xh,max);
   
   
   
   //Ϊ���ж���߷�����ͬѧ�������
   for(i=0;i<5;i++){
   		for(j=0;j<3;j++){
   			sum+=a[i][j];
   		}
   		if(max==sum){//���ѧ�����ֵܷ��������������߷�
   			printf("��߷ֵ�ѧ����ѧ����%d���ܷ���%d\n",100+i,max);
   		}
   		sum=0;
   }
}