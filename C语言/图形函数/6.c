/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//ͼ�κ�����ͷ�ļ�
#include "stdlib.h"
#include "time.h"//ʱ���ͷ�ļ�
void printXY(int ,int);

void main()
{
	int x,y,i=0;
	//ͼ�εĺ����ĳ�ʼ��
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    setbkcolor(WHITE);
    setcolor(RED);
    randomize();//�������
    
    while(i<100){
    	 //����һ���漴��(0-399)
	  	x=random(530)+100;
	  	y=random(410)+60;
	  	rectangle(x,y,x+10,y+10);
	  	printXY(x,y);
	  	i++;
    }
   
  	getch();
  
    //�ر�ͼ�κ���
    closegraph();
    
    
}

void printXY(int x,int y){
	char ch[50];
	settextstyle(0,0,2);
	bar(100,5,300,25);
	sprintf(ch,"X=%d Y=%d",x,y);
	outtextxy(100,5,ch);
}