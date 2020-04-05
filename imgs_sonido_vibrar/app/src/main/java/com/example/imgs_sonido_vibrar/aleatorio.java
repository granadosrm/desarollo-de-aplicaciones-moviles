package com.example.imgs_sonido_vibrar;

public class aleatorio {
    int Imagen;
    int sonido;

    String aleatorio;

    public aleatorio(int Imagen,String aleatorio,int sonido){
        this.Imagen = Imagen;
        this.aleatorio = aleatorio;
        this.sonido=sonido;

    }

    public int getImagen() {
        return Imagen;
    }

    public String getAleatorio() {

        return aleatorio;
    }
     public int getSonido()
     {
         return sonido;
     }
}
