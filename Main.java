
/**
 * Main
 */

// TEMPLATE INFO

// EXIT
// System.out.println("-----------------------------------------------");
// System.out.println("|       Terima kasih telah menggunakan ATM.   |");
// System.out.println("|               Selamat tinggal!              |");
// System.out.println("-----------------------------------------------");

// TRANSAKSI BERHASIL
// System.out.println("-----------------------------------------------");
// System.out.println("|             TARIK TUNAI BERHASIL            |");
// System.out.println("|                                             |");
// System.out.println("|                 INFO SALDO                  |");
// System.out.println("|    Saldo anda saat ini adalah Rp. 100000    |");
// System.out.println("|                                             |");
// System.out.println("|       1. Kembali             2. Keluar      |");
// System.out.println("-----------------------------------------------");

// KONFIRMASI
// System.out.println("-----------------------------------------------");
// System.out.println("|    Saldo yang ingin anda tarik sebesar      |");
// System.out.println("|                Rp. 100000                   |");
// System.out.println("|                                             |");
// System.out.println("-----------------------------------------------");
// System.out.println("| Keterangan :                                |");
// System.out.println("| - Jika benar ketik 'y'                      |");
// System.out.println("| - Jika salah klik 'n'                       |");
// System.out.println("-----------------------------------------------");

// MINIMAL TRANSAKSI
// System.out.println("-----------------------------------------------");
// System.out.println("|             !! TRANSAKSI GAGAL !!           |");
// System.out.println("|                                             |");
// System.out.println("|          Minimal transaksi Rp 50.000        |");
// System.out.println("-----------------------------------------------");

// SALDO TIDAK CUKUP
// System.out.println("-----------------------------------------------");
// System.out.println("|             !! TRANSAKSI GAGAL !!           |");
// System.out.println("|                                             |");
// System.out.println("|             Saldo anda tidak cukup          |");
// System.out.println("-----------------------------------------------");

