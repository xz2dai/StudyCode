using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Resources;

namespace WindowsFormsApp_Test
{
    public partial class Form2 : Form
    {
        private static Form2 form2;
        private System.Timers.Timer t1 = new System.Timers.Timer();
        public Bitmap image = new Bitmap("../../Resources/LinkStart.gif");
        private Form2()
        {
            InitializeComponent();
            Control.CheckForIllegalCrossThreadCalls = false;
            t1.Start();
            t1.Interval = 6400;
            t1.Elapsed += new System.Timers.ElapsedEventHandler(excute);
            t1.AutoReset = false;
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            pictureBox1.Width = image.Width;
            pictureBox1.Height = image.Height;
        }

        private void excute(object sender,System.Timers.ElapsedEventArgs e)
        {
            t1.Stop();
            t1.Close();
            this.Close();
            MessageBox.Show("Link Fail");
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        public static Form2 SingleMethod()
        {
            if(form2 == null)
            {
                form2 = new Form2();
            }
            else
            {
                MessageBox.Show("连接中,请稍后");
            }
            return form2;
        }
    }
}
