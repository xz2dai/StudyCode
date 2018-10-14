#include<stdio.h>
#include<SDL.h>
int main(int argc,char* args[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen= NULL;
	SDL_Surface* image= NULL;
<<<<<<< HEAD
	SDL_Event event;
	SDL_WM_SetCaption("SDL STUDY PROGRAM",NULL);
	image = IMG_Load("a.bmp");
=======
	image = SDL_LoadBMP("a.bmp");
>>>>>>> fd3fea675b3e8b6215c90cde04a47d35b9dc38d7
	screen = SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);
	SDL_BlitSurface(image,NULL,screen,NULL);
	SDL_Flip(screen);
	SDL_Delay(1000);
	SDL_FreeSurface(image);
	SDL_Quit();
}
