class Solution {
    static int answer;
    public int solution(int[] cookie) {
        answer = 0;
        
        int[] sum = new int[cookie.length];
        
        sum[0] = cookie[0];
        for(int i = 1; i < cookie.length; i++) {
            sum[i] = sum[i - 1] + cookie[i];
        }
        
        for(int m = 0; m < cookie.length; m++) {
            find(cookie, m);
        }
        
        return answer;
    }
    
    private void find(int[] arr, int mid) {
        if(mid + 1 >= arr.length) return;
        int l = mid;
        int lSum = arr[l];
        int r = mid + 1;
        int rSum = arr[r];
        while(l >= 0 && r < arr.length) {
            if(lSum < rSum) {
                l--;
                if(l < 0) return;
                lSum += arr[l];
            } else if(lSum == rSum) {
                answer = Math.max(answer, lSum);
                l--;
                if(l < 0) return;
                lSum += arr[l];
            } else {
                r++;
                if(r >= arr.length) return;
                rSum += arr[r];
            }
        }
    }
}