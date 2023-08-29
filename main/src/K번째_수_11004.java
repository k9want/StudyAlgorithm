import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class K번째_수_11004 {
    //퀵정렬
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //퀵 정렬 사용하기
        quickSort(arr, 0, n-1, k-1);
        System.out.println(arr[k-1]);
    }

    public static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = part(arr, start, end);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                quickSort(arr, start, pivot - 1, k);
            } else {
                quickSort(arr, pivot+1, end, k);
            }
        }
    }
    public static int part(int[] arr, int start, int end) {
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
                return end;
            }
        }
        int mid = (start + end) / 2;
        swap(arr, start, mid); // (pivot)중앙값 가장 앞으로
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while(pivot < arr[j] && j > 0) {
                j--;
            }
            while (pivot > arr[i] && i < arr.length-1) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        arr[start] = arr[j];
        arr[j] = pivot;
        return j;


    }
    public static void swap(int[] arr, int start, int end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;

    }
}
