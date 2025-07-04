class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int[] result = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            if (ballMap.containsKey(ball)) {
                int existingColor = ballMap.get(ball);
                int val = colorMap.get(existingColor);
                if (val == 1)
                    colorMap.remove(existingColor);
                else
                    colorMap.put(existingColor, val - 1);
            }
            ballMap.put(ball, color);
            result[index++] = colorMap.size();
        }
        return result;
    }
}