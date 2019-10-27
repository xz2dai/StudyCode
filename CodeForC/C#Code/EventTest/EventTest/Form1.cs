using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventTest
{
    public partial class Form1 : Form
    {
        delegate void EventHander();
        Image image;
        Graphics g;
        public delegate void AddnumHander();
        public event AddnumHander AddnumEvent;
        System.Timers.Timer timer;
        protected int num;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //image = Image.FromFile(@"..\..\bitmaps\Peashooter\peashooter.png"); 高二级目录
            //image = Image.FromFile(@".\bitmaps\Peashooter\peashooter.png");  //exe同级目录
            //g = this.CreateGraphics();
            timer = new System.Timers.Timer(100);
            timer.Enabled = true;
            timer.AutoReset = true;
            timer.Elapsed += new System.Timers.ElapsedEventHandler(DalegateTest);
            Control.CheckForIllegalCrossThreadCalls = false;
        }

        private void Timer_Elapsed(object sender, System.Timers.ElapsedEventArgs e)
        {
            throw new NotImplementedException();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            //g.DrawImage(image, 100, 100);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //this.Invalidate();
        }

        //delegate 
        void DalegateTest(object sender, System.Timers.ElapsedEventArgs e)
        {
            
            label1.Text = num.ToString();
            
            num++;
        }
    }
}
