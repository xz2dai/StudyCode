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
        BufferedGraphicsContext BufferedGraphicsContext;
        BufferedGraphics BufferedGraphics;
        Bitmap BufferBitmap;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //g = this.CreateGraphics();
            BufferBitmap = new Bitmap(this.Width, this.Height);
            BufferedGraphicsContext = BufferedGraphicsManager.Current;
            BufferedGraphics = BufferedGraphicsContext.Allocate(Graphics.FromImage(Properties.Resources.豌豆射手), this.ClientRectangle);
            //BufferedGraphics.Graphics.FillRectangle(new SolidBrush(Color.Transparent), this.ClientRectangle);
            BufferBitmap.MakeTransparent(Color.Black);
            g = BufferedGraphics.Graphics;
            
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
            timer.Elapsed += CreatBuffer;
            timer.Elapsed += shooter.Action;
            timer.Elapsed += FlipScren;
            timer.AutoReset = true;
            timer.Start();
        }

        

        public void FlipScren(object sender, System.Timers.ElapsedEventArgs e)
        {
            //this.Invalidate();
            //g.Clear(Color.Empty);
            BufferedGraphics.Render();
            BufferedGraphics.Graphics.DrawImage(BufferBitmap, 0, 0);
            BufferedGraphics.Dispose();
        }
        void CreatBuffer(object sender,System.Timers.ElapsedEventArgs e)
        {
            BufferedGraphics = BufferedGraphicsContext.Allocate(this.CreateGraphics(), this.ClientRectangle);
            //BufferedGraphics.Graphics.FillRectangle(new SolidBrush(Color.Transparent), this.ClientRectangle);
            g = BufferedGraphics.Graphics;
            //g.Clear(Color.Transparent);
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            BufferBitmap.MakeTransparent(Color.Black);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            BufferedGraphicsContext current = BufferedGraphicsManager.Current; //(1)

            BufferedGraphics bg;

            bg = current.Allocate(this.CreateGraphics(), this.DisplayRectangle); //(2)

            Graphics g = bg.Graphics;//(3)

            //随机 宽400 高400



            System.Random rnd = new Random();

            int x, y, w, h, r, i;

            for (i = 0; i < 10000; i++)

            {

                x = rnd.Next(400);

                y = rnd.Next(400);

                r = rnd.Next(20);

                w = rnd.Next(10);

                h = rnd.Next(10);

                g.DrawEllipse(Pens.Blue, x, y, w, h);

            }

            bg.Render();//(4)

            //bg.Render(this.CreateGraphics());

            bg.Dispose();//(5)
        }
    }
}
