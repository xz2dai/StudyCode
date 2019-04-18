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
        public void DrawAmmo(Graphics g,int x,int y)
        {
            g.DrawImage(Properties.Resources.ammo, x, y, 10, 10);
        }
    }
}
