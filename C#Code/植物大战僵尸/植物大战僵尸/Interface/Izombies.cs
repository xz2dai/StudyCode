using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace 植物大战僵尸
{
    public interface IZombies:Iitem
    {
        void Move();
        void Eat();
        void BeKill();
        void Born();
    }
}
