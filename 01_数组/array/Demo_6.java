package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/12
 */
public class Demo_6 {

  public static void main(String[] args) {
    Integer[] arr = {4, 3, 2, 1};
    Integer[] arr2 = {9, 9, 9, 9};
    System.out.println(Arrays.toString(plusOne(arr)));
    System.out.println(Arrays.toString(plusOne(arr2)));
  }

  /**
   * 加一
   *
   * @param nums
   * @return
   */
  public static Integer[] plusOne(Integer[] nums) {

    ArrayList<Integer> list = new ArrayList<>();
    int addon = 0;

    for (int i = nums.length - 1; i >= 0; i--) {
      nums[i] += addon;
      addon = 0;
      if (i == nums.length - 1) {
        nums[i]++;
      }
      if (nums[i] == 10) {
        addon = 1;
        nums[i] = 0;
      }
    }
    if (addon == 1) {
      list.add(1);
      List<Integer> collect = Arrays.stream(nums).collect(Collectors.toList());
      list.addAll(collect);
      return list.toArray(new Integer[0]);
    } else {
      return nums;
    }
  }
}
