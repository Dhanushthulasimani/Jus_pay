import java.util.*;

class Two_Nodes {

    public int closestMeet(int[] edges, int node1, int node2) {
        int n = edges.length; // Length of the edges array
        boolean[] v1 = new boolean[n];
        boolean[] v2 = new boolean[n];

        v1[node1] = true;
        v2[node2] = true;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.offer(node1);
        q2.offer(node2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            int size1 = q1.size();
            for (int i = 0; i < size1; i++) {
                int cur1 = q1.poll();

                if (v2[cur1]) {
                    return cur1;
                }

                int next1 = edges[cur1];
                if (next1 >= 0 && !v1[next1]) {
                    v1[next1] = true;
                    q1.offer(next1);
                }
            }

            int size2 = q2.size();
            for (int i = 0; i < size2; i++) {
                int cur2 = q2.poll();

                if (v1[cur2]) {
                    return cur2;
                }

                int next2 = edges[cur2];
                if (next2 >= 0 && !v2[next2]) {
                    v2[next2] = true;
                    q2.offer(next2);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Two_Nodes solution = new Two_Nodes();

        System.out.print("Enter the number of nodes in the graph: ");
        int n = s.nextInt();
        int[] edges = new int[n];

        System.out.println("Enter the graph edges:");
        for (int i = 0; i < n; i++) {
            edges[i] = s.nextInt();
        }

        System.out.print("Enter node1 for BFS traversal: ");
        int node1 = s.nextInt();

        System.out.print("Enter node2 for BFS traversal: ");
        int node2 = s.nextInt();

        int closestNode = solution.closestMeet(edges, node1, node2);
        System.out.println("Closest meeting node: " + closestNode);

        s.close();
    }
}
