#include <SDL2/SDL.h>
#include <iostream>

bool g_pRunning = true;
SDL_Window* g_pWindow = 0;
SDL_Renderer* g_pRenderer = 0;

int init(char* title,int xpos,int ypos,int high,int wide,Uint32 flag)
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

int main(int argc,char* args[])
{
    init("sdltest",SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,640,480,0);
   
    SDL_RenderClear(g_pRenderer);
    SDL_RenderPresent(g_pRenderer);
    SDL_Delay(5000);
    SDL_Quit();
    return 0;
}