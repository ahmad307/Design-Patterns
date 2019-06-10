interface SortStrategy {
    public void sort(int []arr);
}

class BubbleSort implements SortStrategy {
    /*
    * Implements SortStrategy interface using Bubble Sort.
    * */
    @Override
    public void sort(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements SortStrategy {
    /*
     * Implements SortStrategy interface using Selection Sort.
     * */
    @Override
    public void sort(int []arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

class Sort {
    /*
    * Class responsible for sorting, using the given sort strategy.
    * */
    private SortStrategy sorter;

    public Sort(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public void sort(int []arr) {
        sorter.sort(arr);
    }
}


public class Main {

    public static void main(String[] args) {
        int []arr1 = {4, 1, 4, 6, 3, 9, 5, 0, 122};
        int []arr2 = {4, 1, 4, 6, 3, 9, 5, 0, 122};

        // Sort the first array with SelectionSort strategy
        SortStrategy strategy = new SelectionSort();
        Sort sorter = new Sort(strategy);

        sorter.sort(arr1);
        printArray(arr1);


        // Sort the second array with BubbleSort strategy
        strategy = new BubbleSort();
        sorter = new Sort(strategy);

        sorter.sort(arr2);
        printArray(arr2);
    }

    private static void printArray(int []arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
 
