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
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            g = this.CreateGraphics();
        }

        Graphics g;

        private void button1_Click(object sender, EventArgs e)
        {
            Pen pen_black = new Pen(Color.Black);
            Brush brush_black = new SolidBrush(Color.Black);
            g.DrawRectangle(pen_black, (int)this.Width / 2, (int)this.Height / 2, 20, 20);
            g.FillRectangle(brush_black, (int)this.Width / 2, (int)this.Height / 2, 20, 20);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }
    }
}
