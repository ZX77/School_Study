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
    
    
    //设置背景色(0`15)
    setbkcolor(WHITE);
    
    //设置图形颜色  (背景颜色是白色的时候 不能设置为黑色)
    setcolor(RED);
    
    //画矩形 (左上角x,左上角y,右下角x,右下角y) 矩形的长是x轴的差 
    //rectangle(200,100,250,150);
    
    //化点 (坐标, 颜色)
    putpixel(300,400,BLUE);
    //获取点的颜色值
   // printf("%d\n",getpixel(300,400));
    
    //屏幕大小 640X480
    printf("%d %d",getmaxx(),getmaxy());
    
    
    //rectangle(200,100,250,150);
    
    setcolor(BLUE);
    
   // rectangle(250,100,300,150);
    
    setcolor(7);
     //rectangle(200,150,250,200);
    
    setcolor(8);
     //rectangle(250,150,300,200);
     
     for(i=1;i<15;i++){
     	setcolor(i);
     	rectangle(400-i*15,250-i*15,400+i*15,250+i*15);
     	getch();
     }
     
     
  
    
    
    //关闭图形函数
    closegraph();
    
    
}