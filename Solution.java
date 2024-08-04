
public class Solution {

    int numberOfElements;

    public int minSwaps(int[] input) {
        numberOfElements = input.length;
        int total_1s = 0;
        for (int value : input) {
            total_1s += value;
        }
        return calculateMinSwaps(total_1s, input);
    }

    private int calculateMinSwaps(int total_1s, int[] input) {
        int count_0s = 0;
        int minSwaps = total_1s;

        int frontPosition = 0;
        int backPosition = 0;

        while (frontPosition < 2 * input.length) {
            count_0s += input[frontPosition % numberOfElements] ^ 1;
            ++frontPosition;
            if (frontPosition - backPosition < total_1s) {
                continue;
            }
            minSwaps = Math.min(minSwaps, count_0s);
            count_0s -= input[backPosition % numberOfElements] ^ 1;
            ++backPosition;
        }

        return minSwaps;
    }
}
