package main

import (
	"fmt"
	"strings"
)

func main() {
	//最长公共前缀

	/**
	编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
	示例1:

	输入: ["flower","flow","flight"]
	输出: "fl"
	示例 2:

	输入: ["dog","racecar","car"]
	输出: ""
	*/

	arr := []string{"flower", "flow", "flight"}

	res := longestPrefix(arr)

	fmt.Println(res)

}

//以第一个元素为基础元素，依次判断索引位置，索引不等于0的，依次递减直到满足索引为0
func longestPrefix(arr []string) string {
	if len(arr) < 0 {
		return ""
	}
	prefix := arr[0]
	for _, s := range arr {
		for strings.Index(s, prefix) != 0 {
			if len(prefix) == 0 {
				return ""
			}
			prefix = prefix[:len(prefix)-1]
		}

	}
	return prefix

}
