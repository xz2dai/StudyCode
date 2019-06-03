using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    public class plant_1: Iplants
    {
        public enum Plants
        {
            sunflower,
            peashooter
        }
        private int HP;
        public Point Location;
        public Image bitmap;
        public plant_1(int X,int Y)
        {
            Location.X = X;
            Location.Y = Y;
        }
        /*
        public void LoadBitmap(string FileLocation)
        {
            string Filename;
            for (int i=0;i<=11;i++)
            {
                Filename = FileLocation + i.ToString() + ".png";
                bitmap[i] = new Bitmap(Filename);
            }
        }
        */
        public void BeHit(int damage)
        {
            HP -= damage;
        }

        void Iitem.Hit()
        {
            
        }
    }
}
