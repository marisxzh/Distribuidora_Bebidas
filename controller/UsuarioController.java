package controller;

import java.util.Scanner;
import repository.UsuarioRepository;
import service.UsuarioService;

public class UsuarioController {

    private UsuarioService service;
    private Scanner scanner = new Scanner(System.in);

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.service = new UsuarioService(usuarioRepository);
    }

    public void inserirUsuario() {
        System.out.println("--- Inserir Usuario ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        service.cadastrarUsuario(nome, email, senha, telefone);

        System.out.println("Usuario adicionado com sucesso! :D");
    }

    private void listarUsuarios() {
        service.consultarUsuarios();
    }

    private void alterarUsuario() {
        service.alterarUsuario();
    }

    private void removerUsuario() {
        System.out.print("Digite o ID do usuario que você deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.removerUsuario(id);
        System.out.println("Usuario removido com sucesso! :)");
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("--- MENU USUARIOS ---");
            System.out.println("1 - Inserir usuario");
            System.out.println("2 - Consultar usuarios");
            System.out.println("3 - Alterar usuario");
            System.out.println("4 - Remover usuario");
            System.out.println("0 - Voltar");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            if (opcao == 1) {
                inserirUsuario();
            } else if (opcao == 2) {
                listarUsuarios();
            } else if (opcao == 3) {
                alterarUsuario();
            } else if (opcao == 4) {
                removerUsuario();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

}
