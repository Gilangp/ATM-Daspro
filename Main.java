    import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Define and initialize the scanner 

        // Sample account details for demonstration
        String sampleUsername = "user123";
        int samplePin = 1234;
        int sampleSaldo = 1000000;
        
            // SEBELUM LOGIN
            System.out.println("-----------------------------------------------");
            System.out.println("|             SELAMAT DATANG di ATM           |");
            System.out.println("-----------------------------------------------");
            
            int loginAttempts = 3;
            while (loginAttempts > 0) {
                System.out.println("-----------------------------------------------");
                System.out.println("|                 SILAHKAN LOGIN              |");
                System.out.println("|           SEBELUM MELAKUKAN TRANSAKSI       |");
                System.out.println("-----------------------------------------------");
                        
                System.out.println("masukkan username: ");
                String inputUsername = input.nextLine();
                System.out.println("masukkan password: ");
                int inputPassword = Integer.parseInt (input.nextLine());
                
                if( (inputUsername.equals(sampleUsername)) && (inputPassword == samplePin) ){
                    
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
                        int menu = input.nextInt();
                        switch (menu) {
                            case 1:
                                // Tarik Tunai
                                System.out.println("Mohon Maaf. Fitur belum tersedia");
                                break;
                            case 2:
                                // SETOR TUNAI
                                    // input
                                    System.out.println("Masukkan jumlah uang yang ingin di setor");
                                    int inputSetor = input.nextInt();
        
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
                                    
                                    char konfirmasiSetor = input.next().charAt(0);
                                    switch (konfirmasiSetor) {
                                        case 'y':
                                        
                                        // konfirmasi pin
                                        System.out.println("Masukkan konfirmasi pin anda");
                                        int inputPin = input.nextInt();
                                        
                                        if (inputPin == samplePin) {
                                                sampleSaldo += inputSetor;
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|               SETOR BERHASIL                |");
                                                System.out.println("|                 INFO SALDO                  |");
                                                System.out.println("|                                             |");
                                                System.out.println("     Saldo anda saat ini adalah Rp. "+ sampleSaldo +"  ");
                                                System.out.println("|                                             |");
                                                System.out.println("|       1. Kembali             2. Keluar      |");
                                                System.out.println("-----------------------------------------------");
                                                
                                                int pilihanSelesai2;
                                                do {
                                                    System.out.print("Masukkan Pilihan (1 or 2): ");
                                                    pilihanSelesai2 = input.nextInt();
                                                    input.nextLine(); // Consume the newline character
                                                } while (pilihanSelesai2 != 1 && pilihanSelesai2 != 2);
                                            
                                                if (pilihanSelesai2 == 2) {
                                                    System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                                    System.exit(0);
                                                }
            
                                            } else {
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|                !! WARNINGG !!               |");
                                                System.out.println("|                                             |");
                                                System.out.println("|          PIN YANG ANDA MASUKKAN SALAH       |");
                                                System.out.println("|                                             |");
                                                System.out.println("|             MOHON TELILI KEMBALI            |");
                                                System.out.println("-----------------------------------------------");
                                            }
                                        case 'n':
                                            break;
                                    }
                                break;
                            case 3:
                                // Transfer
                                System.out.println("Mohon maaf, Sementara waktu fitur tidak dapat diakses");
                                break;
                            case 4:
                                // Pembayaran
                                System.out.println("Mohon maaf, Sementara waktu fitur tidak dapat diakses");
                                break;
                            case 5:
                                // SEDEKAH
                                System.out.println("Mohon maaf, Sementara waktu fitur tidak dapat diakses");
                            case 6:
                                // Info Kurs
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                  INFO KURS                  |");
                                System.out.println("|                                             |");
                                System.out.println("|                     USD                     |");
                                System.out.println("|  Beli : Rp 15,345.00   Jual : Rp 15,375.00  |");
                                System.out.println("|                                             |");
                                System.out.println("|                     SGD                     |");
                                System.out.println("|  Beli : Rp 11,281.89   Jual : Rp 11,295.56  |");
                                System.out.println("|                                             |");
                                System.out.println("|       1. Kembali             2. Keluar      |");
                                System.out.println("-----------------------------------------------");
                            
                                int pilihanSelesai6;
                                do {
                                    System.out.print("Masukkan Pilihan (1 atau 2): ");
                                    pilihanSelesai6 = input.nextInt();
                                    input.nextLine(); // Consume the newline character
                                } while (pilihanSelesai6 != 1 && pilihanSelesai6 != 2);
                            
                                if (pilihanSelesai6 == 2) {
                                    System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                    System.exit(0);
                                }
                                break;
                            case 7:
                                // Riwayat Transaksi
                                System.out.println("Mohon maaf, Sementara waktu fitur tidak dapat diakses");

                            case 8:
                                // CEK SALDO
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                 INFO SALDO                  |");
                                System.out.println("|                                             |");
                                System.out.println("       SALDO ANDA SEBESAR : Rp "+ sampleSaldo + "     ");
                                System.out.println("|                                             |");
                                System.out.println("|       1. Kembali             2. Keluar      |");
                                System.out.println("-----------------------------------------------");
                                int pilihanSelesai8;
                                do {
                                    System.out.print("Masukkan Pilihan (1 atau 2): ");
                                    pilihanSelesai8 = input.nextInt();
                                    input.nextLine(); // Consume the newline character
                                } while (pilihanSelesai8 != 1 && pilihanSelesai8 != 2);
                            
                                if (pilihanSelesai8 == 2) {
                                    System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                    System.exit(0);
                                }
                                break;

                            case 9:
                            // UBAH PIN
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                 UBAH PIN                    |");
                                System.out.println("-----------------------------------------------");
                                System.out.print("Masukkan PIN Anda saat ini: ");
                                int pinSekarang = input.nextInt();
                            
                                if (pinSekarang != samplePin) {
                                    System.out.println("PIN tidak valid. Akses ditolak.");
                                    return;
                                }
                            
                                System.out.print("Masukkan PIN Baru Anda : ");
                                int pinBaru = input.nextInt();
                                System.out.print("Konfirmasi PIN Baru: ");
                                int confirmPin = input.nextInt();
                            
                                if (pinBaru != confirmPin) {
                                    System.out.println("PIN tidak cocok. Perubahan PIN gagal.");
                                } else {
                                    samplePin = pinBaru; // Update the PIN
                                    System.out.println("Perubahan PIN Berhasil.");
                                }
                                System.out.println("\n Apakah anda ingin kembali ke menu atau exit");
                                System.out.println("1. Kembali ke halaman Menu");
                                System.out.println("2. Exit");
                            
                                int pilihanSelesai9;
                                do {
                                    System.out.print("Masukkan Pilihan (1 atau 2): ");
                                    pilihanSelesai9 = input.nextInt();
                                    input.nextLine(); // Consume the newline character
                                } while (pilihanSelesai9 != 1 && pilihanSelesai9 != 2);
                            
                                if (pilihanSelesai9 == 2) {
                                    System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                    System.exit(0);
                                }
                                break;
                            case 10:
                                // Help
                                break;
                            default:
                                System.out.println("Pilihan Menu tidak tersedia");
                                break;
                        }
                    }
                
                else {
                    loginAttempts--;
                    // Jika login gagal
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              !! LOGIN GAGAL !!              |");
                    System.out.println("|                                             |");
                    System.out.println("|   USERNAME / PIN YANG ANDA MASUKKAN SALAH   |");
                    System.out.println("|                                             |");
                    System.out.println("|           Anda sudah mencoba " + loginAttempts + " kali \t      |");
                    System.out.println("|        NB : Maksimal percobaan 3 kali       |");
                    System.out.println("-----------------------------------------------");
                }
            }
            System.out.println("Anda telah melampaui upaya login maksimum. Akun Anda terkunci. Hubungi Admin");
        }
    }
