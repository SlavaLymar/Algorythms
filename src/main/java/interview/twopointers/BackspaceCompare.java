package interview.twopointers;

public class BackspaceCompare {

    public static void main(String[] args) {
        System.out.println(compare("xp#", "xyz##"));
    }

    public static boolean compare(String str1, String str2) {
        boolean result = true;
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            index1 = getNextAvailableIndex(str1, index1);
            index2 = getNextAvailableIndex(str2, index2);
            if (str1.charAt(index1) != str2.charAt(index2)) {
                result = false;
                break;
            }
            index1--;
            index2--;
        }
        return result;
    }

    private static int getNextAvailableIndex(String str, int index) {
        int backSpaceCounter = 0;
        while (str.charAt(index) == '#') {
            backSpaceCounter++;
            index--;
        }
        index -= backSpaceCounter;
        return index;
    }
}
