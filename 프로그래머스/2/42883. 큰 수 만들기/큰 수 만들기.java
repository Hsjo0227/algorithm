class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            int digit = number.charAt(i) - '0';
            int l = sb.length();
            if(l == 0) {
                sb.append(digit);
                continue;
            }
            
            while(l != 0 && n-i > n-k-l) {
                int num = sb.charAt(l-1) - '0';
                if(num < digit) {
                    sb.deleteCharAt(l-1);
                    l--;
                } else {
                    break;
                }
            }
            if(l < n-k) {
                sb.append(digit);
            }
        }
        answer = sb.toString();
        
        return answer;
    }
}