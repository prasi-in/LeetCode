//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[])
    {
        int num[] = {1,2,3,4,5};
        int[] ints = twoSum_brute_force(num, 6);
        System.out.println("TwoSum.main ----------->"  + ints.toString());

        ints = twoSum_double_pass_hashmap(num, 6);
        System.out.println("TwoSum.main ----------->"  + ints.toString());

        ints = twoSum_single_pass_hashmap(num, 6);
        System.out.println("TwoSum.main ----------->"  + ints.toString());

    }

    private static int[] twoSum_single_pass_hashmap(int[] num, int target) {
        Map<Integer, Integer> nums = new HashMap<>();
        for(int i = 0 ; i< num.length ; i++)
        {
            int otherNum =  target - num [i];
            if(nums.containsKey(otherNum)) {
                System.out.println("TwoSum.twoSum_single_pass_hashmap" + i  + " " + num[i]);
                return new int[]{i, nums.get(otherNum)};
            }
            nums.put(num[i],i);
        }
        return null;
    }


    private static int[] twoSum_brute_force(int []num , int target)
    {
        for (int i = 0 ; i < num.length ; i++)
        {
            for(int j=i+1 ; j < num.length;j++)
            {
                if (num[i] + num[j] == target) {
                    System.out.println("TwoSum.twoSum Found ====>" + num[i] + "   " + num[j]);
                    return  new int[] {i,j};
                }
            }
        }
        return null;
    }

    //This is single pass Hashmap method .
    //Time complexity is O(n)
    //Space Complexity is O(n) .. As we store the values in the Hashmap.

    private static int[] twoSum_double_pass_hashmap(int[] num, int target) {
        Map <Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < num.length ; i++)
           map.put(num[i],i);
        for (int i = 0 ; i < num.length; i++)
        {
            int requiredNum = target - num[i];
            if(map.containsKey(requiredNum)) {
                System.out.println("TwoSum.twoSum Found ====>" + num[i] + "   " + map.get(requiredNum));
                return new int[]{num[i], map.get(requiredNum)};
            }
        }
        return null;
    }

}
