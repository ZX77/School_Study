/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //2、编写程序，让用户输入20个整数，统计这20个数中有多少个奇数、多少个偶数并输出。
    int a[20],i,j=0,o=0;
    
    printf("请输入20个整数，空格隔开，回车结束：");
    for(i=0;i<20;i++){
    	scanf("%d",&a[i]);
    	if(a[i]%2==0){
    		o++;
    	}else{
    		j++;
    	}
    }
    
    printf("奇数有%d个，偶数有%d个",j,o);
    
}