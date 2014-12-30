public class BurrowsWheeler {
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray sfa = new CircularSuffixArray(input);
        for (int i = 0; i < input.length(); i++) {
            int j = sfa.index(i);
            if (j == 0) {
                BinaryStdOut.write(i, 4);
                j = input.length();
            }
            BinaryStdOut.write(input.charAt(j-1), 1);
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode() {

    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args) {
        BurrowsWheeler.encode();
    }
}