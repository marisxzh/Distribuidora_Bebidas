
import java.util.Scanner;

import controller.BebidaController;
import controller.ClienteController;
import controller.UsuarioController;
import controller.VendaController;
import repository.BebidaRepository;
import repository.ClienteRepository;
import repository.UsuarioRepository;


public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        BebidaRepository bebidaRepository = new BebidaRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        ClienteController clienteController = new ClienteController(clienteRepository);
        BebidaController bebidaController = new BebidaController(bebidaRepository);
        UsuarioController usuarioController = new UsuarioController(usuarioRepository);
        VendaController vendaController = new VendaController(clienteRepository, bebidaRepository);

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

                clienteController.iniciar();

            } else if (opcao == 2) {

                bebidaController.iniciar();

            } else if (opcao == 3) {

                usuarioController.iniciar();

            } else if (opcao == 4) {

                vendaController.iniciar();

            } else if (opcao ==0) {

                System.out.println("Encerrando o programa...");

            } else {

                System.out.println("Opção inválida! Digite outra ;)");

            }


        }
    }






    

}