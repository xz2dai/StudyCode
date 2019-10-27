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
        Plants PlantKind;
        private int HP,NowFrame;
        public Point Location;
        public Bitmap[] bitmap;                   //在6.19更新计划中，将植物图片也改为享元模式
        PlantDrawFactory m_PlantDrawFactory;
        public Graphics m_g;
        System.Timers.Timer m_timer;
        Form1 FatherForm;
        public plant_1(int X,int Y, Plants plants)
        {
            //bitmap = bitmaps;
            //bitmap = new Bitmap[13];
            //bitmaps.CopyTo(bitmap, 0);
            Location.X = X;
            Location.Y = Y;
            
            NowFrame = 0;
            //AmmoList = new List<Ammo>(12);
            //m_g = g;
            NowPlantState = PlantState.None;
            PlantKind = plants;
            m_timer = new System.Timers.Timer(500);
            m_timer.Elapsed += Shoot;
            m_timer.AutoReset = true;
            m_timer.Start();
            
        }

        public void SetDrawFactory()
        {
            m_PlantDrawFactory = new PlantDrawFactory(m_g);
            DrawTest();
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

        public void SetFartherForm(Form1 form1)
        {
            this.FatherForm = form1;
        }

        void DrawTest()
        {
            //Location = point;
            switch(PlantKind)
            {
                case Plants.peashooter:
                    Peashooter_DrawFrame();
                    break;
                case Plants.sunflower:
                    SunFlower_DrawFrame();
                    break;
                default:
                    break;
            }
        }
        
        void Peashooter_DrawFrame()                 //6.19测试性功能，需要将此功能拓展，以达到增强拓展性和复用性的目的
        {
            
            if (NowFrame >= 10)
            {
                NowFrame = 0;
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                m_PlantDrawFactory.TargetDraw(FatherForm.BitmapManager.PeaShooterBitmaps[NowFrame++], m_g, Location);
                NowFrame++;
            }
            else
            {
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                m_PlantDrawFactory.TargetDraw(FatherForm.BitmapManager.PeaShooterBitmaps[NowFrame++], m_g, Location);
                NowFrame++;
            }
        }
        
        void SunFlower_DrawFrame()
        {
            
            if (NowFrame >= 10)
            {
                NowFrame = 0;
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                m_PlantDrawFactory.TargetDraw(FatherForm.BitmapManager.SunFlowerBitmaps[NowFrame++], m_g, Location);
                NowFrame++;
            }
            else
            {
                //m_PlantDrawFactory.TargetDraw(bitmap[NowFrame + 1], m_g, Location);
                m_PlantDrawFactory.TargetDraw(FatherForm.BitmapManager.SunFlowerBitmaps[NowFrame++], m_g, Location);
                NowFrame++;
            }
        }
    }
}
