package level1;

import java.util.Arrays;

public class level1_42748_UsingQuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] cut_select = new int[][]{{2, 5, 3}, {4,4,1}, {1,7,3}};
        int[] result = new int[cut_select.length];

        for(int i = 0; i < result.length; i++){
            int[] temp = arr.clone();
            result[i] = quickSelect(temp, cut_select[i][2] - 1, cut_select[i][0] - 1, cut_select[i][1] - 1);     
        }

        System.out.println(Arrays.toString(result));
    }

    private static int quickSelect(int[] array, int desire_Location, int left, int right) {
        if (left == right) {
            return array[left];
        }

        int pivotIndex = partition(array, left, right);

        if(pivotIndex - left == desire_Location){
            return array[pivotIndex];
        }else if(pivotIndex - left > desire_Location){
            return quickSelect(array, desire_Location, left, pivotIndex - 1);
        }else{
            return quickSelect(array, desire_Location - (pivotIndex - left + 1), pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        int now = left;
        System.out.println("left : "+ left + " right : " + right);
        for(int i = left; i < right; i++){
            System.out.println("현재 값 : " + array[i]);
            if(array[i] < pivot){
                swap(array, now, i);
                System.out.println("swap 발생 : " + now + " " + i);
                now++;
            }
        }
        
        swap(array, now, right);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return now;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}