package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1018_체스판다시칠하기 {

    static int N, M, MIN;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MIN = Integer.MAX_VALUE;

        map = new char[N][M];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            char[] chars = input.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
            }
        }

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                find(i,j);
            }
        }
        System.out.println(MIN);

    }

    public static void find(int r,int c){
        int sum = 0;
        // char start = map[r][c];
        char even_start = ' ';
        char odd_start = ' ';
//        if(start == 'W') {
//            even_start = 'W';
//            odd_start = 'B';
//        }
//        else if( start == 'B') {
//            even_start = 'B';
//            odd_start = 'W';
//        }
        for (int k = 0; k < 2; k++) {
            sum = 0;
            if ( k == 1){
                even_start = 'B';
                odd_start = 'W';
            }else {
                even_start = 'W';
                odd_start = 'B';
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if( i % 2 == 1){
                        if( j % 2 == 0 && map[r+i][c+j] != odd_start){
                            sum += 1;
                        }
                        else if( j % 2 == 1 && map[r+i][c+j] != even_start){
                            sum += 1;
                        }
                    }
                    else {
                        if( j % 2 == 0 && map[r+i][c+j] != even_start){
                            sum += 1;
                        }
                        else if( j % 2 == 1 && map[r+i][c+j] != odd_start){
                            sum += 1;
                        }
                    }
                }
            }
            MIN = Math.min(MIN,sum);
        }

    }
}
