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
        public Point Location;
        enum ZombieState
        {
            Move,
            Attact,
            Die
        }
        private ZombieState NowZombieState;
        private int NowFrame;
        public Bitmap[] bitmap;
        private ZombieDrawFactory m_ZombieDrawFactory;
        public void BeHit(int damage)
        {
            HP -= damage;
        }

        public void BeKill()
        {

        }

        public void Born()
        {
            Random m_random = new Random();
            int m_XToLine = m_random.Next(1, 5);
            Location.Y = m_XToLine * 75;
            Location.X = 1018;
        }

        public void Eat()
        {

        }

        public void Hit()
        {

        }

        public void Move(Graphics g)
        {
            Location.X -= V_x;
            if(NowZombieState == ZombieState.Move)
            {
                if (NowFrame == 11)
                {
                    NowFrame = 0;
                    m_ZombieDrawFactory.TargetDraw(bitmap[NowFrame + 1], g, Location);
                }
                else
                {
                    m_ZombieDrawFactory.TargetDraw(bitmap[NowFrame + 1], g, Location);
                    NowFrame++;
                }
            }
        }

        public NormalZombie(Bitmap[] bitmaps, Graphics g)
        {
            Born();
            bitmap = new Bitmap[12];
            bitmaps.CopyTo(bitmap, 0);
            m_ZombieDrawFactory = new ZombieDrawFactory(g);
            m_ZombieDrawFactory.TargetDraw(bitmap[0], g, Location);
            NowFrame = 0;
        }

        public NormalZombie()
        {

        }
    }
}
