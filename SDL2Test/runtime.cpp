//
// Created by xz2dai on 2019/2/28.
//

#include "runtime.h"



int Base::init(const char* title,int xpos,int ypos,int high,int wide,Uint32 flag)
{
    if(SDL_Init(SDL_INIT_EVERYTHING) >=0 )

    {

        g_pWindow = SDL_CreateWindow(title,xpos,ypos,wide,high,flag);

        if(g_pWindow != 0)

        {
            g_pRenderer = SDL_CreateRenderer(g_pWindow, -1, 0);
        }

    }
    else
    {
        return 1;
    }
    SDL_SetRenderDrawColor(g_pRenderer,0,0,0,255);
    Running = true;
    std::cout<<"Start success"<<std::endl;
    return 0;
}

int Base::quit()
{
    SDL_DestroyWindow(g_pWindow);
    SDL_DestroyRenderer(g_pRenderer);
    SDL_Quit();
    return 0;
}

int Base::getevent()
{
    if(SDL_PollEvent(&event))
    {
        switch(event.type)
        {
            case SDL_QUIT:
            {

                Running = false;
                break;
            }
            default:
            {
                break;
            }
        }
    }
    return 0;
}

void Base::update()
{
    Uint32 starttime,passtime;
    starttime = SDL_GetTicks();
    SourceRect.w = 73 * int((SDL_GetTicks()/8));
    SDL_RenderClear(g_pRenderer);
    SDL_RenderCopy(g_pRenderer, texture, &SourceRect, &DestinationRect);
    //SDL_RenderCopyEx(g_pRenderer,texture,&SourceRect,0,0,0,SDL_FLIP_HORIZONTAL);  //DestinationRect 改为了0
    SDL_RenderPresent(g_pRenderer);
    passtime = starttime-SDL_GetTicks();
    /*if( passtime < 1000/60)
    {
        SDL_Delay(Uint32( 1000/60 ) - passtime);
    }*/
    SDL_Delay(100);

}

int Base::LoadBMP(const char* filename)
{
    SDL_Surface* surface = IMG_Load(filename);
    texture = SDL_CreateTextureFromSurface(g_pRenderer,surface);
    SDL_FreeSurface(surface);
    //SDL_QueryTexture(texture,NULL,NULL,&SourceRect.w,&SourceRect.h);
    SourceRect.w = 73;
    SourceRect.h = 174;
    DestinationRect.x = SourceRect.x = 0;
    DestinationRect.y = SourceRect.y = 0;
    //DestinationRect.w = SourceRect.w;
    //DestinationRect.h = SourceRect.h;
    //SDL_RenderClear(g_pRenderer);
    //SDL_RenderCopy(g_pRenderer,tex ture,&SourceRect,&DestinationRect);
    //SDL_RenderCopyEx(g_pRenderer,texture,&SourceRect,&DestinationRect,0,0,SDL_FLIP_HORIZONTAL);
    //SDL_RenderPresent(g_pRenderer);
    return 0;
}

int Base::LoadIMG(std::string filename,std::string id)
{
    SDL_Surface* surface = IMG_Load(filename.c_str());
    if(surface == 0)
    {
        std::cout<<"Load IMG Fail"<<std::endl;
        return 1
    }
    SDL_Texture* texture1 = SDL_CreateTextureFromSurface(g_pRenderer,surface);
    SDL_FreeSurface(surface);
    if(texture1 != 0)
    {
        TextureMap[id] = texture1;
        std::cout<<"Load IMG to Map success"<<std::endl;
        return 0;
    }
    std::cout<<"Load IMG Fail"<<std::endl;
    return 1;
}
