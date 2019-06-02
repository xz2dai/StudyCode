using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    interface IAddItemFactory               //添加物品基本接口，下属添加植物接口、僵尸接口
    {
        Iitem CreatItem(Iitem iitem);
        void AddToList(List<Iitem> itemlist);
        void DrawItem(IDrawFactory drawFactory);
    }
}
