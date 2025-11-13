package repository;

import java.util.ArrayList;
import java.util.List;
import model.Bebida;

public class BebidaRepository {

    private List<Bebida> bebidas = new ArrayList<>();

    public void adicionar(Bebida bebida) {
        bebidas.add(bebida);
    }

    public void remover(int id) {
        bebidas.removeIf(b -> b.getId() == id);
    }

    public Bebida buscarPorId(int id) {
        for (Bebida b : bebidas) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public List<Bebida> listarTodos() {
        return new ArrayList<>(bebidas);
    }

}
