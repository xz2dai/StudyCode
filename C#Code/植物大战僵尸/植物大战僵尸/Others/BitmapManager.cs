using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    public class BitmapManager
    {
        public Bitmap[] SunFlowerBitmaps, PeaShooterBitmaps, NormalZombieBitmaps;

        public BitmapManager()
        {
            LoadBitmaps();
        }

        void LoadBitmaps()
        {
            SunFlowerBitmaps = new Bitmap[12];
            PeaShooterBitmaps = new Bitmap[12];
            NormalZombieBitmaps = new Bitmap[12];
            for (int i = 0; i <= 11; i++)
            {
                SunFlowerBitmaps[i] = new Bitmap(@".\bitmaps\SunFlower\" + i.ToString() + ".Png");
                PeaShooterBitmaps[i] = new Bitmap(@".\bitmaps\Peashooter\" + i.ToString() + ".Png");
                NormalZombieBitmaps[i] = new Bitmap(@".\bitmaps\NormalZombie\" + i.ToString() + ".Png");
            }
        }
    }
}
