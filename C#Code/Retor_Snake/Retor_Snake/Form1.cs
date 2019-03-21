using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;
using System.Runtime.InteropServices;


namespace Retor_Snake
{
    public partial class Form1 : Form
    {
        [DllImport("kernel32.dll")]
        static extern bool FreeConsole();
        [DllImport("kernel32.dll")]
        public static extern bool AllocConsole();
        Graphics m_graphics;
        Game Game;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            AllocConsole();
            Console.WriteLine("开始加载渲染器");
            try
            {
                m_graphics = this.CreateGraphics();
            }
            catch
            {
                Console.WriteLine("渲染器加载失败");
            }
            Console.WriteLine("窗体加载完成");
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            string Key_down = e.KeyCode.ToString();
            switch(Key_down)
            {
                default:
                    {
                        break;
                    }
                case "Right":
                    {
                        Game.snakelist[0].M_RIGHT();
                        break;
                    }
                case "Left":
                    {
                        Game.snakelist[0].M_LEFT();
                        break;
                    }
                case "Down":
                    {
                        Game.snakelist[0].M_DOWN();
                        break;
                    }
                case "Up":
                    {
                        Game.snakelist[0].M_UP();
                        break;
                    }
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Console.WriteLine("开始加载游戏");
            try
            {
                Game = Game.Single_game();
                Game.Excution();
            }
            catch
            {
                Console.WriteLine("加载游戏失败");
            }
        }
    }
    class Game
    {
        public bool Is_Running;
        public Fruit Fruit;
        public List<Wall> walls;
        public List<Snake> snakelist;
        public static Game Game_s;
        public static Game Single_game()        //单例化Game
        {
            if(Game_s == null)
            {
                Game_s = new Game();
                return Game_s;
            }
            return Game_s;
        }
        class Handevents:Game  
        {
            public delegate void BoilerLogHander(string status);
            public event BoilerLogHander BoilerEventLog;
            public void Getevent()
            {

            }
        }
        class FrapsManage
        {
            System.DateTime timer = new DateTime();
            private int passtime, starttime;
            public void Start()
            {
                starttime = timer.Millisecond;
            }
            public void Delay()
            {
                passtime = timer.Millisecond - starttime;
                Task.Delay(500 - passtime);
            }
        }
        public void Excution()
        {
            FrapsManage frapsManage = new FrapsManage();
            Handevents handevents = new Handevents();
            while (!Is_Running)
            {
                frapsManage.Start();
                handevents.Getevent();
                Flip();
                frapsManage.Delay();
            }
        }
        Game()
        {
            if(Init()==1)
            {
                Console.WriteLine("初始化失败");
            }
        }
        public void Flip()                                  
        {
            Fruit.Draw(Tools.m_graphics);
            for(int i=1;i<=walls.Count;i++)
            {
                if (walls[i] == null) break;
                walls[i].Draw(Tools.m_graphics);
            }
            for(int i=1;i<=snakelist.Count;i++)
            {
                if (snakelist[i] == null) break;
                snakelist[i].Draw(Tools.m_graphics);
            }
            Console.WriteLine("刷新");
        }
        public int Init()
        {
            Fruit = Fruit.SingleFruit();
            walls = new List<Wall>();
            snakelist = new List<Snake>();
            Wall wall1 = new Wall();
            Wall wall2 = new Wall();
            walls.Add(wall1);
            walls.Add(wall2);
            for (int i = 1; i <= 4; i++)
            {
                snakelist.Add(new Snake());      //初始化Snake
                
            }
            Is_Running = true;
            return 0;
        }
    }
    class Item
    {
        protected int x;
        protected int y;
        readonly protected int w = 10;
        readonly protected int h = 10;
        public Item()
        {
            x = (int)Tools.Random.Next(10) * 100;
            y = (int)Tools.Random.Next(10) * 100;
        }
        public virtual void Draw(Graphics g)
        {
            g.DrawRectangle(Tools.pen_white, x, y, w, h);
        }
        public virtual void Set(int setx,int sety)
        {
            x = setx;
            y = sety;
        }
    }
    class Snake : Item
    {
        int V_x = 0;
        int V_y = 10;
        public  Snake()
        {
            Console.WriteLine("snake被创建");
        }
        public void Move()
        {
            x += V_x;
            y += V_y;
        }
        public override void Draw(Graphics g)
        {
            base.Draw(g);
        }
        public void M_UP()
        {
            V_x = 0;
            V_y = 10;
        }
        public void M_DOWN()
        {
            V_x = 0;
            V_y = -10;
        }
        public void M_LEFT()
        {
            V_x = -10;
            V_y = 0;
        }
        public void M_RIGHT()
        {
            V_x = 10;
            V_y = 0;
        }
    }
    class Fruit : Item
    {
        static Fruit Single_Fruit;
        private Fruit()
        {
            Console.WriteLine("wall被创建");
        }
        public static Fruit SingleFruit()                       //单例fruit
        {
            if(Single_Fruit == null)
            {
                Single_Fruit = new Fruit();
                return Single_Fruit;
            }
            return Single_Fruit;
        }
        public override void Draw(Graphics g)
        {
            g.DrawRectangle(Tools.pen_pink, x, y, w, h);
        }
        private void Reborn()
        {

        }
    }
    class Wall : Item
    {
        public Wall()
        {
            Console.WriteLine("wall被创建");
        }

        public override void Draw(Graphics g)
        {
            g.DrawRectangle(Tools.pen_white, x, y, w, h);
        }
    }
    static public class Tools
    {
        static public Brush brs_black = new SolidBrush(Color.Black);
        static public Brush brs_white = new SolidBrush(Color.White);
        static public Brush brs_pink = new SolidBrush(Color.Pink);
        static public Pen pen_white = new Pen(Color.White);
        static public Pen pen_pink = new Pen(Color.Pink);
        static public Pen pen_black = new Pen(Color.Black);
        static public Random Random = new Random();
        static public Graphics m_graphics;
    }
    
}
