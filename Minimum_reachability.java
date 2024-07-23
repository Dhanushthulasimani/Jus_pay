import java.util.Scanner;

public class Minimum_reachability
{
    static int min = Integer.MAX_VALUE;

    public static int getin(int a[], int x)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(x == a[i])
            {
                return i;
            }
        }
        return -1;
    }

    public static void find(int adj[][], int sum, boolean vis[], int c, int d)
    {
        if(c == d)
        {
            if(min > sum)
            {
                min = sum;
            }
            return;
        }

        if(vis[c])
        {
            return;
        }

        vis[c] = true;

        for(int i = 0; i < adj.length; i++)
        {
            if(adj[c][i] != 0)
            {
                find(adj, sum + adj[c][i], vis, i, d);
            }
        }

        vis[c] = false;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int a[] = new int[n];

        int adj[][] = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }

        int m = s.nextInt();

        for(int i = 0; i < m; i++)
        {
            int x = s.nextInt();
            int y = s.nextInt();
            int we = s.nextInt();

            adj[getin(a, x)][getin(a, y)] = we;
        }

        boolean vis[] = new boolean[n];

        int c = s.nextInt();
        int d = s.nextInt();

        c = getin(a, c);
        d = getin(a, d);

        find(adj, 0, vis, c, d);
        System.out.println(min);

        s.close();
    }
}