/* Note:Your choice is C IDE */
#include "stdio.h"
#include "math.h"
void main()
{
    //sqrt pow ������ʹ��
    int i;
    for(i=1;i<=10;i++){
    	printf("%d��ƽ������%.3f\t %d��������%.0f\n",i,sqrt(i),i,pow(i,3));
    }
}