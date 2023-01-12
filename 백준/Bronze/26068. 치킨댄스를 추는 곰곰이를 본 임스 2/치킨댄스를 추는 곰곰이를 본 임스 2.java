import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            int validity = Integer.parseInt(str.split("-")[1]);
            if(validity >= 91) continue;
            result++;
        }

        System.out.println(result);
    }
}