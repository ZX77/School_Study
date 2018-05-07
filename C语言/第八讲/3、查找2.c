/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //线性查找
    int a[10],i,k,flag=0;
    printf("请输入十个整数：");
    for(i=0;i<10;i++){
    	
    	scanf("%d",&a[i]);
    
    
    }
    
    printf("请输入您要查找的数： ");
    scanf("%d",&k);
    
    for(i=0;i<10;i++){
    	if(a[i]==k){
    		flag=1;//改变标识，表示找到了！
    		break;
    	}
    }
    
    if(flag==1){//0-9
    	printf("您要查找的%d在数组的第%d个位置!",k,i+1);	
    }else{
    	printf("您要查找的数在数组中不存在！");
    }
}