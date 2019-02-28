//
// Created by xz2dai on 2019/2/28.
//

#ifndef _RUNTIME_H_
#define _RUNTIME_H_

#include <SDL2/SDL.h>
#include <SDL2/SDL_image.h>
#include <iostream>
#include <string>
#include <map>

static SDL_Window* g_pWindow = 0;
static SDL_Renderer* g_pRenderer = 0;

class Base
{
    private:

    public:
        static bool Running;
        static SDL_Texture* texture;
        static SDL_Rect SourceRect;
        static SDL_Rect DestinationRect;
        static SDL_Event event;
        static std::map<std::string,SDL_Texture*> TextureMap;
        int init(const char* title,int xpos,int ypos,int high,int wide,Uint32 flag);
        int quit();
        int getevent();
        void update();
        int LoadBMP(const char* filename);
        int LoadIMG(std::string filename,std::string id);
};



#endif
