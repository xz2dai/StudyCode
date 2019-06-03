﻿using System;
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
        public void AddToList(List<plant_1> plantlist,plant_1 plant)
        {
            plantlist.Add(plant);
        }
   
        public plant_1 CreatPlant(Bitmap bitmap,int X,int Y)
        {
            plant_1 newplant = new plant_1(bitmap,X,Y);
            return newplant;
        }

        public void DrawItem(IDrawFactory drawFactory,Graphics g,plant_1 plant,int x,int y)
        {
            drawFactory.TargetDraw(plant.bitmap, g, x, y);
        }
    }
}
