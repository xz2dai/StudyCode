using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 植物大战僵尸
{
    static class MapManager
    {

        public static int FixXLocation(int Receive_X)           //修正植物安放位置为栅格化地图定点位置
        {
            int MidX, FinX;
            MidX = Receive_X - 255;
            if(MidX >= 0)
            {
                FinX = MidX / 80;
            }
            else
            {
                FinX = 0;
            }
            return FinX;
        }

        public static int ReturnFixX(int X)
        {
            return (X * 80) + 255;
        }

        public static int FixYLocation(int Receive_Y)
        {
            int MidY, FinY;
            MidY = Receive_Y - 75;
            if (MidY >= 0)
            {
                FinY = MidY / 100;
            }
            else
            {
                FinY = 0;
            }
            return FinY;
        }

        public static int ReturnFixY(int Y)
        {
            return (Y * 100) + 75;
        }
    }
}
