package com.kenjiro.tokolaptop;

import java.io.Serializable;

public class Checkout implements Serializable {
    String nama, harga;

    public Checkout(String nama, String harga){
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() { return nama; }

    public String getHarga() { return harga; }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
