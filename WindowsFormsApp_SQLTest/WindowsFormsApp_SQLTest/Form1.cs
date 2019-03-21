using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace WindowsFormsApp_SQLTest
{
    public partial class Form1 : Form
    {
        SqlConnection conn;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(textBox1.Text == "")
            {
                MessageBox.Show("未输入数据库名称!");
            }
            else
            {
                try
                {
                    string constr = "server=.;database=" + textBox1.Text.Trim() + ";uid=sa;pwd=" + textBox2.Text.Trim();
                    conn = new SqlConnection(constr);
                    conn.Open();
                    if(conn.State == ConnectionState.Open)
                    {
                        label1.Text = "数据库已经打开";
                    }
                }
                catch
                {
                    MessageBox.Show("连接数据库失败");
                }
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                string str1 = "";
                conn.Close();
                if(conn.State == ConnectionState.Closed)
                {
                    str1 = "数据库已关闭";
                }
                label1.Text = str1;
            }
            catch(Exception ex)
            {
                label1.Text = ex.Message;
            }

        }
    }
}
