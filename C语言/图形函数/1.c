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
    
    
    //���ñ���ɫ(0`15)
    setbkcolor(WHITE);
    
    //����ͼ����ɫ  (������ɫ�ǰ�ɫ��ʱ�� ��������Ϊ��ɫ)
    setcolor(RED);
    
    //������ (���Ͻ�x,���Ͻ�y,���½�x,���½�y) ���εĳ���x��Ĳ� 
    //rectangle(200,100,250,150);
    
    //���� (����, ��ɫ)
    putpixel(300,400,BLUE);
    //��ȡ�����ɫֵ
   // printf("%d\n",getpixel(300,400));
    
    //��Ļ��С 640X480
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
     
     
  
    
    
    //�ر�ͼ�κ���
    closegraph();
    
    
}