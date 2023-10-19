/**
 * Main
 */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // SETOR TUNAI
        int saldo = 5000, masukan;
        
        // masukan input
        System.out.println("Masukkan jumlah uang yang ingin di setor");
        masukan = input.nextInt();

        // konfirmasi
        System.out.println("-----------------------------------------------");
        System.out.println("|     Saldo yang ingin anda setor sebesar     |");
        System.out.println("|                                             |");
        System.out.println("               Rp.  "+ masukan + "  \t\t  ");
        
        System.out.println("-----------------------------------------------");

        saldo += masukan; //saldo = saldo + masukan

        // konfirmasi pin
        System.out.println("Masukkan konfirmasi pin anda");
        int pin = input.nextInt();

        if (pin == 123456) {
            System.out.println("-----------------------------------------------");
            System.out.println("|               SETOR BERHASIL                |");
            System.out.println("|                 INFO SALDO                  |");
            System.out.println("|                                             |");
            System.out.println("     Saldo anda saat ini adalah Rp. "+ saldo +"  ");
            System.out.println("|                                             |");
            System.out.println("-----------------------------------------------");
        } else {
            System.out.println("Pin anda salah");
        }
    }
}