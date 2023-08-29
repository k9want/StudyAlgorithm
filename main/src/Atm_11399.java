import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Atm_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //삽입 정렬 사용해보기
        for (int i = 1; i < n; i++) {
            int insert_position = i;
            int insert_value = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    insert_position = j;
                    break;
                }
            }
            for (int j = i; j > insert_position; j--) {
                arr[j] = arr[j-1];
            }
            arr[insert_position] = insert_value;
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += sum[i];
        }
        System.out.println(result);
    }
}
