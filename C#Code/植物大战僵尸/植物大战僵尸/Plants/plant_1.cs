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
        private int HP = 10;
        Point Location;
        public plant_1(Graphics g,int x,int y)
        {
            Location.X = x;
            Location.Y = y;
            g.DrawImage(Properties.Resources.豌豆射手, x, y, 50, 50);
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
