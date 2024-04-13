#include<graphics.h>
#include<conio.h>
void main()
{
int gd = DETECT, gm;
initgraph(&gd, &gm,"C:\\TURBOC3\\BGI"); 
bar(50,50,150,150); 
bar3d(200,50,300,150,20,1); 
arc(400,100,0,130,50);
circle(550,100,50); 
rectangle(200,250,450,350); 
getch();
closegraph();
}
