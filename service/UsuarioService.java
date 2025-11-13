package service;

import java.util.List;
import java.util.Scanner;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository repository;
    private Scanner input = new Scanner(System.in);

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public void cadastrarUsuario(String nome, String email, String senha, String telefone) {
        Usuario usuario = new Usuario(nome, email, senha, telefone);
        repository.adicionar(usuario);
    }

    public void alterarUsuario() {
        System.out.print("Digite o ID do usuario que deseja alterar: ");
        int id = input.nextInt();
        input.nextLine();

        Usuario usuario = repository.buscarPorId(id);
        if (usuario == null) {
            System.out.println("Usuario não encontrado :(");
            return;
        }

        System.out.println("Digite ENTER se quiser manter a informação anterior");

        System.out.print("Novo nome (" + usuario.getNome() + "): ");
        String nome = input.nextLine();
        if (!nome.isEmpty()) usuario.setNome(nome);

        System.out.print("Novo email (" + usuario.getEmail() + "): ");
        String email = input.nextLine();
        if (!email.isEmpty()) usuario.setEmail(email);

        System.out.print("Nova senha: ");
        String senha = input.nextLine();
        if (!senha.isEmpty()) usuario.setSenha(senha);

        System.out.print("Novo telefone (" + usuario.getTelefone() + "): ");
        String telefone = input.nextLine();
        if (!telefone.isEmpty()) usuario.setTelefone(telefone);

        System.out.println("O usuário foi alterado! ;)");
    }

    public void consultarUsuarios() {
        List<Usuario> lista = repository.listarTodos();
        System.out.println("--- Lista de Usuarios ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
        } else {
            for (Usuario u : lista) {
                u.consultar();
            }
        }
    }

    public void removerUsuario(int id) {
        repository.remover(id);
    }

    public Usuario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

}
