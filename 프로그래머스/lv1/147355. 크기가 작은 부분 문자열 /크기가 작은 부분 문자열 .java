class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long p_num = Long.parseLong(p);
        int num = t.length() - p.length();
        
        for(int i = 0; i < num + 1; i++) {
            long t_sub_num = Long.parseLong(t.substring(i, i + p.length()));
            if(t_sub_num <= p_num) answer++;
        }
        return answer;
    }
}