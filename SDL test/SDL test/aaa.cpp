//#pragma comment(lib,"SDL.lib")
//#pragma comment(lib,"SDLmain.lib")
//#pragma comment(linker,"/subsystem:windows")
#include<stdio.h>
#include<SDL.h>
//#define stdin（__acrt_iob_func（0））
//#define stdout（__acrt_iob_func（1））
//#define stderr（__acrt_iob_func（2））
int main(int argc, char* args[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen = NULL;
	SDL_Surface* loadimage = NULL;
	SDL_Surface* opimage = NULL;
	SDL_WM_SetCaption("祝卫生部全体身体健康万事如意",NULL);
	screen = SDL_SetVideoMode(592, 512, 32, SDL_SWSURFACE);
	loadimage = SDL_LoadBMP("a.bmp");
	opimage = SDL_DisplayFormat(loadimage);
	SDL_BlitSurface(opimage, NULL, screen, NULL);
	SDL_Flip(screen);
	SDL_Delay(2000);
	SDL_Quit();
	return 0;
}