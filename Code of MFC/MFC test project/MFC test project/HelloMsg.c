#include<windows.h>
int WINAPI WINMAIN(HINSTANCE hInstance, HINSTANCE HPrevINSTANCE, PSTR szCmdLine, int iCmdShow)
{
	MessageBox(NULL, TEXT("Hello World"), TEXT("Hello Msg"), 0);
	return 0;
}