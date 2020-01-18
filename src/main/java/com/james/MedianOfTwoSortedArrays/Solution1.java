package com.james.MedianOfTwoSortedArrays;

/**
 * @author: qinkefa
 * @Date: 2020/1/6 0006 12:08
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums2 == null){
            return 0.0;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        // s1 is start of nums1
        //e1 is end of nums1
        int s1 = 0;
        int e1 = n1-1;
        int s2 = 0;
        int e2 = n2-1;
        // terminate until both arrays have one element each left   OR
        // if one of these arrays has s>e
        while( ( s1<=e1 && s2<=e2) && !(s1==e1 && s2==e2) )
        {
            // Increment index which is smaller value in comparison to other
            // for left  end of arrays
            if(nums1[s1] < nums2[s2]){
                s1++;
            }
            else{
                s2++;
            }

            // Decrement index which is larger value in comparison to other
            // for right  end of arrays
            if(nums1[e1] > nums2[e2]){
                e1--;
            }
            else{
                e2--;
            }

        }
        // when both arrays are left with one number each
        if(s1==e1 && s2==e2){
            return (nums1[e1] + nums2[e2]) / 2.00;
        }

        // when second array has numbers left and first array is finished up
        if(s1>e1){
            int len = e2-s2+1;
            return (nums2[s2 + len/2] + nums2[s2 + (len-1)/2]) / 2.00;
        }

        // when first array has numbers left and second array is finished up
        if(s2>e2){
            int len = e1-s1+1;
            return (nums1[s1 + len/2] + nums1[s1 + (len-1)/2]) / 2.00;
        }

        return 0.0;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        double[] medians = new double[2];
        boolean isEven = ((l1+l2) % 2 == 0);

        int count = (l1+l2)/2;

        int index1 = 0, index2 = 0;

        while (count > -1) {

            double temp = 0;
            if (index1 == l1) {
                temp = medians[1];
                medians[1] = nums2[index2];
                medians[0] = temp;
                index2++;
            } else {
                if (index2 == l2) {
                    temp = medians[1];
                    medians[1] = nums1[index1];
                    medians[0] = temp;
                    index1++;
                } else {
                    if (nums1[index1] < nums2[index2]) {
                        temp = medians[1];
                        medians[1] = nums1[index1];
                        medians[0] = temp;
                        index1++;
                    } else {
                        temp = medians[1];
                        medians[1] = nums2[index2];
                        medians[0] = temp;
                        index2++;
                    }
                }
            }

            count--;
        }

        if (isEven) {
            return (medians[0]+medians[1])/2;
        }

        return medians[1];
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1==null || nums2 == null){
            return 0.0;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int tot = n1+n2;

        if((tot)%2 == 0)
        {
            return (findkth(0,nums1,0,nums2,(tot+1)/2) + findkth(0,nums1,0,nums2,(tot+2)/2) )/2.0 ;
        }
        else{
            return (findkth(0,nums1,0,nums2, tot / 2 + 1))/1.0;
        }
    }

    public int findkth(int sa, int[] a, int sb, int[] b, int k){
        // System.out.println(sa + ", " + sb + " , " + k);
        if(sa >= a.length) {
            return b[sb+k-1];
        }

        if(sb >= b.length){
            return a[sa+k-1];
        }


        if(k==1) {
            return Math.min(a[sa],b[sb]);
        }

        int newa = Integer.MAX_VALUE;
        int newb = Integer.MAX_VALUE;
        int khalfthina = sa + k/2 - 1;

        if(khalfthina < a.length) {
            newa = a[khalfthina];
        }


        int khalfthinb = sb + k/2 -1;

        if(khalfthinb < b.length) {
            newb = b[khalfthinb];
        }

        if(newa > newb){
            return findkth(sa, a, sb + k / 2, b, k - k / 2);
        }
        else{
            return findkth(sa + k / 2 ,a,sb,b, k - k / 2);
        }

    }

    public static void main(String[] args) {
    }
}
