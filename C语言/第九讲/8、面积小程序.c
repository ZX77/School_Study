/* Note:Your choice is C IDE */
#include "stdio.h"

void cfx();
void sjx();
void yx();

void main()
{
    int select;
    
    
    while(1){
    	printf("0、退出 1、长方形 2、三角形 3、圆形！\n");
   		printf("请选择你要计算的图形：");
    	scanf("%d",&select);
    	if(select==0){//如果是0就退出程序
    		break;
    	}
    	switch(select){
    		case 1:cfx();break;
    		case 2:sjx();break;
    		case 3:yx();break;
    		default:printf("请在0-3中选择！");
    	}
    }
}

void cfx(){
	int x,y;
	printf("请输入长方形的长和宽:");
	scanf("%d %d",&x,&y);
	printf("长方形的面积是%d\n",x*y);	
}

void sjx(){
	int a,h;
	printf("请输入三角形的底边和高：");
	scanf("%d %d",&a,&h);
	printf("三角形的面积是%.2f\n",a*h/2.0);
}

void yx(){
	int r;
	printf("请输入圆形的半径：");
	scanf("%d",&r);
	printf("圆形的面积是%.2f\n",3.14*r*r);
}