/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���Բ���
    int a[10],i,k,flag=0;
    printf("������ʮ��������");
    for(i=0;i<10;i++){
    	
    	scanf("%d",&a[i]);
    
    
    }
    
    printf("��������Ҫ���ҵ����� ");
    scanf("%d",&k);
    
    for(i=0;i<10;i++){
    	if(a[i]==k){
    		flag=1;//�ı��ʶ����ʾ�ҵ��ˣ�
    		break;
    	}
    }
    
    if(flag==1){//0-9
    	printf("��Ҫ���ҵ�%d������ĵ�%d��λ��!",k,i+1);	
    }else{
    	printf("��Ҫ���ҵ����������в����ڣ�");
    }
}