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
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            m_graphics = this.CreateGraphics();
        }
    }
    class Game
    {
        public int Is_Running;
        Item item_cup = new Item();
        List<Item> objlist = new List<Item>();
        Game()
        {
            objlist[0] = new Wall();                        //objlist的0~3预留给wall和fruit
            for (int i=4,k=1;i<=7;i++)
            {
                objlist[i]= new Snake();      //初始化Snake

            }
        }
        public void Flip()                                  
        {
            for(int i =1;i<=objlist.Count;i++)
            {
                objlist[i].Draw(Tools.m_graphics);
            }
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
        void Move()
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
        public void SingleFruit()                       //单例fruit
        {
            if(Single_Fruit == null)
            {
                Single_Fruit = new Fruit();
            }
        }
        public override void Draw(Graphics g)
        {
            g.DrawRectangle(Tools.pen_pink, x, y, w, h);
        }
        private void reborn()
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
}
