import java.awt.*;

public class Grid {
    int grindArr[];
    int N;
    int k;
    Grid(int n){
        k = n;
        N = 2*k*(k+1);
        grindArr = new int[N];
    }
    public int setElementX(int X,int Y, int step){
        int index;
        index = X / step;
        int tmp = Y / step + 1;
        for(int i = 0;i < tmp;i++){
            if (i % 2 == 0) index+=k;
            else index = k+k+1;
        }
        System.out.print(index);
        return 0;
    }
}
