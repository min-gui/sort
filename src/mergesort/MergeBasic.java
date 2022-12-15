package mergesort;

public class MergeBasic {
    public static void sort(int[] arr, int left, int right) {
        mergeSort(arr, left, right);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2; // 데이터 리스트의 중앙 인덱스를 구함
            mergeSort(arr, left, mid); // 중앙을 기준으로 왼쪽 데이터들을 분할한다.
            mergeSort(arr, mid + 1, right); // 중앙을 기준으로 오른쪽 데이터들을 분할한다.
            merge(arr, left, mid, right); // 정복 및 결합 과정을 진행한다.
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        //분할된 왼쪽 리스트들의 시작점 변수
        int leftIndex = left;
        //분할된 오른쪽 리스트들의 시작점 변수
        int rightIndex = mid + 1;
        //정렬된 데이터가 저장될 인덱스
        int sortedIndex = left;
        //정렬된 데이터를 입시로 저장할 곳
        int[] tempSortedArray = new int[right + 1];

        //분할된 왼쪽 리스트의 인덱스가 mid까지 온 경우 왼쪽 정렬 완료
        //분할된 오른쪽 리스트의 인덱스가 right까지 온 경우 오른쪽 정렬 완료
        //즉, 왼쪽 또는 오른쪽 둘 중 하나라도 정렬이 완료된 경우 반복문을 빠져나감
        while (leftIndex <= mid && rightIndex <= right){
            //오름차순 조건문
            if(arr[leftIndex] <= arr[rightIndex]){
                tempSortedArray[sortedIndex++] = arr[leftIndex++];
            }else {
                tempSortedArray[sortedIndex++] = arr[rightIndex++];
            }
        }

        // 왼쪽이 다 정렬된 경우 오른쪽 데이터들의 남은 부분들을 다 옮겨야 함
        if (leftIndex > mid) {
            for(int i=rightIndex; i<=right; i++) {
                tempSortedArray[sortedIndex++] = arr[i];
            }
        }
        else {
            for(int i=leftIndex; i<=mid; i++) {
                tempSortedArray[sortedIndex++] = arr[i];
            }
        }

        // 원래 배열에 정렬된 데이터로 덮어씌움
        for(int i=left; i<=right; i++) {
            arr[i] = tempSortedArray[i];
        }

    }
}
