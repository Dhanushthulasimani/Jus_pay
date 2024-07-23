import java.util.*;

public class Unreachability
{

    public static int getin(int a[], int x)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (x == a[i])
            {
                return i;
            }
        }
        return -1;
    }

    public static boolean DFS(int a[], boolean vis[], ArrayList<ArrayList<Integer>> adj, int c, int d, List<Integer> path)
    {
        vis[c] = true;
        path.add(a[c]);

        if (c == d)
        {
            return true;
        }

        for (int neighbor : adj.get(c))
        {
            if (!vis[neighbor])
            {
                if (DFS(a, vis, adj, neighbor, d, path))
                {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void solu(int a[], boolean vis[], ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        List<Integer> path = new ArrayList<>();

        if (DFS(a, vis, adj, c, d, path))
        {
            path.remove(0);
            path.remove(path.size() - 1);

            List<Integer> criti = new ArrayList<>();
            for (int node : path)
            {
                Arrays.fill(vis, false);
                vis[getin(a, node)] = true;

                if (!DFS(new int[a.length], vis, adj, c, d, new ArrayList<>()))
                {
                    criti.add(node);
                }
            }
            System.out.println(criti);
        }
        else
        {
            System.out.println("No path exists");
        }
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int a[] = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
            adj.add(new ArrayList<>());
        }

        int m = s.nextInt();

        for (int i = 0; i < m; i++)
        {
            int x = s.nextInt();
            int y = s.nextInt();

            adj.get(getin(a, x)).add(getin(a, y));
            adj.get(getin(a, y)).add(getin(a, x));
        }

        boolean vis[] = new boolean[n];

        int c = s.nextInt();
        int d = s.nextInt();

        c = getin(a, c);
        d = getin(a, d);

        solu(a, vis, adj, c, d);

        s.close();
    }
}