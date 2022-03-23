import java.util.Arrays;

/**
 * Source: https://edabit.com/challenge/eBkknBKXvMm8bDo8M
 * 
 * Description: 6174 is known as one of Kaprekar's constants, after the Indian mathematician D. R. Kaprekar. Number 6174 is notable for the following rule:

    Take any four-digit number, using at least two different digits (leading zeros are allowed).
    Arrange the digits in descending and then in ascending order to get two four-digit numbers, adding leading zeros if necessary.
    Subtract the smaller number from the bigger number.
    Go back to step 2 and repeat.

    The above process, known as Kaprekar's routine, will always reach its fixed point, 6174, in at most 7 iterations. Once 6174 is reached, the process will continue yielding 7641 – 1467 = 6174. For example, choose 3524:

    5432 – 2345 = 3087
    8730 – 0378 = 8352
    8532 – 2358 = 6174
    7641 – 1467 = 6174

    Write a recursive function that will return the number of times it will take to get from a number to 6174 (the above example would equal 3).

    (1)5432 – 2345 = 3087,
    (2)8730 – 0378 = 8352,
    (3)8532 – 2358 = 6174

    495 would produce the following: 4950 to 9540 - 459, 9081 to 9810 - 189, 9621 to 9621 - 1269, 8352 to 8532 - 2358 answer: 4

    For a 2 digit number, the following would be produced (stating with number 10 -> 100):

    100 to 100 - 1, 990 to 990 - 99, 8910 to 9810 - 189, 9621 to 9621 - 1269, 8352 to 8532 - 2358 answer: 5
    Examples

    kaprekar(6621) ➞ 5

    kaprekar(6554) ➞ 4

    kaprekar(1234) ➞ 3

    Notes

    If the subtracted number is less than 1000, add an extra zero to that number. The number 1111 will equal 0000, so this number (1111) is invalid. If you're still unclear, please check the comments section.
 */

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.kaprekarIterations(10));
    }

    public int kaprekarIterations(int input) {
        int iterationNumber = 0; // Counter for how many iterations until reaching the Kaprekar Constant
        String inputString = Integer.toString(input); // String representation of the input
        boolean isValidInput = false;

        if (inputString.length() < 4) {
            // Check that there are 4 digits in the input. If not, add leading 0s
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < 4 - inputString.length(); i++) {
                tmp.append("0");
            }
            tmp.append(inputString);
            inputString = tmp.toString();
        }

        for (int i = 1; i < inputString.length() - 1; i++) {
            // Check that the input is made up of at least 2 different integer digits (i.e: not 1111, 2222, 3333, ...)
            if (inputString.charAt(i - 1) != inputString.charAt(i)) {
                isValidInput = true;
                break; // no need to check the rest
            }
        }
        if (!isValidInput) {
            return -1;
        }

        String[] splitInput = inputString.split(""); // Convert to array for sorting
        Arrays.sort(splitInput); // Sort in ascending order

        int inputDescending = Integer.parseInt(reverse(String.join("", splitInput)));
        int inputAscending = Integer.parseInt(String.join("", splitInput));

        int result = Math.max(inputDescending, inputAscending) - Math.min(inputDescending, inputAscending);
        iterationNumber++;

        if (result == 6174) {
            //Kaprekar's Constant reached!
            return iterationNumber;
        } else {
            return iterationNumber + kaprekarIterations(result);
        }
    }

    private String reverse(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(input.length() - 1 - i));
        }
        return result.toString();
    }
}
