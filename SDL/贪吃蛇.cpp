#include<iostream>
#include<SDL.h>
#include<SDL_image.h>
#include<SDL_ttf.h>
#include<string>
SDL_Surface *screen=NULL;
SDL_Event event;
class she                //蛇
{
	private:
		int x;
		int y;
		int vx;
		int vy;
		int length;
	public:
		int move();
		int grow();		   //吃了fruit则length++
		int check();       //判断碰撞
};
int she::move();
int she::grow();
int she::check();
class timer                  //计时器
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
SDL_Surface *loadimage(char* filename)
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