// PIN SALAH
// System.out.println("-----------------------------------------------");
// System.out.println("|             !! TRANSAKSI GAGAL !!           |");
// System.out.println("|                                             |");
// System.out.println("|          Pin yang anda masukkan salah       |");
// System.out.println("-----------------------------------------------");

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Define and initialize the scanner

        // Sample account details for demonstration
        String sampleUsername = "user123";
        int samplePin = 1234;
        int sampleSaldo = 100000;

        
        String[][] history = new String[1000][1000];
        int currentSnapshot = 1;
        // Add snapshots to the history
        history[0] = new String[] { "Saldo awal", "100000" };

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
            int inputPassword = Integer.parseInt(input.nextLine());

            if ((inputUsername.equals(sampleUsername)) && (inputPassword == samplePin)) {
                System.out.println("-----------------------------------------------");
                System.out.println("|                LOGIN BERHASIL!              |");
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
                            System.out.println("                  Rp.  " + tarikTunai + "  \t\t\t  ");
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
                                                sampleSaldo -= tarikTunai; // sampleSaldo = sampleSaldo - masukan
                                                history[currentSnapshot] = new String[] { "Tarik Tunai",
                                                        "-" + tarikTunai };
                                                currentSnapshot++;
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|            TARIK TUNAI BERHASIL             |");
                                                System.out.println("|                                             |");
                                                System.out.println("|                 INFO SALDO                  |");
                                                System.out.println(
                                                        "     Saldo anda saat ini adalah Rp. " + sampleSaldo + "  ");
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
                                                    System.out
                                                            .println("-----------------------------------------------");
                                                    System.out
                                                            .println("|       Terima kasih telah menggunakan ATM.   |");
                                                    System.out
                                                            .println("|               Selamat tinggal!              |");
                                                    System.out
                                                            .println("-----------------------------------------------");
                                                    System.exit(0);
                                                }
                                            } else {
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                                System.out.println("|                                             |");
                                                System.out.println("|          Minimal transaksi Rp 50.000        |");
                                                System.out.println("-----------------------------------------------");
                                            }
                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|             Saldo anda tidak cukup          |");
                                            System.out.println("-----------------------------------------------");
                                        }

                                    } else {
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                        System.out.println("|                                             |");
                                        System.out.println("|          Pin yang anda masukkan salah       |");
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
                            System.out.println("                  Rp.  " + inputSetor + "  \t\t  ");
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
                                        if (inputSetor >= 50000) {
                                            sampleSaldo += inputSetor;
                                            history[currentSnapshot] = new String[] { "Setor Tunai", "+" + inputSetor };
                                            currentSnapshot++;
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|               SETOR BERHASIL                |");
                                            System.out.println("|                                             |");
                                            System.out.println("|                 INFO SALDO                  |");
                                            System.out.println(
                                                    "     Saldo anda saat ini adalah Rp. " + sampleSaldo + "  ");
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
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                                System.out.println("|               Selamat tinggal!              |");
                                                System.out.println("-----------------------------------------------");
                                                System.exit(0);
                                            }
                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|          Minimal transaksi Rp 50.000        |");
                                            System.out.println("-----------------------------------------------");
                                        }

                                    } else {
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                        System.out.println("|                                             |");
                                        System.out.println("|          PIN YANG ANDA MASUKKAN SALAH       |");
                                        System.out.println("|             MOHON TELITI KEMBALI            |");
                                        System.out.println("-----------------------------------------------");
                                    }
                                case 'n':
                                    break;
                            }
                            break;
                        case 3:
                            // Transfer
                            String[][] dataAccount = {
                                    { "Fajar", "123456", "BCA" },
                                    { "Yefta", "789012", "BRI" },
                                    { "Gopal", "345678", "BNI" }
                            };

                            String[][] dataBank = {
                                    { "123", "BCA" },
                                    { "456", "BRI" },
                                    { "234", "BNI" }
                            };

                            System.out.print("Masukkan nomor kode bank tujuan anda: ");
                            String kodeBankTujuan = input.next();
                            String namaBank = "";
                            int indexKodeBank = -1;

                            // Mencari nomor kode bank tujuan di dalam array

                            for (int i = 0; i < dataBank.length; i++) {
                                if (dataBank[i][0].equals(kodeBankTujuan)) {
                                    indexKodeBank = i;
                                    namaBank = dataBank[i][1];
                                    break;
                                }
                            }

                            if (indexKodeBank == -1) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                System.out.println("|                                             |");
                                System.out.println("|          NOMOR KODE BANK TIDAK VALID        |");
                                System.out.println("|              MOHON TELITI KEMBALI           |");
                                System.out.println("-----------------------------------------------");
                                break; // Hentikan eksekusi transfer karena kode bank tidak valid

                            }
                            // Input nomor rekening tujuan
                            System.out.print("Masukkan nomor rekening tujuan: ");
                            String nomorRekeningTujuan = input.next();
                            int indexRekeningTujuan = -1;

                            // Mencari nomor rekening tujuan di dalam array
                            for (int i = 0; i < dataAccount.length; i++) {
                                if (dataAccount[i][1].equals(nomorRekeningTujuan)
                                        && dataAccount[i][2].equals(namaBank)) {
                                    indexRekeningTujuan = i;
                                    break;
                                }
                            }

                            if (indexRekeningTujuan == -1) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                System.out.println("|                                             |");
                                System.out.println("|        Nomor rekening tidak ditemukan       |");
                                System.out.println("-----------------------------------------------");
                                break; // Hentikan eksekusi transfer karena nomor rekening tidak valid
                            }

                            String namaPemilikAccount = dataAccount[indexRekeningTujuan][0];
                            System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
                            double jumlahTransfer = input.nextDouble();

                            if (jumlahTransfer <= 0) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                System.out.println("|                                             |");
                                System.out.println("|           Jumlah tranfer tidak valid!       |");
                                System.out.println("-----------------------------------------------");
                                input.close();
                                return;
                            }

                            // konfirmasi
                            System.out.println("-----------------------------------------------");
                            System.out.println("|              KONFIRMASI TRANSFER             |");
                            System.out.println("-----------------------------------------------");
                            System.out.println("    Kepada  : " + namaPemilikAccount);
                            System.out.println("    Bank    : " + namaBank);
                            System.out.println("    No Rek  : " + nomorRekeningTujuan);
                            System.out.println("    Jumlah  : Rp.  " + jumlahTransfer);
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
                                        if (sampleSaldo >= jumlahTransfer) {
                                            // if (Transfer >= 50000) {
                                            sampleSaldo -= jumlahTransfer; // saldo = saldo + masukan
                                            // history[currentSnapshot] = new String[] {
                                            //         String.format("Transfer ke %s ($s) : - %s", namaPemilikAccount,
                                            //                 nomorRekeningTujuan, String.valueOf(jumlahTransfer))
                                            // };
                                            history[currentSnapshot] = new String[] {
                                                "Pembayaran ke " + namaPemilikAccount,
                                                String.valueOf("-"+jumlahTransfer) };
                                            currentSnapshot++;
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             TRANSFER  BERHASIL              |");
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|                                             |");
                                            System.out.println("    Kepada      : " + namaPemilikAccount);
                                            System.out.println("    Bank        : " + namaBank);
                                            System.out.println("    No Rek      : " + nomorRekeningTujuan);
                                            System.out.println("    Jumlah      : Rp.  " + jumlahTransfer);
                                            System.out.println("    Sisa Saldo  : Rp. " + sampleSaldo + "  ");
                                            System.out.println("|                                             |");
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|       1. Kembali             2. Keluar      |");
                                            System.out.println("-----------------------------------------------");
                                            int pilihanSelesai3;
                                            do {
                                                System.out.print("Masukkan Pilihan (1 or 2): ");
                                                pilihanSelesai3 = input.nextInt();
                                                input.nextLine(); // Consume the newline character
                                            } while (pilihanSelesai3 != 1 && pilihanSelesai3 != 2);

                                            if (pilihanSelesai3 == 2) {
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                                System.out.println("|               Selamat tinggal!              |");
                                                System.out.println("-----------------------------------------------");
                                                System.exit(0);
                                            }
                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|             Saldo anda tidak cukup          |");
                                            System.out.println("-----------------------------------------------");
                                        }

                                    } else {
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                        System.out.println("|                                             |");
                                        System.out.println("|          Pin yang anda masukkan salah       |");
                                        System.out.println("-----------------------------------------------");
                                    }
                                case 'n':
                                    break;
                            }

                            break;
                        case 4:
                            // Pembayaran VA
                            String[][] dataVA = {
                                    { "VA12345", "Shopee", "100000" },
                                    { "VA67890", "Tokopedia", "150000" },
                                    { "VA54321", "Kai Tiket", "200000" }
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
                                int jumlahPembayaran = Integer.parseInt(dataVA[indexVA][2]);

                                System.out.println("-----------------------------------");
                                System.out.println("|         VIRTUAL ACCOUNT         |");
                                System.out.println("-----------------------------------");
                                System.out.println("  Nama Pemilik VA: " + namaPemilikVA);
                                System.out.println("  Pembayaran VA sebesar: Rp " + jumlahPembayaran);
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

                                            if (sampleSaldo >= jumlahPembayaran) {
                                                sampleSaldo -= jumlahPembayaran;

                                                history[currentSnapshot] = new String[] {
                                                        "Pembayaran ke " + namaPemilikVA,
                                                        String.valueOf("-"+jumlahPembayaran) };
                                                currentSnapshot++;
                                                dataVA[indexVA][2] = String.valueOf(jumlahPembayaran);
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|             TRANSAKSI BERHASIL               |");
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("  Nama VA       : " + namaPemilikVA);
                                                System.out.println("  Pembayaran VA : Rp " + jumlahPembayaran);
                                                System.out.println("  Sisa saldo    : Rp " + sampleSaldo);
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|       1. Kembali             2. Keluar      |");
                                                System.out.println("-----------------------------------------------");
                                                int pilihanSelesai4;
                                                do {
                                                    System.out.print("Masukkan Pilihan (1 or 2): ");
                                                    pilihanSelesai4 = input.nextInt();
                                                    input.nextLine(); // Consume the newline character
                                                } while (pilihanSelesai4 != 1 && pilihanSelesai4 != 2);

                                                if (pilihanSelesai4 == 2) {
                                                    System.out.println("-----------------------------------------------");
                                                    System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                                    System.out.println("|               Selamat tinggal!              |");
                                                    System.out.println("-----------------------------------------------");
                                                    System.exit(0);
                                                }
                                            } else {
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                                System.out.println("|                                             |");
                                                System.out.println("|             Saldo anda tidak cukup          |");
                                                System.out.println("-----------------------------------------------");
                                            }
                                        } else {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                            System.out.println("|                                             |");
                                            System.out.println("|          Pin yang anda masukkan salah       |");
                                            System.out.println("-----------------------------------------------");
                                        }
                                }
                            } else {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                System.out.println("|                                             |");
                                System.out.println("|              NOMOR VA TIDAK VALID           |");
                                System.out.println("|              MOHON TELITI KEMBALI           |");
                                System.out.println("-----------------------------------------------");
                            }
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
                            if (inputSedekah <= 0) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                System.out.println("|                                             |");
                                System.out.println("|           JUMLAH SEDEKAH TIDAK VALID        |");
                                System.out.println("|              MOHON TELITI KEMBALI           |");
                                System.out.println("-----------------------------------------------");
                                continue;
                            }
                            // konfirmasi
                            System.out.println("-----------------------------------------------");
                            System.out.println("|   Konfirmasi Sedekah yang ingin diberikan   |");
                            System.out.println("-----------------------------------------------");
                            System.out.println("    kepada  : Dompet" + donationOptions[pilihanSedekah - 1] + "");
                            System.out.println("    Sebesar : Rp. " + inputSedekah + "  \t\t  ");

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
                                    if (inputSedekah <= sampleSaldo) {
                                        sampleSaldo -= inputSedekah;
                                        history[currentSnapshot] = new String[] { "Bersedekah", "-" + inputSedekah };
                                        currentSnapshot++;
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|                SEDEKAH BERHASIL             |");
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("    kepada  : Dompet" + donationOptions[pilihanSedekah - 1] + "");
                                        System.out.println("    Sebesar Rp " + inputSedekah);
                                        System.out.println("    Sisa saldo anda Rp " + sampleSaldo);
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|       1. Kembali             2. Keluar      |");
                                        System.out.println("-----------------------------------------------");
                                        int pilihanSelesai5;
                                        do {
                                            System.out.print("Masukkan Pilihan (1 atau 2): ");
                                            pilihanSelesai5 = input.nextInt();
                                            input.nextLine(); // Consume the newline character
                                        } while (pilihanSelesai5 != 1 && pilihanSelesai5 != 2);

                                        if (pilihanSelesai5 == 2) {
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                            System.out.println("|               Selamat tinggal!              |");
                                            System.out.println("-----------------------------------------------");
                                            System.exit(0);
                                        }
                                    } else {
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                        System.out.println("|                                             |");
                                        System.out.println("|             Saldo anda tidak cukup          |");
                                        System.out.println("-----------------------------------------------");
                                    }
                                } else {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                                    System.out.println("|                                             |");
                                    System.out.println("|          Pin yang anda masukkan salah       |");
                                    System.out.println("-----------------------------------------------");
                                }
                            } else if (responSedekah == 'n') {
                                // kembali ke menu sedekah
                                continue;
                            }
                            break;
                        case 6:
                            // Info Kurs
                            double kursBeliUSD = 15000;
                            double kursJualUSD = 15000;
                            System.out.println("--------------------------------- ");
                            System.out.println("|            INFO KURS           |");
                            System.out.println("--------------------------------- ");
                            System.out.println("   => USD");
                            System.out.println("   Beli : " + kursBeliUSD);
                            System.out.println("   Jual : " + kursJualUSD);

                            System.out.println("\nApakah ingin konversi KURS (y/n)?");
                            char konversiKurs = input.next().charAt(0);
                            if (konversiKurs == 'y') {
                                System.out.println("Masukkan jumlah(Rupiah) yang ingin dikonversi ke USD");
                                System.out.print("Masukkan jumlah Rupiah: Rp ");
                                int inputKurs = input.nextInt();
                                System.out.println("1. Beli : " + inputKurs / kursBeliUSD);
                                System.out.println("2. Jual : " + inputKurs / kursJualUSD);
                            }

                            System.out.println("\n---------------------------------");
                            System.out.println("|   1. Kembali    2. Keluar      |");
                            System.out.println("--------------------------------- ");

                            int pilihanSelesai6;
                            do {
                                System.out.print("Masukkan Pilihan (1 atau 2): ");
                                pilihanSelesai6 = input.nextInt();
                                input.nextLine(); // Consume the newline character
                            } while (pilihanSelesai6 != 1 && pilihanSelesai6 != 2);

                            if (pilihanSelesai6 == 2) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                System.out.println("|               Selamat tinggal!              |");
                                System.out.println("-----------------------------------------------");
                                System.exit(0);
                            }
                            break;
                        case 7:
                            // Get the number of snapshots stored
                            int numSnapshots = currentSnapshot;

                            System.out.println("Transaction History: " + numSnapshots);
                            // Print all snapshots
                            System.out.println("History:");
                            for (int i = 0; i < currentSnapshot; i++) {
                                System.out.println(history[i][0] + " : " + history[i][1]);
                            }
                            System.out.println("\n---------------------------------");
                            System.out.println("|   1. Kembali    2. Keluar      |");
                            System.out.println("--------------------------------- ");

                            int pilihanSelesai7;
                            do {
                                System.out.print("Masukkan Pilihan (1 atau 2): ");
                                pilihanSelesai7 = input.nextInt();
                                input.nextLine(); // Consume the newline character
                            } while (pilihanSelesai7 != 1 && pilihanSelesai7 != 2);

                            if (pilihanSelesai7 == 2) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                System.out.println("|               Selamat tinggal!              |");
                                System.out.println("-----------------------------------------------");
                                System.exit(0);
                            }
                            break;
                        case 8:
                            // CEK SALDO
                            System.out.println("-----------------------------------------------");
                            System.out.println("|                 INFO SALDO                  |");
                            System.out.println("|                                             |");
                            System.out.println("       SALDO ANDA SEBESAR : Rp " + sampleSaldo + "     ");
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
                                System.out.println("-----------------------------------------------");
                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                System.out.println("|               Selamat tinggal!              |");
                                System.out.println("-----------------------------------------------");
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
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                    System.out.println("|               Selamat tinggal!              |");
                                    System.out.println("-----------------------------------------------");
                                    System.exit(0);
                                }
                            }
                            break;
                        case 10:
                            // Help
                            System.out.println(
                                    "=========================================================================================");
                            System.out.println(
                                    "|                                        HELP                                           |");
                            System.out.println(
                                    "=========================================================================================");
                            System.out.println(
                                    "| - Gunakan Menu ke-1 jika anda ingin melakukan penarikan saldo                         |");
                            System.out.println(
                                    "| - Gunakan Menu ke-2 jika anda ingin mengisi saldo                                     |");
                            System.out.println(
                                    "| - Gunakan Menu ke-3 jika anda ingin melakukakan transfer sesama/berbeda nasabah       |");
                            System.out.println(
                                    "| - Gunakan Menu ke-4 jika anda ingin melakukan pembayaran melalui Virtual Account (VA) |");
                            System.out.println(
                                    "| - Gunakan Menu ke-5 jika anda ingin melakukan sedekah pada platform yang tersedia     |");
                            System.out.println(
                                    "| - Gunakan Menu ke-6 jika anda ingin melihat nilai tukar mata uang                     |");
                            System.out.println(
                                    "| - Gunakan Menu ke-7 jika ingin melihat riwayat transaksi anda                         |");
                            System.out.println(
                                    "| - Gunakan Menu ke-8 jika anda ingin melihat jumlah saldo yang tersedia                |");
                            System.out.println(
                                    "| - Gunakan Menu ke-9 jika ingin mengubah pin anda                                      |");
                            System.out.println(
                                    "| - Untuk tarik dan setor tunai, minimal transaksi sebesar Rp.50000                     |");
                            System.out.println(
                                    "| - Jika terdapat masalah pada mesin ATM hubungi admin (085105120605)                   |");
                            System.out.println(
                                    "|                                                                                       |");
                            System.out.println(
                                    "-----------------------------------------------------------------------------------------");
                            System.out.println(
                                    "|                  1. Kembali                               2. Keluar                   |");
                            System.out.println(
                                    "-----------------------------------------------------------------------------------------");
                            int pilihanSelesai10;
                            do {
                                System.out.print("Masukkan Pilihan (1 atau 2): ");
                                pilihanSelesai10 = input.nextInt();
                                input.nextLine(); // Consume the newline character
                            } while (pilihanSelesai10 != 1 && pilihanSelesai10 != 2);

                            if (pilihanSelesai10 == 2) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("|       Terima kasih telah menggunakan ATM.   |");
                                System.out.println("|               Selamat tinggal!              |");
                                System.out.println("-----------------------------------------------");
                                System.exit(0);
                            }
                            break;
                        default:
                            System.out.println("Pilihan Menu tidak tersedia");
                            break;
                    }
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
                System.out.println("|     Sisa percobaan kurang " + loginAttempts + " kali lagi\t      |");
                System.out.println("|        NB : Maksimal percobaan 3 kali       |");
                System.out.println("-----------------------------------------------");
            }
        }
        System.out.println("Anda telah melampaui upaya login maksimum. Akun Anda terkunci. Hubungi Admin");
    }
}
