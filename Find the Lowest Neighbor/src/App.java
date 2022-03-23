/**
 * Source: https://edabit.com/challenge/pgqyeEyTtzJL9L8Nq
 * 
 * Description:
 * Create a function that returns the lowest neighbor of a given (x, y) coordinate element in a 2D array. The function will be passed three parameters.
 * arr will be a 2D array holding integer values and will always be symmetrical in size (e.g. 2x2, 3x3, 4x4).
 * x will hold the row coordinate, while y will hold the column coordinate.
 * 
 * Example:
 * lowestElement([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
    ], 1, 1) ➞ 1

    lowestElement([
    [9, 8, 7],
    [0, -1, -3],
    [-5, -9, 54]
    ], 0, 0) ➞ -1
 */

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int lowestNeighbor(int[][] arr, int x, int y) {
        int lowestNode = arr[x][y];

        for (int i = -1; i <= 1; i++) {
            if (x + i < 0 || x + i > arr.length - 1) {
                // If the indexes to check are out of bounds, skip the loop
                continue;
            }
            for (int j = -1; j <= 1; j++) {
                if (y + j < 0 || y + j > arr.length - 1) {
                    // If the indexes to check are out of bounds, skip the loop
                    continue;
                }
                if (arr[x + i][y + j] < lowestNode) {
                    lowestNode = arr[x + i][y + j];
                }
            }
        }

        return lowestNode;
    }
}
