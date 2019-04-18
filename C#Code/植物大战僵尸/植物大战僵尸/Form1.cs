using System;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Resources;
using System.Collections;
using System.Runtime;

namespace 植物大战僵尸
{
    public partial class Form1 : Form
    {
        Graphics g;
        Image Background = Properties.Resources.map;
        Ammo ammo = new Ammo();
        public Form1()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.FormBorderStyle = FormBorderStyle.None;
            this.Width = Background.Width - (int)0.21*(Background.Width);
            this.Height = Background.Height;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            g = this.CreateGraphics();
            
            this.BackgroundImage = Properties.Resources.map;
            
        }

        private void Form1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            Iplants plant = new Plants.plant_1(g, e.Location.X, e.Location.Y);
        }
    }
}
