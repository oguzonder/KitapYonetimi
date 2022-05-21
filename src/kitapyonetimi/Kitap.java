package kitapyonetimi;

public class Kitap {
    private String kitapAdı;
    private String yazar;
    private double kitapFiyatı;

    public Kitap() {}

    protected Kitap (String kitapAdı, String yazar, double kitapFiyatı) {
        this.kitapAdı=kitapAdı;
        this.yazar=yazar;
        this.kitapFiyatı=kitapFiyatı;
    }

    @Override
    public String toString() {
        return "Kitap{" +

                ", kitapAdı='" + kitapAdı + '\'' +
                ", yazar='" + yazar + '\'' +
                ", kitapFiyatı=" + kitapFiyatı +
                '}';
    }





    public String getKitapAdı() {
        return kitapAdı;
    }

    public void setKitapAdı(String kitapAdı) {
        this.kitapAdı = kitapAdı;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public double getKitapFiyatı() {
        return kitapFiyatı;
    }

    public void setKitapFiyatı(double kitapFiyatı) {
        this.kitapFiyatı = kitapFiyatı;
    }


}
