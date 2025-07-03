class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int len = word.length();
            StringBuilder next = new StringBuilder();

            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);

                char nextChar = (char)((ch - 'a' + 1) % 26 + 'a');
                next.append(nextChar);
            }

            word.append(next);
        }

        return word.charAt(k - 1);
    }
}
