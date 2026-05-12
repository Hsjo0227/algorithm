class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer = new int[size+1];
        int last;
        if(num_list[size-1] > num_list[size-2]) {
            last = num_list[size-1] - num_list[size-2];}
        else {
            last = num_list[size-1]*2;
        }
        for(int i=0; i<size; i++){
            answer[i] = num_list[i];
        }
        answer[size] = last;
        return answer;
    }
}