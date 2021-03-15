package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ZhaoWeiLong
 * @date 2021/3/15
 */
public class Demo_7 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new Integer[] {2, 7, 11, 15}, 9)));
  }

  /**
   * 两数之和
   *
   * @param num
   * @param target
   * @return
   */
  public static Integer[] twoSum(Integer[] num, Integer target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < num.length; i++) {
      int v = num[i];
      if (map.containsKey(target - v)) {
        list.add(map.get(target - v));
        list.add(i);
      }
      map.put(v, i);
    }
    return list.toArray(new Integer[0]);
  }
}
