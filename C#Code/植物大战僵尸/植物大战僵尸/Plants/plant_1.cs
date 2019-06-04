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
        public enum Plants
        {
            sunflower,
            peashooter
        }
        private int HP,NowFrame;
        public Point Location;
        public Bitmap[] bitmap;
        PlantDrawFactory m_PlantDrawFactory;
        public plant_1(int X,int Y, Bitmap[] bitmaps,Graphics g)
        {
            //bitmap = bitmaps;
            bitmap = new Bitmap[12];
            bitmaps.CopyTo(bitmap, 0);
            Location.X = X;
            Location.Y = Y;
            m_PlantDrawFactory = new PlantDrawFactory();
            m_PlantDrawFactory.TargetDraw(bitmap[0], g, Location);
            NowFrame = 0;
        }

        public plant_1()
        {
        }

        /*
public void LoadBitmap(string FileLocation)
{
   bitmap = new Bitmap[12];
   string Filename;
   for (int i=0;i<=11;i++)
   {
       Filename = FileLocation + i.ToString() + ".png";
       bitmap[i] = new Bitmap(Filename);
   }
}
*/
        public void BeHit(int damage)
        {
            HP -= damage;
        }

        void Iitem.Hit()
        {
            
        }

        public void Action(Graphics g)
        {
            m_PlantDrawFactory.TargetDraw(bitmap[NowFrame+1], g, Location);
        }
    }
}
