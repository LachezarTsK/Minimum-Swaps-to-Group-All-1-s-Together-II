
#include <vector>
#include <algorithm>
using namespace std;

/*
// The code will run faster withh ios::sync_with_stdio(0).
// However, this should not to be used in production code and interactive problems.
// In this particular problem, it is ok to apply ios::sync_with_stdio(0).

static auto speedup = [] {
    ios::sync_with_stdio(0);
    return nullptr;
}();
*/

class Solution {

    int numberOfElements{};	

public:
    int minSwaps(const vector<int>& input) {

        numberOfElements = input.size();
        int total_1s = 0;
        for (const auto& value : input) {
            total_1s += value;
        }
        return calculateMinSwaps(total_1s, input);
    }

private:
    int calculateMinSwaps(int total_1s, span<const int> input) const {
        int count_0s = 0;
        int minSwaps = total_1s;

        int frontPosition = 0;
        int backPosition = 0;

        while (frontPosition < 2 * input.size()) {
            count_0s += input[frontPosition % numberOfElements] ^ 1;
            ++frontPosition;
            if (frontPosition - backPosition < total_1s) {
                continue;
            }
            minSwaps = min(minSwaps, count_0s);
            count_0s -= input[backPosition % numberOfElements] ^ 1;
            ++backPosition;
    }

        return minSwaps;
    }
};
