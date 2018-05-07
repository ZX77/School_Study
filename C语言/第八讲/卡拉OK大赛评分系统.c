/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //卡拉OK大赛评分系统
    float a[10],max,min,sum=0;
    int i;
    printf("*                 卡拉OK大赛评分系统                *\n");
    printf("-----------------------------------------------------\n");
    printf("        第一届宏图杯卡拉OK大赛正式开始               \n");
    printf("-----------------------------------------------------\n");
    for(i=0;i<10;i++){
    	printf("请第%d位裁判打分:",i+1);
    	scanf("%f",&a[i]);
    }
    max=a[0];
    min=a[0];
    printf("各裁判打分如下:\n");
    for(i=0;i<10;i++){
    	printf("%.2f\t",a[i]);
    	if(i==4){
    		printf("\n");
    	}
    	if(a[i]>max){
    		max=a[i];
    	}
    	if(a[i]<min){
    		min=a[i];
    	}
    	sum+=a[i];
    }
    
    printf("\n去掉一个最高分:%.2f\n",max);
    printf("\n去掉一个最低分:%.2f\n",min);
    printf("\n该选手最终得分:%.2f\n",(sum-max-min)/8);
}