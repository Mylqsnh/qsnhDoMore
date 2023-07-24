package algorithm;

import java.util.Arrays;

public class FindMedianSortedArrays_4 {


    public static void main(String[] args) {
        int[] a1 = {1,5, 6};
        int[] a2 = {3,4, 7};
        double medianSortedArrays = findMedianSortedArrays(a1, a2);
        System.out.println(medianSortedArrays);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            return getMedian(nums2);
        }

        if (nums2.length == 0) {
            return getMedian(nums1);
        }

        int l1 = 0;
        int l2 = 0;
        int[] temp = new int[nums1.length + nums2.length];
        int index = 0;

        while (true) {

            if (l2 < nums2.length && l1 < nums1.length && nums1[l1] >= nums2[l2]) {
                temp[index] = nums2[l2];
                l2++;
            } else {
                temp[index] = nums1[l1];
                l1++;
            }
            index++;
            if (l1 == nums1.length&& l2 != nums2.length) {
                while (l2 != nums2.length) {
                    temp[index] = nums2[l2];
                    l2++;
                    index++;
                }
                break;
            }
            if (l2 == nums2.length && l1 != nums1.length) {
                while (l1 != nums1.length) {
                    temp[index] = nums1[l1];
                    l1++;
                    index++;
                }
                break;
            }

            if (l1 == nums1.length && l2 == nums2.length) {
                break;
            }
        }

        String s = Arrays.toString(temp);
        System.out.println(s);
        return getMedian(temp);
    }

    public static double getMedian(int[] nums) {
        int i = nums.length % 2;
        double median;
        if (i == 0) {
            median = ((nums[nums.length / 2 - 1 ]) + ( nums[nums.length / 2]) ) / (double)2;
        } else {
            median = nums[(nums.length - 1) / 2];
        }

        return median;
    }
}
