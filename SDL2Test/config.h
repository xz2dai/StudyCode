//
// Created by xz2dai on 2019/2/28.
//

#ifndef NMSL_RETRO_SNAKER_CONFIG_H
#define NMSL_RETRO_SNAKER_CONFIG_H

#include <SDL2/SDL.h>
#include <SDL2/SDL_image.h>
#include <iostream>
#include <string>
#include <map>
#include "runtime.h"


bool Running;
SDL_Window* g_pWindow = 0;
SDL_Renderer* g_pRenderer = 0;
SDL_Texture* texture;
SDL_Rect SourceRect;
SDL_Rect DestinationRect;
SDL_Event event;
std::map<std::string,SDL_Texture*> TextureMap;


#endif //NMSL_RETRO_SNAKER_CONFIG_H
