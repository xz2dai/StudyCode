#ifndef _SNAKE_H_
#define _SNAKE_H_
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
		
		enum Direction direction;
	
	public:
		
		she();
		
		void change();
		
		void move();
		
		void grow();		   //吃了fruit则length++
		
		void check();       //判断碰撞	12.4计划使用SDL2碰撞检测函数SDL_HasIntersection
		
		void show();

};
enum class Direction
		{
			up=1,
			down,
			right,
			left
		};
#endif
