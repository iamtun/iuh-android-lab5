package fit.android.lab5.model;

import java.text.DecimalFormat;

public class Donut {
    private int id;
    private String name;
    private String desc;
    private double price;

    public Donut(int id, String name, String desc, double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormatPrice() {
        DecimalFormat df = new DecimalFormat("$ #.###.00");
        return df.format(this.getPrice());
    }
}
