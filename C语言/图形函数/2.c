/* Note:Your choice is C IDE */
#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main()
{
	int i;
	int arw[16]={200, 102, 300, 102, 300, 107, 330, 
                       100, 300, 93, 300, 98, 200, 98, 200, 102}; 

	//��ʼ��
    int gd=DETECT,gm;
    initgraph(&gd,&gm,"");
    
    setbkcolor(WHITE);
    setcolor(5);
    //����
   // line(100,100,500,100);
    
    
    //for(i=1;i<15;i++){
    	//setcolor(i);
    	//��Բ(Բ��,�뾶r)
    	//circle(300,200,i*20);
    	// getch();
  //  }
  
  //������(Բ������x,y,��ʼ�Ƕ�,�����Ƕ�,�뾶)
   //arc(300,300,0,360,100);
   
   //��Բ����
   ellipse(300,300,0,360,150,100);
   
   //�������
   drawpoly(8, arw);   /*��һ��ͷ*/ 

   
   getch();
    //�ر�
    closegraph();
}