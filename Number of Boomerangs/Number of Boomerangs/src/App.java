
/**
 * Source: https://edabit.com/challenge/b7iHQDw72zzkmgCun
 * 
 * Description:
 * A boomerang is a V-shaped sequence that is either upright or upside down. Specifically, a boomerang can be defined as: sub-array of length 3, 
 * with the first and last digits being the same and the middle digit being different.
 * 
 * Examples: [3, 7, 3], [1, -1, 1], [5, 6, 5]
 * 
 * [3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2]
 * 3 boomerangs in this sequence:  [3, 7, 3], [1, 5, 1], [2, -2, 2]
 * 
 * [1, 7, 1, 7, 1, 7, 1]
 * 5 boomerangs (from left to right): [1, 7, 1], [7, 1, 7], [1, 7, 1], [7, 1, 7], and [1, 7, 1]
 * 
 * [1, 3, 1, 2, 1, 5, 4, 5, 3, 5]
 * 4 boomerangs: [1, 3, 1], [1, 2, 1], [5, 4, 5], [5, 3, 5]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] input1 = { 3, 7, 3 }; // 1 boomerang
        int[] input2 = { 3, 7, 3, 2, 1, 5, 1, 2, 2, -2, 2 }; // 3 boomerangs
        int[] input3 = { 1, 7, 1, 7, 1, 7, 1 }; // 5 boomerangs
        int[] input4 = { 0, 1, 2, 5, 5, 5 }; // 0 boomerangs

        System.out.println(
                "Given: " + Arrays.toString(input1) + "\n\tFound: " + app.countBoomerangs(input1) + " boomerangs.");
        System.out.println(
                "Given: " + Arrays.toString(input2) + "\n\tFound: " + app.countBoomerangs(input2) + " boomerangs.");
        System.out.println(
                "Given: " + Arrays.toString(input3) + "\n\tFound: " + app.countBoomerangs(input3) + " boomerangs.");
        System.out.println("Given: " + Arrays.toString(input4) + "\n\tFound: " + app.countBoomerangs(input4) + " boomerangs.");
    }

    public int countBoomerangs(int[] input) {
        ArrayList<Integer> differences = new ArrayList<Integer>(); // The list of differences between two digits. Size should be input.length - 1
        int result = 0; // Counter for the found boomerangs
        
        for (int i = 1; i < input.length; i++) {
            differences.add(input[i - 1] - input[i]);
        }
        for (int i = 1; i < differences.size(); i++) {
            if (differences.get(i - 1) == (-1 * differences.get(i)) && differences.get(i) != 0) {
                result += 1;
            }
        }
        
        return result;
    }
}
