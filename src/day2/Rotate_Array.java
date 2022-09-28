package day2;

//TODO: this is not completed yet.

public class Rotate_Array {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        permuteArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void permuteArray(int[] nums) {

        int temp;
        temp = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            int temp1 = nums[i + 1] ;
            nums[i + 1] = nums[i];
        }

        nums[0] = temp;

    }

    public static void rotate(int[] nums, int k) {

    }


    public static void translateArrayOneIndexToTheRight(int[] array , int indexOfStarting ){

        for(int i = indexOfStarting ;i<array.length -1 ;i++){
            int temp1 = array[i] ;
            int temp2 = array[i+1];
            array[i+1]=temp1 ;
        }
    }

}
