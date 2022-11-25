import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15684_사다리조작 {
    static int N,M,H,MIN;
    static int[][] map;
    static int[] max;

    static int[] dr = {1,0,0};
    static int[] dc = {0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N+2][N+1];
        max = new int[H+1];
        MIN = Integer.MAX_VALUE;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            map[r][c+1] = 1;
        }

        for(int i = 0; i <= 3; i++){
            MIN = i;
            dfs(1,1,0);
        }
                dfs(1,1,0);

        if(MIN > H || MIN == Integer.MAX_VALUE){
            MIN = -1;
        }

        System.out.println(MIN);
    }

    public static void dfs(int r,int c, int cnt){
        if(r == N+1 && c == N-1){
            if (Isladder()){
                MIN = Math.min(MIN,cnt);
            }
            return;
        }

        if(MIN < cnt){
            return;
        }

        for (int i = 0; i < ; i++) {
            for (int j = 0; j < ; j++) {

            }
        }

    }

    public static boolean Isladder(){
        for(int i = 1; i < N+1; i++){
            int r = 1;
            int c = i;
            boolean flag;
            while(true){
                if(r == N+1){
                    if(c == i){
                        flag = true;
                    }else {
                        flag = false;
                    }
                    break;
                }

                if(map[r][c] == 1){
                    for(int d = 1; d < 3; d++){
                        int nc = c + dc[d];

                        if(nc < 1 || nc >= N+1 || map[r][nc] == 0){
                            continue;
                        }

                        c = nc;
                        break;
                    }
                }
                r = r + dr[0];
            }

            if(!flag){
                return false;
            }
        }
        return true;
    }
}
