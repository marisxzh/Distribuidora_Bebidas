package repository;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void remover(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

}
