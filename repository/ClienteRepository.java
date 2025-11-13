package repository;


import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente){

        clientes.add(cliente);

    }

    public void remover(int id) {
    
        clientes.removeIf(c -> c.getId() == id);
    
    }

    public Cliente buscarPorId(int id) {

        for (Cliente c : clientes) {

            if (c.getId() == id) {

                return c;

            }

        }

        return null;

    }

    public List<Cliente> listarTodos() {

        return new ArrayList<>(clientes);

    }

}