// classe Bebida

package model;

public class Bebida{

    private static int idAutomatico = 1;

    private int id, quantidadeEstoque;
    private String nome, volume;
    private boolean alcoolica;
    private double preco;


    public Bebida(String nome, int quantidadeEstoque, String volume, boolean alcoolica, double preco) {

        this.id = idAutomatico++;

        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.volume = volume;
        this.alcoolica = alcoolica;
        this.preco = preco;

    }



    // getters

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getVolume() {
        return this.volume;
    }

    public int getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    public boolean getAlcoolica() {
        return this.alcoolica;
    }

    public double getPreco() {
        return this.preco;
    }


    // setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setVolume(String volume){
        this.volume = volume;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setAlcoolica(boolean alcoolica){
        this.alcoolica = alcoolica;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }



    @Override
    public String toString() {
        return String.format("""
            ID: %d
            Nome: %s
            Volume: %s
            Estoque: %d
            Alcoólica: %s
            Preço: R$ %.2f
            """, id, nome, volume, quantidadeEstoque, 
            (alcoolica ? "Sim" : "Não"), preco);
    }

}