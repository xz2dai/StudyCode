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
        enum MouseState
        {
            PlantingPlant,
            None,
            SelectSun
        }
        FrapsManage timer;
        Graphics g;
        Image map,Loginimage,NowSettingPlant;
        FormState NowFormState;
        MouseState NowMouseState;
        bool Settingplant;
        int SunCount;
        public Form1()
        {
            InitializeComponent();

        }


        private void Form1_Load(object sender, EventArgs e)             //启动页面及启动按钮,以及加载资源
        {
            NowFormState = FormState.Start;
            NowMouseState = MouseState.None;
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
            GameStart();
        }

        private void Form1_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            //Iplants plant = new Plants.plant_1(g, e.Location.X, e.Location.Y);       //用于测试植物生成
            if(NowMouseState == MouseState.PlantingPlant)
            {

            }
        }

        private void SettingButton_Click(object sender, EventArgs e)        //菜单按钮按下事件
        {
            if(NowFormState == FormState.Gaming)
            {
                ShowSetting();
            }
            else if(NowFormState == FormState.menu)
            {
                QuitSetting();
            }
            
        }

        private void QuitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void SunCountLabel_TextChanged(object sender, EventArgs e)          //太阳数改变时事件
        {

        }

        private void PlantButton1_Click(object sender, EventArgs e)
        {

        }

        private void PlantButton2_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            //RPGBitmap[g_iDirection].MakeTransparent(Color.White);             //去掉背景色

        }

        void GameStart()
        {
            g = this.CreateGraphics();
            NowFormState = FormState.Gaming;
            QuitButton.Enabled = false;
            QuitButton.Visible = false;
            PlantButton1.Visible = true;
            PlantButton1.BackgroundImage = Properties.Resources.SunFlowerLimpid;
            PlantButton2.Visible = true;
            PlantButton2.BackgroundImage = Properties.Resources.PeashooterLimpid;
            SunCountPicture.Visible = true;
            SunCountLabel.Visible = true;
            SunCount = 0;
            SunCountLabel.Text = SunCount.ToString();
            this.BackgroundImage = map;                 //设置背景地图
            this.Width = this.BackgroundImage.Width;
            this.Height = this.BackgroundImage.Height;
            button1.Visible = false;                      //隐藏开始按钮
            button1.Enabled = false;
            SettingButton.Location = new Point(this.Width - SettingButton.Width, 0);       //调整菜单按钮
            AddPlantFactory plantFactory = new AddPlantFactory();
            AddZombieFactory zombieFactory = new AddZombieFactory();
            
        }

        void ShowSetting()
        {
            QuitButton.Location = new Point(this.Width - QuitButton.Width - 50, this.Height - QuitButton.Height - 50);
            QuitButton.Enabled = true;
            QuitButton.Visible = true;
            NowFormState = FormState.menu;
        }

        void QuitSetting()
        {
            QuitButton.Enabled = false;
            QuitButton.Visible = false;
            NowFormState = FormState.Gaming;
        }

        void GetSun(int num)
        {
            SunCount += num;
            SunCountLabel.Text = SunCount.ToString();
        }

        void UseSun(int num)
        {
            SunCount -= num;
            SunCountLabel.Text = SunCount.ToString();
        }
    }
}
