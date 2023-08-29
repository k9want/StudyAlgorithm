import java.io.*;
import java.util.*;
public class 수찾기_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i =0; i < n; i++){
            a[i] = sc.nextInt();
        }
        // 바로 찾을거니까 정렬
        Arrays.sort(a);
        int m = sc.nextInt();
        for(int i=0; i < m; i++) {
            //찾고자 하는 m의 값을 받는다.
            int find = sc.nextInt();
            //찾아야지 이진탐색으로
            //0. 시작과 끝 부터
            int start = 0;
            int end = a.length - 1; // -1유의
            boolean flag = false;
            //찾기
            while(start <= end) {
                int midI = (start + end)/2;
                int midV = a[midI];
                if(midV > find){
                    // target 중앙값
                    //왼쪽
                    end = midI - 1;
                }else if (midV < find) {
                    //오른쪽
                    start = midI + 1;
                }else { //같다면
                    flag = true;
                    break; //반복문 탈출
                }
            }
            if(flag){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
        //일단 입력 다 받고 시작
    }
}
