//
// Created by xz2dai on 2019/2/28.
//

#ifndef NMSL_RETRO_SNAKER_RUNTIME_H
#define NMSL_RETRO_SNAKER_RUNTIME_H

#include <config.h>

class Base
{
    private:

    public:
        int init(const char* title,int xpos,int ypos,int high,int wide,Uint32 flag);
        int quit();
        int getevent();
        int update();
        int LoadBMP(const char* filename);
        int LoadIMG(std::string filename,std::string id);
};



#endif //NMSL_RETRO_SNAKER_RUNTIME_H
