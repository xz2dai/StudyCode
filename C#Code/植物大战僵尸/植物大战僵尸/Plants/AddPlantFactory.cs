using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    class AddPlantFactory : IAddItemFactory
    {
        public void AddToList(List<Iitem> itemlist)
        {
            throw new NotImplementedException();
        }

        public Iitem CreatItem(Iitem iitem)
        {
            throw new NotImplementedException();
        }

        public void DrawItem(IDrawFactory drawFactory)
        {
            throw new NotImplementedException();
        }
    }
}
