package level1;

public class level1_42748_sorting {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,6,3,7,4};
        int[][] commands = new int[][]{{2,5,3},{3,6,3}};
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            result[i] = quickSelect(arr, commands[i][2]-1, commands[i][0]-1, commands[i][1]-1);
        }
        
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int quickSelect(int[] arr, int k, int left, int right){
        if(left == right) return arr[left];

        int pivotIndex = partition(arr, left, right);
        int length = pivotIndex - left;

        if(length == k){
            return arr[pivotIndex];
        }else if(length > k){
            return quickSelect(arr, k, left, pivotIndex - 1);
        } else{
            return quickSelect(arr, k - length, pivotIndex+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left;

        for(int j = left; j < right; j++){
            if(arr[j] < pivot){
                swap(arr,i,j);
                i++;
            }
        }

        swap(arr, i, right);
        System.out.println("i : " + i);
        return i;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


// Quick Sort 사용해서 정렬을 시킨 후 값을 찾는 방법이 아닌 바로 값을 찾는 방법으로 가도 괜찮다.