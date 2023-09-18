import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int saldo = 5000;
        int pin = 123456;

        
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
            
            if( (username.equals("admin")) && (password==pin) ){
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
                    // tarik tunai
                } else if (menu == 2){
                    // SETOR TUNAI
                    int inputSetor;
                    
                    // input
                    System.out.println("Masukkan jumlah uang yang ingin di setor");
                    inputSetor = input.nextInt();

                    // konfirmasi
                    System.out.println("-----------------------------------------------");
                    System.out.println("|     Saldo yang ingin anda setor sebesar     |");
                    System.out.println("|                                             |");
                    System.out.println("                  Rp.  "+ inputSetor + "  \t\t  ");
                    System.out.println("|                                             |");
                    System.out.println("-----------------------------------------------");
                    System.out.println("| Keterangan :                                |");
                    System.out.println("| - Jika benar ketik 'y'                      |");
                    System.out.println("| - Jika salah klik 'n'                       |");
                    System.out.println("-----------------------------------------------");
                    
                    char respon = input.next().charAt(0);

                    if (respon == 'y') {
                        
                        saldo += inputSetor; //saldo = saldo + masukan
                
                        // konfirmasi pin
                        System.out.println("Masukkan konfirmasi pin anda");
                        int inputPin = input.nextInt();
                
                        if (inputPin == pin) {
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
                    }else if (respon == 'n') {
                        // Kembali ke menu
                    }
                } else if (menu == 3) {
                    // Transfer
                } else if (menu == 4) {
                    // Pembayaran (VA)
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

                    System.out.println("Masukkan sedekah yang ingin diberikan ");
                    int inputSedekah = input.nextInt();
                    // konfirmasi
                    System.out.println("-----------------------------------------------");
                    System.out.println("|     Sedekah yang akan diberikan sebesar     |");
                    System.out.println("|                                             |");
                    System.out.println("                  Rp.  "+ inputSedekah + "  \t\t  ");
                    System.out.println("|                                             |");
                    System.out.println("-----------------------------------------------");
                    System.out.println("| Keterangan :                                |");
                    System.out.println("| - Jika benar ketik 'y'                      |");
                    System.out.println("| - Jika salah klik 'n'                       |");
                    System.out.println("-----------------------------------------------");


                    char responSedekah = input.next().charAt(0);
                    if (responSedekah == 'y') {

                    // konfirmasi pin
                        System.out.println("Masukkan konfirmasi pin anda");
                        int inputPin = input.nextInt();
                        saldo -= inputSedekah;
                        if (inputPin == pin) {
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
                    }else if (responSedekah == 'n') {
                        // kembali ke menu
                    }
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
                } else if( menu == 8) {
                    // CEK SALDO
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                 INFO SALDO                  |");
                    System.out.println("|                                             |");
                    System.out.println("|       SALDO ANDA SEBESAR : Rp 15,345.00     |");
                    System.out.println("-----------------------------------------------");
                } else if (menu == 9) {
                    // UBAH PIN
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                 UBAH PIN                    |");
                    System.out.println("-----------------------------------------------");
                    System.out.print("masukan pin lama anda : ");
                    int pinLama = input.nextInt();
                    if (pinLama == pin) {
                        System.out.print("masukan pin baru anda : ");
                        int pinBaru = input.nextInt();
                        System.out.println("masukkan konfirmasi pin baru anda");
                        int pinBaruKonfirmasi = input.nextInt();
                        if (pinBaru == pinBaruKonfirmasi) {
                            pin = pinBaru;
                                System.out.println("-----------------------------------------------");
                                System.out.println("|           ~  UBAH PIN BERHASIL  ~           |");
                                System.out.println("-----------------------------------------------");
                        }else {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                !! WARNINGG !!               |");
                                System.out.println("|                                             |");
                                System.out.println("|     PIN BARU DENGAN KONFIRMASI PIN BARU     |");
                                System.out.println("|               ~  TIDAK SAMA  ~              |");
                                System.out.println("|                                             |");
                                System.out.println("-----------------------------------------------");
                        }

                    }else {
                        System.out.println("pin lama yang anda masukkan salah");
                    }
                } else if (menu == 10) {
                    // HELP
                }
            }
            else {
                System.out.println("\n  username atau password anda salah,silahkan coba lagi");
                System.out.println("\n");
            }
        }
    }
}