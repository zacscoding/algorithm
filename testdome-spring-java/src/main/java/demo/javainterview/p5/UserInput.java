package demo.javainterview.p5;

public class UserInput {

    public static class TextInput {
        protected StringBuilder sb = new StringBuilder();

        public void add(char c) {
            sb.append(c);
        }

        public String getValue() {
            return sb.toString();
        }
    }

    public static class NumericInput extends TextInput {
        int start = '0';
        int last = '9';

        @Override
        public void add(char c) {
            if (c < start || c > last) {
                return;
            }
            super.add(c);
        }
    }

    public static void main(String[] args) {
//        TextInput input = new NumericInput();
//        input.add('1');
//        input.add('a');
//        input.add('0');
//        System.out.println(input.getValue());
    }
}