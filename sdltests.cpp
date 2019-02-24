#include <SDL2/SDL.h>
#include <SDL2/SDL_image.h>
#include <iostream>
#include<string>

bool g_pRunning = true;
SDL_Window* g_pWindow = 0;
SDL_Renderer* g_pRenderer = 0;
SDL_Texture* texture;
SDL_Rect SourceRect;
SDL_Rect DestinationRect;


int init(const char* title,int xpos,int ypos,int high,int wide,Uint32 flag)
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
    SDL_DestroyWindow(g_pWindow);
    SDL_DestroyRenderer(g_pRenderer);
	SDL_Quit();
    return 0;
}

int getevent()
{
	SDL_Event event;
	if(SDL_PollEvent(&event))
	{
		switch(event.type)
		{
			case SDL_QUIT:
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

int LoadBMP(const char* filename)
{
	SDL_Surface* surface = SDL_LoadBMP(filename);
	texture = SDL_CreateTextureFromSurface(g_pRenderer,surface);
	SDL_FreeSurface(surface);
    SDL_QueryTexture(texture,NULL,NULL,&SourceRect.w,&SourceRect.h);
    DestinationRect.x = SourceRect.x = 0;
    DestinationRect.y = SourceRect.y = 0;
    DestinationRect.w = SourceRect.w;
    DestinationRect.h = SourceRect.h;
    SDL_RenderClear(g_pRenderer);
    //SDL_RenderCopy(g_pRenderer,tex ture,&SourceRect,&DestinationRect);
    SDL_RenderCopy(g_pRenderer,texture,0,0);
    SDL_RenderPresent(g_pRenderer);
	return 0;
}

int main(int argc,char* args[])
{
    //std::string title("SDL Test");
    init("SDL_Test",SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,640,480,0);
    //SDL_RenderClear(g_pRenderer);
    LoadBMP("../BMPTEST.bmp");
    SDL_Delay(2000);
    return 0;
}
