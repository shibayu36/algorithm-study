/**
 * Created by shibayu36 on 2016/12/16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] data = { 1, 3, 5, 8 };
        int found = binarySearch(data, 8);
        System.out.println(found);
    }

    private static int binarySearch(int[] data, int number) {
        int lower = 0;
        int upper = data.length - 1;
        int result = -1;

        while (true) {
            if (lower > upper) {
                break;
            }

            int middle = (upper + lower) / 2;

            if (data[middle] == number) {
                result = middle;
                break;
            }
            else if (number > data[middle]) {
                lower = middle + 1;
            }
            else if (number < data[middle]) {
                upper = middle - 1;
            }
        }

        return result;
    }
}
