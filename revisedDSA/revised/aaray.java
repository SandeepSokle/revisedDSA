
class aaray {

    //// leetcode maxArea
    public static int maxArea(int[] height) {
        int max = -(int) 1e9;
        int strI = 0;
        int endI = height.length - 1;

        while (strI < endI) {

            int distance = endI - strI;
            int vol = Math.min(height[strI], height[endI]) * distance;

            if (max < vol)
                max = vol;

            if (height[strI] < height[endI])
                strI++;
            else
                endI--;
        }
        return max;
    }

    //// leetcode 80 removeDuplicates

    public static int swap(int[] nums, int i, int j) {
        return i;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int totalNum = 1;
        int pre = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {

            while (i < nums.length && pre == nums[i]) {
                if (count < 2) {
                    nums[totalNum] = swap(nums, nums[i], nums[i] = nums[totalNum]);
                    totalNum++;
                    count += 1;
                }
                i++;
            }

            if (i < nums.length) {
                pre = nums[i];
                nums[totalNum] = swap(nums, nums[i], nums[i] = nums[totalNum]);
                totalNum++;
                count = 1;
            }
        }
        return totalNum;
    }

    // leetcode duplicateZeros

    public static int swap(int i, int j) {
        return i;
    }

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int k = n - 1;
                arr[k] = 0;
                while (k > i) {
                    arr[k - 1] = swap(arr[k], arr[k] = arr[k - 1]);
                    k--;
                }
                i++;
            }
        }
    }

    ///////// using extra function

    public void change_01(int[] arr, int i, int n) {
        int k = n - 1;
        arr[k] = 0;
        while (k > i) {
            arr[k - 1] = swap(arr[k], arr[k] = arr[k - 1]);
            k--;
        }
    }

    public void duplicateZeros_01(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                change_01(arr, i, n);
                i++;
            }
        }
        return;
    }

}
