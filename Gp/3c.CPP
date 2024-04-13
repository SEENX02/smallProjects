#include<graphics.h> 
#include<conio.h>
#include<stdio.h> 
#include<math.h>	
void main()
{
int rc,rb,xc,yc,i; 
float x,y;
int gd=DETECT,gm; 
initgraph(&gd,&gm,"C:\\TURBOC3\\BGI"); 
printf("enter the radiusofthe outercircle\n"); 
scanf("%d",&rc); 
printf("enter the radius of the innercircle\n"); 
scanf("%d",&rb); 
printf("enter the center of the circle\n"); 
scanf("%d",&xc);
scanf("%d",&yc); 
for(i=1;i<=360;i++)
{
x=xc+(rb*(cos (i)));
y=yc+(rb*(sin (i)));
putpixel(x,y,7);
}
for(i=1;i<=360;i++)
{
x=xc+(rc*(cos(i)));
y=yc+(rc*(sin(i)));
putpixel(x,y,7);
}
getch();
 closegraph();
}
