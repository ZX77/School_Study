/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //2����д�������û�����20��������ͳ����20�������ж��ٸ����������ٸ�ż���������
    int a[20],i,j=0,o=0;
    
    printf("������20���������ո�������س�������");
    for(i=0;i<20;i++){
    	scanf("%d",&a[i]);
    	if(a[i]%2==0){
    		o++;
    	}else{
    		j++;
    	}
    }
    
    printf("������%d����ż����%d��",j,o);
    
}