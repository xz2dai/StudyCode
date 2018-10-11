#include<stdio.h>
#include<SDL.h>
int main(int argc,char* args[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen= NULL;
	SDL_Surface* image= NULL;
	image = SDL_LoadBMP("a.bmp");
	screen = SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);
	SDL_BlitSurface(image,NULL,screen,NULL);
	SDL_Flip(screen);
	SDL_Delay(2000);
	SDL_FreeSurface(image);
	SDL_Quit();
}
