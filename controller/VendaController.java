package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Bebida;
import model.ItemVenda;
import repository.BebidaRepository;
import repository.ClienteRepository;
import service.VendaService;

public class VendaController {

    private VendaService service;
    private ClienteRepository clienteRepository;
    private BebidaRepository bebidaRepository;
    private Scanner scanner = new Scanner(System.in);

    public VendaController(ClienteRepository clienteRepository, BebidaRepository bebidaRepository) {
        this.clienteRepository = clienteRepository;
        this.bebidaRepository = bebidaRepository;
        this.service = new VendaService(clienteRepository, bebidaRepository);
    }

    public void inserirVenda() {
        System.out.println("--- Nova venda ---");

        if (clienteRepository.listarTodos().isEmpty()) {
            System.out.println("Não há clientes cadastrados ainda :(");
            return;
        }

        System.out.println("Clientes cadastrados:");
        clienteRepository.listarTodos().forEach(c -> System.out.println("[" + c.getId() + "] " + c.getNome()));

        System.out.print("Digite o ID do cliente que efetuou a compra: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        if (clienteRepository.buscarPorId(idCliente) == null) {
            System.out.println("Cliente não encontrado :(");
            return;
        }

        List<ItemVenda> itens = new ArrayList<>();

        while (true) {
            System.out.println("Bebidas:");
            bebidaRepository.listarTodos().forEach(b -> System.out.printf("[" + b.getId() + "] " + b.getNome() + " - R$" + b.getPreco() + " (Estoque: " + b.getQuantidadeEstoque() + ")"));

            System.out.print("Digite o ID da bebida (ou 0 para finalizar): ");
            int idBebida = scanner.nextInt();
            scanner.nextLine();

            if (idBebida == 0) break;

            Bebida bebida = bebidaRepository.buscarPorId(idBebida);
            if (bebida == null) {
                System.out.println("Bebida não encontrada :(");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            if (qtd > bebida.getQuantidadeEstoque()) {
                System.out.println("Estoque insuficiente!");
                continue;
            }

            itens.add(new ItemVenda(bebida, qtd));
            System.out.println("Item adicionado :D");
        }

        if (!itens.isEmpty()) {
            service.cadastrarVenda(idCliente, itens);
            System.out.println("Venda finalizada com sucesso!");
        }
    }

    private void listarVendas() {
        service.consultarVendas();
    }

    private void alterarVenda() {
        service.alterarVenda();
    }

    private void removerVenda() {
        System.out.print("Digite o ID da venda que você deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.removerVenda(id);
        System.out.println("Venda removida com sucesso! :)");
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("--- MENU VENDAS ---");
            System.out.println("1 - Inserir venda");
            System.out.println("2 - Consultar vendas");
            System.out.println("3 - Alterar venda");
            System.out.println("0 - Voltar");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            if (opcao == 1) {
                inserirVenda();
            } else if (opcao == 2) {
                listarVendas();
            } else if (opcao == 3) {
                alterarVenda();
            } else if (opcao == 0) {
                System.out.println("Voltando ao menu principal...");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

}
