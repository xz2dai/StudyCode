
public class astar {
    class point {
        int x;  //xy����
        int y;
        int g;  //�������·��
        int h;  //����ʽ�����Ȩֵ�������þ�Ŀ������
        int f;  //��ֵ��f=g+h
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