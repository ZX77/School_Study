/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"//ͼ�κ�����ͷ�ļ�
#include "stdlib.h"

void main()
{
	int i;
	//ͼ�εĺ����ĳ�ʼ��
	
    int gdriver=DETECT,gmode;
    initgraph(&gdriver,&gmode,"");
    
   // setbkcolor(WHITE);
    setcolor(5);
    
    //��������(�����ߵ���ʽ(ʵ��/����) ,0,�߿�(1/3))
    setlinestyle(1,0,1);
    
   // rectangle(200,200,300,300);
    
    //for(i=0;i<12;i++){
    	//���÷��ͼ�ε������ʽ
    	//setfillstyle(i,YELLOW);
    	
    	//�������(Ĭ�ϰ�ɫ���)
    	//bar(100,100,160,160);
    	//getch();
   // }
    
    bar3d(200,200,250,250,100,50);
    getch();
    //�ر�ͼ�κ���
    closegraph();
    
    
}