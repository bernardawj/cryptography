package security;

public class Cipher {

    public static void main(String[] args) {
        VigenereSquare vigenereSquare = new VigenereSquare();
        System.out.println(vigenereSquare);
    }

    private static class VigenereSquare {

        private char[][] table;

        VigenereSquare() {
            this.table = new char[26][26];
            this.generateTable();
        }

        private void generateTable() {
            // Preset the number of characters to be inside the row
            int startCharacterIdx = 0;
            int currentCharacterIdx = 0;

            for (int rowIdx = 0; rowIdx < this.table.length; rowIdx++) {
                // Capital letters in ASCII table starts from 65 (A) - 90 (Z)
                int overflowCounter = 0;
                for (int colIdx = 0; colIdx < this.table[rowIdx].length; colIdx++) {
                    char currentChar = (char)(65 + startCharacterIdx + currentCharacterIdx++);

                    if (currentChar <= 90) {
                        this.table[rowIdx][colIdx] = currentChar;
                    } else {
                        char overflowChar = (char)(65 + overflowCounter++);
                        this.table[rowIdx][colIdx] = overflowChar;
                    }

                    if (colIdx == this.table[rowIdx].length - 1) {
                        // Increment the start character index by 1 and reset all values
                        ++startCharacterIdx;
                        currentCharacterIdx = 0;
                        overflowCounter = 0;
                    }
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int rowIdx = 0; rowIdx < this.table.length; rowIdx++) {
                sb.append("[");

                for (int colIdx = 0; colIdx < this.table[rowIdx].length; colIdx++) {
                    sb.append(this.table[rowIdx][colIdx]);
                }

                sb.append("]");
                if (rowIdx < this.table.length - 1) {
                    sb.append("\n");
                }
            }

            return sb.toString();
        }

    }

}
