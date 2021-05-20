using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    public class ZombieDrawFactory                  //直接套用植物的绘制工厂
    {
        Graphics m_g;
        Point Location;

        public void TargetDraw(Bitmap[] bitmap, Graphics g, int x, int y)
        {
            
            m_g = g;
            Location.X = x;
            Location.Y = y;
            g.DrawImage(Properties.Resources.shadow, x - 13, y + 45);
            g.DrawImage(bitmap[0], x, y);

        }

        public void TargetDraw(Bitmap bitmap, Graphics g, Point point)
        {

            
            Location = point;
            //Bitmap shadow = new Bitmap(Properties.Resources.shadow);
            //m_g.DrawImage(shadow, Location.X - 13, Location.Y + 45);

            m_g.DrawImage(bitmap, Location);
            
        }

        public ZombieDrawFactory(Graphics g)
        {
            m_g = g;
        }
    }
}
