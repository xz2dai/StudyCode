using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    public class Flip      //刷新画面类
    {
        public void FlipPlants(List<plant_1> plantlist,Graphics g)
        {
            if (plantlist.Count() == 0) return;
            for (int i = 0;i<= plantlist.Count-1; i++)
            {
                plantlist[i].Action(g);
            }
        }

        public void FlipZombies(List<NormalZombie> zombielist,Graphics g)
        {
            if (zombielist.Count() == 0) return;
            for (int i = 0; i <= zombielist.Count - 1; i++)
            {
                zombielist[i].Move(g);
            }

        }
    }
}
