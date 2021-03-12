package main

import "fmt"

func main() {
	//原地删除
	/**
	给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

	示例 1:

	给定 nums = [3,2,2,3], val = 3,
	函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
	你不需要考虑数组中超出新长度后面的元素。

	给定 nums = [0,1,2,2,3,0,4,2], val = 2,

	*/

	nums := []int{3, 2, 2, 3}
	fmt.Println(removeElement(nums, 3))
	fmt.Println("nums:", nums)

	nums2 := []int{0, 1, 2, 2, 3, 0, 4, 2}
	fmt.Println(removeElement2(nums2, 2))
	fmt.Println("num2:", nums2)

}

func removeElement(nums []int, val int) int {
	for i := 0; i < len(nums); {
		if nums[i] == val {
			nums = append(nums[:i], nums[i+1:]...)
		} else {
			i++
		}
	}
	return len(nums)
}

func removeElement2(nums []int, val int) int {
	cnt := 0
	n := len(nums)

	for i := 0; i < n; i++ {
		if nums[i] == val {
			cnt++
		} else {
			nums[i-cnt] = nums[i]
		}
	}
	return n - cnt
}
