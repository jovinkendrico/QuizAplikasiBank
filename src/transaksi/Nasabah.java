package transaksi;
import java.util.ArrayList;

public class Nasabah {
    public String nama;
    public int saldo;
    public String nomorRekening;
    ArrayList<String> logMutasi = new ArrayList<String>();
   
    public Nasabah(String nama, int saldo, String nomorRekening){
        this.nama = nama;
        this.saldo = saldo;
        this.nomorRekening = nomorRekening;
    }

    public boolean saldoTersedia(int jumlah){
        if(this.saldo >= jumlah){
            return true;
        }
        return false;
    }

    public boolean checkNasabah(ArrayList<Nasabah> arrayNasabah, String nomorRekeningTujuan){
        for(Nasabah nasabah : arrayNasabah){
            if (nasabah.getNomorRekening().equals(nomorRekeningTujuan)){
                return true;
            }
        }
        return false;
    }
    public void transferUang(int jumlah, String nomorRekeningTujuan, ArrayList<Nasabah> arrayNasabah){
        tarikUang(jumlah);
        terimaUang(jumlah, nomorRekeningTujuan,arrayNasabah);
        logMutasi.add("Transfer uang sebesar "+ jumlah + " berhasil");
        tambahMutasi(jumlah, nomorRekeningTujuan, arrayNasabah);
        System.out.println("=============================================================================");
        System.out.println("Transfer Berhasil");
    }

    private void tambahMutasi(int jumlah, String nomorRekeningTujuan, ArrayList<Nasabah> arrayNasabah){
        for(Nasabah nasabah: arrayNasabah){
            if(nasabah.getNomorRekening().equals(nomorRekeningTujuan)){
                nasabah.logMutasi.add(this.getNama() + " mengirim uang sebesar " + jumlah + "ke rekening anda");
            }
        }
    }

    private void tarikUang(int jumlah){
        this.saldo-=jumlah;
    }

    private void terimaUang(int jumlah, String nomorRekeningTujuan, ArrayList<Nasabah> arrayNasabah){
        for(Nasabah nasabah: arrayNasabah){
            if(nasabah.getNomorRekening().equals(nomorRekeningTujuan)){
                nasabah.saldo+=jumlah;
            }
        }
    }

    public void cetakMutasi(){
        for(String log : logMutasi){
            System.out.println("=============================================================================");
            System.out.println(log);
        }
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNomorRekening() {
        return this.nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }
}
