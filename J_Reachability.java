import java.util.*;

public class J_Reachability {

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

        public static boolean find(boolean vis[], ArrayList<ArrayList<Integer>> adj, int c, int d)
        {
            if(c == d)
            {
                return true;
            }

            if(vis[c])
            {
                return false;
            }

            ArrayList<Integer> l = adj.get(c);
            vis[c] = true;

            for(int i = 0; i < l.size(); i++)
            {
                boolean res = find(vis, adj, l.get(i), d);

                if(res)
                {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args)
        {
            Scanner s = new Scanner(System.in);

            int n = s.nextInt();
            int a[] = new int[n];

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                a[i] = s.nextInt();
                adj.add(new ArrayList<>());
            }

            int m = s.nextInt();

            for(int i = 0; i < m; i++)
            {
                int x = s.nextInt();
                int y = s.nextInt();

                adj.get(getin(a, x)).add(getin(a, y));
            }

            boolean vis[] = new boolean[n];

            int c = s.nextInt();
            int d = s.nextInt();

            c = getin(a, c);
            d = getin(a, d);

            System.out.println(find(vis, adj, c, d) ? 1 : 0);

            s.close();
        }
    }