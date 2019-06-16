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
        int V_x = 5;
        bool isDie;
        Point Location;
        Bitmap AmmoBitmap;

        public bool IsDie()
        {
            return isDie;
        }

        public void DrawAmmo(Graphics g)
        {
            if (this.Location.X >= 1000)
            {
                isDie = true;
                return;
            }
            g.DrawImage(Properties.Resources.ammo, Location.X, Location.Y, 20, 20);
            Location.X += V_x;
        }
        public Ammo(int x,int y)
        {
            isDie = false;
            Location.X = x;
            Location.Y = y;
            //Properties.Resources.ammo.MakeTransparent(Color.White);
            AmmoBitmap = (Bitmap)Properties.Resources.ammo.Clone();
            AmmoBitmap.MakeTransparent(Color.White);
        }

        
    }
}
