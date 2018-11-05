#include<stdio.h>
#include<SDL.h>
#include<SDL_ttf.h>
#include<SDL_image.h>
#include<stdlib.h>
#include<string>
#include<sstream>
const int SCREEN_WIDTH=640;
const int SCREEN_HEIGHT=480
const int SCREEN_BPP=32;
SDL_Surface* background=NULL;
SDL_Surface* startstop=NULL;
SDL_Surface* seconds=NULL;
SDL_Surface* screen=NULL;
SDL_Event event;
TTF_font* font;
SDL_Color textcolor = {0xF0,0xFF,0xF0};
SDL_Surface* load_image(sdt::string filename)
{
	SDL_Surface* loadedimage=NULL;
	SDL_Surface* optimizedimage=NULL;
	loadedimage=IMG_Load(filename.c_str());
	if(loadedimage!=NULL)
	{
		optimizedimage=SDL_DisplayFormat(loadedimage);
		SDL_FreeSurface(loadedimage);
		if(optimizedimage!=NULL)
		{
			SDL_SetColorKey(optimizedimage,SDL_SRCCOLORKEY,SDL_MapRGB(optimizedimage->format,0,0xFF,0xFF));
		}	
	}
	return optimizedimage;	
} 
void apply_surface(int x,int y,SDL_Surface* source,SDL_Surface* destination,SDL_Rect* clip=NULL)
{
	SDL_Rect ofset;
	offset.x=x;
	offset.y=y;
	SDL_BlitSurface(source,clip,destination,&offset);
}
bool init()
{
	if(SDL_Init(SDL_INIT_EVERYTHING)==-1)
	{
		return false;
	}
	screen= SDL_SetVideoMode(SCREEN_WIDE,SCREEN_HIGH,SCREEN_BPP,SDL_SWSURFACE);
	if(screen==-1)
	{
		return false;
	}
	if(TTF_Init()==-1)
	{
		return false;
	}
	SDL_WM_SetCaption("Timer Test",NULL);
	return true;
}
bool load_file()
{
	background=load_image("background.png");
	font=TTF_OpenFont("lazy")
}
