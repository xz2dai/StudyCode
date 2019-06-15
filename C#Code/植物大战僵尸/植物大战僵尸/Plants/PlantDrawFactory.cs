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
        //Graphics mGraphics;

        public void TargetDraw(Bitmap[] bitmap, Graphics g, int x, int y)
        {
            //bitmaps = new Bitmap[12];
            //bitmap.CopyTo(bitmaps, 0);
            //m_g = g;
            Location.X = x;
            Location.Y = y;
            //g.DrawImage(Properties.Resources.shadow, x - 13, y + 45);
            g.DrawImage(bitmap[0],x,y);
            
        }

        public void TargetDraw(Bitmap bitmap, Graphics g,Point point)
        {

            //bitmaps = new Bitmap[12];
            //bitmap.CopyTo(bitmaps, 0);                //在更新6.4中决定去掉了传入一整个图片组的设计
            //Image m_image = bitmap;
            //m_g = Graphics.FromImage(m_image);           //无法贴图，在更新6.11中修改了此问题
            //m_g = g;
            try
            {
                Location = point;
                Bitmap shadow = new Bitmap(Properties.Resources.shadow);
                m_g.DrawImage(shadow, Location.X - 13, Location.Y + 45);

                m_g.DrawImage(bitmap, Location);
                //m_g.Dispose();
            }
            catch(Exception)
            {
                
            }
        }

        public PlantDrawFactory(Graphics g)
        {
            m_g = g;
        }
    }
}
