/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int n,a[10][10],i,j,d1=0,d2=0,jxd=0;
    printf("�����������С��");
    scanf("%d",&n);//445
    
    
    for(i=0;i<n;i++){
    	printf("�������ĵ�%d������%d�����֣�",i+1,n);
    	for(j=0;j<n;j++){
    		scanf("%d",&a[i][j]);
    		//��һ���Խ���
    		if(i==j){
    			d1+=a[i][j];
    		}
    		//�ڶ����Խ���
    		if(i+j==n-1){
    			d2+=a[i][j];
    		}
    		
    		//�ж϶Խ��ߵ�ֵ
    		if(i==j&&i+j==n-1){
    			jxd=a[i][j];
    		}
    	}
    }
    
    printf("��һ���Խ����ϵĺ���%d\n",d1);
    printf("�ڶ����Խ����ϵĺ���%d\n",d2);
    printf("�����Խ��ߵĺ���%d",d1+d2-jxd);
    
}