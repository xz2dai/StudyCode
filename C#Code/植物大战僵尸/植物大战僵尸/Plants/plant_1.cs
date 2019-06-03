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
        private int HP;
        Point Location;
        public Bitmap bitmap;
        public plant_1(Bitmap R_bitmap,int X,int Y)
        {
            bitmap = R_bitmap;
            Location.X = X;
            Location.Y = Y;
        }
        public void BeHit(int damage)
        {
            HP -= damage;
        }

        void Iitem.Hit()
        {
            
        }
    }
}
