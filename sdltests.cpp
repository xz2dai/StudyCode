#include <SDL2/SDL.h>
#include <iostream>
#include<string>

bool g_pRunning = true;
SDL_Window* g_pWindow = 0;
SDL_Renderer* g_pRenderer = 0;

int init(std::string title,int xpos,int ypos,int high,int wide,Uint32 flag)
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
		 return 0;
}

int quit()
{
    SDL_DestoryWindow(g_pWindow);
	SDL_DestoryRenderer(g_pRenderer);
	SDL_Quit();
    return 0;
}

int getevent()
{
	SDL_Event event;
	if(SDL_PullEvent(&event))
	{
		switch(event.type)
		{
			case SDL_QUIT :
			{
				quit();
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

int main(int argc,char* args[])
{
    init("sdltest",SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,640,480,0);
   
    SDL_RenderClear(g_pRenderer);
    SDL_RenderPresent(g_pRenderer);
    SDL_Delay(5000);
    SDL_Quit();
    return 0;
}
