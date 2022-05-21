package kitapyonetimi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Methods extends Kitap{ //METHODLAR CLASS'I
    static int kitapNo=1000;
    static Map<Integer,Kitap> kitapMap=new HashMap<>();
    static Scanner scan=new Scanner(System.in);


    protected static void girisPaneli(){
        System.out.println("//////////////// KİTAP YONETIMI PROGRAMI //////////////////");
        System.out.println(
                "	1-kitap ekle\n" +
                        "	2-numara ile kitap goruntule\n" +
                        "	3-bilgi ile kitap goruntule\n"+
                        "	4-numara ile kitap sil\n" +
                        "	5-tum kitaplari listele\n" +
                        "	6-cikis ");
        System.out.print("Isleminizi secisiniz: ");

        int islem= scan.nextInt();

        switch (islem){

            case 1:
                kitapEkleMethodu();
                girisPaneli();

                break;
            case 2:
                numaraIleKitapGoruntule();
                girisPaneli();
                break;
            case 3:
                bilgiIleGoruntule();
                girisPaneli();
                break;
            case 4:
                numaraIleKitapSil();
                girisPaneli();
                break;
            case 5:
                kitaplariListele();
                girisPaneli();
                break;
            case 6:
                cikis();
                break;

            default:
                System.out.println("Gecerli islem numarasi giriniz");
        }}

    //1- KitapEkle methodu baslangic
    private static void kitapEkleMethodu(){
        //-->Kullanicidan kitapObjesinin variable'larini alarak KitapMap'i listemize ekleyen method
        System.out.println("Kitap adini giriniz");
        scan.nextLine();//dummy
        String kitapAdi= scan.nextLine();
        System.out.println("Kitap Yazarını giriniz");
        String kitapYazari= scan.nextLine();
        System.out.println("Kitap Fiyatı giriniz");

        //Try catch başlangıç, Fiyat için calisir. olasi exception ve istenmeyen deger girisini handle eder
        double kitapFiyati = 0;
        boolean flag = true;
        do {
            try {
                kitapFiyati = scan.nextDouble();
                if (kitapFiyati<=0) {
                    throw new ArithmeticException();//kitap fiyati <=0 ise exception firlatir

                }
                flag = false;
            } catch (ArithmeticException e){ //eger fiyat 0 dan kucukse calisir
                System.out.println("Fiyat 0 dan buyuk olmali");
            }
            catch (Exception e) {//eger fiyat double data turune uygun degilse calisir
                scan.next();
                System.out.println("lütfen geçerli bir fiyat giriniz");
            }
        } while (flag); //try catch sonu

        Kitap kitapObjesi= new Kitap(kitapAdi,kitapYazari,kitapFiyati); //kitap obejesine kullanicidan aldigimiz variable'lari atadik
        kitapMap.put(kitapNo,kitapObjesi); //Kitap Map'ine kitapNo-> Key olarak ve kitapObjesi-> Value olarak eklendi (put edildi)
        kitapNo++; //KitapNo 1000 den baslayarak her kitap eklendiginde 1 artacak
    }//method sonu


    //2- Numara ile kitap goruntule methodu baslangic
    private static void numaraIleKitapGoruntule() {
        //-->kullanicidan int kitap numarasini alarak arama yapiyor, varsa yazdiriyor
        System.out.println("aranan kitap numarasi giriniz");
        int arananNumara=scan.nextInt();

        if (kitapMap.containsKey(arananNumara)){
            System.out.println(arananNumara+" numarali:  "+ kitapMap.get(arananNumara));

        }else System.out.println("Girdiginiz numarada kitap bulunmadi");
    }//method sonu


    //3- Bilgi ile (kitap adi veya yazar adi) kitabi goruntule methodu baslangic
    private static void bilgiIleGoruntule() {
        //kullanicidan kitap adi veya yazar adi bilgisini alarak arama yapar. varsa listeler
        System.out.println("Kitap adi ile aramak icin--> 1\nKitap yazari ile aramak icin--> 2");
        int islem= scan.nextInt();
        switch (islem){
            case 1:
                System.out.println("kitap adi giriniz: ");
                scan.nextLine();//dummy
                String arananKitapAdi=scan.nextLine();

                for (Kitap each: kitapMap.values()) {
                    if( each.getKitapAdı().equalsIgnoreCase(arananKitapAdi)){
                        System.out.println("\nKitap adi:  "+each.getKitapAdı()+"  /  Kitap Yazari:  "+each.getYazar()+"  /  Kitap fiyati:  "+each.getKitapFiyatı());
                        System.out.println("\n");
                        break;
                    }else System.out.println("Girdiginiz adli kitap yok");} break;

            case 2:
                System.out.println("yazar gir");
                scan.nextLine();//dummy
                String arananYazarAdi=scan.nextLine();

                for (Kitap each: kitapMap.values()) {
                    if( each.getYazar().equalsIgnoreCase(arananYazarAdi)){
                        System.out.println("\nKitap adi:  "+each.getKitapAdı()+"  /  Kitap Yazari:  "+each.getYazar()+"  /  Kitap fiyati:  "+each.getKitapFiyatı());
                        System.out.println("\n");
                        break;
                    }else System.out.println("Girdiginiz yazar adli kitap yok");}break; }
    }//method sonu


    //4- kitap numarasi ile listedeki kitabi sil methodu baslangic
    private static void numaraIleKitapSil() {
        //kullanicidan kitap numarasi alarak arama yapar, varsa o numarali kitabi listeden siler ve silinen kitabi yazdirir
        System.out.println("silmek istediginiz kitap numarasi giriniz");
        int arananNumara=scan.nextInt();

        if (kitapMap.containsKey(arananNumara)){
            System.out.println(arananNumara+" numarali:  "+ kitapMap.get(arananNumara)+" Kitap listesinden silindi...");
            kitapMap.remove(arananNumara);

        }else System.out.println("Girdiginiz numarada kitap bulunmadi");
    }//method sonu


    //5- eklenen kitaplari liste seklinde yazdiran method
    private static void kitaplariListele() {
        Set<Map.Entry<Integer, Kitap>> urunEntrySeti = kitapMap.entrySet();
        System.out.println("-----------------------------KİTAP LİSTESİ-----------------------------------");
        System.out.println("NO:       kitap adi                  yazari                   fiyati" +
                "\n----------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Kitap> e : urunEntrySeti
        ) {
            Integer entryKey = e.getKey();
            System.out.printf("%-9d %-26s %-24s %-18s\n", entryKey, kitapMap.get(entryKey).getKitapAdı(), kitapMap.get(entryKey).getYazar(),
                    kitapMap.get(entryKey).getKitapFiyatı());       }
    }




    //6-  cikis cikis yani
    private static void cikis() {System.out.println("Cikis yapildi");}


}
