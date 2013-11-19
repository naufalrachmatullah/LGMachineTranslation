/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lgmachinetranslation;

/**
 *
 * @author acer
 */
public class Parsing {

    public String[][] setParsing(String[][][] word, int length, int counter) {
        int i, j;
        String parseWord[][] = new String[100][100];
        boolean subject = false,verb=false;
        for (i = 0; i < length; i++) {
            for (j = 0; j < counter; j++) {
                System.out.println(word[i][j][0] + " " + word[i][j + 1][0]);
                System.out.println(word[i][j][2] + " " + word[i][j + 1][2]);
                System.out.println(i);
                if (word[i][j + 1][0] != null) {
                    if (word[i][j][0].equals(word[i][j + 1][0])) {
                        System.out.println(word[i][j][0] + " dan " + word[i][j + 1][0]);
                        if (word[i][j][2].equals("d")) {
                            parseWord[i][0] = word[i][j][0];
                            parseWord[i][1] = word[i][j][1];
                            parseWord[i][2] = word[i][j][2];
                            word[i][j + 1][0] = null;
                            System.out.println("determiner");
                        } else if (word[i][j][2].equals("n") && i<=1) {
                            parseWord[i][0] = word[i][j][0];
                            parseWord[i][1] = word[i][j][1];
                            parseWord[i][2] = word[i][j][2];
                            word[i][j + 1][0] = null;
                            subject = true;
                            System.out.println("subject");
                        } else if (word[i][j][2].equals("a")) {
                            parseWord[i][0] = word[i][j][0];
                            parseWord[i][1] = word[i][j][1];
                            parseWord[i][2] = word[i][j][2];
                            word[i][j + 1][0] = null;
                            System.out.println("aux");
                        }   else if (word[i][j][2].equals("i")) {
                            parseWord[i][0] = word[i][j][0];
                            parseWord[i][1] = word[i][j][1];
                            parseWord[i][2] = word[i][j][2];
                            word[i][j + 1][0] = null;
                            System.out.println("invinitives");
                        } else if (word[i][j][2].equals("v") && i>=2) {
                            parseWord[i][0] = word[i][j][0];
                            parseWord[i][1] = word[i][j][1];
                            parseWord[i][2] = word[i][j][2];
                            word[i][j + 1][0] = null;
                            System.out.println("verb");
                        }
                    }
                } else if (word[i][j + 1][0] == null && word[i][j+1][2]!=null) {
                    parseWord[i][0] = word[i][j][0];
                    parseWord[i][1] = word[i][j][1];
                    parseWord[i][2] = word[i][j][2];
                    System.out.println("null cacat");
                }
            }

        }
        return parseWord;
    }
}