#include<graphics.h>
#include<conio.h>
void main()
{
int gd=DETECT,gm;
int x,y,radius=80;
initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
x=getmaxx()/2;
y=getmaxy()/2;
outtextxy(100,50,"Circle using graphics in C");
circle(x,y,radius);
getch();
closegraph();
}
