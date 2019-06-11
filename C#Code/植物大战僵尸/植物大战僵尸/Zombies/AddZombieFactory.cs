using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    class AddZombieFactory : IAddItemFactory
    {
        public NormalZombie CreatZombie(int X, int Y, Bitmap[] bitmaps, Graphics g)
        {
            NormalZombie normalZombie = new NormalZombie(X,Y,bitmaps,g);
            return normalZombie;
        }

        public void DrawZombie(IDrawFactory drawFactory, Graphics g, NormalZombie normalZombie)
        {

        }
    }
}
