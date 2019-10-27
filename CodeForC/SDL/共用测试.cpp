#include<SDL.h
#include<SDL2.h>
#include<SDL_image.h>
int main(int argc,char* args[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen=NULL;
	SDL_Surface* changeloadimage=NULL;
	SDL_Surface* loadimage=NULL;
	loadimage=IMG_Load("a.bmp");
	changeloadimage=SDL_DisplayFormat(loadimage);
	SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);
	SDL_BlitSurface(changeloadimage,NULL,screen,NULL);
	SDL_Flip(screen);
	SDL_Quit();
	return 0;
}