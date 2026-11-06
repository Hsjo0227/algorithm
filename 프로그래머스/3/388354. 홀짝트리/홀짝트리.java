class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int maxNode = 0;
        for (int node : nodes) {
            maxNode = Math.max(maxNode, node);
        }

        int[] degree = new int[maxNode + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int[][] graph = new int[maxNode + 1][];
        for (int node : nodes) {
            graph[node] = new int[degree[node]];
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a][--degree[a]] = b;
            graph[b][--degree[b]] = a;
        }

        int[] answer = new int[2];
        boolean[] visited = new boolean[maxNode + 1];
        int[] stack = new int[nodes.length];

        for (int start : nodes) {
            if (visited[start]) continue;

            int size = 0;
            stack[size++] = start;
            visited[start] = true;
            int same = 0;
            int different = 0;

            while (size > 0) {
                int node = stack[--size];
                int[] neighbors = graph[node];

                if (node % 2 == neighbors.length % 2) {
                    same++;
                } else {
                    different++;
                }

                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack[size++] = neighbor;
                    }
                }
            }

            if (same == 1) answer[0]++;
            if (different == 1) answer[1]++;
        }

        return answer;
    }
}