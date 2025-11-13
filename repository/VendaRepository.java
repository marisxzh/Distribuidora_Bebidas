package repository;

import java.util.ArrayList;
import java.util.List;
import model.Venda;

public class VendaRepository {

    private List<Venda> vendas = new ArrayList<>();

    public void adicionar(Venda venda) {
        vendas.add(venda);
    }

    public void remover(int id) {
        vendas.removeIf(v -> v.getId() == id);
    }

    public Venda buscarPorId(int id) {
        for (Venda v : vendas) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public List<Venda> listarTodos() {
        return new ArrayList<>(vendas);
    }

}
