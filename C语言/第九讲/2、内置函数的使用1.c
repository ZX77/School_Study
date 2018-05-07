/* Note:Your choice is C IDE */
#include "stdio.h"
#include "math.h"
void main()
{
    //sqrt pow 函数的使用
    int i;
    for(i=1;i<=10;i++){
    	printf("%d的平方根是%.3f\t %d的立方是%.0f\n",i,sqrt(i),i,pow(i,3));
    }
}