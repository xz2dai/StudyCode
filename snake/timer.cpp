#include <iostream>
#include <SDL/SDL.h>
#include <SDL_image.h>
#include <SDL_ttf.h>
#include <string>
#include <chrono>
class timer                  //计时器    12.4计划更改为使用std::chrono模板 具体见cppreference
{
	private:
		int starttime;
		int pausetime;
	public:
		void start();
		void pause();
		int gettime();
};
