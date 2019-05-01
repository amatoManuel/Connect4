package Connect4;

import java.util.Scanner;

public class Main {

    public static void main (String args[]){
        Connect connect = new Connect();
        int x =0;
        Scanner input = new Scanner(System.in);
        System.out.println(connect.startGame());
        while(connect.turn <= 42){
            if(connect.owner == 1){
                System.out.println(connect+"\nGiocatore 1 inserisci coordinate x");
                x=input.nextInt();
                System.out.println(connect.set(x));
            }
            else{
                System.out.println(connect+"\nGiocatore 2 inserisci coordinate x");
                x=input.nextInt();
                System.out.println(connect.set(x));
            }
        }
        System.out.println(connect);
    }
}
