/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���Բ���
    int a[10],i,k;
    printf("������ʮ��������");
    for(i=0;i<10;i++){
    	
    	scanf("%d",&a[i]);
    
    
    }
    
    printf("��������Ҫ���ҵ����� ");
    scanf("%d",&k);
    
    for(i=0;i<10;i++){
    	if(a[i]==k){
    		break;
    	}
    }
    
    if(i<10){//0-9
    	printf("��Ҫ���ҵ�%d������ĵ�%d��λ��!",k,i+1);	
    }else{
    	printf("��Ҫ���ҵ����������в����ڣ�");
    }
}