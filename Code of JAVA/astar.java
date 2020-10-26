
public class astar {
    class point {
        int x;  //xy坐标
        int y;
        int g;  //距出发点路程
        int h;  //启发式计算加权值，这里用距目标点距离
        int f;  //总值，f=g+h
    }

    public final static int n = 10;

    public static void main(String[] args) {
        point[][] map = new point[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j].x = i;
                map[i][j].y = j;
            }

        }
    }

    void FoundWayByAstar()
    {

    }

    void BFS() {

    }

}