package main

import "fmt"

func main() {
	//旋转数组
	/**
	给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	示例 1:

	输入: nums = [1,2,3,4,5,6,7], k = 3
	输出: [5,6,7,1,2,3,4]
	解释:
	向右旋转 1 步: [7,1,2,3,4,5,6]
	向右旋转 2 步: [6,7,1,2,3,4,5]
	向右旋转 3 步: [5,6,7,1,2,3,4]
	示例 2:

	输入：nums = [-1,-100,3,99], k = 2
	输出：[3,99,-1,-100]
	解释:
	向右旋转 1 步: [99,-1,-100,3]
	向右旋转 2 步: [3,99,-1,-100]
	*/

	nums := []int{1, 2, 3, 4, 5, 6, 7}
	nums2 := []int{-1, -100, 3, 99}
	fmt.Println(rotating(nums, 3))
	fmt.Println(rotating(nums2, 2))

	fmt.Println(rotating2(nums, 3))
	fmt.Println(rotating2(nums2, 2))
}

//解法一 将第（i+k）%n的数组放入一个新的数组
func rotating(arr []int, k int) []int {
	n := len(arr)
	num := make([]int, n)
	for i := 0; i < n; i++ {
		num[(i+k)%n] = arr[i]
	}
	return num
}

//解法二 翻转数组
func rotating2(arr []int, k int) []int {
	reverse(arr)
	reverse(arr[:k%len(arr)])
	reverse(arr[k%len(arr):])
	return arr
}

func reverse(arr []int) {
	for i := 0; i < len(arr); i++ {
		arr[i], arr[len(arr)-i-1] = arr[len(arr)-i-1], arr[i]
	}
}
