#include<iostream.h>
#include<stdlib.h> 
#include<stdio.h> 
#include<graphics.h> 
#include<conio.h>
int main()
{
    char a[2];
    int x, y;
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "C:\\TURBOC3\\BGI"); 
    x = getmaxx() / 2;
    y = getmaxx() / 2; 
    line(x, 0, x, y);
    line(0, y, x, y);
    line(x, y, getmaxx(), y);
    line(x, y, x, getmaxx()); 
    outtext("Circle");
    circle(159, 120, 80);
    outtextxy(320, 0, "Rectangle"); 
    rectangle(360, 40, 580, 200); 
    outtextxy(0, 241, "Ellipse"); 
    ellipse(159, 360, 0, 360, 50, 100);
    outtextxy(321, 241, "Half Ellipse"); 
    ellipse(529, 360, 0, 180, 50, 100);
    getch(); 
    closegraph();
    return 0; 
}
