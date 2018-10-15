#include<stdio.h>
#include<SDL.h>
#include<SDL_ttf.h>
void apply_surface(int x, int y, SDL_Surface * source,
                   SDL_Surface * destination) {
  // 用于保存坐标
  SDL_Rect offset;
  SDL_Rect *clip = NULL;
  // 获得坐标
  offset.x = x;
  offset.y = y;

  // Blit操作
  SDL_BlitSurface(source, clip, destination, &offset);
}
int main(int argc, char *args[]) {
  SDL_Init(SDL_INIT_EVERYTHING);
  SDL_Surface *screen = NULL;
  SDL_Surface *image = NULL;
  SDL_Surface *message = NULL;
  SDL_Surface *upMessage = NULL;
  SDL_Surface *downMessage = NULL;
  SDL_Surface *leftMessage = NULL;
  SDL_Surface *rightMessage = NULL;
  SDL_Event event;
  TTF_Font *font = NULL;
  SDL_Color textColor = { 0, 245, 255 };
  TTF_Init();
  font = TTF_OpenFont("Coffeebreak.ttf", 45);
  upMessage = TTF_RenderText_Solid(font, "Up was pressed.", textColor);
  downMessage = TTF_RenderText_Solid(font, "Down was pressed.", textColor);
  leftMessage = TTF_RenderText_Solid(font, "Left was pressed", textColor);
  rightMessage = TTF_RenderText_Solid(font, "Right was pressed", textColor);
  message = TTF_RenderText_Solid(font, "fuk u n1994", textColor);
  SDL_WM_SetCaption("SDL STUDY PROGRAM", NULL);
  image = IMG_Load("a.bmp");
  image = SDL_LoadBMP("a.bmp");
  screen = SDL_SetVideoMode(592, 512, 32, SDL_SWSURFACE);
  SDL_FillRect(screen, &screen->clip_rect,
               SDL_MapRGB(screen->format, 0xFF, 0xFF, 0xFF));
  apply_surface(0, 0, image, screen);
  apply_surface(0, 150, message, screen);
  SDL_Flip(screen);
  if (SDL_pollEvent(&event)) {
    if (event.type == SDL.KEYDOWN) {
    swich(event.key.keysym.sym) }
  }
  int quit = 1;
  while (quit == 1) {
    SDL_Delay(1000);
  }
  SDL_FreeSurface(image);
  SDL_FreeSurface(message);
  TTF_CloseFont(font);
  TTF_Quit();
  SDL_Quit();
}