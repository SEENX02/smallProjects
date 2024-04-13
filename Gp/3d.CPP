#include<graphics.h> 
#include<conio.h>
void main()
{
int gd=DETECT,gm; int x,y;
initgraph(&gd,&gm,"C:\\TURBOC3\\BGI"); 
x=getmaxx()/2; 
y=getmaxy()/2;
outtextxy(x-100,50,"ELLIPSE Using Graphics in C"); 
ellipse(x,y,0,360,120,60); 
getch();
closegraph();
}      
