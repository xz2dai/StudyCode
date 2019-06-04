using System;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Resources;
using System.Collections;
using System.Runtime;
using System.Collections.Generic;

namespace 植物大战僵尸
{
    class AddPlantFactory : IAddItemFactory 
    {
   
        public plant_1 CreatPlant(int X,int Y, Bitmap[] bitmaps,Graphics g)
        {
            plant_1 newplant = new plant_1(X,Y,bitmaps,g);
            return newplant;
        }

        public void DrawItem(IDrawFactory drawFactory,Graphics g,plant_1 plant)
        {
            drawFactory.TargetDraw(plant.bitmap, g, plant.Location.X, plant.Location.Y);
        }


    }
}
