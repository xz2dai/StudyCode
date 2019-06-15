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
        private int V_x = 1;
        //public Point Location;
        //public Bitmap[] bitmap;
        public Point Location;
        enum ZombieState
        {
            Move,
            Attact,
            Die,
            None
        }
        private ZombieState NowZombieState = ZombieState.None;
        private int NowFrame;
        public Bitmap[] bitmap;
        private ZombieDrawFactory m_ZombieDrawFactory;
        public Graphics m_g;
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
            Location.X = 928;
            NowZombieState = ZombieState.Move;

        }

        public void Eat()
        {

        }

        public void Hit()
        {

        }

        public void Move()
        {
            
            if (NowZombieState == ZombieState.Move)
            {
                if (Location.X <= 255)
                {
                    Die();
                    return;
                }
                Location.X -= V_x;
                
                if (NowFrame == 11)
                {
                    NowFrame = 0;

                    m_ZombieDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                    NowFrame++;
                }
                else
                {
                    m_ZombieDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                    NowFrame++;
                }
            }
        }

        public NormalZombie(Bitmap[] bitmaps)
        {
            Born();
            bitmap = new Bitmap[12];
            bitmaps.CopyTo(bitmap, 0);

            
            //m_g = g;
        }

        public void SetDrawFactory()
        {
            m_ZombieDrawFactory = new ZombieDrawFactory(m_g);
            m_ZombieDrawFactory.TargetDraw(bitmap[0], m_g, Location);
            NowFrame = 0;
        }

        public NormalZombie()
        {

        }

        void Die()
        {
            NowZombieState = ZombieState.Die;
        }
    }
}
