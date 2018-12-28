#include <iostream>
#include <SDL/SDL.h>
#include <SDL_image.h>
#include <SDL_ttf.h>
#include <string>
#include <chrono>
class She                //蛇
{
	private:
		int headx;
		int heady;
		int vx;
		int vy;
		int length;			//蛇长度
	public:
		she();
		void change();
		void move();
		void grow();		   //吃了fruit则length++
		void check();       //判断碰撞	12.4计划使用SDL2碰撞检测函数SDL_HasIntersection
		void show();
};
She::she()
{
	hendx=320;
	heady=160;
	length=4;
	SDL_Rect head;
	SDL_Rect body[length];
	head.x=headx;
	head.y=heady;
	head.width=Wide;
	head.height=Length;
}
void She::show()
{
		
}
void She::move()
{
	
}
int She::check(SDL_Rect wall,SDL_Rect body)
{

}
