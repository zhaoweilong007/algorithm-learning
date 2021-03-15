package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/12
 */
public class Demo_4 {
  public static void main(String[] args) {

    var nums = new Integer[] {1, 2, 3, 4, 5, 6, 7};
    var nums2 = new Integer[] {-1, -100, 3, 99};

    System.out.println(Arrays.toString(rotating(nums, 3)));
    System.out.println(Arrays.toString(rotating(nums2, 2)));
  }

  /**
   * 旋转数组 解法一
   *
   * @param nums
   * @return
   */
  public static Integer[] rotating(Integer[] nums, Integer k) {
    int n = nums.length;
    Integer[] res = new Integer[n];
    for (int i = 0; i < n; i++) {
      res[(i + k) % n] = nums[i];
    }
    return res;
  }

  /**
   * 解法二
   *
   * @param nums
   * @param k
   * @return
   */
  public static Integer[] rotating2(Integer[] nums, Integer k) {
    reverse(nums);
    List<Integer> list =
        Arrays.stream(nums).collect(Collectors.toList()).subList(0, k % nums.length);
    Integer[] array = list.toArray(new Integer[0]);
    reverse(array);
    List<Integer> list2 =
        Arrays.stream(array).collect(Collectors.toList()).subList(k % nums.length, nums.length);
    array = list2.toArray(new Integer[0]);
    reverse(array);
    return array;
  }

  public static void reverse(Integer[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] ^ nums[nums.length - i - 1];
      nums[nums.length - i - 1] = nums[i] ^ nums[nums.length - i - 1];
      nums[i] = nums[i] ^ nums[nums.length - i - 1];
    }
  }
}
