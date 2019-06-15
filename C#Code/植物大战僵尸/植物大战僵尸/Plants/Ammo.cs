using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Resources;
using System.Drawing;

namespace 植物大战僵尸
{
    class Ammo
    {
        int V_x = 10;
        Point Location;
        public void DrawAmmo(Graphics g)
        {
            g.DrawImage(Properties.Resources.ammo, Location.X, Location.Y, 10, 10);
            Location.X += V_x;
        }
        public Ammo(int x,int y)
        {
            Location.X = x;
            Location.Y = y;
             
        }
    }
}
