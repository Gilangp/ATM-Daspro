
/**
 * Main
 */

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in); // Define and initialize the scanner object

    static double kursBeliUSD = 15000;
    static double kursJualUSD = 15000;
    static String[][] dataAccount = new String[1000][2];
    static {
        dataAccount[0] = new String[] { "Fajar", "admin", "11223344", "1234" };
        dataAccount[1] = new String[] { "Yefta", "user", "1234", "123", "1000000", "BRI", "Active" };
        dataAccount[2] = new String[] { "Gopal", "user", "4567", "456", "500000", "BCA", "Active" };
        dataAccount[3] = new String[] { "Gilang", "user", "7890", "789", "250000", "BNI", "Active" };
        dataAccount[4] = new String[] { "Prabowo", "user", "1212", "121", "150000", "Mandiri", "Active" };
        dataAccount[5] = new String[] { "Jokowi", "user", "1313", "131", "550000", "CIMB", "Active" };
        dataAccount[6] = new String[] { "Jackie Chan", "user", "1414", "141", "150000", "BCA", "Active" };
    }
    static int nextIndexUser = 7;

    static String[][] dataVA = {
            { "VA12345", "Shopee", "100000" },
            { "VA67890", "Tokopedia", "150000" },
            { "VA54321", "Kai Tiket", "200000" }
    };

    static String[][] dataBank = {
            { "123", "BCA" },
            { "456", "BRI" },
            { "234", "BNI" },
            { "567", "Mandiri" },
            { "789", "CIMB" }
    };

    static String[] donationOptions = new String[100];
    static int nextIndexBank = 5;

    static boolean[] menuAktif = { true, true, true, true, true, true, true, true, true, true };

    static String[][] history = new String[1000][2];
    static {
        donationOptions[0] = "BAZNAS";
        donationOptions[1] = "KPRB";
        donationOptions[2] = "Dompet DHUAFA";
        donationOptions[3] = "DigiZakat";
        donationOptions[4] = "LAMZIZ";
        // Add more values as needed
    }
    static int nextIndexSedekah = 5;

    static int currentSnapshot = 1;

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
            String noRek = input.nextLine();
            System.out.print("Masukkan Pin: ");
            String inputPin = input.nextLine();

            int indexAkun = findAccount(noRek, inputPin);

            if (indexAkun != -1) {

                isLoginIn = true;
                String accountType = dataAccount[indexAkun][1];
                System.out.println(accountType);

                if (accountType.equals("admin")) {
                    alertLoginBerhasil();
                    tampilAdminMenu();
                }

                if (accountType.equals("user")) {
                    if (dataAccount[indexAkun][6].equals("Blocked")) {
                        alertLoginGagal("Akun Anda terkunci. Hubungi Admin.");
                        break;
                    }
                    alertLoginBerhasil();
                    tampilUserMenu(indexAkun);
                }
            } else {
                maxAttempts--;
                if (maxAttempts > 0) {
                    // Jika login gagal
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              !! LOGIN GAGAL !!              |");
                    System.out.println("|                                             |");
                    System.out.println("|    NO REK / PIN YANG ANDA MASUKKAN SALAH    |");
                    System.out.println("|                                             |");
                    System.out.println("|     Sisa percobaan kurang " + maxAttempts + " kali lagi\t      |");
                    System.out.println("|        NB : Maksimal percobaan 3 kali       |");
                    System.out.println("-----------------------------------------------");
                } else {
                    System.out.println("Anda telah melampaui upaya login maksimum. Hubungi Admin");
                    System.out.println("-----------------------------------------------");
                    System.out.println("|              !! LOGIN GAGAL !!              |");
                    System.out.println("|                                             |");
                    System.out.println("|    NO REK / PIN YANG ANDA MASUKKAN SALAH    |");
                    System.out.println("|                                             |");
                    System.out.println("|  Anda telah melampaui upaya login maksimum  |");
                    System.out.println("|               Hubungi Admin                 |");
                    System.out.println("-----------------------------------------------");
                }
            }
        }
        input.close();
    }

    // Function tampilUserMenu
    static void tampilAdminMenu() {
        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("|             Silahkan Pilih Menu             |");
            System.out.println("|                                             |");
            System.out.println("| 1. Informasi Akun         3. Informasi KURS |");
            System.out.println("| 2. Informasi Sedekah      4. Informasi HELP |");
            System.out.println("-----------------------------------------------");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    // Informasi Akun
                    tampilInformasiAkun();
                    kembaliAtauKeluar(input);
                    break;

                case 2:
                    // Informasi Sedekah
                    tampilInformasiSedekah();
                    kembaliAtauKeluar(input);

                    break;
                case 3:
                    // Informasi KURS
                    tampilInformasiKURS();
                    kembaliAtauKeluar(input);
                    break;

                case 4:
                    // Informasi Help
                    tampilInformasiHelp();
                    kembaliAtauKeluar(input);
                    break;
                default:
                    alertTidakTersedia("Menu");
                    break;
            }
        }
    }

    // ADMIN MENU
    // Function 1. tampilInformasiAkun
    static void tampilInformasiAkun() {
        tampilOpsi("Informasi Akun");
        operasiAdmin("Akun", "Tambah Akun", "Edit Akun", "Aktivasi Akun");
        int operation = input.nextInt();
        switch (operation) {
            case 1:
                tambahInformasiAkun();
                break;
            case 2:
                editInformasiAkun();
                break;
            case 3:
                aktivasiAkun();
                break;
            case 4:
                break;
            default:
                alertTidakTersedia("operasi");
                break;
        }
    }

    // Function 2. tampilInformasiSedekah
    static void tampilInformasiSedekah() {
        tampilOpsi(donationOptions, nextIndexSedekah, "Macam - Macam Sedekah");
        operasiAdmin("Sedekah", "Tambah Sedekah", "Edit Sedekah", "Hapus Sedekah");
        int operation = input.nextInt();
        switch (operation) {
            case 1:
                tambahSedekah();
                break;
            case 2:
                editSedekah();
                break;
            case 3:
                hapusSedekah();
                break;
            case 4:
                break;
            default:
                alertTidakTersedia("operasi");
                break;
        }
    }

    // Function 3. tampilInformasiKURS
    static void tampilInformasiKURS() {
        //
    }

    // Function 4. tampilInformasiHelp
    static void tampilInformasiHelp() {
        //
    }

    // Tampil Informasi operasiAdmin
    static void operasiAdmin(String nama, String pilihan1, String pilihan2, String pilihan3) {
        System.out.println("Pilih operasi untuk " + nama + ":");
        System.out.println("1. " + pilihan1);
        System.out.println("2. " + pilihan2);
        System.out.println("3. " + pilihan3);
        System.out.println("4. Lainnya");
    }

    static void tambahInformasiAkun() {
        System.out.println("Masukkan nama:");
        String nama = input.next();

        String noRek = "";
        while (true) {
            System.out.println("Masukkan Nomer Rekening:");
            noRek = input.next();
            if (!isAccountNumberExists(noRek)) {
                break;
            } else {
                System.out.println("Maaf, nomor rekening sudah terdaftar. Silakan masukkan nomor rekening baru.");
            }
        }
        System.out.println("Masukkan PIN:");
        String pin = input.next();

        // Add the new account to the dataAccount array
        String[] newAccount = { nama, "user", noRek, pin, "0", "BCA", "Active" };
        dataAccount[nextIndexUser] = newAccount;
        // Increment the nextIndexUser
        nextIndexUser++;

        System.out.println("Akun baru berhasil ditambahkan.");
    }

    static boolean isAccountNumberExists(String targetNoRek) {
        for (int i = 1; i < nextIndexUser; i++) {
            if (targetNoRek.equals(dataAccount[i][2])) { // Assuming the account number is at index 6
                return true; // Account number already exists
            }
        }
        return false; // Account number does not exist
    }

    static void editInformasiAkun() {
        System.out.println("-----------------------------------------------");
        System.out.println("|                Edit AKUN                |");
        System.out.println("-----------------------------------------------");
        // Display the list of accounts

        tampilOpsi("Informasi Akun");

        System.out.println("Masukkan nomor akun yang ingin diedit:");
        int accountIndex = input.nextInt();

        if (isValidAccountIndex(accountIndex)) {
            System.out.println("Masukkan nama baru untuk akun " + dataAccount[accountIndex][0] + ":");
            String newName = input.next();

            // Update the name of the selected account
            dataAccount[accountIndex][0] = newName;

            System.out.println("Nama akun berhasil diubah menjadi " + newName + ".");
        } else {
            System.out.println("Nomor akun tidak valid.");
        }
    }

    static void aktivasiAkun() {
        System.out.println("-----------------------------------------------");
        System.out.println("|                Aktivasi AKUN                |");
        System.out.println("-----------------------------------------------");

        System.out.println("Pilih operasi:");
        System.out.println("1. Aktifkan Akun");
        System.out.println("2. Nonaktifkan Akun");

        int operation = input.nextInt();

        switch (operation) {
            case 1:
                tampilListAkunByStatus("Disabled");
                break;
            case 2:
                tampilListAkunByStatus("Active");
                break;
            default:
                System.out.println("Operasi tidak valid.");
                return;
        }

        if (operation == 1 && !isEmptyList("Disabled")) {
            System.out.println("Masukkan nomor akun yang ingin diaktifkan:");
            int accountIndex = input.nextInt();
            performAktivasiAkun(accountIndex, "Active");
        } else if (operation == 2 && !isEmptyList("Active")) {
            System.out.println("Masukkan nomor akun yang ingin dinonaktifkan:");
            int accountIndex = input.nextInt();
            performAktivasiAkun(accountIndex, "Disabled");
        } else {
            System.out.println("Tidak ada akun dengan status yang sesuai.");
        }
    }

    static boolean isEmptyList(String targetStatus) {
        for (int i = 1; i < nextIndexUser; i++) {
            if (dataAccount[i][6].equals(targetStatus)) {
                return false;
            }
        }
        return true;
    }

    static void performAktivasiAkun(int accountIndex, String newStatus) {
        if (isValidAccountIndex(accountIndex)) {
            aktivasiAkunStatus(accountIndex, newStatus);
            System.out.println("Akun berhasil di" + (newStatus.equals("Active") ? "aktifkan." : "nonaktifkan."));
        } else {
            System.out.println("Nomor akun tidak valid.");
        }
    }

    static void aktivasiAkunStatus(int accountIndex, String newStatus) {
        dataAccount[accountIndex][6] = newStatus; // Assuming the status is at index 6
    }

    static boolean isValidAccountIndex(int accountIndex) {
        return accountIndex >= 1 && accountIndex < nextIndexUser;
    }

    static void tampilListAkunByStatus(String targetStatus) {
        boolean isEmpty = true;
        System.out.println("List Akun (" + (targetStatus.equals("Active") ? "Nonaktif" : "Aktif") + "):");
        for (int i = 1; i < nextIndexUser; i++) {
            if (dataAccount[i][6].equals(targetStatus)) { // Assuming the status is at index 6
                System.out.println(i + ". " + dataAccount[i][0] + " (" + dataAccount[i][2] + ")");
                isEmpty = false;
            }
        }
    }

    static void tambahSedekah() {

        System.out.println("Tambah Sedekah");
        // Menambahkan nilai baru pada array
        System.out.println("Masukkan nama sedekah baru:");
        String namaSedekahBaru = input.next();

        // Menambahkan nilai baru pada indeks berikutnya
        donationOptions[nextIndexSedekah] = namaSedekahBaru;

        // Menampilkan pesan sukses
        System.out.println("Sedekah " + namaSedekahBaru + " berhasil ditambahkan.");

        // Menambahkan indeks berikutnya
        nextIndexSedekah++;

    }

    static void editSedekah() {
        System.out.println("Edit Sedekah");

        // Menampilkan sedekah yang dapat diedit
        tampilOpsi(donationOptions, nextIndexSedekah, "Sedekah yang dapat diubah");

        // Memilih sedekah yang akan diubah
        System.out.print("Masukkan nomor sedekah yang akan diubah: ");
        int indexSedekah = input.nextInt();

        // Memastikan nomor sedekah berada dalam batas yang benar
        if (indexSedekah >= 1 && indexSedekah <= nextIndexSedekah) {
            System.out.println("Masukkan nama sedekah baru:");
            String namaSedekahBaru = input.next();

            // Mengubah nilai pada indeks yang dipilih
            donationOptions[indexSedekah - 1] = namaSedekahBaru;

            // Menampilkan pesan sukses
            System.out.println("Sedekah berhasil diubah.");

        } else {
            alertInputTidakValid("Nomor sedekah");
        }

    }

    static void hapusSedekah() {
        System.out.println("Hapus Sedekah");

        // Menampilkan sedekah yang dapat dihapus
        tampilOpsi(donationOptions, nextIndexSedekah, "Sedekah yang dapat dihapus");

        // Memilih sedekah yang akan dihapus
        System.out.print("Masukkan nomor sedekah yang akan dihapus: ");
        int indexSedekah = input.nextInt();

        // Memastikan nomor sedekah berada dalam batas yang benar
        if (indexSedekah >= 1 && indexSedekah <= nextIndexSedekah) {
            // Menghapus nilai pada indeks yang dipilih
            for (int i = indexSedekah - 1; i < nextIndexSedekah - 1; i++) {
                donationOptions[i] = donationOptions[i + 1];
            }

            // Menampilkan pesan sukses
            System.out.println("Sedekah berhasil dihapus.");

            // Mengurangi indeks berikutnya
            nextIndexSedekah--;

        } else {
            System.out.println("Nomor sedekah tidak valid.");
        }
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
            System.out.println("| 3. Transfer            8. Informasi         |");
            System.out.println("| 4. Pembayaran          9. Ubah Pin          |");
            System.out.println("|    (Virtual Account)   10. Help             |");
            System.out.println("| 5. Sedekah                                  |");
            System.out.println("-----------------------------------------------");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    // Tarik Tunai
                    tampilTarikTunai(indexAkun, sampleSaldo);
                    break;
                case 2:
                    // SETOR TUNAI
                    // input
                    tampilSetorTunai(indexAkun, sampleSaldo);
                    break;
                case 3:
                    // TRANSFER
                    tampilTransfer(indexAkun, sampleSaldo);
                    break;
                case 4:
                    // Pembayaran VA
                    tampilVA(indexAkun, sampleSaldo);
                    break;
                case 5:
                    tampilSedekah(indexAkun, sampleSaldo);
                    kembaliAtauKeluar(input);
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
                    tampilInformasi(indexAkun, sampleSaldo);
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
                    alertTidakTersedia("Menu");
                    break;
            }
        }

    }

    // USER MENU

    // Function 1. tampilTarikTunai
    static void tampilTarikTunai(int indexAkun, int sampleSaldo) {
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
                confirmPin(inputPin, indexAkun, input);
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
                        alertMinimalTransaksi();
                    }
                } else {
                    alertSaldoTidakCukup();
                }
            case 'n':
        }
    }

    // Function 2. tampilSetorTunai
    static void tampilSetorTunai(int indexAkun, int sampleSaldo) {
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

                confirmPin(inputPin, indexAkun, input);
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
                    alertMinimalTransaksi();
                }
            case 'n':
                break;
        }
    }

    // Function 3. tampilTransfer
    static void tampilTransfer(int indexAkun, int sampleSaldo) {
        tampilOpsi(dataBank, "KODE BANK TUJUAN");

        System.out.print("Masukkan nomor kode bank tujuan anda: ");
        String kodeBankTujuan = input.next();
        String namaBank = "";
        int indexKodeBank = -1;

        // Mencari nomor kode bank tujuan di dalam array

        cariBank(kodeBankTujuan, indexKodeBank, namaBank);

        if (indexKodeBank == -1) {
            alertInputTidakValid("Kode Bank");
            return; // Hentikan eksekusi transfer karena kode bank tidak valid

        }
        // Input nomor rekening tujuan
        System.out.print("Masukkan nomor rekening tujuan: ");
        String nomorRekeningTujuan = input.next();
        int indexRekeningTujuan = -1;

        // Mencari nomor rekening tujuan di dalam array
        cariRekening(indexAkun, nomorRekeningTujuan, namaBank, indexRekeningTujuan);

        if (indexRekeningTujuan == -1) {
            alertInputTidakValid("Nomer Rekening");
            return; // Hentikan eksekusi transfer karena nomor rekening tidak valid
        }

        String namaPemilikAccount = dataAccount[indexRekeningTujuan][0];
        System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
        double jumlahTransfer = input.nextDouble();

        if (jumlahTransfer <= 0) {
            alertInputTidakValid("Jumlah Transfer");
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

                confirmPin(inputPin, indexAkun, input);
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
                    alertSaldoTidakCukup();
                }
            case 'n':
                break;
        }
    }

    // Function 4. tampilVA
    static void tampilVA(int indexAkun, int sampleSaldo) {
        System.out.print("Masukkan nomor Virtual Account (VA): ");
        String inputNomorVA = input.next();

        int indexVA = -1;

        cariVa(inputNomorVA, indexVA);

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

                    confirmPin(inputPin, indexAkun, input);
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
                        alertSaldoTidakCukup();
                    }
            }
        } else {
            alertInputTidakValid("Nomor VA");
        }
    }

    // Function 5. tampilSedekah
    static void tampilSedekah(int indexAkun, int sampleSaldo) {
        // SEDEKAH
        tampilOpsi(donationOptions, nextIndexSedekah, "Pilih Sedekah");

        System.out.print("Pilih sedekah : ");
        int pilihanSedekah = input.nextInt();

        if (pilihanSedekah < 1 || pilihanSedekah > donationOptions.length) {
            alertTidakTersedia("Sedekah");
            return;
        }

        System.out.println("Masukkan sedekah yang ingin diberikan ");
        int inputSedekah = input.nextInt();
        if (inputSedekah <= 0) {
            alertInputTidakValid("Jumlah Sedekah");
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

            confirmPin(inputPin, indexAkun, input);
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
                alertSaldoTidakCukup();
            }
        }
    }

    // Function 6. tampilKurs
    static void tampilKurs() {
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

    // Fuction 7. tampilRiwayat
    static void tampilRiwayat() {
        System.out.println("Transaction History: " + currentSnapshot);
        // Print all snapshots
        System.out.println("History:");
        for (int i = 0; i < currentSnapshot; i++) {
            System.out.println(history[i][0] + " : " + history[i][1]);
        }
    }

    // Function 8. tampilInformasi
    static void tampilInformasi(int indexAkun, int sampleSaldo) {
        System.out.println("-----------------------------------------------");
        System.out.println("|                  INFORMASI                  |");
        System.out.println("   Nama        : " + dataAccount[indexAkun][0]);
        System.out.println("   Saldo akhir : Rp " + sampleSaldo);
        System.out.println("-----------------------------------------------");
    }

    // Function 9. tampilUbahPin
    static void tampilUbahPin(int indexAkun) {
        System.out.println("-----------------------------------------------");
        System.out.println("|                 UBAH PIN                    |");
        System.out.println("-----------------------------------------------");
        System.out.print("Masukkan PIN Anda saat ini: ");

        int inputPin = input.nextInt();

        confirmPin(inputPin, indexAkun, input);

        System.out.print("Masukkan PIN Baru Anda : ");
        int pinBaru = input.nextInt();
        System.out.print("Konfirmasi PIN Baru: ");
        int confirmPin = input.nextInt();

        if (pinBaru != confirmPin) {
            System.out.println("------------------------------------------------");
            System.out.println("|               !! Peringatan !!               |");
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

    // Function 10. tampilhelp
    static void tampilHelp() {
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

    // PEMROSESAN DATA
    // Function Konfirmasi
    static char konfirmasi(Scanner input) {
        System.out.println("-----------------------------------------------");
        System.out.println("| Keterangan :                                |");
        System.out.println("| - Jika benar ketik 'y'                      |");
        System.out.println("| - Jika salah ketik 'n'                      |");
        System.out.println("-----------------------------------------------");

        return input.next().charAt(0);
    }

    // Fungsi untuk menampilkan opsi
    static void tampilOpsi(String[] options, int length, String header) {
        System.out.println("-----------------------------------------------");
        System.out.println("              " + header + "                   ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < length; i++) {
            System.out.println("    " + (i + 1) + ". " + options[i]);
        }
        System.out.println("-----------------------------------------------");
    }

    // Fungsi untuk menampilkan opsi bank
    static void tampilOpsi(String[][] options, String header) {
        System.out.println("-----------------------------------------------");
        System.out.println("              " + header + "                   ");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i][1] + " (" + options[i][0] + ")");
        }
        System.out.println("-----------------------------------------------");
    }

    static void tampilOpsi(String header) {
        System.out.println("-----------------------------------------------");
        System.out.println("              " + header + "                   ");
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.printf("%-3s %-13s %-8s %-10s %-10s%n",
                "No", "Nama", "No Rek", "Bank", "Status");

        System.out.println("-----------------------------------------------");
        for (int i = 1; i < nextIndexUser; i++) {
            System.out.printf("%-3s %-13s %-8s %-10s %-10s%n",
                    i, dataAccount[i][0], dataAccount[i][2], dataAccount[i][5], dataAccount[i][6]);
        }
        System.out.println("-----------------------------------------------");
    }

    // Function pilihan kembali atau keluar
    static void kembaliAtauKeluar(Scanner input) {
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

    static boolean isPinValid(int enteredPin, int accountIndex) {
        // Assuming PIN is stored at index 2 in dataAccount
        int actualPin = Integer.parseInt(dataAccount[accountIndex][3]);
        return enteredPin == actualPin;
    }

    static void confirmPin(int enteredPin, int accountIndex, Scanner input) {
        // Assuming PIN is stored at index 2 in dataAccount
        int actualPin = Integer.parseInt(dataAccount[accountIndex][3]);

        int maxAttempts = 2;
        int currentAttempts = 0;

        while (currentAttempts < maxAttempts) {
            if (enteredPin == actualPin) {
                return; // PIN is valid
            } else {
                int remainingAttempts = maxAttempts - currentAttempts;
                alertPinSalah(remainingAttempts);
                currentAttempts++;

                // Prompt the user to enter the PIN again
                System.out.println("Masukkan konfirmasi pin anda");
                enteredPin = input.nextInt();
            }
        }

        // If the user exceeds the maximum attempts, block the account and exit
        System.out.println("Exceeded maximum attempts. Account blocked.");
        dataAccount[accountIndex][6] = "Blocked"; // Assuming status is stored at index 6
        System.exit(0);
        return;
    }

    // Function cariBank
    static void cariBank(String kodeBankTujuan, int indexKodeBank, String namaBank) {
        for (int i = 0; i < dataBank.length; i++) {
            if (dataBank[i][0].equals(kodeBankTujuan)) {
                indexKodeBank = i;
                namaBank = dataBank[i][1];
                break;
            }
        }
    }

    // Function cariVA
    static void cariVa(String inputNomorVA, int indexVA) {
        for (int i = 0; i < dataVA.length; i++) {
            if (dataVA[i][0].equals(inputNomorVA)) {
                indexVA = i;
                break;
            }
        }
    }

    // Function cariRekening
    static void cariRekening(int indexAkun, String nomorRekeningTujuan, String namaBank, int indexRekeningTujuan) {
        for (int i = 0; i < dataAccount.length; i++) {
            if (dataAccount[i][1].equals("user") // Hanya mencari akun user
                    && !dataAccount[i][0].equals(dataAccount[indexAkun][0]) // Bukan rekening sendiri
                    && dataAccount[i][2].equals(nomorRekeningTujuan)
                    && dataAccount[i][5].equals(namaBank)) {
                indexRekeningTujuan = i;
                break;
            }
        }
    }

    // Function KonversiKURS
    static void KonversiKurs(double kursBeliUSD, double kursJualUSD) {
        System.out.println("Masukkan jumlah(Rupiah) yang ingin dikonversi ke USD");
        System.out.print("Masukkan jumlah Rupiah: Rp ");
        int inputKurs = input.nextInt();
        System.out.println("1. Beli : " + inputKurs / kursBeliUSD);
        System.out.println("2. Jual : " + inputKurs / kursJualUSD);
    }

    // ALERT
    // Function Alert Input tidak valid
    static void alertInputTidakValid(String nama) {
        System.out.println("-----------------------------------------------");
        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
        System.out.println("|                                             |");
        System.out.println("    Alert : " + nama + " tidak valid");
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Tidak tersedia
    static void alertTidakTersedia(String nama) {
        System.out.println("-----------------------------------------------");
        System.out.println("|               !! Peringatan !!              |");
        System.out.println("|                                             |");
        System.out.println("          Pilihan " + nama + " tidak tersedia       ");
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Login Berhasil
    static void alertLoginBerhasil() {
        System.out.println("-----------------------------------------------");
        System.out.println("|               LOGIN BERHASIL!               |");
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Login Berhasil
    static void alertLoginGagal(String pesan) {
        System.out.println("-----------------------------------------------");
        System.out.println("|               LOGIN Gagal!               |");
        System.out.println("    Pesan : " + pesan);
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Saldo tidak cukup
    static void alertSaldoTidakCukup() {
        System.out.println("-----------------------------------------------");
        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
        System.out.println("|                                             |");
        System.out.println("|            Saldo anda tidak cukup           |");
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Pin Salah
    static void alertPinSalah() {
        System.out.println("-----------------------------------------------");
        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
        System.out.println("|                                             |");
        System.out.println("|          Pin yang anda masukkan salah       |");
        System.out.println("-----------------------------------------------");
    }

    static void alertPinSalah(int remainingAttempts) {
        System.out.println("-----------------------------------------------");
        System.out.println("|                !! PERINGATAN !!             |");
        System.out.println("|                                             |");
        System.out.println("|         Pin yang anda masukkan salah       |");
        System.out.println("            Sisa kesempatan anda : " + remainingAttempts);
        System.out.println("-----------------------------------------------");
    }

    // Function Alert Minimal Transaksi
    static void alertMinimalTransaksi() {
        System.out.println("-----------------------------------------------");
        System.out.println("|             !! TRANSAKSI GAGAL !!           |");
        System.out.println("|                                             |");
        System.out.println("|          Minimal transaksi Rp 50.000        |");
        System.out.println("-----------------------------------------------");
    }
}
