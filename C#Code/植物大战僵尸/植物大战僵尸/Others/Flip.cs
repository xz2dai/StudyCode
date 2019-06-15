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
        List<plant_1> plantlist;
        List<NormalZombie> zombielist;
        Graphics g;
        public void SetPlantMethod(List<plant_1> plantlist)
        {
            this.plantlist = plantlist;
            //this.g = g;
        }

        public void SetZombieMethod(List<NormalZombie> zombielist)
        {
            this.zombielist = zombielist;
            //this.g = g;
        }

        public void FlipPlants(object sender,System.Timers.ElapsedEventArgs e)
        {
            if (plantlist.Count() == 0) return;
            for (int i = 0; i <= plantlist.Count - 1; i++)
            {
                plantlist[i].Action();
            }
        }

        public void FlipZombies(object sender,System.Timers.ElapsedEventArgs e)
        {
            if (zombielist.Count() == 0) return;
            for (int i = 0; i <= zombielist.Count - 1; i++)
            {
                zombielist[i].Move();
                if (zombielist[i].IsDie())
                    zombielist.RemoveAt(i);
            }

        }
    }
}
