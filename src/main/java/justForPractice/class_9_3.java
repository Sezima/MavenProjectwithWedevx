package justForPractice;

public class class_9_3 {
    public static void main(String[] args) {
        int[][] myArray = {
                {5, 1, 2},
                {4, 8, 6},
        };
        //*Let's say if we have an array
        // where at index 0 we store {5, 1, 2},
        // and at index 1 we store {4, 8, 6},
        //Inside the array, indexing is also from 0.
        // under index 0 = 5
        //array {5, 1, 2}
        //index  0  1  2

        //
        System.out.println(accessElement2D(myArray, 2, 3));
    }

    public static int accessElement2D(int[][] array, int row, int column) {
        if (row >= 1 && row <= array.length && column >= 1 && column <= array[0].length) {
            System.out.println(array[row ][column ]);
            return array[row - 1][column - 1];

        } else {
            return -1;
        }
    }
}
