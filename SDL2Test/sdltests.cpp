#include "runtime.h"

int main(int argc,char* args[])
{
    Base base;
    //std::string title("SDL Test");
    base.init("SDL_Test",SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,640,480,0);
    //SDL_RenderClear(g_pRenderer);
    base.LoadBMP("../image/timg.jpg");
    base.update();
    while(Base::Running)
    {
        base.update();
        base.getevent();
    }
    std::cout<<"Quit";
    return 0;
}