/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main()
{
	int i;
	int arw[16]={200, 102, 300, 102, 300, 107, 330, 
                       100, 300, 93, 300, 98, 200, 98, 200, 102}; 

	//初始化
    int gd=DETECT,gm;
    initgraph(&gd,&gm,"");
    
    setbkcolor(WHITE);
    setcolor(5);
    //画线
   // line(100,100,500,100);
    
    
    //for(i=1;i<15;i++){
    	//setcolor(i);
    	//画圆(圆心,半径r)
    	//circle(300,200,i*20);
    	// getch();
  //  }
  
  //画弧线(圆心坐标x,y,开始角度,结束角度,半径)
   //arc(300,300,0,360,100);
   
   //椭圆弧线
   ellipse(300,300,0,360,150,100);
   
   //画多边形
   drawpoly(8, arw);   /*画一箭头*/ 

   
   getch();
    //关闭
    closegraph();
}