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
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
    class game
    {
       public int Is_Running;
        ArrayList objlist;
        class Item
        {
            protected int x;
            protected int y;
            protected int Is_exist;
            protected void Present()
            {

            }
        }
        class Snake:Item
        {
            int S_x;
            int S_y;
            void move()
            {
                x += S_x;
                y += S_y;
            }
        }
        class Fruit:Item
        {

        }
        class Wall:Item
        {

        }
        public void Flip()
        {
            for(int i =1;i<=objlist.Count;i++)
            {

            }
        }
    }
}
