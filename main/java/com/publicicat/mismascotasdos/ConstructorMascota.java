package com.publicicat.mismascotasdos;

public class ConstructorMascota {

    private String nMascota;
    private int rMascota;
    private int foto;

    //Constructor
    public ConstructorMascota( String nMascota, int rMascota, int foto ) {

        this.nMascota = nMascota;
       //this.dMascota = dMascota;
        this.rMascota = rMascota;
        this.foto = foto;
    }

    public String getnMascota() {
        return nMascota;
    }

    public void setnMascota(String nMascota) {
        this.nMascota = nMascota;
    }
    /*
    public String getdMascota() {
        return dMascota;
    }

    public void setdMascota(String dMascota) {
        this.dMascota = dMascota;
    }
     */

    public int getrMascota() {
        return rMascota;
    }

    public void setrMascota(int rMascota) {
        this.rMascota = rMascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
