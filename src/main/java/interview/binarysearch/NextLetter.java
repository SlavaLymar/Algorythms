package interview.binarysearch;

public class NextLetter {

    //           s
    // Input: { 'a', 'c', 'f', 'h' }, key = 'f'
    //                m         e
    // Output: 'h'
    //
    // t: O (Log N)
    // space: O (1)
    public static char searchNextLetter(char[] letters, char key) {
        if (letters.length <= 1 || letters[letters.length - 1] <= key) {
            return letters[0];
        }
        int start = 0, end = letters.length - 1, mid = start + (end - start) / 2;
        while (start <= end) {
            if (key < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return letters[mid];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
