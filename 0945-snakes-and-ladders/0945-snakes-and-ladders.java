import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattened = new int[n * n];
        int idx = 0;
        boolean leftToRight = true;

        // Step 1: Flatten the board in Boustrophedon order
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    flattened[idx++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    flattened[idx++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        // Step 2: BFS
        boolean[] visited = new boolean[n * n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // Start at square 1 (index 0)
        visited[0] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n - 1) return moves;

                for (int i = 1; i <= 6; i++) {
                    int next = curr + i;
                    if (next >= n * n) continue;

                    int dest = flattened[next] == -1 ? next : flattened[next] - 1;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
