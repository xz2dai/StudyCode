using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GUI绘图测试
{
    public partial class Form1 : Form
    {
        public Bitmap[] shooterbitmap;
        public System.Timers.Timer timer;
        shooter shooter;
        public Graphics g;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            g = this.CreateGraphics();
            shooterbitmap = new Bitmap[12];
            timer = new System.Timers.Timer(300);
            for(int i=0;i<=11;i++)
            {
                shooterbitmap[i] = new Bitmap(@".\bitmaps\Peashooter\" + i.ToString() + ".Png");
            }
            
        }

        

        private void button1_Click(object sender, EventArgs e)
        {
            //shooter shooter = new shooter(this.Width / 2, this.Height / 2, this);
            shooter = new shooter(this.Width / 2, this.Height / 2, this);
            timer.Elapsed += shooter.Action;
            // timer.Elapsed += FlipScren;
            timer.AutoReset = true;
            timer.Start();
        }

        

        public void FlipScren()
        {
            this.Invalidate();
        }
    }
}
