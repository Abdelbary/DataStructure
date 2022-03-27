class Solution {
    public static void quickSort(int[] arr,int left,int right)
    {
        if(left >= right)
        {
            return;
        }
        
        int pivot = arr[left + (right-left)/2];
        int indx  = partation(arr,left,right,pivot);
        quickSort(arr,left,indx-1);
        quickSort(arr,indx,right);
    }
    
    public static int partation(int[] arr,int left,int right,int pivot)
    {
        while(left <= right)
        {
            //get first element on the left not in place
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            
            if(left <= right)
            {
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    public static void swap(int[] arr,int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static void printArr(int[] arr)
    {
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,8,7,7,6,5,4,4,1,1,2,2,3,3,3,3};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
