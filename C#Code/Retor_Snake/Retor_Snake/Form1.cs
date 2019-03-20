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


namespace Retor_Snake
{
    public partial class Form1 : Form
    {
        Graphics m_graphics;
        Game Game;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            m_graphics = this.CreateGraphics();
            Game = Game.Single_game();
        }
    }
    class Game
    {
        public bool Is_Running;
        Item item_cup = new Item();
        protected Fruit Fruit;
        protected List<Wall> walls = new List<Wall>(3);
        protected List<Snake> snakelist = new List<Snake>();
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
            Init();
        }
        public void Flip()                                  
        {
            Fruit.Draw(Tools.m_graphics);
            for(int i=1;i<=walls.Count;i++)
            {
                walls[i].Draw(Tools.m_graphics);
            }
            for(int i=1;i<=snakelist.Count;i++)
            {
                walls[i].Draw(Tools.m_graphics);
            }
        }
        public int Init()
        {
            Fruit = Fruit.SingleFruit();                      //objlist的0~3预留给wall和fruit
            walls[1] = new Wall();
            walls[2] = new Wall();
            for (int i = 1; i <= 4; i++)
            {
                snakelist[i] = new Snake();      //初始化Snake
                
            }
            return 0;
        }
    }
    class Item
    {
        protected int x;
        protected int y;
        readonly protected int w = 10;
        readonly protected int h = 10;
        protected int Is_exist;
        Rectangle m_rect;
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
        int V_x;
        int V_y;
        public void Move()
        {
            x += V_x;
            y += V_y;
        }
        public override void Draw(Graphics g)
        {
            base.Draw(g);
        }
    }
    class Fruit : Item
    {
        static Fruit Single_Fruit;
        private Fruit()
        {

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
    class Handevents
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
            Task.Delay(33 - passtime);
        }
    }
}
