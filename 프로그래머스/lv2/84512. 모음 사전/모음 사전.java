class Solution {
   int result = 0;
    boolean isEqual = false;

    public int solution(String word) {
        int answer = 0;
        String[] arr = {"A", "E", "I", "O", "U"};
        String str = "";
        
        find(word, str, arr);
        answer = result;
        return answer;
    }

    public void find(String word, String str, String[] sArray){
        if(word.equals(str)){
            isEqual = true;
            return;
        }
        if(str.length() == 5) return;

        for(int i = 0; i < sArray.length; i++){
            if(isEqual) return;
            str += sArray[i];
            result += 1;
            find(word, str, sArray);
            str = str.substring(0, str.length() - 1);
        }

    }
}