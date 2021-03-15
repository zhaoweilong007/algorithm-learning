package main

import (
	"fmt"
	"sort"
)

func main() {
	//两个数组的交集

	/**
	给定两个数组，编写一个函数来计算它们的交集
	示例一：
	输入: nums1 = [1,2,2,1], nums2 = [2,2]

	输出: [2,2]

	示例二：
	输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]

	输出: [4,9]
	*/

	num1 := []int{1, 2, 2, 1}
	num2 := []int{2, 2}

	fmt.Println(intersection(num1, num2))
	fmt.Println(intersection2(num1, num2))

	//

}

func intersection(num1, num2 []int) []int {
	m := make(map[int]int)
	//将num1重复的次数添加到map中
	for _, v := range num1 {
		m[v] += 1
	}
	k := 0
	for _, v := range num2 {
		//如果相同， 将其存入num2，并将出现次数减1
		if m[v] > 0 {
			m[v] -= 1
			num2[k] = v
			k++
		}
	}
	return num2[:k]
}

//排序优化版
func intersection2(num1, num2 []int) []int {
	i, j, k := 0, 0, 0

	sort.Ints(num1)
	sort.Ints(num2)

	for i < len(num1) && j < len(num2) {
		if num1[i] > num2[j] {
			j++
		} else if num1[i] < num2[j] {
			i++
		} else {
			num1[k] = num1[i]
			i++
			j++
			k++
		}
	}

	return num1[:k]
}
