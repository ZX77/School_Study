/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //�ֱ������ı���ļ۸񣬲������
    float book[4];
    int i;
    printf("������4����ļ۸�");
    for(i=0;i<4;i++){
    	scanf("%f",&book[i]);
    }
    printf("�ı���ļ۸��ǣ�");
    for(i=0;i<4;i++){
    	printf("%f\t",book[i]);
    }
    
}