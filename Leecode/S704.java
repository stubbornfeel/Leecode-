package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S704 {
    /**
     * 二分法查找:search1：左闭右闭区间  search2：左闭右开区间
     * @param num
     * @param target
     * @return
     */
    public static int search1(int[] num, int target )
    {
        if( target >num[num.length-1] || target < num[0])
        {
            return -1;
        }
        int left = 0,right = num.length-1;
        while(left <= right)
        {
            int mid = left + ((right - left) >> 1);
            if(target > num[mid] )
            {
                return left =  mid +1;
            }
            if(target < num[mid] )
            {
                return right = mid - 1;
            }
            if(target == num[mid] )
            {
                return mid;
            }
        }
        return -1;
    }

    public static int search2(int[] num, int target )
    {
        int  left = 0, right = num.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (num[mid] == target)
                return mid;
            else if (num[mid] < target)
                left = mid + 1;
            else if (num[mid] > target)
                right = mid;
        }

        return -1;
    }

    public static boolean searchSort(ArrayList<Integer> num, int target )
    {
        for(Integer e : num )
        {
            if(e == target)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序数组的平方977
     * @param nums
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        for(int i = 0,j = n-1,pos = n-1;i <=j; )
        {
            if(nums[i] * nums[i] < nums[j]*nums[j] )
            {
                ans[pos] = nums[j] * nums[j];
                --j;
            }else {
                ans[pos] = nums[i] * nums[i];
                ++i;
            }
            --pos;
        }
        return ans;
    }

    public static int[] sortedSquares2(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    /**
     * 189  轮转数组
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }



    public static void main(String[] args)
    {
        /*
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        String s = in.nextLine();
        String[] s1 = s.split(",");
        for (int i = 0; i < s1.length; i++) {
            array.add(Integer.valueOf(s1[i]));
        }

        while( !in.hasNextInt())
        {
            array.add(Integer.valueOf(in.nextInt()));
        }
        System.out.println(searchSort(array,5));
*/
        int [] aq = {-4,-1,0,3,10};
        int [] sq = sortedSquares1(aq);
        for(Integer a :sq)
        {
            System.out.println(a);
        }

        System.out.println(10%3);

    }

}
