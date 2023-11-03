    import java.util.*;
/**
 * Main
 */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Define and initialize the scanner 

        // Sample account details for demonstration
        String sampleUsername = "user123";
        int samplePin = 1234;
        int sampleSaldo = 100000;
        
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
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                SELAMAT DATANG               |");
                    System.out.println("-----------------------------------------------");
                    while (true) {
                        // SETELAH LOGIN
                        System.out.println("-----------------------------------------------");
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
                                int tarikTunai;

                                // input
                                System.out.println("Masukkan jumlah uang yang ingin di ambil");
                                tarikTunai = input.nextInt();

                                // konfirmasi
                                System.out.println("-----------------------------------------------");
                                System.out.println("|    Saldo yang ingin anda tarik sebesar      |");
                                System.out.println("|                                             |");
                                System.out.println("                  Rp.  "+ tarikTunai + "  \t\t\t  ");
                                System.out.println("|                                             |");
                                System.out.println("-----------------------------------------------");
                                System.out.println("| Keterangan :                                |");
                                System.out.println("| - Jika benar ketik 'y'                      |");
                                System.out.println("| - Jika salah klik 'n'                       |");
                                System.out.println("-----------------------------------------------");

                                char respon1 = input.next().charAt(0);
                                switch (respon1) {
                                    case 'y':
                                    
                                    // konfirmasi pin
                                    System.out.println("Masukkan konfirmasi pin anda");
                                    int inputPin = input.nextInt();
                                    
                                    if (inputPin == samplePin) {
                                            if (tarikTunai < sampleSaldo) {
                                                if (tarikTunai >= 50000) {
                                                    sampleSaldo -= tarikTunai; //sampleSaldo = sampleSaldo - masukan
                                                    System.out.println("-----------------------------------------------");
                                                    System.out.println("|       PENARIKAN ANDA TELAH BERHASIL         |");
                                                    System.out.println("|                 INFO SALDO                  |");
                                                    System.out.println("|                                             |");
                                                    System.out.println("     Saldo anda saat ini adalah Rp. "+ sampleSaldo +"  ");
                                                    System.out.println("|                                             |");
                                                    System.out.println("|       1. Kembali             2. Keluar      |");
                                                    System.out.println("-----------------------------------------------");
                                                    int pilihanSelesai1;
                                                        do {
                                                            System.out.print("Masukkan Pilihan (1 or 2): ");
                                                            pilihanSelesai1 = input.nextInt();
                                                            input.nextLine(); // Consume the newline character
                                                        } while (pilihanSelesai1 != 1 && pilihanSelesai1 != 2);
                                                    
                                                        if (pilihanSelesai1 == 2) {
                                                            System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                                            System.exit(0);
                                                        }
                                                }else {
                                                    System.out.println("Transaksi gagal, minimal transaksi 50000");
                                                }
                                            } else {
                                                System.out.println("Transaksi gagal, Saldo anda tidak cukup");
                                            }

                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|          PIN YANG ANDA MASUKKAN SALAH       |");
                                            System.out.println("|                                             |");
                                            System.out.println("|             MOHON TELILI KEMBALI            |");
                                            System.out.println("-----------------------------------------------");
                                        }
                                    case 'n':
                                }
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
                                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                                System.out.println("|                                             |");
                                                System.out.println("|          PIN YANG ANDA MASUKKAN SALAH       |");
                                                System.out.println("|                                             |");
                                                System.out.println("|             MOHON TELITI KEMBALI            |");
                                                System.out.println("-----------------------------------------------");
                                            }
                                        case 'n':
                                            break;
                                    }
                                break;
                            case 3:
                                // Transfer
                                String namaTujuan;
                                int Transfer, noRekening;

                                // input
                                System.out.println("Masukkan nama yang akan anda transfer");
                                namaTujuan = input.next();
                                System.out.println("Masukkan No Rekening tujuan anda");
                                noRekening = input.nextInt();
                                System.out.println("Masukkan jumlah uang yang ingin di transfer");
                                Transfer = input.nextInt();

                                // konfirmasi
                                System.out.println("-----------------------------------------------");
                                System.out.println("|              KONFIRMASI TRANSFER             |");
                                System.out.println("|                                             |");
                                System.out.println("Kepada : "+ namaTujuan);
                                System.out.println("No Rek : "+ noRekening);
                                System.out.println("Jumlah : Rp.  "+ Transfer);
                                System.out.println("|                                             |");
                                System.out.println("-----------------------------------------------");
                                System.out.println("| Keterangan :                                |");
                                System.out.println("| - Jika benar ketik 'y'                      |");
                                System.out.println("| - Jika salah klik 'n'                       |");
                                System.out.println("-----------------------------------------------");

                                char respon3 = input.next().charAt(0);
                                switch (respon3) {
                                    case 'y':
                                    
                                    // konfirmasi pin
                                        System.out.println("Masukkan konfirmasi pin anda");
                                        int inputPin = input.nextInt();
                                        
                                        if (inputPin == samplePin) {
                                            // Code saldo tidak cukup
                                            if (Transfer < sampleSaldo) {
                                                if (Transfer >= 50000) {
                                                    sampleSaldo -= Transfer; //saldo = saldo + masukan
                                                    System.out.println("-----------------------------------------------");
                                                    System.out.println("|         TRANSFER ANDA TELAH BERHASIL         |");
                                                    System.out.println("|                 INFO SALDO                  |");
                                                    System.out.println("|                                             |");
                                                    System.out.println("     Saldo anda saat ini adalah Rp. "+ sampleSaldo +"  ");
                                                    System.out.println("|                                             |");
                                                    System.out.println("|       1. Kembali             2. Keluar      |");
                                                    System.out.println("-----------------------------------------------");
                                                    int pilihanSelesai3;
                                                        do {
                                                            System.out.print("Masukkan Pilihan (1 or 2): ");
                                                            pilihanSelesai3 = input.nextInt();
                                                            input.nextLine(); // Consume the newline character
                                                        } while (pilihanSelesai3 != 1 && pilihanSelesai3 != 2);
                                            
                                                        if (pilihanSelesai3 == 2) {
                                                            System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                                            System.exit(0);
                                                        }
                                                } else {
                                                     System.out.println("Transaksi gagal, minimal transaksi 50000");
                                                }
                                            } else {
                                                System.out.println("Transaksi gagal, Saldo anda tidak cukup");
                                            }

                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|          PIN YANG ANDA MASUKKAN SALAH       |");
                                            System.out.println("|                                             |");
                                            System.out.println("|             MOHON TELITI KEMBALI            |");
                                            System.out.println("-----------------------------------------------");
                                        }
                                    case 'n':
                                        break;
                                }
                                if (respon3 == 'y') {

                                } else if (respon3 == 'n') {
                                    // kembali ke menu
                                }
                            break;
                            case 4:
                                // Pembayaran VA
                                String[][] dataVA = {
                                    {"VA12345", "Shopee", "100000"},
                                    {"VA67890", "Tokopedia", "150000"},
                                    {"VA54321", "Kai Tiket", "200000"}
                                };
                        
                                System.out.print("Masukkan nomor Virtual Account (VA): ");
                                String inputNomorVA = input.next();
                        
                                int indexVA = -1;
                        
                                for (int i = 0; i < dataVA.length; i++) {
                                    if (dataVA[i][0].equals(inputNomorVA)) {
                                        indexVA = i;
                                        break;
                                    }
                                }
                        
                                if (indexVA != -1) {
                                    String namaPemilikVA = dataVA[indexVA][1];
                                    double saldoVA = Double.parseDouble(dataVA[indexVA][2]);
                        
                                    System.out.println("-----------------------------------");
                                    System.out.println("|         VIRTUAL ACCOUNT         |");
                                    System.out.println("-----------------------------------");
                                    System.out.println("    Nama Pemilik VA: " + namaPemilikVA);
                                    System.out.println("    Pembayaran VA sebesar: " + saldoVA);
                                    System.out.println("-----------------------------------");
                                    System.out.println("| Keterangan :                    |");
                                    System.out.println("| - Jika benar ketik 'y'          |");
                                    System.out.println("| - Jika salah klik 'n'           |");
                                    System.out.println("-----------------------------------");
                        
                                    char respon = input.next().charAt(0);
                                    switch (respon) {
                                        case 'y':
                        
                                        // konfirmasi pin
                                        System.out.println("Masukkan konfirmasi pin anda");
                                        int inputPin = input.nextInt();
                                        
                                        if (inputPin == samplePin) {
                                    
                                            // Ambil nominal pembayaran dari data VA
                                            double jumlahPembayaran = saldoVA;
                        
                                            if (jumlahPembayaran <= saldoVA) {
                                                saldoVA -= jumlahPembayaran;
                                                dataVA[indexVA][2] = String.valueOf(saldoVA);
                                                System.out.println("---------------------------------------------------------------");
                                                System.out.println("|                       TRANSAKSI BERHASIL                    |");
                                                System.out.println("---------------------------------------------------------------");
                                                System.out.println("  Pembayaran sebesar " + jumlahPembayaran + " berhasil dilakukan.");
                                                System.out.println("  Sisa saldo VA Anda: " + saldoVA);
                                                System.out.println("---------------------------------------------------------------");
                                            } else {
                                              System.out.println("Saldo VA tidak mencukupi untuk melakukan pembayaran.");
                                            } 
                                        }
                                    }        
                                } else {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                    System.out.println("|                                             |");
                                    System.out.println("|              NOMOR VA TIDAK VALID           |");
                                    System.out.println("|                                             |");
                                    System.out.println("|              MOHON TELITI KEMBALI           |");
                                    System.out.println("-----------------------------------------------");
                                }
                        
                                System.out.println("Terima kasih telah menggunakan mesin ATM.");
                                System.out.println("Mohon maaf, Sementara waktu fitur tidak dapat diakses");
                                break;
                            case 5:
                                // SEDEKAH
                                System.out.println("-----------------------------------------------");
                                System.out.println("|              SELAMAT BERSEDEKAH             |");
                                System.out.println("|            Silahkan Pilih Sedekah           |");
                                System.out.println("|                                             |");
                                System.out.println("|   1. BAZNAS                 4. DigiZakat    |");
                                System.out.println("|   2. KPRB                   5. LAMZIZ       |");
                                System.out.println("|   3. Dompet DHUAFA                          |");
                                System.out.println("-----------------------------------------------");

                                String[] donationOptions = {
                                    "BAZNAS", "KPRB", "Dompet DHUAFA", "DigiZakat", "LAMZIZ"
                                };

                                System.out.println("Pilih sedekah");
                                int pilihanSedekah = input.nextInt();

                                if (pilihanSedekah < 1 || pilihanSedekah > donationOptions.length) {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|                !! WARNING !!                |");
                                    System.out.println("|                                             |");
                                    System.out.println("|        Pilihan sedekah tidak tersedia       |");
                                    System.out.println("-----------------------------------------------");
                                    continue;
                                }

                                System.out.println("Masukkan sedekah yang ingin diberikan ");
                                int inputSedekah = input.nextInt();
                                // konfirmasi
                                System.out.println("-----------------------------------------------");
                                System.out.println("|   Konfirmasi Sedekah yang ingin diberikan   |");
                                System.out.println("-----------------------------------------------");
                                System.out.println("kepada  : Dompet" + donationOptions[pilihanSedekah - 1] + "");
                                System.out.println("Sebesar : Rp. "+ inputSedekah + "  \t\t  ");

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
                                        if (inputPin == samplePin) {
                                            // Code saldo tidak cukup
                                            sampleSaldo -= inputSedekah;
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|        BERSEDEKAH KEPADA Dompet DHUAFA      |");
                                            System.out.println("|                   BERHASIL                  |");
                                            System.out.println("|                                             |");
                                            System.out.println("                Sebesar Rp "+ inputSedekah);
                                            System.out.println("            Sisa saldo anda Rp "+ sampleSaldo);
                                            System.out.println("|                                             |");
                                            System.out.println("|       1. Kembali             2. Keluar      |");
                                            System.out.println("-----------------------------------------------");
                                            int pilihanSelesai5;
                                            do {
                                                System.out.print("Masukkan Pilihan (1 atau 2): ");
                                                pilihanSelesai5 = input.nextInt();
                                                input.nextLine(); // Consume the newline character
                                            } while (pilihanSelesai5 != 1 && pilihanSelesai5 != 2);
                                        
                                            if (pilihanSelesai5 == 2) {
                                                System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                                System.exit(0);
                                            }
                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! SEDEKAH GAGAL !!             |");
                                            System.out.println("|                                             |");
                                            System.out.println("|       PIN LAMA YANG ANDA MASUKKAN SALAH     |");
                                            System.out.println("-----------------------------------------------");
                                        }
                                    }else if (responSedekah == 'n') {
                                        // kembali ke menu sedekah
                                        continue;
                                    }   
                                    break;
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
                                break;
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
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|                 !! WARNING !!               |");
                                    System.out.println("|        PIN tidak valid. Akses ditolak.      |");
                                    System.out.println("-----------------------------------------------");
                                    continue;
                                }
                            
                                System.out.print("Masukkan PIN Baru Anda : ");
                                int pinBaru = input.nextInt();
                                System.out.print("Konfirmasi PIN Baru: ");
                                int confirmPin = input.nextInt();
                            
                                if (pinBaru != confirmPin) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("|                 !! WARNING !!                |");
                                    System.out.println("|              Perubahan PIN gagal             |");
                                    System.out.println("|    Pin baru dan Konfirmasi pin tidak cocok.  |");
                                    System.out.println("------------------------------------------------");
                                    
                                } else {
                                    samplePin = pinBaru; // Update the PIN
                                    System.out.println("Perubahan PIN Berhasil.");

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
                                }
                                break;
                            case 10:
                                // Help
                                System.out.println("=========================================================================================");
                                System.out.println("|                                        HELP                                           |");
                                System.out.println("=========================================================================================");
                                System.out.println("| - Gunakan Menu ke-1 jika anda ingin melakukan penarikan saldo                         |");
                                System.out.println("| - Gunakan Menu ke-2 jika anda ingin mengisi saldo                                     |");
                                System.out.println("| - Gunakan Menu ke-3 jika anda ingin melakukakan transfer sesama/berbeda nasabah       |");
                                System.out.println("| - Gunakan Menu ke-4 jika anda ingin melakukan pembayaran melalui Virtual Account (VA) |");
                                System.out.println("| - Gunakan Menu ke-5 jika anda ingin melakukan sedekah pada platform yang tersedia     |");
                                System.out.println("| - Gunakan Menu ke-6 jika anda ingin melihat nilai tukar mata uang                     |");
                                System.out.println("| - Gunakan Menu ke-7 jika ingin melihat riwayat transaksi anda                         |");
                                System.out.println("| - Gunakan Menu ke-8 jika anda ingin melihat jumlah saldo yang tersedia                |");
                                System.out.println("| - Gunakan Menu ke-9 jika ingin mengubah pin anda                                      |");
                                System.out.println("| - Saat penarikan, saldo minimal anda adalah Rp.50000                                  |");
                                System.out.println("| - Jika terdapat masalah pada mesin ATM hubungi admin (085105120605)                   |");
                                System.out.println("|                                                                                       |");
                                System.out.println("|NB : ATM masih dalam perbaikan, Terdapat beberapa fitur yang belum dapat diakses       |");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                System.out.println("|                  1. Kembali                               2. Keluar                   |");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                int pilihanSelesai10;
                                do {
                                    System.out.print("Masukkan Pilihan (1 atau 2): ");
                                    pilihanSelesai10 = input.nextInt();
                                    input.nextLine(); // Consume the newline character
                                } while (pilihanSelesai10 != 1 && pilihanSelesai10 != 2);
                            
                                if (pilihanSelesai10 == 2) {
                                    System.out.println("Terima kasih telah menggunakan ATM. Selamat tinggal!");
                                    System.exit(0);
                                }
                                break;
                            default:
                                System.out.println("Pilihan Menu tidak tersedia");
                                break;
                        }
                    }}
                
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
