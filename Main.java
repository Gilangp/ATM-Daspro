import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        // SEBELUM LOGIN
        System.out.println("-----------------------------------------------");
        System.out.println("|                 SELAMAT DATANG              |");
        System.out.println("|                                             |");
        System.out.println("|                 SILAHKAN LOGIN              |");
        System.out.println("|           SEBELUM MELAKUKAN TRANSAKSI       |");
        System.out.println("|                                             |");
        System.out.println("-----------------------------------------------");
        
        boolean login;
        login = false;
        while (login == false){
            System.out.println("masukkan username: ");
            String username = input.nextLine();
            System.out.println("masukkan password: ");
            int password = Integer.parseInt (input.nextLine());
            
            if( (username.equals("admin")) && (password==123) ){
                login = true;
                // SETELAH LOGIN
                System.out.println("-----------------------------------------------");
                System.out.println("|                SELAMAT DATANG               |");
                System.out.println("|          Silahkan Pilih transaksi           |");
                System.out.println("|                                             |");
                System.out.println("| 1. Tarik Tunai         6. info Kurs         |");
                System.out.println("| 2. Setor Tunai         7. Riwayat Transaksi |");
                System.out.println("| 3. Transfer            8. Cek Saldo         |");
                System.out.println("| 4. Pembayaran          9. Ubah Pin          |");
                System.out.println("|    (Virtual Account)   10. Help             |");
                System.out.println("| 5. Sedekah                                  |");
                System.out.println("-----------------------------------------------");
                int menu = Integer.parseInt (input.nextLine());

                if (menu == 1) {
                    // asd
                } else if (menu == 6) {
                    // Info Kurs
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                  INFO KURS                  |");
                    System.out.println("|                                             |");
                    System.out.println("|                     USD                     |");
                    System.out.println("|  Beli : Rp 15,345.00   Jual : Rp 15,375.00  |");
                    System.out.println("|                                             |");
                    System.out.println("|                     SGD                     |");
                    System.out.println("|  Beli : Rp 11,281.89   Jual : Rp 11,295.56  |");
                    System.out.println("-----------------------------------------------");
                } else if( menu == 8) {
                    // CEK SALDO
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                 INFO SALDO                  |");
                    System.out.println("|                                             |");
                    System.out.println("|       SALDO ANDA SEBESAR : Rp 15,345.00     |");
                    System.out.println("-----------------------------------------------");

                } else if (menu == 7) {
                    // RIWAYAT TRANSAKSI
                    System.out.println("-----------------------------------------------");
                    System.out.println("|               RIWAYAT TRANSAKSI             |");
                    System.out.println("|                                             |");
                    System.out.println("|                    MASUKAN                  |");
                    System.out.println("|                 Rp 15,345.00                |");
                    System.out.println("|                                             |");
                    System.out.println("|                   KELUARAN                  |");
                    System.out.println("|                 Rp 11,281.89                |");
                    System.out.println("-----------------------------------------------");
                    
                } else if (menu == 5) {
                    // SEDEKAH
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              SELAMAT BERSEDEKAH             |");
                    System.out.println("|            Silahkan Pilih Sedekah           |");
                    System.out.println("|                                             |");
                    System.out.println("|   1. BAZNAS                 4. DigiZakat    |");
                    System.out.println("|   2. KPRB                   5. LAMZIZ       |");
                    System.out.println("|   3. Dompet DHUAFA                          |");
                    System.out.println("-----------------------------------------------");
                }






            }
            else {
                System.out.println("\n  username atau password anda salah,silahkan coba lagi");
                System.out.println("\n");
            }
        }
        
        
    }
}