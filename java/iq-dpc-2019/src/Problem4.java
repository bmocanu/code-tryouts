public class Problem4 {

    public class BasicEncrypt {

        public String encrypt(String text, int rule) {
            char[] result = new char[text.length()];
            rule = rule % 256;
            for (int index = 0; index < text.length(); index++) {
                result[index] = (char) ((text.charAt(index) + rule) % 256);
            }
            return new String(result);
        }
    }

    public static void main(String[] args) {

    }

}
