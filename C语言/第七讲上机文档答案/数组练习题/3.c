/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int n,a[10][10],i,j,d1=0,d2=0,jxd=0;
    printf("请输入数组大小：");
    scanf("%d",&n);//445
    
    
    for(i=0;i<n;i++){
    	printf("请给数组的第%d行输入%d个数字：",i+1,n);
    	for(j=0;j<n;j++){
    		scanf("%d",&a[i][j]);
    		//第一条对角线
    		if(i==j){
    			d1+=a[i][j];
    		}
    		//第二条对角线
    		if(i+j==n-1){
    			d2+=a[i][j];
    		}
    		
    		//判断对角线的值
    		if(i==j&&i+j==n-1){
    			jxd=a[i][j];
    		}
    	}
    }
    
    printf("第一条对角线上的和是%d\n",d1);
    printf("第二条对角线上的和是%d\n",d2);
    printf("两条对角线的和是%d",d1+d2-jxd);
    
}