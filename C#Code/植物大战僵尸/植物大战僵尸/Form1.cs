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
        FrapsManage timer;
        Graphics g;
        Image Background = Properties.Resources.map;
        Ammo ammo = new Ammo();
        public Form1()
        {
            InitializeComponent();

        }


        private void Form1_Load(object sender, EventArgs e)
        {
            timer = new FrapsManage();
            this.FormBorderStyle = FormBorderStyle.None;
            this.Width = Background.Width - (int)0.21*(Background.Width);
            this.Height = Background.Height;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            g = this.CreateGraphics();
            this.Width = this.BackgroundImage.Width;
            this.BackgroundImage = Background;
            button1.Visible = false;
        }

        private void Form1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            //Iplants plant = new Plants.plant_1(g, e.Location.X, e.Location.Y);
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            //RPGBitmap[g_iDirection].MakeTransparent(Color.White);

        }
    }
}
