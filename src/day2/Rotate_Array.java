package day2;

// the function works fine, but it exceeded the time complexity.

public class Rotate_Array {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int k = 0;

        while (k < 3) {
            translateArrayOneIndexToTheRight(nums);
            k++;
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }

    }

    public static void translateArrayOneIndexToTheRight(int[] array) {

        int temp = array[array.length - 1];
        int temp1 = array[0];
        int temp2;
        for (int i = 0; i < array.length - 1; i++) {
            temp2 = array[i + 1];
            array[i + 1] = temp1;
            temp1 = temp2;
        }

        array[0] = temp;

    }

}
