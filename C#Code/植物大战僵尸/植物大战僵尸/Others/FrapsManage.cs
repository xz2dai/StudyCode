using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    class FrapsManage       //手动控制帧率，datatimer相对于winform.timer来说采用了多线程，帧率控制更精确
    {
        //System.DateTime timer;                //6.13更新：使用更为先进的system.timer,使用委托、方法与更优秀的多线程解决方案
        System.Timers.Timer timer;
        private int starttime;
        private int passtime;
        public Flip flip;
        //public delegate void FlipHander();
        //public event FlipHander FlipEvent;

        //public int Passtime { get => timer.Millisecond - starttime; }

        public void Start(Form1 form1)
        {
            //starttime = timer.Millisecond;
            //timer.Elapsed += form1.Invalidate;
            timer.Elapsed += form1.RefreshMap;
            timer.Elapsed += form1.RecreatBuffer;
            timer.Start();

        }
        public void Delay()
        {

            //Task.Delay(500 - Passtime);
            timer.Stop();
        }

        public void ReStart()
        {
            timer.Start();
        }

        public FrapsManage(int targetfraps)
        {
            timer = new System.Timers.Timer();
            //timer.BeginInit();

            timer.Interval = 1000 / targetfraps;
            //timer.Interval = targetfraps;
            //flip = new Flip();
            //timer.Enabled = true;
            timer.AutoReset = true;
            

        }

        public void AddEvent()
        {
            timer.Elapsed += flip.FlipPlants;
            timer.Elapsed += flip.FlipZombies;
        }
    }
}
