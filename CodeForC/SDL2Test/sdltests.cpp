#include "iostream"
#include "SDL2/SDL.H"

using namespace std;

const int Windows_Width = 640;
const int Windows_Height = 480;

SDL_Window *window = nullptr;
SDL_Texture *texture = nullptr;
SDL_Renderer *render = nullptr;



bool Init(){
    if(SDL_Init(SDL_INIT_EVERYTHING) < 0 ){
        cout<<"SDL init false!"<<SDL_GetError()<<endl;
        return false;
    }
    window = SDL_CreateWindow("SDL2Test",SDL_WINDOWPOS_UNDEFINED,SDL_WINDOWPOS_UNDEFINED,Windows_Width,Windows_Height,SDL_WINDOW_SHOWN);
    if(window == NULL){
        cout << "Creat window false" << SDL_GetError() <<endl;
        return false;
    }
    render = SDL_CreateRenderer(window,-1,0);
    if(render == NULL){
        cout << "Creat render false" <<SDL_GetError() << endl;
        return false;
    }
    SDL_SetRenderDrawColor(render,255,255,255,255);
    SDL_RenderClear(render);
    return true;

}

bool Load_Image(const char *location){
    SDL_Surface *image = nullptr;
    image = SDL_LoadBMP(location);
    if(image == nullptr){
        cout << "Load image false" << endl;
        return false;
    }
    texture = SDL_CreateTextureFromSurface(render,image);
    SDL_FreeSurface(image);
    if(texture == nullptr){
        cout << "Creat texture false";
        return false;
    }
    return true;
}

bool Put_Image(){
    SDL_RenderCopy(render,texture,NULL,NULL);
    SDL_RenderPresent(render);
    return true;
}

bool QUit(){
    SDL_DestroyWindow(window);
    SDL_DestroyRenderer(render);
    SDL_DestroyTexture(texture);
    SDL_Quit();
    return true;
}

int main(int argc,char* args[]){
    bool isQuit = false;
    SDL_Event event;
    if(Init()){
        //if(Load_Image("a.bmp")) Put_Image();
    }
    while(!isQuit){
        while(SDL_PollEvent(&event) != 0){
            if(event.type == SDL_QUIT) isQuit = true;
        }
    }
    QUit();
    return 0;

}