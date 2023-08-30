import java.util.Scanner;

public class 이항_계수1_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        //일단 1C0 = 1 4C4 = 1 4c1 = i
        //2차원 배열 초기화 및 셋팅
        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            arr[i][1] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        System.out.println(arr[n][k]);
    }
}
