
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
        GerenciadorBebida gerenciadorBebida = new GerenciadorBebida();
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
        GerenciadorVenda gerenciadorVenda = new GerenciadorVenda(gerenciadorCliente.getListaClientes(), gerenciadorBebida.getListaBebidas());

        Scanner input = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {

            System.out.println();
            System.out.println("--- MENU ---");
            System.out.println("1 - Gerenciar cliente");
            System.out.println("2 - Gerenciar bebidas");
            System.out.println("3 - Gerenciar usuarios");
            System.out.println("4 - Gerenciar vendas");
            System.out.println("0 - Sair");
            System.out.println();
            
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();
            input.nextLine();


            if (opcao == 1) {

                menuCliente(gerenciadorCliente);

            } else if (opcao == 2) {

                menuBebida(gerenciadorBebida);

            } else if (opcao == 3) {

                menuUsuario(gerenciadorUsuario);

            } else if (opcao == 4) {

                menuVenda(gerenciadorVenda);

            } else if (opcao ==0) {

                System.out.println("Encerrando o programa...");

            } else {

                System.out.println("Opção inválida! Digite outra ;)");

            }


        }
    }





    // MENU DE CLIENTES

    private static void menuCliente(GerenciadorCliente servico) {

        Scanner input = new Scanner(System.in);
        
        int opcao = -1;

        while (opcao != 0) {

            System.out.println();

            System.out.println("--- MENU CLIENTES ---");
            
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Alterar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("0 - Voltar");
            
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();

            System.out.println();

            if (opcao == 1){

                servico.inserirCliente();
            
            } else if (opcao == 2){
            
                servico.consultarClientes();
            
            } else if (opcao == 3){
            
                servico.alterarCliente();
            
            } else if (opcao == 4) {
            
                servico.removerCliente();
            
            } else if (opcao == 0) {

            } else {
            
                System.out.println("Opção inválida!");
            
            }
                
        }

    }





    // MENU DE BEBIDAS

    private static void menuBebida(GerenciadorBebida servico) {

        Scanner input = new Scanner(System.in);
        
        int opcao = -1;

        while (opcao != 0) {

            System.out.println();

            System.out.println("--- MENU BEBIDAS ---");
            
            System.out.println("1 - Inserir bebida");
            System.out.println("2 - Consultar bebidas");
            System.out.println("3 - Alterar bebida");
            System.out.println("4 - Remover bebida");
            System.out.println("0 - Voltar");
            
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();

            System.out.println();


            if (opcao == 1){

                servico.inserirBebida();
            
            } else if (opcao == 2){
            
                servico.consultarBebidas();
            
            } else if (opcao == 3){
            
                servico.alterarBebida();
            
            } else if (opcao == 4) {
            
                servico.removerBebida();
            
            } else if (opcao == 0) {

            } else {
            
                System.out.println("Opção inválida!");
            
            }
                
        }

    }





    // MENU DE USUARIOS
    
    private static void menuUsuario(GerenciadorUsuario servico) {

        Scanner input = new Scanner(System.in);
        
        int opcao = -1;

        while (opcao != 0) {

            System.out.println();

            System.out.println("--- MENU USUARIOS ---");
            
            System.out.println("1 - Inserir usuario");
            System.out.println("2 - Consultar usuarios");
            System.out.println("3 - Alterar usuario");
            System.out.println("4 - Remover usuario");
            System.out.println("0 - Voltar");
            
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();
            System.out.println();


            if (opcao == 1){

                servico.inserirUsuario();
            
            } else if (opcao == 2){
            
                servico.consultarUsuarios();
            
            } else if (opcao == 3){
            
                servico.alterarUsuario();
            
            } else if (opcao == 4) {
            
                servico.removerUsuario();
            
            } else if (opcao == 0) {

            } else {
            
                System.out.println("Opção inválida!");
            
            }
                
        }

    }





    // MENU DE VENDAS

    private static void menuVenda(GerenciadorVenda servico) {

        Scanner input = new Scanner(System.in);
        
        int opcao = -1;

        while (opcao != 0) {

            System.out.println();

            System.out.println("--- MENU VENDAS ---");
            
            System.out.println("1 - Inserir venda");
            System.out.println("2 - Consultar vendas");
            System.out.println("3 - Alterar venda");
            System.out.println("0 - Voltar");
            
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();

            System.out.println();

            if (opcao == 1){

                servico.inserirVenda();
            
            } else if (opcao == 2){
            
                servico.consultarVendas();
            
            } else if (opcao == 3){
            
                servico.alterarVenda();
            
            } else if (opcao == 0) {

            } else {
            
                System.out.println("Opção inválida!");
            
            }
                
        }

    }
    

}