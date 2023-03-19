import java.util.ArrayList;
import java.util.Scanner;

public class TokoBuah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] buah = {
            {"apel", "35000"},
            {"jeruk", "50000"},
            {"mangga", "25000"},
            {"duku", "15000"},
            {"semangka", "20000"}
        };

        ArrayList<String> belanjaan = new ArrayList<>();
        ArrayList<Integer> jumlah = new ArrayList<>();
        ArrayList<Integer> harga = new ArrayList<>();
        ArrayList<Integer> subtotal = new ArrayList<>();

        int totalHarga = 0;

        System.out.println("Menu:");
        System.out.println("1. Beli Buah");
        System.out.println("2. Struk Belanja");
        System.out.println("3. Keluar");

        boolean isRunning = true;

        while (isRunning) {
            System.out.print("\nMasukkan pilihan: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Pilih Buah (0-4): ");
                    int pilihanBuah = input.nextInt();

                    System.out.print("Masukkan jumlah: ");
                    int jml = input.nextInt();

                    belanjaan.add(buah[pilihanBuah][0]);
                    jumlah.add(jml);
                    harga.add(Integer.parseInt(buah[pilihanBuah][1]));
                    subtotal.add(jml * Integer.parseInt(buah[pilihanBuah][1]));
                    totalHarga += jml * Integer.parseInt(buah[pilihanBuah][1]);

                    System.out.print("\nInput lagi? (y/n): ");
                    String inputLagi = input.next();

                    if (inputLagi.equalsIgnoreCase("n")) {
                        isRunning = false;
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Belanja:");
                    System.out.println("========================================");
                    System.out.println("No.\tNama Buah\tJumlah\tHarga\tSubtotal");

                    for (int i = 0; i < belanjaan.size(); i++) {
                        System.out.println((i+1) + "\t" + belanjaan.get(i) + "\t\t" + jumlah.get(i) + "\t" + harga.get(i) + "\t" + subtotal.get(i));
                    }

                    System.out.println("========================================");
                    System.out.println("Total:\t\t\t\t\t" + totalHarga);

                    double discount = totalHarga * 0.15;
                    double totalBayar = totalHarga - discount;

                    System.out.println("Discount(15%):\t\t\t\t" + discount);
                    System.out.println("Total bayar:\t\t\t\t" + totalBayar);
                    break;

                case 3:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }

        System.out.println("Terima kasih telah berbelanja!");
    }
}