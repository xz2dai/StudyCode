#include"SDL.h"
int main(int argc,char* args[])
{
	SDL_Surface* hello = NULL;
	SDL_Surface* screen = NULL; 
	SDL_Init(SDL_INIT_EVERYTHING);
	screen = SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);
	hello = SDL_LoadBMP("a.bmp");
	SDL_BlitSurface(hello,NULL,screen,NULL);
	SDL_Flip(screen);
	SDL_Delay(3000);
	SDL_FreeSurface(hello);
	SDL_Quit();
	return 0;
}
