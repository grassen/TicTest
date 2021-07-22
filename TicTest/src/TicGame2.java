import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TicGame2 {

    private char[ ][ ] ticArr = {{'n', 'n', 'n'}, {'n', 'n', 'n'}, {'n', 'n', 'n'}};
    private int ROW = 3;// hard code row=3
    private int COLUMN = 3;// hard code column=3

    /**
     * Assume that this game has 3*3 chess
     */
    protected int ticGameEndpoint(String[] param) {
        if (ticArr[Integer.parseInt(param[1])][Integer.parseInt(param[2])] != 'n') {
            System.out.println("This slot was already put, please choose other slots!");
            return 0;
        }
        ticArr[Integer.parseInt(param[1])][Integer.parseInt(param[2])] = param[0].toCharArray()[0];

        printTic();

        Set<Character> winnerSet1 = new HashSet<>();
        Set<Character> winnerSet2 = new HashSet<>();

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COLUMN; j++) {
                winnerSet1.add(ticArr[i][j]);
                winnerSet2.add(ticArr[j][i]);
                if (j >= COLUMN - 1 && i <= ROW - 3) {
                    if ((ticArr[i][j] == ticArr[i+1][j-1]) && (ticArr[i][j]== ticArr[i+2][j-2])) {
                        if (ticArr[i][j] == 'O') {
                            System.out.println("The Winner is O");
                        } else if (ticArr[i][j] == 'X') {
                            System.out.println("The Winner is X");
                        }
                    }
                }
                if (j <= COLUMN - 3 && i <= ROW - 3) {
                    if ((ticArr[i][j] == ticArr[i+1][j+1]) && (ticArr[i][j]== ticArr[i+2][j+2])) {
                        if (ticArr[i][j] == 'O') {
                            System.out.println("The Winner is O");
                            return 1;
                        } else if (ticArr[i][j] == 'X') {
                            System.out.println("The Winner is X");
                            return 1;
                        }
                    }
                }
            }

            if (winnerSet1.size() == 1) {
                if (winnerSet1.contains('O')) {
                    System.out.println("The Winner is O");
                    return 1;
                } else if(winnerSet1.contains('X')) {
                    System.out.println("The Winner is X");
                    return 1;
                }
            }

            if (winnerSet2.size() == 1) {
                if (winnerSet2.contains('O')) {
                    System.out.println("The Winner is O");
                    return 1;
                } else if(winnerSet2.contains('X')) {
                    System.out.println("The Winner is X");
                    return 1;
                }
            }
        }

        return 0;
    }

    protected void printTic() {
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[0][0], ticArr[0][1], ticArr[0][2]));
        System.out.println("---------------");
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[1][0], ticArr[1][1], ticArr[1][2]));
        System.out.println("---------------");
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[2][0], ticArr[2][1], ticArr[2][2]));
    }

    public static void main(String[] args) {
        TicGame2 ticGame = new TicGame2();
        while (true) {
            int res = ticGame.ticGameEndpoint(ticGame.waitInput());
            if (1 == res) {
                System.out.println("Game over! Good luck next time man!");
                break;
            }
        }
    }

    protected String[] waitInput() {
        String[] params = new String[]{"","",""};
        String str;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please input role firstly, you can type 'O' or 'X' only!");
            while (true) {
                str = br.readLine();
                if (!str.equals("O") && !str.equals("X")) {
                    System.out.println("Your input is incorrect, you can type 'O' or 'X' only!");
                } else {
                    params[0] = str;
                    break;
                }
            }

            System.out.println("Please type row number you want to choose, for example: 0, 1, 2");
            while (true) {
                str = br.readLine();
                if (!str.equals("0") && !str.equals("1") && !str.equals("2")) {
                    System.out.println("Your input is incorrect, type row number again");
                } else {
                    params[1] = str;
                    break;
                }
            }

            System.out.println("Please type column number you want to choose, for example: 0, 1, 2");
            while (true) {
                str = br.readLine();
                if (!str.equals("0") && !str.equals("1") && !str.equals("2")) {
                    System.out.println("Your input is incorrect, type column number again");
                } else {
                    params[2] = str;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return params;
    }
}
