
#include<graphics.h>
#include<conio.h> 
void main()
{
int gd = DETECT, gm;
initgraph(&gd, &gm, "C:\\TURBOC3\\BGI"); 
setcolor(WHITE); 
rectangle(160,200,240,400); 
rectangle(185,250,215,400); 
rectangle(240,200,400,400); 
line(160,200,200,100); 
line(200,100,240,200); 
line(200,100,350,100); 
line(350,100,400,200);
circle(200,170,15); 
getch(); 
closegraph();
}
