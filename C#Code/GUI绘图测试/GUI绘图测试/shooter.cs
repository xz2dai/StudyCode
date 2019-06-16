using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GUI绘图测试
{
    class shooter
    {
        public Point Location;
        //Graphics g;
        Form1 m_form;
        public int NowFrame = 0 ;
        public shooter(int x,int y,Form1 form1)
        {
            Location.X = x;
            Location.Y = y;
            m_form = form1;
        }

        public void Action(object sender,System.Timers.ElapsedEventArgs e)
        {
            if (NowFrame >= 11)
            {
                NowFrame = 0;
                m_form.g.DrawImage(m_form.shooterbitmap[NowFrame], Location);
                NowFrame++;
            }
            else
            {
                m_form.g.DrawImage(m_form.shooterbitmap[NowFrame], Location);
                NowFrame++;
            }
        }
    }
}
