package ru.geekbrains.lesson3.SOLID.lsp;

/**
 * S
 */
public class Ostrich extends Bird {


    public Ostrich() {
        super(false);
    }

    @Override
    public void fly() {
        System.out.println("Страус не умеет летать!");
        //throw new UnsupportedOperationException("Страус не умеет летать!");
    }

    public void run(){
        System.out.println("Страус бежит!");
    }
}
