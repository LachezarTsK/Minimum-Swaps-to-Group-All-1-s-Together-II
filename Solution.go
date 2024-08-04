
package main

import "fmt"

var numberOfElements int

func minSwaps(input []int) int {
    numberOfElements = len(input)
    total_1s := 0
    for _,value := range input {
        total_1s += value
    }
    return calculateMinSwaps(total_1s, input)
}

func calculateMinSwaps(total_1s int, input []int) int {
    count_0s := 0
    minSwaps := total_1s

    frontPosition := 0
    backPosition := 0

    for frontPosition < 2 * len(input) {
        count_0s += input[frontPosition % numberOfElements] ^ 1;
        frontPosition++
        if (frontPosition - backPosition < total_1s) {
            continue
        }
        minSwaps = min(minSwaps, count_0s)
        count_0s -= input[backPosition % numberOfElements] ^ 1
        backPosition++
    }

    return minSwaps
}
