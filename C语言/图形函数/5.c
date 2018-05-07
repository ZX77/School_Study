/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//图形函数的头文件
#include "stdlib.h"

void main()
{
	int i;
	char ch[50];
	//图形的函数的初始化
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
    settextstyle(0,0,2);
    setcolor(RED);
    
    setfillstyle(0,BLACK);  
    for(i=1;i<10;i++){
    	//清屏
    	//cleardevice();//system("cls");
    	//用封闭区域实现局部刷新
    	bar(200,200,450,230);
    	sprintf(ch,"LEVEL:%d SCORE:%d",i,i*10);
    	outtextxy(200,200,ch);
    	getch();
    }
    
  
	
    getch();
    //关闭图形函数
    closegraph();
    
    
}