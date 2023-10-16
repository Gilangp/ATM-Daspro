import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int saldo = 5000,selesai1,selesai2 = 0,selesai3 = 0,selesai4,selesai5 = 0 ,selesai6,selesai7, selesai8, selesai9 = 0, selesai10;
        int pin = 123456;
        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    // SEBELUM LOGIN
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                 SELAMAT DATANG              |");
                    System.out.println("|                                             |");
                    System.out.println("|                 SILAHKAN LOGIN              |");
                    System.out.println("|           SEBELUM MELAKUKAN TRANSAKSI       |");
                    System.out.println("|                                             |");
                    System.out.println("-----------------------------------------------");
                    
                    break;
                    
                case 2:
                    break;
            }
            System.out.println("masukkan username: ");
            String username = input.nextLine();
            System.out.println("masukkan password: ");
            int password = Integer.parseInt (input.nextLine());
            
            boolean login = false;
            if( (username.equals("admin")) && (password==pin) ){
                login = true;
                while (login == true) {
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
                            break;
                        case 2:
                            // SETOR TUNAI
                            do {
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
                                switch (respon) {
                                    case 'y':
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
                                            System.out.println("|       1. Kembali             2. Keluar      |");
                                            System.out.println("-----------------------------------------------");
                                            selesai2 = input.nextInt();
                                            switch (selesai2) {
                                            case 2:
                                            System.exit(0);
                                            break;
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
                                if (respon == 'y') {
                                    
                                }else if (respon == 'n') {
                                    // kembali ke menu
                                }
                            } while (selesai2 != 1);
                            break;
                        case 3:
                            // Transfer
                            do {
                                String namaTujuan;
                                int Transfer, noRekening;

                                // input
                                System.out.println("Masukkan nama yang akan anda tranfer");
                                namaTujuan = input.next();
                                System.out.println("Masukkan No Rekening tujuan anda");
                                noRekening = input.nextInt();
                                System.out.println("Masukkan jumlah uang yang ingin di tranfer");
                                Transfer = input.nextInt();

                                // konfirmasi
                                System.out.println("-----------------------------------------------");
                                System.out.println("|              KONFIRMASI TRANFER             |");
                                System.out.println("|                                             |");
                                System.out.println("|           Kepada : "+ namaTujuan + "\t\t      |");
                                System.out.println("|           No Rek : "+ noRekening + " \t\t      |");
                                System.out.println("|           Jumlah : Rp.  "+ Transfer + "\t\t |");
                                System.out.println("|                                             |");
                                System.out.println("-----------------------------------------------");
                                System.out.println("| Keterangan :                                |");
                                System.out.println("| - Jika benar ketik 'y'                      |");
                                System.out.println("| - Jika salah klik 'n'                       |");
                                System.out.println("-----------------------------------------------");

                                char respon = input.next().charAt(0);
                                switch (respon) {
                                    case 'y':
                                        saldo -= Transfer; //saldo = saldo + masukan

                                        // konfirmasi pin
                                        System.out.println("Masukkan konfirmasi pin anda");
                                        int inputPin = input.nextInt();

                                        if (inputPin == pin) {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|         TRANFER ANDA TELAH BERHASIL         |");
                                            System.out.println("|                 INFO SALDO                  |");
                                            System.out.println("|                                             |");
                                            System.out.println("     Saldo anda saat ini adalah Rp. "+ saldo +"  ");
                                            System.out.println("|                                             |");
                                            System.out.println("|       1. Kembali             2. Keluar      |");
                                            System.out.println("-----------------------------------------------");
                                            selesai3 = input.nextInt();
                                            switch (selesai3) {
                                            case 3:
                                            System.exit(0);
                                            break;
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
                                if (respon == 'y') {

                                } else if (respon == 'n') {
                                    // kembali ke menu
                                }
                            } while (selesai3 != 1 && selesai3 != 2);
                            break;
                        case 4:
                            // Pembayaran
                            break;
                        case 5:
                            // SEDEKAH
                            do {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|              SELAMAT BERSEDEKAH             |");
                                System.out.println("|            Silahkan Pilih Sedekah           |");
                                System.out.println("|                                             |");
                                System.out.println("|   1. BAZNAS                 4. DigiZakat    |");
                                System.out.println("|   2. KPRB                   5. LAMZIZ       |");
                                System.out.println("|   3. Dompet DHUAFA                          |");
                                System.out.println("-----------------------------------------------");

                                System.out.println("Pilih sedekah");
                                int pilihanSedekah = input.nextInt();
                                System.out.println("Masukkan sedekah yang ingin diberikan ");
                                int inputSedekah = input.nextInt();
                                // konfirmasi
                                System.out.println("-----------------------------------------------");
                                System.out.println("|     Sedekah yang akan diberikan sebesar     |");
                                System.out.println("|         kepada Dompet DHUAFA sebesar        |");
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
                                    if (inputPin == pin) {
                                        saldo -= inputSedekah;
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|        BERSEDEKAH KEPADA Dompet DHUAFA      |");
                                        System.out.println("|                   BERHASIL                  |");
                                        System.out.println("|                                             |");
                                        System.out.println("                Sebesar Rp "+ inputSedekah);
                                        System.out.println("            Sisa saldo anda Rp "+ saldo);
                                        System.out.println("|                                             |");
                                        System.out.println("|       1. Kembali             2. Keluar      |");
                                        System.out.println("-----------------------------------------------");
                                        selesai5 = input.nextInt();
                                            switch (selesai5) {
                                                case 1:
                                                    // Kembali ke halaman menu
                                                    break;
                                                case 2:
                                                    // Kembali ke layar login
                                                    i=1;
                                                    login = false;
                                                    break;}
                                    } else {
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|             !! SEDEKAH GAGAL !!             |");
                                        System.out.println("|                                             |");
                                        System.out.println("|       PIN LAMA YANG ANDA MASUKKAN SALAH     |");
                                        System.out.println("-----------------------------------------------");
                                        break;
                                    }
                                }else if (responSedekah == 'n') {
                                    // kembali ke menu sedekah
                                    continue;
                                }
                            } while (selesai5 != 1 && selesai5 != 2);
                            break;
                        case 6:
                            // Info Kurs
                            do {
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
                                selesai6 = input.nextInt();
                                        switch (selesai6) {
                                            case 1:
                                                // Kembali ke halaman menu
                                                break;
                                            case 2:
                                                // Kembali ke layar login
                                                i=1;
                                                login = false;
                                                break;}
                            } while (selesai6 != 1 && selesai6 != 2);
                            break;
                        case 7:
                            // Riwayat Transaksi
                            do {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|               RIWAYAT TRANSAKSI             |");
                                System.out.println("|                                             |");
                                System.out.println("|                    MASUKAN                  |");
                                System.out.println("|                 Rp 15,345.00                |");
                                System.out.println("|                                             |");
                                System.out.println("|                   KELUARAN                  |");
                                System.out.println("|                 Rp 11,281.89                |");
                                System.out.println("|                                             |");
                                System.out.println("|       1. Kembali             2. Keluar      |");
                                System.out.println("-----------------------------------------------");
                                selesai7 = input.nextInt();
                                    switch (selesai7) {
                                        case 1:
                                            // Kembali ke halaman menu
                                            break;
                                        case 2:
                                            // Kembali ke layar login
                                            i=1;
                                            login = false;
                                            break;}
                            } while (selesai7 != 1 && selesai7 != 2);
                            break;
                        case 8:
                            // CEK SALDO
                            do {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                 INFO SALDO                  |");
                                System.out.println("|                                             |");
                                System.out.println("       SALDO ANDA SEBESAR : Rp "+ saldo + "     ");
                                System.out.println("|                                             |");
                                System.out.println("|       1. Kembali             2. Keluar      |");
                                System.out.println("-----------------------------------------------");
                                selesai8 = input.nextInt();
                                switch (selesai8) {
                                    case 1:
                                        // Kembali ke halaman menu
                                        break;
                                    case 2:
                                        // Kembali ke layar login
                                        i=1;
                                        login = false;
                                        break;}
                            } while (selesai8 != 1 && selesai8 != 2);
                            break;
                        case 9:
                        // UBAH PIN
                        System.out.println("-----------------------------------------------");
                        System.out.println("|                 UBAH PIN                    |");
                        System.out.println("-----------------------------------------------");
                            do {
                                    System.out.print("masukan pin lama anda : ");
                                    int pinLama = input.nextInt();
                                    if (pinLama == pin) {
                                        boolean konfirmasiPin = false;
                                        while (konfirmasiPin == false){
                                            System.out.print("masukan pin baru anda : ");
                                            int pinBaru = input.nextInt();
                                            if (pinBaru == pin) {
                                                
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|                !! WARNINGG !!               |");
                                                System.out.println("|                                             |");
                                                System.out.println("|     PIN ANDA SUDAH SAMA DENGAN PIN LAMA     |");
                                                System.out.println("|                                             |");
                                                System.out.println("|             MOHON TELILI KEMBALI            |");
                                                System.out.println("-----------------------------------------------");
                                                konfirmasiPin = false;
                                                continue;
                                            }
                                            System.out.println("masukkan konfirmasi pin baru anda");
                                            int pinBaruKonfirmasi = input.nextInt();
                                                if (pinBaru == pinBaruKonfirmasi) {
                                                    konfirmasiPin = true;
                                                    pin = pinBaru;
                                                        System.out.println("-----------------------------------------------");
                                                        System.out.println("|           ~  UBAH PIN BERHASIL  ~           |");
                                                        System.out.println("|                                             |");
                                                        System.out.println("|       1. Kembali             2. Keluar      |");
                                                        System.out.println("-----------------------------------------------");
                                                        selesai9 = input.nextInt();
                                                        switch (selesai9) {
                                                            case 1:
                                                                // Kembali ke halaman menu
                                                                break;
                                                            case 2:
                                                                // Kembali ke layar login
                                                                i=1;
                                                                login = false;
                                                                break;}
                                                }else {
                                                        System.out.println("-----------------------------------------------");
                                                        System.out.println("|                !! WARNINGG !!               |");
                                                        System.out.println("|                                             |");
                                                        System.out.println("|     PIN BARU DENGAN KONFIRMASI PIN BARU     |");
                                                        System.out.println("|               ~  TIDAK SAMA  ~              |");
                                                        System.out.println("|                                             |");
                                                        System.out.println("| ! PIN BARU DAN KONFIRMASI PIN HARUS SAMA  ! |");
                                                        System.out.println("|             MOHON TELILI KEMBALI            |");
                                                        System.out.println("-----------------------------------------------");
                                                }
                                        }
                                    }else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|            !! UBAH PIN GAGAL !!             |");
                                            System.out.println("|                                             |");
                                            System.out.println("|       PIN LAMA YANG ANDA MASUKKAN SALAH     |");
                                            System.out.println("-----------------------------------------------");
                                    }
                                
                            } while (selesai9 != 1 && selesai9 != 2);
                                break;
                        case 10:
                            // Help
                            do {
                                System.out.println("==============================================================================================================");
                                System.out.println("|                                                  Help                                                      |");
                                System.out.println("==============================================================================================================");
                                System.out.println("| 1. Gunakan Menu ke-1 jika anda ingin melakukan penarikan saldo                                             |");
                                System.out.println("| 2. Gunakan Menu ke-2 jika anda ingin mengisi saldo                                                         |");
                                System.out.println("| 3. Gunakan Menu ke-3 jika anda ingin melakukakan transfer sesama/berbeda nasabah                           |");
                                System.out.println("| 4. Gunakan Menu ke-4 jika anda ingin melakukan pembayaran melalui Virtual Account (VA)                     |");
                                System.out.println("| 6. Gunakan Menu ke-5 jika anda ingin melakukan sedekah pada platform yang tersedia                         |");
                                System.out.println("| 7. Gunakan Menu ke-6 jika anda ingin melihat nilai tukar mata uang                                         |");
                                System.out.println("| 8. Gunakan Menu ke-7 jika ingin melihat riwayat transaksi anda                                             |");
                                System.out.println("| 9. Gunakan Menu ke-8 jika anda ingin melihat jumlah saldo yang tersedia                                    |");
                                System.out.println("| 10. Gunakan Menu ke-9 jika ingin mengubah pin anda                                                         |");
                                System.out.println("| 7. Saat penarikan, saldo minimal anda adalah Rp.50000                                                      |");
                                System.out.println("| 8. Jika terdapat masalah pada mesin ATM hubungi 021-5437xxx                                                |");
                                System.out.println("|                                     ATM MASIH DALAM PERBAIKAN                                              |");
                                System.out.println("--------------------------------------------------------------------------------------------------------------");
                                System.out.println("|                           1. Kembali                                2. Keluar                              |");
                                System.out.println("--------------------------------------------------------------------------------------------------------------");
                                selesai10 = input.nextInt();
                                    switch (selesai10) {
                                        case 1:
                                            // Kembali ke halaman menu
                                            break;
                                        case 2:
                                            // Kembali ke layar login
                                            i=1;
                                            login = false;
                                            break;}
                                } while (selesai10 != 1 && selesai10 != 2);
                            break;
                    }
                }
            }
            else {
                // Jika login gagal
                System.out.println("-----------------------------------------------");
                System.out.println("|              !! LOGIN GAGAL !!              |");
                System.out.println("|                                             |");
                System.out.println("|   USERNAME / PIN YANG ANDA MASUKKAN SALAH   |");
                System.out.println("|                                             |");
                System.out.println("|           Anda sudah mencoba " + i + " kali \t      |");
                System.out.println("|        NB : Maksimal percobaan 3 kali       |");
                System.out.println("-----------------------------------------------");
            }
        }
    }
}