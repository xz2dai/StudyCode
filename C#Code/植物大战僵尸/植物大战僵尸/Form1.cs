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
using System.Collections.Generic;
using System.Threading;

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
        Image map,Loginimage;
        Bitmap[] SunFlowerBitmaps, PeaShooterBitmaps;
        plant_1.Plants NowSettingPlant;
        FormState NowFormState;
        MouseState NowMouseState;
        bool Settingplant;
        int SunCount;
        int[,] Map_HavePlant;
        AddZombieFactory zombieFactory;
        AddPlantFactory plantFactory;
        List<plant_1> plantlist;
        List<NormalZombie> Zombielist;
        PlantDrawFactory PlantDrawFactory;
        public Form1()
        {
            InitializeComponent();

        }


        private void Form1_Load(object sender, EventArgs e)             //启动页面及启动按钮,以及加载资源
        {
            g = this.CreateGraphics();
            NowFormState = FormState.Start;
            NowMouseState = MouseState.None;
            plantlist = new List<plant_1>();
            PlantDrawFactory = new PlantDrawFactory();
            Zombielist = new List<NormalZombie>();
            Map_HavePlant = new int[9, 5];
            map = Properties.Resources.map;
            Loginimage = Properties.Resources.Logo;
            timer = new FrapsManage();
            this.BackgroundImage = Properties.Resources.Logo;           //设置背景
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

            Point NowLocation = this.PointToClient(Control.MousePosition);
            //Iplants plant = new Plants.plant_1(g, e.Location.X, e.Location.Y);       //用于测试植物生成
            if(NowMouseState == MouseState.PlantingPlant && !(NowLocation.X < 231 || NowLocation.X > 1000 || NowLocation.Y < 70 || NowLocation.Y > 578))
            {
                int m_X, m_Y;
                m_X = MapManager.FixXLocation(NowLocation.X);
                m_Y = MapManager.FixYLocation(NowLocation.Y);
                if (m_X > 8 || m_Y > 4) return;
                if (Map_HavePlant[m_X, m_Y] == 0)//判断该点是否已有植物
                {
                    
                    Map_HavePlant[m_X, m_Y] = 1;
                    plant_1 m_plant = new plant_1();
                    switch (NowSettingPlant)
                    {
                            case plant_1.Plants.sunflower:
                            {
                                //m_plant.bitmap = Properties.Resources.SunFlower1;
                                //m_plant.LoadBitmap(@".\bitmaps\Sunflower\");
                                m_plant = plantFactory.CreatPlant(MapManager.ReturnFixX(m_X), MapManager.ReturnFixY(m_Y), SunFlowerBitmaps,g);//放置栅格化定位植物位置
                                
                                break;
                            }
                            case plant_1.Plants.peashooter:
                            {
                                //m_plant.bitmap = Properties.Resources.Peashooter1;
                                //m_plant.LoadBitmap(@".\bitmaps\Peashooter\");
                                m_plant = plantFactory.CreatPlant(MapManager.ReturnFixX(m_X), MapManager.ReturnFixY(m_Y), PeaShooterBitmaps,g);//放置栅格化定位植物位置
                                
                                break;
                            }
                    }
                    plantlist.Add(m_plant);
                }
                else
                {
                    return;
                }

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
            NowMouseState = MouseState.PlantingPlant;
            NowSettingPlant = plant_1.Plants.sunflower;
        }

        private void PlantButton2_Click(object sender, EventArgs e)
        {
            NowMouseState = MouseState.PlantingPlant;
            NowSettingPlant = plant_1.Plants.peashooter;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            //RPGBitmap[g_iDirection].MakeTransparent(Color.White);             //去掉背景色

        }

        void GameStart()
        {
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
            plantFactory = new AddPlantFactory();
            zombieFactory = new AddZombieFactory();
            LoadBitmaps();
            Thread thread = new Thread(Flip);
            thread.Start();
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

        private void Form1_Move(object sender, EventArgs e)
        {
            if(NowMouseState == MouseState.PlantingPlant)
            {
                switch (NowSettingPlant)
                {
                    case plant_1.Plants.peashooter:
                        g.DrawImage(PeaShooterBitmaps[0], this.PointToClient(MousePosition));
                        break;
                    case plant_1.Plants.sunflower:
                        //  g.DrawImage(PeaShooterBitmaps[0], this.PointToClient(MousePosition));
                        break;
                }
            }
        }

        void GetSun(int num)
        {
            SunCount += num;
            SunCountLabel.Text = SunCount.ToString();
        }

        private void Form1_SizeChanged(object sender, EventArgs e)
        {
            g = this.CreateGraphics();
        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            SunCountLabel.Text = this.PointToClient(Control.MousePosition).ToString();
        }

        void UseSun(int num)
        {
            SunCount -= num;
            SunCountLabel.Text = SunCount.ToString();
        }

        void LoadBitmaps()
        {
            SunFlowerBitmaps = new Bitmap[12];
            PeaShooterBitmaps = new Bitmap[12];
            for (int i = 0;i<=11;i++)
            {
                SunFlowerBitmaps[i] = new Bitmap(@".\bitmaps\SunFlower\" + i.ToString() + ".Png");
                PeaShooterBitmaps[i] = new Bitmap(@".\bitmaps\Peashooter\" + i.ToString() + ".Png");
            }
        }

        void Flip()
        {
            while(NowFormState == FormState.Gaming)
            {
                while(plantlist.Count() == 0 && Zombielist.Count() == 0) continue;
                timer.Start();
                this.Invalidate();
                timer.flip.FlipPlants(plantlist, g);
                timer.Delay();
            }
        }
    }
}
