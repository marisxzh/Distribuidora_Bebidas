import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorUsuario {

    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public Scanner input = new Scanner(System.in);

    
    // inserir usuario

    public void inserirUsuario() {
    
        System.out.println("--- Inserir Usuario ---");
        
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("Senha: ");
        String senha = input.nextLine();

        System.out.print("Telefone: ");
        String telefone = input.nextLine();


        Usuario usuario = new Usuario(nome, email, senha, telefone);
        usuarios.add(usuario);

        System.out.println("Usuario adicionada com sucesso! :D");
    
    }





    // consultar usuarios

    public void consultarUsuarios() {

        System.out.println("--- Lista de Usuario ---");
        
        if (usuarios.isEmpty()) {
        
            System.out.println("Nenhum usuario cadastrado.");
        
        } else {
        
            for (Usuario u : usuarios) {
        
                System.out.println(u);
        
            }
        
        }
    
    }





    // alterar usuario

    public void alterarUsuario() {

        int id;

        System.out.print("--- Alterando informações do usuario buscando por ID ---");
        System.out.println();


        System.out.print("Digite o ID do usuario que deseja alterar: ");
        id = input.nextInt();
        input.nextLine();


        for (Usuario usuario : usuarios) {

            if (usuario.getId() == id) {

                System.out.println("Digite ENTER se quiser manter a informação anterior");

            
                System.out.print("Novo nome (" + usuario.getNome() + "): ");
                String nome = input.nextLine();

                if (!nome.isEmpty()){
                    usuario.setNome(nome);
                }


                System.out.print("Novo email (" + usuario.getEmail() + "): ");
                String email = input.nextLine();

                if (!email.isEmpty()){
                    usuario.setEmail(email);
                }


                System.out.print("Nova senha: ");
                String senha = input.nextLine();
                
                if (!senha.isEmpty()){
                    usuario.setSenha(senha);
                } 


                System.out.print("Novo telefone (" + usuario.getTelefone() + "): ");
                String telefone = input.nextLine();

                if (!telefone.isEmpty()) {
                    usuario.setTelefone(telefone);
                }



                System.out.println("O usuário foi alterado! ;)");
                return;
         
            }
        
        }

        System.out.println("Não encontrei o usuario :(");

    }





    // remover usuario

    public void removerUsuario() {

        int id;

        System.out.print("--- Removendo usuario por meio da busca por ID ---");
        System.out.println();


        System.out.print("Digite o ID do usuario que você deseja remover: ");
        id = input.nextInt();
        input.nextLine();

        Usuario usuario = buscarPorId(id);

        if (usuario != null) {

            usuarios.remove(usuario);
            System.out.println("Usuario foi removido com sucesso! :)");

        } else {

            System.out.println("Não encontrei o usuario :(");

        }

    }

    public Usuario buscarPorId(int id) {

        for (Usuario u : usuarios) {

            if (u.getId() == id){

                return u;

            }

        }

        return null;

    }

}


