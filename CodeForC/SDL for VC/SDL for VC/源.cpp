#include <SDL.h>
#include <SDL_image.h>

int main(int argc, char** argv)
{
	SDL_Init(SDL_INIT_VIDEO);
	SDL_Window* window = SDL_CreateWindow("SDL", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, 800, 600, SDL_WINDOW_SHOWN);

	SDL_Delay(3000);
	SDL_DestroyWindow(window);
	SDL_Quit();
	return 0;
}