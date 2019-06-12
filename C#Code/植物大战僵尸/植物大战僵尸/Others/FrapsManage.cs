using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    class FrapsManage       //手动控制帧率，system.timer相对于winform.timer来说采用了多线程，帧率控制更精确
    {
        System.DateTime timer = new DateTime();
        private int starttime;
        private int passtime;
        public Flip flip;

        public int Passtime { get => timer.Millisecond - starttime; }

        public void Start()
        {
            starttime = timer.Millisecond;
        }
        public void Delay()
        {
            Task.Delay(500 - Passtime);
        }
        public FrapsManage()
        {
            flip = new Flip();
        }
    }
}
