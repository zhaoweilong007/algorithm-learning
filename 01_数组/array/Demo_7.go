package main

import "fmt"

func main() {

	//两数之和
	/**
	给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

	示例:

	给定 nums = [2, 7, 11, 15], target = 9
	因为 nums[0] + nums[1] = 2 + 7 = 9
	所以返回 [0, 1]
	*/

	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
	fmt.Println(twoSum2([]int{2, 7, 11, 2}, 9))
}

//暴力破解
func twoSum(nums []int, target int) []int {
	for i, num := range nums {
		for j := i + 1; j < len(nums); j++ {
			if target-nums[j] == num {
				return []int{i, j}
			}
		}
	}
	return []int{}
}

//优化版
func twoSum2(nums []int, target int) []int {
	m := map[int]int{}
	result := []int{}
	for i, v := range nums {
		if val, exist := m[target-v]; exist {
			result = append(result, val)
			result = append(result, i)
		}
		m[v] = i
	}
	return result
}
