
package utils;

public class ArrayUtils {

    public static void displayIntArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] randomIntArray(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = NumberUtils.getRandomNumberInRange(min, max);
        }
        return array;
    }

    public static int[] cloneArray(int[] arr) {
        int[] ret = new int[arr.length];
        int c = 0;
        for (int i : arr) {
            ret[c++] = i;
        }
        return ret;
    }
}
