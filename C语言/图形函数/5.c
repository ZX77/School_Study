/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//ͼ�κ�����ͷ�ļ�
#include "stdlib.h"

void main()
{
	int i;
	char ch[50];
	//ͼ�εĺ����ĳ�ʼ��
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
    settextstyle(0,0,2);
    setcolor(RED);
    
    setfillstyle(0,BLACK);  
    for(i=1;i<10;i++){
    	//����
    	//cleardevice();//system("cls");
    	//�÷������ʵ�־ֲ�ˢ��
    	bar(200,200,450,230);
    	sprintf(ch,"LEVEL:%d SCORE:%d",i,i*10);
    	outtextxy(200,200,ch);
    	getch();
    }
    
  
	
    getch();
    //�ر�ͼ�κ���
    closegraph();
    
    
}