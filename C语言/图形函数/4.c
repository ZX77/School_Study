/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//图形函数的头文件
#include "stdlib.h"

void main()
{
	char ch[50];
	//图形的函数的初始化
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
    
    //设置字体大小
    settextstyle(0,0,3);
    
    setcolor(RED);
	//将第二个参数的内容 动态编译,将最后的结果赋给ch
	sprintf(ch,"LEVEL:%d SCORE:%d",2,100);
	
	//以图形的方式定点输出文本
	outtextxy(200,200,ch);
	
	
	
    getch();
    //关闭图形函数
    closegraph();
    
    
}