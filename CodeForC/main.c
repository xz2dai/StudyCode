#include <ti/devices/msp432p4xx/driverlib/driverlib.h>


void changelight(int );

void wait(int );

void main(void)

{

    GPIO_setAsOutputPin(GPIO_PORT_P1,GPIO_PIN0);

    GPIO_setAsOutputPin(GPIO_PORT_P2,GPIO_PIN0);

    GPIO_setAsOutputPin(GPIO_PORT_P2,GPIO_PIN1);

    GPIO_setAsOutputPin(GPIO_PORT_P2,GPIO_PIN2);

    


int lightlevel[]={24,20,16,12,8,4,0,4,8,12,16,20,24};

    int i=0,j,len=13;

    while(1)

    {

        for(i=0;i<len;i++)

            for(j=0;j<10;j++)

                changelight(lightlevel[i]);

    }

}


void changelight(int level){

    GPIO_setOutputHighOnPin(GPIO_PORT_P1,GPIO_PIN0);

    GPIO_setOutputLowOnPin(GPIO_PORT_P2,GPIO_PIN2);

   GPIO_setOutputLowOnPin(GPIO_PORT_P2,GPIO_PIN1);

    wait(level);

 

    GPIO_setOutputLowOnPin(GPIO_PORT_P1,GPIO_PIN0);

    GPIO_setOutputHighOnPin(GPIO_PORT_P2,GPIO_PIN2);

    GPIO_setOutputHighOnPin(GPIO_PORT_P2,GPIO_PIN1);

    wait(24-level);

}

void wait(int time){

    int i=300*time;

    while(i--) ;

}