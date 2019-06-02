using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    class FrapsManage       //手动控制帧率，system.timer相对于winform.timer来说采用了多线程，帧率控制更精确
    {
        System.DateTime timer = new DateTime();
        private int passtime, starttime;
        public void Start()
        {
            starttime = timer.Millisecond;
        }
        public void Delay()
        {
            passtime = timer.Millisecond - starttime;
            Task.Delay(500 - passtime);
        }
    }
}
