import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String str : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (skill.indexOf(c) != -1) {
                    sb.append(c);
                }
            }

            if (skill.startsWith(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }
}