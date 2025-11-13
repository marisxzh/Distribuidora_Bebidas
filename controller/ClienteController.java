package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import repository.ClienteRepository;
import service.ClienteService;

public class ClienteController {
    private ClienteService service;
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClienteController(ClienteRepository clienteRepository) {
        this.service = new ClienteService(clienteRepository);
    }


    public void inserirCliente() {

        int tipo;

        System.out.println("Tipo de cliente a ser inserido:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println();

        System.out.print("Digite o tipo de cliente: ");
        tipo = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (tipo == 1) {

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Data de nascimento (dd/MM/yyyy): ");
            String dataTexto = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataTexto, formato);


            service.cadastrarPessoaFisica(nome, telefone, email, cpf, dataNascimento);

            System.out.println("Um cliente do tipo Pessoa Física foi adicionado! :)");

        } else if (tipo == 2) {

            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();


            service.cadastrarPessoaJuridica(nome, telefone, email, cnpj);

            System.out.println("Um cliente do tipo Pessoa Jurídica foi adicionado! :)");

        } else {

            System.out.println("Tipo de cliente inválido!");

        }

    }


    private void listarClientes() {

        service.consultarClientes();

        }


    private void buscarPorId() {

        System.out.print("Digite o ID: ");

        int id = scanner.nextInt();

        Cliente cliente = service.buscarPorId(id);

        if (cliente != null) cliente.consultar();

        else System.out.println("Cliente não encontrado :(");

    }

    private void removerCliente() {

        System.out.print("Digite o ID: ");

        int id = scanner.nextInt();

        service.removerCliente(id);

    }


    private void alterarCliente() {

        service.alterarCliente();

    }

    public void iniciar() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println();
            System.out.println("--- MENU CLIENTES ---");
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Alterar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("0 - Voltar");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            if (opcao == 1){

                inserirCliente();

            } else if (opcao == 2){

                listarClientes();

            } else if (opcao == 3){

                alterarCliente();

            } else if (opcao == 4) {

                removerCliente();

            } else if (opcao == 0) {

                System.out.println("Voltando ao menu principal...");

            } else {

                System.out.println("Opção inválida!");

            }

        }

    }

    public static void main(String[] args) {

        new ClienteController(new repository.ClienteRepository()).iniciar();

    }

}


