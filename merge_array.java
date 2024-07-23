import java.util.*;

public class merge_array {

    public static List<Integer> find(int[][] arr) {
        List<Integer> li = new LinkedList<>();
        int k = arr.length;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                li.add(arr[i][j]);
            }
        }

        mergeSort(li);

        return li;
    }

    public static void mergeSort(List<Integer> li) {
        if (li.size() <= 1) {
            return;
        }

        int mid = li.size() / 2;
        List<Integer> left = new LinkedList<>(li.subList(0, mid));
        List<Integer> right = new LinkedList<>(li.subList(mid, li.size()));

        mergeSort(left);
        mergeSort(right);

        merge(li, left, right);
    }

    public static void merge(List<Integer> li, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                li.set(k++, left.get(i++));
            } else {
                li.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            li.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            li.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int k = s.nextInt();

        int[][] arr = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        List<Integer> res = find(arr);
        System.out.println("Merged sorted array: " + res);

        s.close();
    }
}
