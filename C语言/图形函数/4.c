/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//ͼ�κ�����ͷ�ļ�
#include "stdlib.h"

void main()
{
	char ch[50];
	//ͼ�εĺ����ĳ�ʼ��
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
    
    //���������С
    settextstyle(0,0,3);
    
    setcolor(RED);
	//���ڶ������������� ��̬����,�����Ľ������ch
	sprintf(ch,"LEVEL:%d SCORE:%d",2,100);
	
	//��ͼ�εķ�ʽ��������ı�
	outtextxy(200,200,ch);
	
	
	
    getch();
    //�ر�ͼ�κ���
    closegraph();
    
    
}