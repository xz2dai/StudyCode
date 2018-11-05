#include<SDL.h>
#include<stdio.h>
int main(int argc,char* argv[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen = NULL;//创建表面 
	SDL_Surface* loadimage = NULL;
	loadimage = IMG_Load("a.bmp");//载入图片 
	screen = SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);//设定窗口 
	SDL_BlitSurface(loadimage,NULL,screen,NULL);//把lodeimage表面贴在screen上 
	SDL_WM_SetCaption("My first SDL program",NULL);//窗口标签 
	SDL_Flip(screen);//刷新 
	SDL_Delay(2000);//延时 
	SDL_FreeSurface(screen);
	SDL_FreeSurface(loadimage);
	SDL_Quit();
	return 0;
}
