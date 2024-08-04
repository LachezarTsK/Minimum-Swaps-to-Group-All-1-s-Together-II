
function minSwaps(input: number[]): number {
    this.numberOfElements = input.length;
    let total_1s = 0;
    for (let value of input) {
        total_1s += value;
    }
    return calculateMinSwaps(total_1s, input);
};


function calculateMinSwaps(total_1s: number, input: number[]): number {
    let count_0s = 0;
    let minSwaps = total_1s;

    let frontPosition = 0;
    let backPosition = 0;

    while (frontPosition < 2 * input.length) {
        count_0s += input[frontPosition % this.numberOfElements] ^ 1;
        ++frontPosition;
        if (frontPosition - backPosition < total_1s) {
            continue;
        }
        minSwaps = Math.min(minSwaps, count_0s);
        count_0s -= input[backPosition % this.numberOfElements] ^ 1;
        ++backPosition;
    }

    return minSwaps;
}
