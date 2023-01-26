import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char[] cArr = st.nextToken().toCharArray();

            for(int k=0; k<cArr.length; k++){
                for(int j=0; j<r; j++){
                    System.out.print(cArr[k]);
                }
            }
            System.out.println();
        }
    }
}