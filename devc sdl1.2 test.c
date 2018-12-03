#include "SDL/SDL.h"         //SDL的bug 加个空格就可以运行
int main(int argc,char* args[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Quit();
	return 0;
}