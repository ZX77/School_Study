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
    
    printf("�����ά����ĵ���������%d\n",a[1][0]);
    
    
    //
    for(i=0;i<3;i++){//���ѭ����ѭ���У�
    	for(j=0;j<2;j++){//�ڲ�ѭ����ѭ���У�
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