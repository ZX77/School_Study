/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //����ֵ
    int a[10];
    int i,max,min;
    printf("������ʮ���������ÿո������");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    }
    
    //�����ֵ
    max = a[0];
    min = a[0];
    
    for(i=0;i<10;i++){
    	if(a[i] > max){
    		max = a[i];
    	}
    	
    	if(a[i] < min){
    		min = a[i];
    	}
    }
    
    printf("�����е��������%d����С���� %d",max,min);
}