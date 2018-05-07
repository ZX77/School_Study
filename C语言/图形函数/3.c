/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//图形函数的头文件
#include "stdlib.h"

void main()
{
	int i;
	//图形的函数的初始化
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
   // setbkcolor(WHITE);
    setcolor(5);
    
    //设置线形(设置线的样式(实线/虚线) ,0,线宽(1/3))
    setlinestyle(1,0,1);
    
   // rectangle(200,200,300,300);
    
    //for(i=0;i<12;i++){
    	//设置封闭图形的填充样式
    	//setfillstyle(i,YELLOW);
    	
    	//封闭区域(默认白色填充)
    	//bar(100,100,160,160);
    	//getch();
   // }
    
    bar3d(200,200,250,250,100,50);
    getch();
    //关闭图形函数
    closegraph();
    
    
}