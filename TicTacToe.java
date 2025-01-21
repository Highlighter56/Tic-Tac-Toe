import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // char a[][] = { {'_','_','_'},
        //                {'_','_','_'},
        //                {'_','_','_',} };

        char m[][] = { {' ',' ',' '},
                       {' ',' ',' '},
                       {' ',' ',' '} };

        int turn=0;
        String move = "";
        int temp=0;

        printBoard(m);

        while(win(m)==0 && turn < 9) {
            
            System.out.print("Where would you like to move? ");
            move = sc.nextLine();

            temp = turn;
            turn += changeBoard(m, turn, move);

            if(temp != turn) printBoard(m);
        }

        if(win(m)>0) {
            System.out.println("Congratulations, X wins!!!\n");
        } else if(win(m)<0) {
            System.out.println("Congratulations, O wins!!!\n");
        } else {
            System.out.println("Congratulations, you tied!!!\n");
        }

        sc.close();
    }

    public static int win(char[][] m) {
        // Horizontal Win Cases
        for(int i = 0; i<m.length; i++) {
            if(m[i][0] == 'X' && m[i][0] == m[i][1] && m[i][1] == m[i][2]) {        // Checks Horizontal for X win
                return 1;
            }
            if(m[i][0] == 'O' && m[i][0] == m[i][1] && m[i][1] == m[i][2]) {        // Checks Horizontal for O win
                return -1;
            }
        }

        // Vertical Win Cases
        for(int i = 0; i<m.length; i++) {
            if(m[0][i] == 'X' && m[0][i] == m[1][i] && m[1][i] == m[2][i]) {        // Checks Vertical for X win
                return 1;
            }
            if(m[0][i] == 'O' && m[0][i] == m[1][i] && m[1][i] == m[2][i]) {        // Checks Vertical for O win
                return -1;
            }
        }

        // Diagnols 
        if(m[1][1] == 'X' && m[0][0] == m[1][1] && m[1][1] == m[2][2]) {        // Checks D1 for X win
            return 1;
        }
        if(m[1][1] == 'X' && m[0][2] == m[1][1] && m[1][1] == m[2][0]) {        // Checks D2 for X win
            return 1;
        }

        if(m[1][1] == 'O' && m[0][0] == m[1][1] && m[1][1] == m[2][2]) {        // Checks D1 for O win
            return -1;
        }
        if(m[1][1] == ')' && m[0][2] == m[1][1] && m[1][1] == m[2][0]) {        // Checks D2 for O win
            return -1;
        }

        return 0;
    }

    public static int changeBoard(char[][] m, int turn, String move) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Where would you like to move? ");
        // String move = sc.nextLine();
        // sc.close();

        if(!check1(move)) {
            System.out.println("Please Enter Valid Cordinates");
            System.out.println("Rows:\t  1-3");
            System.out.println("Columns:  A-C");
            return 0;
        }

        int[] a = stringToCord(move);

        if(!check2(a)) {
            System.out.println("Please Enter a Valid Cordinate");
            System.out.println("The rows are numbered 1-3,");
            System.out.println("and the columns are labeled A-C");
            return 0;
        }

        char player = 'X';
        if(turn%2==0) {
            player = 'X';
        } else {
            player = 'O';
        }

        if(m[a[0]][a[1]] == ' ') m[a[0]][a[1]] = player;
        else {
            System.out.println("Please enter a tile that\nhas not been move on yet");
            return 0;
        }
        return 1;
    }

    public static int[] stringToCord(String cords) {
        int[] a = {0,0};

        a[0] = (cords.toUpperCase()).charAt(0) - 65;
        // System.out.println(a[0]);

        String s = cords.substring(1);
        a[1] = Integer.parseInt(s)-1;

        return a;
    }

    public static boolean check1(String c) {
        // System.out.println("Error: " + c);
        if(c.equals("")) {
            // System.out.println("***Here***");
            return false;
        } 
        if(c.length() != 2) {
            return false;
        }
        if(!Character.isLetter(c.charAt(0)) || !Character.isDigit(c.charAt(1))) {
            return false;
        }
        
        return true;
    }

    public static boolean check2(int[] a) {
        int check=0;
        // System.out.print("check2: ");
        for(int i=0; i<2; i++) {
            if(a[i] == 0 || a[i] == 1 || a[i] == 2) {
                // System.out.println("true");
                // System.out.println("a[0]: "+a[0]);
                // System.out.println("a[1]: "+a[1]);
                check++;
            }
        }
        if(check==2) return true;
        return false;
    }

    public static void printBoard(char[][] m) {
        System.out.println();
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                System.out.print(m[i][j]);
                if(j!=2) {
                    System.out.print("   "+"|"+"\t");
                }
            }
            System.out.println();
            if(i != m.length-1) System.out.println("----|-------|----");
            // System.out.println();
        }
        System.out.println();
    }

}