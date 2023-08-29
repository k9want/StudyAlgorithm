//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class 미로탐색_2178 {
    //1.dx dy
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    //2. visited
    static boolean[][] visited;
    //3. 주인공
    static int[][] arr;
    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); //110110
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        //bfs 시작
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
//        for (boolean[] vis : visited) {
//            System.out.println(Arrays.toString(vis));
//        }
        //setting end
        //bfs로 푼다. => visited[][]
        //방문이 안되는 조건:
        // 배열밖은 불가능, 0은 이동 불가. 방문한곳 또 x,
    }
    public static void bfs(int x, int y){
        Queue<int []> q = new LinkedList();
        q.add(new int[] {x, y});
        //방문 체크 하고
        visited[x][y] = true;
        while(!q.isEmpty()){
            //일단 q에서 꺼내고
            int[] now = q.poll();
            // 갈 방향 정해야지 4가지 dx, dy에서 꺼내니까 4번 반복
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                //이제 진짜 갈수 있는지 체크
                // 배열밖 x,
                if (nx >= 0 && ny >=0 && nx < n && ny < m){
                    //방문한 곳 x 이 문제에서 0도 x
                    if(!visited[nx][ny] && arr[nx][ny] != 0){
                        //방문체크 안해도 되려나?위에서 하는데
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[now[0]][now[1]] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
