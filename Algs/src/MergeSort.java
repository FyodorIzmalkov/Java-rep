import java.util.Arrays;

public class MergeSort {

    private static void mergeArrays(int[] array, int start, int mid, int end){
        int[] lowHalf = new int[mid - start + 1];
        int[] highHalf = new int[end - mid];

        int arr_index = start;
        for (int i = 0; arr_index <= mid; i++, arr_index++) {
            lowHalf[i] = array[arr_index];
        }
        for (int i = 0; arr_index <= end; i++, arr_index++) {
            highHalf[i] = array[arr_index];
        }
        int i = 0;
        int j = 0;
        arr_index = start;
        while (i < lowHalf.length && j < highHalf.length){
            if (lowHalf[i] < highHalf[j]){
                array[arr_index] = lowHalf[i];
                i++;
                arr_index++;
            } else {
                array[arr_index] = highHalf[j];
                j++;
                arr_index++;
            }
        }
        while ( i < lowHalf.length){
            array[arr_index] = lowHalf[i];
            i++;
            arr_index++;
        }
        while ( j < highHalf.length){
            array[arr_index] = highHalf[j];
            j++;
            arr_index++;
        }
    }

    public static void mergeSort(int[] array, int start, int end){
        if (start != end){
            int middle = Math.floorDiv(start + end, 2);
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            mergeArrays(array, start, middle, end);
        }
    }

    public static void main(String[] args) {
        int [] array = {150, 140, 30, -10, 5, 15, 0, -150};
        mergeSort(array, 0, array.length - 1 );
        System.out.println(Arrays.toString(array));
    }
}
