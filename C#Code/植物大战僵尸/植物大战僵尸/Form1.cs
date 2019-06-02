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
        enum FormState
        {
            Start,          //开始界面
            Gaming,         //游戏界面
            menu            //菜单界面
        }
        FrapsManage timer;
        Graphics g;
        Image map,Loginimage;
        FormState NowFormState;
        public Form1()
        {
            InitializeComponent();

        }


        private void Form1_Load(object sender, EventArgs e)             //启动页面及启动按钮,以及加载资源
        {
            NowFormState = FormState.Start;
            map = Properties.Resources.map;
            Loginimage = Properties.Resources.Logo;
            timer = new FrapsManage();
            this.BackgroundImage = Properties.Resources.Logo;           //设置背景
            this.FormBorderStyle = FormBorderStyle.None;
            this.Width = this.BackgroundImage.Width;
            this.Height = this.BackgroundImage.Height;
            SettingButton.Location = new Point(this.Width - SettingButton.Width, 0);        //调整菜单按钮位置
        }

        private void button1_Click(object sender, EventArgs e)          //转入游戏界面
        {
            NowFormState = FormState.Gaming;
            QuitButton.Enabled = false;
            QuitButton.Visible = false;
            g = this.CreateGraphics();
            this.BackgroundImage = map;                 //设置背景地图
            this.Width = this.BackgroundImage.Width;
            this.Height = this.BackgroundImage.Height;
            button1.Visible = false;                      //隐藏开始按钮
            button1.Enabled = false;
            SettingButton.Location = new Point(this.Width - SettingButton.Width, 0);       //调整菜单按钮
        }

        private void Form1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            //Iplants plant = new Plants.plant_1(g, e.Location.X, e.Location.Y);
        }

        private void SettingButton_Click(object sender, EventArgs e)        //菜单按钮按下事件
        {
            if(NowFormState == FormState.Gaming)
            {
                QuitButton.Location = new Point(this.Width - QuitButton.Width - 50, this.Height - QuitButton.Height -50);
                QuitButton.Enabled = true;
                QuitButton.Visible = true;
                NowFormState = FormState.menu;
            }
            else if(NowFormState == FormState.menu)
            {
                QuitButton.Enabled = false;
                QuitButton.Visible = false;
                NowFormState = FormState.Gaming;
            }
            
        }

        private void QuitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            //RPGBitmap[g_iDirection].MakeTransparent(Color.White);

        }
    }
}
