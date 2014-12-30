public class CircularSuffixArray {
    private Index[] sorted;
    private String string;

    public class Index implements Comparable<Index> {
        private int index;
        private boolean circle;

        public Index(int i) {
            index = i;
        }

        public int getIndex() {
            return index;
        }

        public int compareTo(Index i) {
            circle = false;
            return compare(index, i.getIndex());
        }

        private int compare(int base, int other) {
            base = norm(base);
            other = norm(other);
            if (circle && base == index)
                return "".compareTo("");
            if (string.charAt(base) < string.charAt(other))
                return "a".compareTo("b");
            if (string.charAt(base) > string.charAt(other))
                return "b".compareTo("a");
            return compare(base + 1, other + 1);
        }

        private int norm(int j) {
            int res = j;
            if (res >= string.length()) {
                res -= string.length();
                circle = true;
            }
            return res;
        }
    }

    public CircularSuffixArray(String s) {  // circular suffix array of s
        if (s == null)
            throw new NullPointerException();
        string = s;
        sorted = new Index[s.length()];
        for (int i = 0; i < s.length(); i++)
            sorted[i] = new Index(i);
        Quick3way.sort(sorted);
    }

    public int length() {                   // length of s
        return sorted.length;
    }

    public int index(int i) {               // returns index of ith sorted suffix
        if (i < 0 || i >= length())
            throw new IndexOutOfBoundsException();
        return sorted[i].getIndex();
    }

    public static void main(String[] args) {// unit testing of the methods (optional)
        String s = "ABRACADABRA!";
        CircularSuffixArray sfa = new CircularSuffixArray(s);
        for (int i = 0; i < s.length(); i++)
            System.out.printf("%d: %c - %d\n", i, s.charAt(i), sfa.index(i));
    }
}