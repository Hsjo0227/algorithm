class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        int n = sequence.length;

        long[] arr1 = new long[n];
        long[] arr2 = new long[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr1[i] = sequence[i] * -1L;
                arr2[i] = sequence[i];
            } else {
                arr1[i] = sequence[i];
                arr2[i] = sequence[i] * -1L;
            }
        }

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 = Math.max(arr1[i], sum1 + arr1[i]);
            sum2 = Math.max(arr2[i], sum2 + arr2[i]);

            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        return answer;
    }
}