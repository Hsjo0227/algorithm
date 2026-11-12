import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int deployDay = 0;

        for (int i = 0; i < progresses.length; i++) {
            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (days > deployDay) {
                deployDay = days;
                answer.add(1);
            } else {
                int last = answer.size() - 1;
                answer.set(last, answer.get(last) + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}