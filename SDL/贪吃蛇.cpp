#include <iostream>
#include <SDL/SDL.h>
#include <SDL_image.h>
#include <SDL_ttf.h>
#include <string>
//SDL_Surface *screen=NULL;				12.4计划使用SDL2的createwindow
SDL_Event event;
class she                //蛇
{
	private:
		int x;
		int y;
		int vx;
		int vy;
		int length;			//蛇长度
	public:
		int move();
		int grow();		   //吃了fruit则length++
		int check();       //判断碰撞	12.4计划使用SDL2碰撞检测函数
};
class timer                  //计时器    12.4计划更改为使用std::chrono模板 具体见cppreference
{
	private:
		int starttime;
		int pausetime;
	public:
		timer();
		void start();
		void pause();
		int gettime();
};
int init()
{
	if(SDL_Init(SDL_INIT_EVERYTHING)==-1) return -1;
	if(TTF_Init()==-1) return -1;
	screen=SDL_SetVideoMode(640,320,32,SDL_SWSURFACE);
	if(screen==NULL) return -1;
	SDL_WM_SetCaption("贪吃蛇");
	return 1;
};
SDL_Surface *loadimage(char* filename)			//12.4计划将surface转到render
{
	SDL_Surface *loadimage=NULL;
	SDL_Surface *opimage=NULL;
	loadimage=IMG_Load(filename);
	opimage=SDL_DispalyFormat(loadimage);
	SDL_FreeSurface(loadimage);
	return opimage;
};
int main(int argc,char* argc[])
{
	
}

