package main

import (
	"fmt"
	"sort"
)

func main() {
	//三数之和
	/**
	给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
	使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。

	有点难度，思路：对数组进行排序，定义两个指针，一个在左，一个在右，判断两指针所在的元素是否等于当前索引元素，
	如果小于当前元素，则左指针向右移动，大于则右指针向左移动
	*/
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

func threeSum(nums []int) [][]int {
	//先排序
	sort.Ints(nums)
	var res [][]int
	for i, v := range nums {
		//目标值
		target := -v
		//左指针
		l := i + 1
		//右指针
		r := len(nums) - 1
		//元素是否大于0
		if v > 0 {
			break
		}
		//第一个元素或者元素不等于前一个元素
		if i == 0 || v != nums[i-1] {
			for l < r {
				if nums[l]+nums[r] == target {
					res = append(res, [][]int{{nums[l], nums[r], v}}...)
					for l < r && nums[l] == nums[l-1] {
						l++
					}
					for l < r && nums[r] == nums[r-1] {
						i--
					}
					l++
					i--
				} else if nums[l]+nums[r] < target {
					l++
				} else {
					r--
				}
			}
		}
	}
	return res
}
