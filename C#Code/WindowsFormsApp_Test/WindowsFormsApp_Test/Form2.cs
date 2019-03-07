using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp_Test
{
    public partial class Form2 : Form
    {
        System.Timers.Timer t1 = new System.Timers.Timer();
        public Form2()
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
    }
}
