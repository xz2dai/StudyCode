using System;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Resources;
using System.Collections;
using System.Runtime;

namespace 植物大战僵尸
{
    interface IDrawFactory      //绘制基本接口
    {
        void TargetDraw(Bitmap[] bitmap, Graphics g, int x, int y);
    }
}
