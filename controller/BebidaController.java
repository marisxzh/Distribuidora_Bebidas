package controller;

import java.util.Scanner;
import repository.BebidaRepository;
import service.BebidaService;

public class BebidaController {

    private BebidaService service;
    private Scanner scanner = new Scanner(System.in);

    public BebidaController(BebidaRepository bebidaRepository) {
        this.service = new BebidaService(bebidaRepository);
    }

    public void inserirBebida() {
        System.out.println("--- Inserir Bebida ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Volume (ex: 600ml, 1L): ");
        String volume = scanner.nextLine();

        System.out.print("Quantidade em estoque: ");
        int qtd = scanner.nextInt();

        System.out.print("Preço (R$): ");
        double preco = scanner.nextDouble();

        System.out.print("É alcoólica? (1 - Sim / 0 - Não): ");
        boolean alcoolica = (scanner.nextInt() == 1);
        scanner.nextLine();

        service.cadastrarBebida(nome, qtd, volume, alcoolica, preco);

        System.out.println("Bebida adicionada com sucesso! :D");
    }

    private void listarBebidas() {
        service.consultarBebidas();
    }

    private void alterarBebida() {
        service.alterarBebida();
    }

    private void removerBebida() {
        System.out.print("Digite o ID da bebida que você deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.removerBebida(id);
        System.out.println("Bebida removida com sucesso! :)");
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("--- MENU BEBIDAS ---");
            System.out.println("1 - Inserir bebida");
            System.out.println("2 - Consultar bebidas");
            System.out.println("3 - Alterar bebida");
            System.out.println("4 - Remover bebida");
            System.out.println("0 - Voltar");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            if (opcao == 1) {
                inserirBebida();
            } else if (opcao == 2) {
                listarBebidas();
            } else if (opcao == 3) {
                alterarBebida();
            } else if (opcao == 4) {
                removerBebida();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

}
