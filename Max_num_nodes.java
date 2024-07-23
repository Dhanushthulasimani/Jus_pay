import java.util.*;

class Max_num_nodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases
        for (int testCase = 0; testCase < T; testCase++) {
            int N = scanner.nextInt(); // Number of nodes

            int[] parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = scanner.nextInt();
            }

            // Construct adjacency list representation of the tree
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                tree.add(new ArrayList<>());
            }

            int root = -1;
            for (int i = 0; i < N; i++) {
                if (parent[i] == -1) {
                    root = i;
                } else {
                    tree.get(parent[i]).add(i);
                }
            }

            // Perform BFS to calculate depth of each node
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(root);

            int[] depthCount = new int[N]; // To count nodes at each depth
            int maxDepth = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    depthCount[maxDepth]++;

                    for (int child : tree.get(node)) {
                        queue.offer(child);
                    }
                }
                maxDepth++;
            }

            // Find the depth with maximum number of nodes
            int maxNodes = 0;
            int depthWithMaxNodes = 0;
            for (int d = 0; d < maxDepth; d++) {
                if (depthCount[d] > maxNodes) {
                    maxNodes = depthCount[d];
                    depthWithMaxNodes = d;
                }
            }

            // Output the result for current test case
            System.out.println(depthWithMaxNodes);
        }

        scanner.close();
    }
}
