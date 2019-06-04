using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    class PlantDrawFactory : IDrawFactory
    {
        //Bitmap[] bitmaps;
        Graphics m_g;
        Point Location;

        public void TargetDraw(Bitmap[] bitmap, Graphics g, int x, int y)
        {
            //bitmaps = new Bitmap[12];
            //bitmap.CopyTo(bitmaps, 0);
            m_g = g;
            Location.X = x;
            Location.Y = y;
            g.DrawImage(Properties.Resources.shadow, x - 13, y + 45);
            g.DrawImage(bitmap[0],x,y);
            
        }

        public void TargetDraw(Bitmap bitmap, Graphics g,Point point)
        {
            //bitmaps = new Bitmap[12];
            //bitmap.CopyTo(bitmaps, 0);
            m_g = g;
            Location = point;
            g.DrawImage(Properties.Resources.shadow, Location.X - 13, Location.Y + 45);
            g.DrawImage(bitmap, Location);

        }

        
    }
}
