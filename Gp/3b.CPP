#include<graphics.h> 
#include<conio.h>
void main()
{
int gd=DETECT,gm; 
initgraph(&gd,&gm,"C:\\TURBOC3\\BGI");
rectangle(150,50,400,150); 
bar(150,200,400,350);
getch(); 
closegraph();
}
