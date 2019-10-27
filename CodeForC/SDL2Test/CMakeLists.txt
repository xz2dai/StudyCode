cmake_minimum_required(VERSION 2.9.0)

project(SDL2_Test)

include_directories(
        ./
        C:/SDL2-2.0.9/x86_64-w64-mingw32/include
        )

link_directories(
        C:/SDL2-2.0.9/x86_64-w64-mingw32/lib
        )

set(CMAKE_CXX_FLAGS_DEBUG "$ENV{CXXFLAGS} -Wall -g -std=c++17")
set(CMAKE_CXX_FLAGS_RELEASE "$ENV{CXXFLAGS}  -Wall -O2 -std=c++17")

set(LINK_LIBS mingw32 SDL2main SDL2 SDL2_image)


add_executable(sdltests sdltests.cpp)

target_link_libraries(sdltests ${LINK_LIBS})