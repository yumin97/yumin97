import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1012_유기농배추 {

    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {0,0,1,-1};
    static int[] dc = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[j][k] == 1 && !visited[j][k]){
                        cnt++;
                        dfs(j,k);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int r,int c){
        if(map[r][c] == 0){
            return;
        }

        for(int d=0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0){
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr,nc);
        }
    }
}
