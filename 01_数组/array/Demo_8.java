package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/15
 */
public class Demo_8 {

  public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }

  /**
   * 三数之和
   *
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    // 对数组排序
    Arrays.sort(nums);
    ArrayList<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int target = -nums[i];
      int l = i + 1;
      int r = nums.length - 1;
      // 如果目标数大于0直接退出，大于0的情况下不可能三数之和为0
      if (nums[i] > 0) {
        break;
      }
      if (i == 0 || nums[i] != nums[i - 1]) {
        while (l < r) {
          // 左指针的数加右指针的数等于当前数
          if (nums[l] + nums[r] == target) {
            res.add(Arrays.asList(nums[i], nums[l], nums[r]));
            // 指针向左移动，如果元素相同则跳过元素
            while (l < r && nums[l] == nums[l + 1]) {
              l++;
            }
            // 指针向右移动，如果元素相同则跳过元素
            while (l < r && nums[r] == nums[r - 1]) {
              r--;
            }
            l++;
            r--;
          } else if (nums[l] + nums[r] < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }
    return res;
  }
}
