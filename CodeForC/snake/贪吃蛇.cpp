#include <iostream>
#include <SDL/SDL.h>
#include <SDL_image.h>	
#include <SDL_ttf.h>
#include <string>
#include <chrono>
#define Wide 10
#define Length 10
#define Speed 10
//SDL_Surface *screen=NULL;				12.4计划使用SDL2的createwindow
SDL_Event event;
int init()
{
	if(SDL_Init(SDL_INIT_EVERYTHING)==-1) return -1;
	if(TTF_Init()==-1) return -1;
	/*screen=SDL_SetVideoMode(640,320,32,SDL_SWSURFACE);
	if(screen==NULL) return -1;
	SDL_WM_SetCaption("贪吃蛇");*/
	SDL_CreatWindow("贪吃蛇",SDL_WINDOWPOS_UNDEFINED,SDL_WINDOWPOS_UNDEFINED,640,320,0);
	if(window==NULL) return -1;
	screen = SDL_GetWindowSurface(window);				//刷新为SDL_UpdateWindowSurface(window)
	she she = new She();
	return 1;
}
void quit()
{
	SDL_DestoryWindow(window);
	TTF_Quit();
	SDL_Quit();
}
SDL_Surface *loadimage(char* filename)			//12.4计划将surface转到render
{
	SDL_Surface *loadimage=NULL;
	SDL_Surface *opimage=NULL;
	loadimage=IMG_Load(filename);
	opimage=SDL_DispalyFormat(loadimage);
	SDL_FreeSurface(loadimage);
	return opimage;
}
int main(int argc,char* argc[])
{
	if(init()==-1)
	{
		std::cout<<"初始化失败";
		return 0;
	}
	
	return 0;
}

