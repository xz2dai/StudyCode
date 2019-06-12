using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    public class NormalZombie : IZombies
    {
        private int HP = 50;
        private int V_x = 10;
        //public Point Location;
        //public Bitmap[] bitmap;
         Point Location;
        enum ZombieState
        {
            Move,
            Attact,
            Die
        }
        ZombieState NowZombieState;
        private int NowFrame;
        private Bitmap[] bitmap;

        public void BeHit(int damage)
        {
            HP -= damage;
        }

        public void BeKill()
        {
            
        }

        public void Born()
        {
            
        }

        public void Eat()
        {
            
        }

        public void Hit()
        {
            
        }

        public void Move(Graphics g)
        {
            Location.X += V_x;
        }

        public NormalZombie(int X, int Y, Bitmap[] bitmaps, Graphics g)
        {
            //bitmap = bitmaps;
            Born();
            bitmap = new Bitmap[12];
            bitmaps.CopyTo(bitmap, 0);
            Location.X = X;
            Location.Y = Y;
            NowFrame = 0;
        }
    }
}
