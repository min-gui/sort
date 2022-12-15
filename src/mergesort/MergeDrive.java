package mergesort;

public class MergeDrive {
    private static final int MAX_COUNT = 30;

    public static void main(String[] args) {
        int[] arr = new int[MAX_COUNT];
        for(int i=0; i<MAX_COUNT; i++) {
            // 0 ~ MAX_COUNT 범위내의 난수를 생성
            arr[i] = (int)(Math.random() * MAX_COUNT);
        }

        System.out.println("정렬 전 데이터");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("정렬 후 데이터 (오름차순)");
        int[] ascSortedArrayTest = arr.clone();
        MergeBasic.sort(ascSortedArrayTest, 0, ascSortedArrayTest.length - 1);
        for(int i : ascSortedArrayTest) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
