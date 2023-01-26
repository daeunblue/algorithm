import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map ;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
    // 분할 정복 수행
    public static void divide(int row, int col, int size){
        if(isCorrect(row, col, size)){
            if(map[row][col] == -1){
                result[0]++;
            }else if (map[row][col] == 0) {
                result[1]++;
            }else{
                result[2]++;
            }
            return;
        }
        int newSize = size/3; // 9개의 영역으로 나누기
        divide(row,col,newSize);
        divide(row,col+newSize, newSize);
        divide(row, col+2*newSize, newSize);

        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
        divide(row+newSize, col+2*newSize, newSize);


        divide(row+2*newSize, col, newSize);
        divide(row+2*newSize, col+newSize, newSize);
        divide(row+2*newSize, col+2*newSize, newSize);

    }
    // 같은 색으로 이루어져있는지 확인
    public static boolean isCorrect(int row, int col, int size){
        int first = map[row][col];

        for(int i=row; i<size+row; i++){
            for(int j=col; j<size+col; j++){
                if(map[i][j] != first) return false;
            }
        }
        return true;
    }
}