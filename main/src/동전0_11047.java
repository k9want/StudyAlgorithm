import java.util.*;
public class 동전0_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int cnt = 0;
        //그리디 시작
        for (int i = n-1; i >= 0; i--) {
            if (a[i] <= k){
                cnt += (k / a[i]);
                k =  k % a[i];
            }
        }
        System.out.println(cnt);
    }
}
