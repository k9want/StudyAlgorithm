import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //양방향성 즉, 방향이 없다는 점!!
            arr[a].add(b);
            arr[b].add(a);
        }
        //하나씩 탐색 해야지
        //일단 나는 엣지 만큼 반복할거야!
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            // 방문 안한게 잇으면 들어갈거야!
            if (!visited[i]) {
                cnt ++;
                //그리고 dfs 돌릴거야
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    //dfs 선언하기
    private static void dfs(int node) {
        if (visited[node]) return;
        //만약에 visited[node]가 방문을 안햇으면 true로 바꾸고

        visited[node] = true;
        //여기가 중요!!!방문 안한 애들 중에 나는 방문할거야!!
        for (int v : arr[node]){
            if (!visited[v]) {
                dfs(v);
            }
        }
        // 다시 또 들어가!
    }
}
