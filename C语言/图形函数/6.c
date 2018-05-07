/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//图形函数的头文件
#include "stdlib.h"
#include "time.h"//时间的头文件
void printXY(int ,int);

void main()
{
	int x,y,i=0;
	//图形的函数的初始化
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    setbkcolor(WHITE);
    setcolor(RED);
    randomize();//随机种子
    
    while(i<100){
    	 //生成一个随即书(0-399)
	  	x=random(530)+100;
	  	y=random(410)+60;
	  	rectangle(x,y,x+10,y+10);
	  	printXY(x,y);
	  	i++;
    }
   
  	getch();
  
    //关闭图形函数
    closegraph();
    
    
}

void printXY(int x,int y){
	char ch[50];
	settextstyle(0,0,2);
	bar(100,5,300,25);
	sprintf(ch,"X=%d Y=%d",x,y);
	outtextxy(100,5,ch);
}