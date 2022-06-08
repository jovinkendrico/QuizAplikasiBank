
import java.util.ArrayList;
import java.util.Scanner;

import transaksi.Nasabah;

public class App {
    public static void main(String[] args) throws Exception{
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Nasabah> arrayNasabah = new ArrayList<Nasabah>();
            arrayNasabah.add(new Nasabah("Susi", 10000000, "0312456"));
            arrayNasabah.add(new Nasabah("Budi", 1000000, "0314865"));
            boolean cekNomorRekening = true;
            do{
                System.out.println("=====================");
                System.out.println("Program Aplikasi Bank");
                System.out.println("=====================");
                System.out.print("Masukkan Nomor Rekening yang ingin digunakan = ");
                String nomorRekening = scanner.next();
                for(Nasabah nasabah : arrayNasabah){
                    if(nasabah.getNomorRekening().equals(nomorRekening)){
                        cekNomorRekening = false;
                        boolean ulang = true;
                        do{
                            System.out.println("=============================================================================");
                            System.out.println("Menu Aplikasi Bank");
                            System.out.println("=============================================================================");
                            System.out.println("1.Transfer Uang");
                            System.out.println("2.Cek Mutasi");
                            System.out.println("3.Keluar");
                            System.out.println("=============================================================================");
                            System.out.print("Masukkan pilihan anda (1-3) = ");
                            int pilih = scanner.nextInt();
                            if(pilih == 1){
                                System.out.println("=============================================================================");
                                System.out.print("Masukkan nomor rekening tujuan = ");
                                String nomorRekeningTujuan = scanner.next();
                                if(nasabah.checkNasabah(arrayNasabah, nomorRekeningTujuan)){
                                    System.out.println("=============================================================================");
                                    System.out.print("Masukkan jumah uang yang ingin ditransfer = ");
                                    int jumlah = scanner.nextInt();
                                    if(nasabah.saldoTersedia(jumlah)){
                                        nasabah.transferUang(jumlah, nomorRekeningTujuan, arrayNasabah);
                                    }else{
                                        System.out.println("=============================================================================");
                                        System.out.println("Saldo tidak mencukupi");
                                    }
                                }else{
                                    System.out.println("=============================================================================");
                                    System.out.println("Nomor Rekening tujuan tidak terdaftar di bank");
                                    continue;
                                }
                            }else if(pilih == 2){
                                nasabah.cetakMutasi();
                            }
                            else{
                                ulang = false;
                            }
                        }while(ulang);
                    }
                }
                clearScreen();
            }while(cekNomorRekening);

        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
