
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

    private static Scanner input = new Scanner(System.in); // Define and initialize the scanner object

    private static double kursBeliUSD = 15000;
    private static double kursJualUSD = 15000;
    private static String[][] dataAccount = {
            { "Fajar", "admin", "11223344", "11223344" },
            { "Yefta", "user", "1234", "123", "1000000", "BRI", "Active" },
            { "Gopal", "user", "4567", "456", "500000", "BCA", "Active" },
            { "Gilang", "user", "7890", "789", "250000", "BNI", "Active" },
            { "Prabowo", "user", "1212", "121", "150000", "Mandiri", "Active" },
            { "Jokowi", "user", "1313", "131", "550000", "CIMB", "Active" },
            { "Jackie Chan", "user", "1414", "141", "150000", "BCA", "Active" },
    };

    static boolean[] menuAktif = { true, true, true, true, true, true, true, true, true, true };
    static Scanner sc = new Scanner(System.in);

    // public static void main(String[] args) {
    int maxAttempts = 3;
    boolean isLoginIn = false;

    static int findAccount(String accountNumber, String pin) {
        for (int i = 0; i < dataAccount.length; i++) {
            if (dataAccount[i][2].equals(accountNumber) && dataAccount[i][3].equals(pin)) {
                return i;
            }
        }
        return -1;
    }

    static void showAdminMenu(int accountIndex) {
        System.out.println("menu bagian admin");
    }

    static void showUserMenu(int accountIndex) {
        System.out.println("menu bagian user");
    }

    private static String[][] history = new String[1000][2];
    private static int currentSnapshot = 1;

    public static void main(String[] args) {
        // Menambah Riwayat pertama
        history[0] = new String[] { "Saldo awal", "100000" };

        // SELAMAT DATANG
        System.out.println("-----------------------------------------------");
        System.out.println("|             SELAMAT DATANG di ATM           |");
        System.out.println("-----------------------------------------------");

        int maxAttempts = 3;
        boolean isLoginIn = false;

        while (maxAttempts > 0 && !isLoginIn) {
            System.out.println("-----------------------------------------------");
            System.out.println("|                 SILAHKAN LOGIN              |");
            System.out.println("|           SEBELUM MELAKUKAN TRANSAKSI       |");
            System.out.println("-----------------------------------------------");

            System.out.print("Masukkan Nomor Rekening Anda: ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan Pin: ");
            String inputPin = sc.nextLine();

            int indexAkun = findAccount(noRek, inputPin);

            if (indexAkun != -1) {
                if (dataAccount[indexAkun][6].equals("Blocked")) {
                    System.out.println("Akun Anda terkunci. Hubungi Admin.");
                    break;
                }
                isLoginIn = true;
                String accountType = dataAccount[indexAkun][1];
                System.out.println(accountType);
                System.out.println("-----------------------------------------------");
                System.out.println("|                LOGIN BERHASIL!              |");
                System.out.println("-----------------------------------------------");

                if (accountType.equals("admin")) {
                    showAdminMenu(indexAkun);
                } else if (accountType.equals("user")) {

                    tampilUserMenu(indexAkun);
                }
            } else {
                maxAttempts--;
                if (maxAttempts > 0) {
                    // Jika login gagal
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              !! LOGIN GAGAL !!              |");
                    System.out.println("|                                             |");
                    System.out.println("|   USERNAME / PIN YANG ANDA MASUKKAN SALAH   |");
                    System.out.println("|                                             |");
                    System.out.println("|     Sisa percobaan kurang " + maxAttempts + " kali lagi\t      |");
                    System.out.println("|        NB : Maksimal percobaan 3 kali       |");
                    System.out.println("-----------------------------------------------");
                } else {
                    dataAccount[indexAkun][6] = "Blocked";
                    System.out.println("Anda telah melampaui upaya login maksimum. Akun Anda terkunci. Hubungi Admin");
                }
            }
        }
        sc.close();
    }

    // Function tampilUserMenu
    private static void tampilAdminMenu() {
        // Tampil Admin menu
    }

    // Function tampilUserMenu
    static void tampilUserMenu(int indexAkun) {
        while (true) {
            int sampleSaldo = Integer.parseInt(dataAccount[indexAkun][4]);
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
                    char responsTarik = konfirmasi(input);
                    switch (responsTarik) {
                        case 'y':
                        System.out.println("Masukkan konfirmasi pin anda");
                        int inputPin = input.nextInt();
                    
                        if (isPinValid(inputPin, indexAkun)) {
                                if (tarikTunai < sampleSaldo) {
                                    if (tarikTunai >= 50000) {
                                        
                                        sampleSaldo -= tarikTunai; // sampleSaldo = sampleSaldo - masukan
                                        dataAccount[indexAkun][4] = String.valueOf(sampleSaldo);

                                        history[currentSnapshot] = new String[] { "Tarik Tunai",
                                                "-" + tarikTunai };
                                        currentSnapshot++;
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("|            TARIK TUNAI BERHASIL             |");
                                        System.out.println("|                                             |");
                                        System.out.println("|                 INFO SALDO                  |");
                                        System.out.println(
                                                "     Saldo anda saat ini adalah Rp. " + sampleSaldo + "  ");
                                        System.out.println("-----------------------------------------------");
                                        kembaliAtauKeluar(input);
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
                    char responsSetor = konfirmasi(input);
                    switch (responsSetor) {
                        case 'y':

                            // konfirmasi pin
                            System.out.println("Masukkan konfirmasi pin anda");
                            int inputPin = input.nextInt();
                        
                            if (isPinValid(inputPin, indexAkun)) {
                                if (inputSetor >= 50000) {
                                    sampleSaldo += inputSetor;
                                    dataAccount[indexAkun][4] = String.valueOf(sampleSaldo);

                                    history[currentSnapshot] = new String[] { "Setor Tunai", "+" + inputSetor };
                                    currentSnapshot++;
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("|               SETOR BERHASIL                |");
                                    System.out.println("|                                             |");
                                    System.out.println("|                 INFO SALDO                  |");
                                    System.out.println(
                                            "     Saldo anda saat ini adalah Rp. " + sampleSaldo + "  ");
                                    System.out.println("-----------------------------------------------");
                                    kembaliAtauKeluar(input);
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
                    String[][] dataBank = {
                            { "123", "BCA" },
                            { "456", "BRI" },
                            { "234", "BNI" },
                            { "567", "Mandiri"},
                            { "789", "CIMB"}
                    };
                    
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              KODE BANK TUJUAN               |");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < dataBank.length; i++) {
                    System.out.println((i + 1) + ". " + dataBank[i][1] + " (" + dataBank[i][0] + ")");
                    }
                    System.out.println("-----------------------------------------------");
                    System.out.println("Masukkan nomor kode bank tujuan anda: ");
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
                        if (dataAccount[i][1].equals("user")  // Hanya mencari akun user
                                && !dataAccount[i][0].equals(dataAccount[indexAkun][0])  // Bukan rekening sendiri
                                && dataAccount[i][2].equals(nomorRekeningTujuan)
                                && dataAccount[i][5].equals(namaBank)) {
                            indexRekeningTujuan = i;
                            break;
                        }
                    }

                    if (indexRekeningTujuan == -1) {
                        System.out.println("-----------------------------------------------");
                        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
                        System.out.println("|                                             |");
                        System.out.println("|           Nomor rekening tidak valid        |");
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

                    char responsTransfer = konfirmasi(input);
                    switch (responsTransfer) {
                        case 'y':

                            // konfirmasi pin
                            System.out.println("Masukkan konfirmasi pin anda");
                            int inputPin = input.nextInt();
                        
                            if (isPinValid(inputPin, indexAkun)) {
                                // Code saldo tidak cukup
                                if (sampleSaldo >= jumlahTransfer) {
                                    // if (Transfer >= 50000) {
                                    sampleSaldo -= jumlahTransfer; // saldo = saldo + masukan
                                    dataAccount[indexAkun][4] = String.valueOf(sampleSaldo);

                                    history[currentSnapshot] = new String[] {
                                            "Pembayaran ke " + namaPemilikAccount,
                                            String.valueOf("-" + jumlahTransfer) };
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
                                    System.out.println("-----------------------------------------------");
                                    kembaliAtauKeluar(input);
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
                        char responsVa = konfirmasi(input);
                        switch (responsVa) {
                            case 'y':

                                // konfirmasi pin
                                System.out.println("Masukkan konfirmasi pin anda");
                                int inputPin = input.nextInt();
                            
                                if (isPinValid(inputPin, indexAkun)) {
                                    // Ambil nominal pembayaran dari data VA

                                    if (sampleSaldo >= jumlahPembayaran) {
                                        sampleSaldo -= jumlahPembayaran;
                                        dataAccount[indexAkun][4] = String.valueOf(sampleSaldo);

                                        history[0] = new String[] { "Saldo awal", "100000" };

                                        history[currentSnapshot] = new String[] {
                                                "Pembayaran ke " + namaPemilikVA,
                                                String.valueOf("-" + jumlahPembayaran) };
                                        currentSnapshot++;
                                        dataVA[indexVA][2] = String.valueOf(jumlahPembayaran);
                                        System.out.println(
                                                "---------------------------------------------------------------");
                                        System.out.println(
                                                "|                       TRANSAKSI BERHASIL                    |");
                                        System.out.println(
                                                "---------------------------------------------------------------");
                                        System.out.println("  Nama VA       : " + namaPemilikVA);
                                        System.out.println("  Pembayaran VA : Rp " + jumlahPembayaran);
                                        System.out.println("  Sisa saldo    : Rp " + sampleSaldo);
                                        System.out.println(
                                                "---------------------------------------------------------------");
                                        kembaliAtauKeluar(input);
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
                        input.close();
                        return;
                    }
                    // konfirmasi
                    System.out.println("-----------------------------------------------");
                    System.out.println("|   Konfirmasi Sedekah yang ingin diberikan   |");
                    System.out.println("-----------------------------------------------");
                    System.out.println("    kepada  : Dompet" + donationOptions[pilihanSedekah - 1] + "");
                    System.out.println("    Sebesar : Rp. " + inputSedekah + "  \t\t  ");
                    System.out.println("-----------------------------------------------");

                    char responsSedekah = konfirmasi(input);
                    if (responsSedekah == 'y') {

                        // konfirmasi pin
                        System.out.println("Masukkan konfirmasi pin anda");
                        int inputPin = input.nextInt();
                    
                        if (isPinValid(inputPin, indexAkun)) {
                            // Code saldo tidak cukup
                            if (inputSedekah < sampleSaldo) {
                                sampleSaldo -= inputSedekah;
                                dataAccount[indexAkun][4] = String.valueOf(sampleSaldo);

                                history[currentSnapshot] = new String[] { "Bersedekah", "-" + inputSedekah };
                                currentSnapshot++;
                                System.out.println("-----------------------------------------------");
                                System.out.println("|                SEDEKAH BERHASIL             |");
                                System.out.println("-----------------------------------------------");
                                System.out.println("    kepada  : Dompet" + donationOptions[pilihanSedekah - 1] + "");
                                System.out.println("    Sebesar Rp " + inputSedekah);
                                System.out.println("    Sisa saldo anda Rp " + sampleSaldo);
                                System.out.println("-----------------------------------------------");
                                kembaliAtauKeluar(input);
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
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    // Info Kurs
                    tampilKurs();
                    kembaliAtauKeluar(input);
                    break;
                case 7:
                    // ambil array Riwayat

                    tampilRiwayat();
                    kembaliAtauKeluar(input);
                    break;
                case 8:
                    // CEK SALDO
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                  INFORMASI                  |");
                    System.out.println("   Nama        : " + dataAccount[indexAkun][0]);
                    System.out.println("   Saldo akhir : Rp " + sampleSaldo);
                    System.out.println("-----------------------------------------------");
                    kembaliAtauKeluar(input);
                    break;

                case 9:
                    // UBAH PIN
                    tampilUbahPin(indexAkun);
                    kembaliAtauKeluar(input);

                    break;
                case 10:
                    // Help
                    tampilHelp();
                    kembaliAtauKeluar(input);
                    break;
                default:
                    System.out.println("Pilihan Menu tidak tersedia");
                    break;
            }
        }

    }

    // Function tampilKurs
    private static void tampilKurs() {
        System.out.println("--------------------------------- ");
        System.out.println("|            INFO KURS           |");
        System.out.println("--------------------------------- ");
        System.out.println("   => USD");
        System.out.println("   Beli : " + kursBeliUSD);
        System.out.println("   Jual : " + kursJualUSD);

        System.out.println("\nApakah ingin konversi KURS (y/n)?");
        char konversiKurs = input.next().charAt(0);
        if (konversiKurs == 'y') {
            KonversiKurs(kursBeliUSD, kursJualUSD);
        }
    }

    // Fuction tampilRiwayat
    private static void tampilRiwayat() {
        System.out.println("Transaction History: " + currentSnapshot);
        // Print all snapshots
        System.out.println("History:");
        for (int i = 0; i < currentSnapshot; i++) {
            System.out.println(history[i][0] + " : " + history[i][1]);
        }
    }

    // Function tampilhelp
    private static void tampilHelp() {
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
        System.out.println("| - Untuk tarik dan setor tunai, minimal transaksi sebesar Rp.50000                     |");
        System.out.println("| - Jika terdapat masalah pada mesin ATM hubungi admin (085105120605)                   |");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // Function tampilUbahPin
    private static void tampilUbahPin(int indexAkun) {
        System.out.println("-----------------------------------------------");
        System.out.println("|                 UBAH PIN                    |");
        System.out.println("-----------------------------------------------");
        System.out.print("Masukkan PIN Anda saat ini: ");

        int inputPin = input.nextInt();
    
        if (!isPinValid(inputPin, indexAkun)) {
            System.out.println("-----------------------------------------------");
            System.out.println("|                 !! WARNING !!               |");
            System.out.println("|        PIN tidak valid. Akses ditolak.      |");
            System.out.println("-----------------------------------------------");
            return;
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
            dataAccount[indexAkun][3] = String.valueOf(pinBaru);
            System.out.println("--------------------------------- ");
            System.out.println("|     Perubahan PIN Berhasil     |");
            System.out.println("--------------------------------- ");
        }
    }

    // Function Konfirmasi
    private static char konfirmasi(Scanner input) {
        System.out.println("-----------------------------------------------");
        System.out.println("| Keterangan :                                |");
        System.out.println("| - Jika benar ketik 'y'                      |");
        System.out.println("| - Jika salah ketik 'n'                      |");
        System.out.println("-----------------------------------------------");

        return input.next().charAt(0);
    }

    // Function pilihan kembali atau keluar
    private static void kembaliAtauKeluar(Scanner input) {
        System.out.println("\n---------------------------------");
        System.out.println("|   1. Kembali    2. Keluar      |");
        System.out.println("--------------------------------- ");

        int pilihan;
        do {
            System.out.print("Masukkan Pilihan (1 atau 2): ");
            pilihan = input.nextInt();
            input.nextLine(); // Consume the newline character
        } while (pilihan != 1 && pilihan != 2);

        if (pilihan == 2) {
            System.out.println("-----------------------------------------------");
            System.out.println("|       Terima kasih telah menggunakan ATM.   |");
            System.out.println("|               Selamat tinggal!              |");
            System.out.println("-----------------------------------------------");
            System.exit(0);
        }
    }

    private static boolean isPinValid(int enteredPin, int accountIndex) {
        // Assuming PIN is stored at index 2 in dataAccount
        int actualPin = Integer.parseInt(dataAccount[accountIndex][3]);
        return enteredPin == actualPin;
    }
    
    // Function KonversiKURS
    private static void KonversiKurs(double kursBeliUSD, double kursJualUSD) {
        System.out.println("Masukkan jumlah(Rupiah) yang ingin dikonversi ke USD");
        System.out.print("Masukkan jumlah Rupiah: Rp ");
        int inputKurs = input.nextInt();
        System.out.println("1. Beli : " + inputKurs / kursBeliUSD);
        System.out.println("2. Jual : " + inputKurs / kursJualUSD);
    }
}
