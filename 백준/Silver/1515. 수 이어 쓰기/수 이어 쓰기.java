import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        int result = 0;
        int one = 0;
        boolean flag = false;
        while(result++ < 30000){ // 1부터체크
            if(flag) break;
            String tmp = String.valueOf(result);

            for(int j=0; j<tmp.length(); j++){

                if(tmp.charAt(j) == input.charAt(one)){
                    one++;  // 일의 자리 증가시키기
                }
                if(one == input.length()){  // 길이체크 후 종료시키기
                    flag = true;
                    break;
                }
            }
        }

        System.out.println(result-1);
    }
}