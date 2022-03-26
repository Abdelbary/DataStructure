
// Main class should be named 'Solution'
class Solution {
    public static void mergeSort(int[] arr)
    {
        arrayMergeSort(arr,new int[arr.length], 0,arr.length-1);
    }
    
    public static void  arrayMergeSort(int[] arr,int[] temp,int leftStart, int rightEnd)
    {
        if(leftStart >= rightEnd)
        {
            return;
        }
        
        int middle = leftStart + (rightEnd - leftStart)/2;
        arrayMergeSort(arr,temp,leftStart,middle);
        arrayMergeSort(arr,temp,middle+1,rightEnd);
        mergeSortedArrays(arr,temp,leftStart,rightEnd);
    }
    
    public static void mergeSortedArrays(int[] arr,int[] temp,int leftStart,int rightEnd)
    {
        int middle  = leftStart + (rightEnd - leftStart)/2;
        int leftEnd = middle;
        int rightStart = middle + 1;
        int indx = leftStart;
        int left = leftStart;
        int right = rightStart;
        
        while(left <= leftEnd && right <= rightEnd)
        {
            if(arr[left] < arr[right])
            {
               temp[indx] = arr[left];
               left++; 
            }else
            {
                temp[indx] = arr[right];
                right++;
            }
            indx++;
        } 
        
        System.arraycopy(arr, left, temp, indx, leftEnd-left+1);
        System.arraycopy(arr, right, temp, indx, rightEnd-right+1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd-leftStart+1);
    }
    public static void main(String[] args) {
        int[] arr =new int[]{5,6,4,7,3,8,2,9,1,1,1,1};
        mergeSort(arr);
        
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        
    }
}
