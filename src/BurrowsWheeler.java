public class BurrowsWheeler {
    private static final int BYTE = 8;

    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode() {
        String input = "";
        /*while (true) {
            char end = BinaryStdIn.readChar();
            if (end == '0')
                break;
            input += end;
        }*/
        input = BinaryStdIn.readString();
        CircularSuffixArray sfa = new CircularSuffixArray(input);
        for (int i = 0; i < input.length(); i++) {
            int j = sfa.index(i);
            if (j == 0) {
                BinaryStdOut.write(i, 4 * BYTE);
                j = input.length();
            }
            BinaryStdOut.write(input.charAt(j-1), 1 * BYTE);
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode() {

    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args) {
        if (args[0].equals("-"))
        {
            encode();
        }
        else
        if (args[0].equals("+"))
        {
            decode();
        }
        else
        {
            throw new RuntimeException("Illegal command line argument");
        }
    }
}