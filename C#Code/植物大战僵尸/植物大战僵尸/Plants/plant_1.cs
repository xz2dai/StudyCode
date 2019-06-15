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
            peashooter,
            None
        }
        List<Ammo>[] AmmoList;
        private int HP,NowFrame;
        public Point Location;
        public Bitmap[] bitmap;
        PlantDrawFactory m_PlantDrawFactory;
        public Graphics m_g;
        public plant_1(int X,int Y, Bitmap[] bitmaps)
        {
            //bitmap = bitmaps;
            bitmap = new Bitmap[12];
            bitmaps.CopyTo(bitmap, 0);
            Location.X = X;
            Location.Y = Y;
            
            NowFrame = 0;
            AmmoList = new List<Ammo>[12];
            //m_g = g;
        }

        public void SetDrawFactory()
        {
            m_PlantDrawFactory = new PlantDrawFactory(m_g);
            m_PlantDrawFactory.TargetDraw(bitmap[0], m_g, Location);
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

        public void Action()
        {
            if(NowFrame >= 11)
            {
                NowFrame = 0;
                m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                NowFrame++;
            }
            else
            {
                m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                NowFrame++;
            }
        }
    }
}
