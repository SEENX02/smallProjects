
#include<stdio.h> 
#include<conio.h> 
#include<graphics.h> 
void main()
{
int gd = DETECT, gm; 
int midx, midy;
initgraph(&gd, &gm, "C:\\TURBOC3\\BGI"); 
cleardevice();
midx=getmaxx()/2; 
midy=getmaxy()/2; 
line(1,midy,1920,midy); 
line(midx,1,midx,1080); 
getch();
}
