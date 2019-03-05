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
        System.Timers.Timer t1 = new System.Timers.Timer(6300);
        public Form2()
        {
            InitializeComponent();
            t1.Elapsed +=new System.Timers.ElapsedEventHandler(excuce);
            t1.AutoReset = true;
            t1.Enabled = true;
            t1.Start();
            
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void Form2_Shown(object sender, EventArgs e)
        {

        }
        public void excuce(object sender, System.Timers.ElapsedEventArgs e)
        {
            MessageBox.Show("Link Fail");
            t1.Stop();
            this.Close();
        }
    }
}
