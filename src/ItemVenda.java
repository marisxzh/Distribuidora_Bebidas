// Classe ItemVenda 


public class ItemVenda {

    private Bebida produto;

    private int quantidade;


    public ItemVenda(Bebida produto, int quantidade) {

        this.produto = produto;
        this.quantidade = quantidade;

    }


    // getters

    public Bebida getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }



    // setters

    public void setProduto(Bebida produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }



    public double getSubtotal() {

        return produto.getPreco() * quantidade;
    
    }


    public void subtotal() {
        
        System.out.println("--- SUBTOTAL ---");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Subtotal: " + getSubtotal());

    }

}