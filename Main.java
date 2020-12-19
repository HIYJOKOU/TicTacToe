import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] tablica = new char[3][3];
        char player = 'X';
        int tury = 0;
        boolean win = true;

        System.out.println("\n\t\t████████████████████\n\t\t█─▄▄─███▄─▄███▄─▀─▄█\n\t\t█─██─████─█████▀─▀██\n\t\t▀▄▄▄▄▀▀▀▄▄▄▀▀▀▄▄█▄▄▀\n");
        System.out.print("\tABY ROZPOCZAC GRE WPISZ COKOLWIEK: ");
        String start = sc.nextLine();

        while (win) {

            for (int g = 0; g < 10; g++) System.out.println(" ");

            Main.tablica(tablica);

            System.out.println("\n\t" + player + " TO TWOJA RUNDA!");

            int Y = Main.Y_Lenght(sc);
            int X = Main.X_Lenght(sc);

            Main.CheckMoveProperty(X, Y, tablica, player, sc);

            boolean Ywin = checkY(tablica, player);
            boolean Xwin = checkX(tablica, player);
            boolean Lline = checkLine1(tablica, player);
            boolean Rline = checkLine2(tablica, player);

            if (Ywin || Xwin || Lline || Rline) {
                for (int spam = 0; spam < 10; spam++) System.out.println(" ");
                System.out.println("\tGRACZ " + player + " WYGRAL");
                win = false;
            }

            if (player == 'X') player = 'O';
            else player = 'X';

            win = Main.checkTury(tury,win);
        }
    }
    // ODPOWIEDZIALNE ZA DISPLAY TABLICY

    public static void tablica(char[][] tablica) {

        System.out.println("\t#\t0\t1\t2");

        for (int a = 0; a < tablica.length; a++) {
            System.out.print("\t" + a + "\t");
            for (int b = 0; b < tablica.length; b++) {
                System.out.print(tablica[a][b] + "\t");
            }
            System.out.println(" ");
        }
    }

    // ODPOWIEDZIALNE ZA SPRAWDZANIE CZY GRACZ WYGRAL W LINII Y

    public static boolean checkY(char[][] tablica, char player) {
        for (int a = 0; a < 3; a++) {
            boolean wined = true;
            for (int b = 0; b < 3; b++) {
                if (tablica[a][b] != player) {
                    wined = false;
                    break;
                }
            }
            if (wined) return true;
        }
        return false;
    }

    // ODPOWIEDZIALNE ZA SPRAWDZANIE CZY GRACZ WYGRAL W LINII X

    public static boolean checkX(char[][] tablica, char player) {
        for (int a = 0; a < 3; a++) {
            boolean wined = true;
            for (int b = 0; b < 3; b++) {
                if (tablica[b][a] != player) {
                    wined = false;
                    break;
                }
            }
            if (wined) return true;
        }
        return false;
    }

    // ODPOWIEDZIALNE ZA SPRAWDZANIE CZY GRACZ WYGRAL W LEWYM SKOSIE

    public static boolean checkLine1(char[][] tablica, char player) {
        for (int a = 0; a < 3; a++){
            if (tablica[a][a] != player){
                return false;
            }
        }
        return true;
    }

    // ODPOWIEDZIALNE ZA SPRAWDZANIE CZY GRACZ WYGRAL PRAWYM SKOSIE

    public static boolean checkLine2(char[][] tablica, char player) {
        int b = tablica.length;
        for (int a = 0; a < 3; a++){
            if (tablica[a][b - a -1] != player){
                return false;
            }
        }
        return true;
    }

    // ODPOWIEDZIALNE ZA TO BY Y NIE WYCHODZIL ZA [][]

    public static int Y_Lenght(Scanner sc) {
        int Y;
        do {
            System.out.print("\tPODAJ Y: ");
            Y = sc.nextInt();
        } while (Y != 1 && Y != 2 && Y != 0);
        return Y;
    }

    // ODPOWIEDZIALNE ZA TO BY X NIE WYCHODZIL ZA [][]

    public static int X_Lenght(Scanner sc) {

        int X;
        do {
            System.out.print("\tPODAJ X: ");
            X = sc.nextInt();
        } while (X != 1 && X != 2 && X != 0) ;
        return X;
    }

    // ODPOWIEDZIALNE ZA POPRAWNOSC RUCHU

    public static void CheckMoveProperty(int X, int Y, char[][] tablica, char player, Scanner sc) {

        if (tablica[Y][X] == '\0'){
            System.out.println(" ");
        }else{
            do{
                for(int a=0;a<15;a++)System.out.println(" ");
                Main.tablica(tablica);
                System.out.println("\nTo miejsce jest juz zajete!\n");
                Y= Main.Y_Lenght(sc);
                X= Main.X_Lenght(sc);

            }while (tablica[Y][X] != '\0');
        }
        tablica[Y][X] = player;
    }

    //ODPOWIEDZIALNE ZA LICZENIE TUR

    public static boolean checkTury(int tury, boolean win){

        tury += 1;

        if(tury == 9){
            for(int a=0;a<15;a++)System.out.println(" ");
            System.out.println("KONIEC GRY: REMIS ");
            return false;
        }
        return win;
    }
}