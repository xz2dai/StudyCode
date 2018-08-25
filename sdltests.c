#include <SDL.h>

int main(int argc,char *argv[]){
	SDL_Init(SDL_INIT_EVERYTHING);
	
	SDL_Window *window = SDL_CreateWindow("CNM",0,0,1024,768,SDL_WINDOW_SHOWN);
	SDL_Renderer *renderer = SDL_CreateRenderer(window,-1,SDL_RENDERER_ACCELERATED|SDL_RENDERER_PRESENTVSYNC);
	
	SDL_SetRenderDrawColor(renderer,0,0,0,255);
	SDL_RenderClear(renderer);
	
	SDL_SetRenderDrawColor(renderer,255,255,255,255);
	SDL_RenderDrawLine(renderer,0,0,100,100); 
	
	SDL_RenderPresent(renderer);
	
	SDL_Delay(10000);

	SDL_DestroyRenderer(renderer);	
	SDL_DestroyWindow(window); 

	
	SDL_Quit();
	return 0;
} 
