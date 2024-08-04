
import kotlin.math.min

class Solution {

    private var numberOfElements: Int = 0

    fun minSwaps(input: IntArray): Int {
        numberOfElements = input.size
        var total_1s = 0
        for (value in input) {
            total_1s += value
        }
        return calculateMinSwaps(total_1s, input)
    }

    private fun calculateMinSwaps(total_1s: Int, input: IntArray): Int {
        var count_0s = 0
        var minSwaps = total_1s

        var frontPosition = 0
        var backPosition = 0

        while (frontPosition < 2 * input.size) {
            count_0s += input[frontPosition % numberOfElements] xor 1
            ++frontPosition
            if (frontPosition - backPosition < total_1s) {
                continue
            }
            minSwaps = min(minSwaps, count_0s)
            count_0s -= input[backPosition % numberOfElements] xor 1
            ++backPosition
        }

        return minSwaps
    }
}
