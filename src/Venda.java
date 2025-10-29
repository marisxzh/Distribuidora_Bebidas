// Classe Venda
// puxa dados de ItemVenda e Clientes

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;



public class Venda {

    private static int idAutomatico = 1;

    private int id;
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;
    private LocalDateTime dataHora;


    private static final DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");



    public Venda(Cliente cliente) {

        this.id = idAutomatico++;

        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataHora = LocalDateTime.now();

    }



    // getters

    public int getId() {
        return id;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public ArrayList<ItemVenda> getItens(){
        return itens;
    }



    public void adicionarItem(ItemVenda item){ 
        
        itens.add(item);

    }


    public double getTotal() {

        double total = 0;
        
        for (ItemVenda item: itens) {

            total = total + item.getSubtotal();

        }

        return total;

    }


    public String getDataHoraFormatada() {
        
        return dataHora.format(formatoDataHora);

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Venda ID: ").append(id).append(" ---");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Data/Hora: ").append(getDataHoraFormatada()).append("\n");
        sb.append("Itens:\n");
        for (ItemVenda i : itens) {
            sb.append(" - ").append(i).append("\n");
        }
        sb.append(String.format("Total: R$ %.2f\n", getTotal()));
        return sb.toString();
    }


}