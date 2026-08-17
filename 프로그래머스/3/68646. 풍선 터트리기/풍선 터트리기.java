class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        leftMin[0] = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], a[i-1]);
        }
        
        rightMin[n-1] = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], a[i+1]);
        }
        
        for(int i = 0; i < n; i++) {
            if(a[i] < leftMin[i] || a[i] < rightMin[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}