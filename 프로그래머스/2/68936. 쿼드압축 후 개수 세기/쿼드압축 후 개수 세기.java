class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        function(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void function(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) {
                    int half = size / 2;

                    function(arr, row, col, half);
                    function(arr, row, col + half, half);
                    function(arr, row + half, col, half);
                    function(arr, row + half, col + half, half);
                    return;
                }
            }
        }

        answer[value]++;
    }
}