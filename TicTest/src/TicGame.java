import java.util.HashSet;
import java.util.Set;

public class TicGame {

    private char[ ][ ] ticArr = {{'n', 'n', 'n'}, {'n', 'n', 'n'}, {'n', 'n', 'n'}};

    /**
     * Assume that this game has 3*3 chess
     */
    protected void ticGameEndpoint(String[] param) {

        if (null == param || param.length != 3) {
            System.out.println("Invalid params");
            return;
        }

        if ("O".equals(param[0])) {
            int dimension1 = Integer.parseInt(param[1]);
            int dimension2 = Integer.parseInt(param[2]);
            ticArr[dimension1][dimension2] = 'O';
        }
        if ("X".equals(param[0])) {
            int dimension1 = Integer.parseInt(param[1]);
            int dimension2 = Integer.parseInt(param[2]);
            ticArr[dimension1][dimension2] = 'X';
        }

        Set<Character> winnerSet1 = new HashSet<>();
        Set<Character> winnerSet2 = new HashSet<>();


        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                winnerSet1.add(ticArr[i][j]);
                winnerSet2.add(ticArr[j][i]);
            }

            if (winnerSet1.size() == 1) {
                if (winnerSet1.contains('O')) {
                    System.out.println("The Winner is O");
                    printTic();
                } else if(winnerSet1.contains('X')) {
                    System.out.println("The Winner is X");
                }
            }

            if (winnerSet2.size() == 1) {
                if (winnerSet2.contains('O')) {
                    System.out.println("The Winner is O");
                } else if(winnerSet2.contains('X')) {
                    System.out.println("The Winner is X");
                }
            }

            Set<Character> winnerSet3 = new HashSet<>();
            winnerSet3.add(ticArr[0][0]);
            winnerSet3.add(ticArr[1][1]);
            winnerSet3.add(ticArr[2][2]);

            if (winnerSet3.size() == 1) {
                if (winnerSet3.contains('O')) {
                    System.out.println("The Winner is O");
                    printTic();
                    return;
                } else if (winnerSet3.contains('X')) {
                    System.out.println("The Winner is X");
                }
            }

            winnerSet3.clear();

            winnerSet3.add(ticArr[0][2]);
            winnerSet3.add(ticArr[1][1]);
            winnerSet3.add(ticArr[2][0]);

            if (winnerSet3.size() == 1) {
                if (winnerSet3.contains('O')) {
                    System.out.println("The Winner is O");
                } else if (winnerSet3.contains('X')) {
                    System.out.println("The Winner is X");
                }
            }
        }
    }

    protected void printTic() {
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[0][0], ticArr[0][1], ticArr[0][2]));
        System.out.println("---------------");
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[1][0], ticArr[1][1], ticArr[1][2]));
        System.out.println("---------------");
        System.out.println(String.format(" %s  |  %s  |  %s", ticArr[2][0], ticArr[2][1], ticArr[2][2]));
    }

    public static void main(String[] args) {
        TicGame ticGame = new TicGame();
        String[] param = new String[] {"O", "0", "0"};
        ticGame.ticGameEndpoint(param);
        param = new String[] {"X", "1", "0"};
        ticGame.ticGameEndpoint(param);
        param = new String[] {"O", "0", "1"};
        ticGame.ticGameEndpoint(param);
        param = new String[] {"X", "1", "2"};
        ticGame.ticGameEndpoint(param);
        param = new String[] {"O", "0", "2"};
        ticGame.ticGameEndpoint(param);
    }
}
