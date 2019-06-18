using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Collections.Generic;

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
        public enum PlantState
        {
            None,
            Attact,
            Die
        }
        PlantState NowPlantState;
        //List<Ammo> AmmoList;              //在6.15中计划使用list保存子弹，在6.16更改为用享元模式
        private int HP,NowFrame;
        public Point Location;
        public Bitmap[] bitmap;
        PlantDrawFactory m_PlantDrawFactory;
        public Graphics m_g;
        System.Timers.Timer m_timer;
        public plant_1(int X,int Y, Bitmap[] bitmaps)
        {
            //bitmap = bitmaps;
            bitmap = new Bitmap[13];
            bitmaps.CopyTo(bitmap, 0);
            Location.X = X;
            Location.Y = Y;
            
            NowFrame = 0;
            //AmmoList = new List<Ammo>(12);
            //m_g = g;
            NowPlantState = PlantState.None;
            m_timer = new System.Timers.Timer(500);
            m_timer.Elapsed += Shoot;
            m_timer.AutoReset = true;
            m_timer.Start();
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
        ~plant_1()
        {
            AmmoList.Clear();
            m_g.Dispose();
            m_timer.Dispose();
            foreach(Bitmap bitmap in bitmap)
            {
                bitmap.Dispose();
            }
        }
        */                              //尝试手动释放对象
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
            if (HP <= 0) NowPlantState = PlantState.Die;
        }

        void Iitem.Hit()
        {
            
        }

        public void Action()
        {
            this.NextFrame();
            //this.AmmoAction();

            
        }

        public bool IsDie()
        {
            if (NowPlantState == PlantState.Die)
                return true;
            else
                return false;
        }

        void Shoot(object sender,System.Timers.ElapsedEventArgs e)
        {
            Ammo m_ammo = new Ammo(this.Location.X + 55, this.Location.Y + 10);
           // this.AmmoList.Add(m_ammo);
        }

        void NextFrame()
        {
            if (NowFrame >= 10)
            {
                NowFrame = 0;
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                DrawTest();
                NowFrame++;
            }
            else
            {
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                DrawTest();
                NowFrame++;
            }
        }
        /*
        void AmmoAction()
        {

            AmmoList[i].DrawAmmo(m_g);
                if (AmmoList[i].IsDie())
                {
                    //AmmoList[i] = null;
                    AmmoList.RemoveAt(i);
                    GC.Collect();
                }
            }
        }
        */

        void DrawTest()
        {
            //Location = point;
            try
            {
                Bitmap shadow = new Bitmap(Properties.Resources.shadow);
                m_g.DrawImage(shadow, Location.X - 13, Location.Y + 45);

                m_g.DrawImage(bitmap[NowFrame], Location);
            }
            catch(Exception)
            {

            }
        }
    }
}
