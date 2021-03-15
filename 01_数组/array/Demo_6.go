package main

import "fmt"

func main() {
	//加一
	/**
	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。

	示例 1:

	输入: [1,2,3]
	输出: [1,2,4]
	解释: 输入数组表示数字 123。
	示例 2:

	输入: [4,3,2,1]
	输出: [4,3,2,2]
	解释: 输入数组表示数字 4321。
	*/
	nums := []int{4, 3, 2, 1}
	nums2 := []int{9, 9, 9, 9}
	fmt.Println(plusOne(nums))
	fmt.Println(plusOne(nums2))

}

func plusOne(nums []int) []int {
	var result []int
	addon := 0
	for i := len(nums) - 1; i >= 0; i-- {
		//在进位的基础上再加一
		nums[i] += addon
		//重置进位
		addon = 0
		//如果是第一次，直接加一
		if i == len(nums)-1 {
			nums[i]++
		}
		//如果加以等于10，则需要进位处理
		if nums[i] == 10 {
			addon = 1
			nums[i] = 0
		}
	}
	if addon == 1 {
		result = make([]int, 1)
		result[0] = 1
		result = append(result, nums...)
	} else {
		result = nums
	}
	return result
}
