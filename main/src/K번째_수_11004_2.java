import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K번째_수_11004_2 {
    public static void quicksort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        //오른쪽 파티션 기준 왼쪽데이터가 1개 혹은 없을 경우는 정렬할 필요가 없다.
        // 따라서 시작점보다 한개이상 차이 날 경우에만 재귀호출
        if(start < part2 - 1){
            quicksort(arr, start, part2-1);
        }
        //오른쪽은 한개이상일때만 호출
        if(part2 < end){
            quicksort(arr, part2, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end ) /2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }


    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //퀵 정렬 시작
        quicksort(arr, 0, n - 1);

        //sorting 끝
        System.out.println(arr[k-1]);
    }

}
