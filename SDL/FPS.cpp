#include<iostream>
#include<SDL.h>
#include<SDL_ttf.h>
#include<SDL_image.h>
void apply_surface(int x, int y, SDL_Surface * source,SDL_Surface * destination) 
 {
  // 用于保存坐标
  SDL_Rect offset;
  SDL_Rect *clip = NULL;
  // 获得坐标
  offset.x = x;
  offset.y = y;

  // Blit操作
  SDL_BlitSurface(source, clip, destination, &offset);
}
SDL_Surface *load_image( std::string filename )
{
    SDL_Surface* loadedImage = NULL;
    SDL_Surface* optimizedImage = NULL;
    loadedImage = IMG_Load( filename.c_str() );
    if( loadedImage != NULL )
    {
        optimizedImage = SDL_DisplayFormat( loadedImage )；
        SDL_FreeSurface( loadedImage ）；
        if( optimizedImage != NULL )
        {
            SDL_SetColorKey( optimizedImage, SDL_SRCCOLORKEY, SDL_MapRGB( optimizedImage->format, 0, 0xFF, 0xFF ) );
        }
	}
}
int main(int argc,char* args[])
{
	SDL_Init(SDl_INIT_EVERYTHING);
	int frame=0;
	const int fps_s=20;
	bool cap=ture;
	Timer fps;
	TTF_Init();
	SDL_Event *event;
	TTF_Font *font=NULL;
	SDL_Color textColor = { 0, 245, 255 };
  
	font = TTF_OpenFont("Coffeebreak.ttf", 45);
	message = TTF_RenderText_Solid( font, "Testing Frame Rate", textColor );
	while(quit==false)
	{
		fps.start();
	}
}
