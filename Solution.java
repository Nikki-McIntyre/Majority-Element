import java.util.Scanner;
import java.util.ArrayList;

class Solution {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    System.out.println(
        "Enter int's and hit an empty space to end. There is no error checking and it is assumed there is a majority element");
    ArrayList<Integer> numsAL = new ArrayList<Integer>();
    String input = "w";
    while (input != "") {
      input = kbd.nextLine();

      try {
        numsAL.add(Integer.parseInt(input));
      } catch (Exception e) {
        input = "";
      }

    }
    int[] nums = new int[numsAL.size()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = numsAL.get(i);
    }
    System.out.print(majorityElement(nums));

  }

  public static int majorityElement(int[] nums) {
    // keep track of what numbers have already been searched
    ArrayList<Integer> search = new ArrayList<Integer>();
    // how many times the element been seen in the array
    int count = 0;
    // the current number being looked at
    int lookAt = -1;
    // setting an initial answer
    int ans = nums[0];
    // iterate through the array
    for (int i = 0; i < nums.length; i++) {
      // if it hasn't already been looked at, now look at it (to save some time)
      if (!search.contains(nums[i])) {
        // iterate through the array starting from that number
        for (int j = i; j < nums.length; j++) {
          // where to start looking
          lookAt = nums[i];
          // if it's the same add to count
          if (nums[j] == lookAt) {
            count++;
          }
          // and if it's the majority element set it to answer and break the loop
          if (count > ((nums.length / 2))) {
            ans = lookAt;
            break;
          }
        }
        // add to search that it's been looked at
        search.add(nums[i]);
      }
      // reset count
      count = 0;
    }
    return ans;
  }
}