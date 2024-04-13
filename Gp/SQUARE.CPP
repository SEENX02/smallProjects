#include <graphics.h>
#include<conio.h>
int main() {
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "c:\\TURBOC3\\BGI");

    int x = 100, y = 100;
    int size = 200;

    rectangle(x, y, x + size, y + size);

    getch();
    closegraph();
    return 0;
}
