#include<SDL.h>
#include<stdio.h>
int main(int argc,char* argv[])
{
	SDL_Init(SDL_INIT_EVERYTHING);
	SDL_Surface* screen = NULL;//�������� 
	SDL_Surface* loadimage = NULL;
	loadimage = IMG_Load("a.bmp");//����ͼƬ 
	screen = SDL_SetVideoMode(592,512,32,SDL_SWSURFACE);//�趨���� 
	SDL_BlitSurface(loadimage,NULL,screen,NULL);//��lodeimage��������screen�� 
	SDL_WM_SetCaption("My first SDL program",NULL);//���ڱ�ǩ 
	SDL_Flip(screen);//ˢ�� 
	SDL_Delay(2000);//��ʱ 
	SDL_FreeSurface(screen);
	SDL_FreeSurface(loadimage);
	SDL_Quit();
	return 0;
}
