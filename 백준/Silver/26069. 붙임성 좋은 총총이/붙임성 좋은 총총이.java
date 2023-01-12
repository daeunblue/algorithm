import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean isChong = false;
        int result = 0;
        Map<String, Boolean> people = new HashMap<>();
        for(int i=0; i<N; i++){
            // 처음에는 ChongChong 만 춤춘다
            // 춤추는 사람을 만나면 => 그 사람도 이제 춤추기 시작
            String str = br.readLine();
            String first =  str.split(" ")[0];
            String second = str.split(" ")[1];

            // ChongChong인 경우
            if(first.equals("ChongChong")){
                people.put("ChongChong", true);
                people.put(second,true);
                continue;
            }
            if(second.equals("ChongChong")){
                people.put("ChongChong",true);
                people.put(first,true);
                continue;
            }

            // 둘중에 한명도 총총이 아닌 경우
            if(people.getOrDefault(first,false) == true){
                people.put(second,true);
                continue;
            }
            if(people.getOrDefault(second, false) == true){
                people.put(first,true);
            }

        }
        System.out.println(people.size());
    }
}