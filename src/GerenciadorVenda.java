import java.util.ArrayList;
import java.util.Scanner;


public class GerenciadorVenda {

    public ArrayList<Venda> listaVendas = new ArrayList<>();
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Bebida> listaBebidas;

    public Scanner input = new Scanner(System.in);


    public GerenciadorVenda(ArrayList<Cliente> clientes, ArrayList<Bebida> bebidas) {

        this.listaClientes = clientes;
        this.listaBebidas = bebidas;

    }




    // inserir venda

    public void inserirVenda() {

        System.out.println("--- Nova venda ---");


        // cliente
        if (listaClientes.isEmpty()) {

            System.out.println("Não há clientes cadastrados ainda :(");
            return;

        } else {

            System.out.println("Clientes cadastrados: ");

            for(Cliente c : listaClientes) {

                System.out.println("[" + c.getId() + "] " + c.getNome());

            }

            System.out.print("Digite o ID do cliente que efetuou a compra: ");
            int idCliente = input.nextInt();
            input.nextLine();


            Cliente cliente = null;
            for(Cliente c : listaClientes) {

                if (c.getId() == idCliente) {

                    cliente = c;
                    break;

                }

            }

            if (cliente == null) {

                System.out.println("Não encontrei esse cliente :(");
                return;

            }

            Venda venda = new Venda(cliente);


            while (true) {

                System.out.println("Bebidas:");

                for (Bebida b : listaBebidas) {

                    System.out.printf("[" + b.getId() + "] " + b.getNome() + " - R$" + b.getPreco() + "(Estoque: " + b.getQuantidadeEstoque() + ")");

                }

                System.out.print("Digite o ID da bebida (ou 0 para finalizar): ");
                int idBebida = input.nextInt();
                input.nextLine();

                if (idBebida == 0){

                    break;

                } else {

                    Bebida bebida = null;

                    for (Bebida b : listaBebidas) {

                        if (b.getId() == idBebida) {

                            bebida = b;
                            break;

                        }
                    }

                    if (bebida == null) {

                        System.out.println("Não encontrei a bebida :(");
                        continue;

                    }


                    System.out.print("Quantidade: ");
                    int qtd = input.nextInt();
                    input.nextLine();

                    if (qtd > bebida.getQuantidadeEstoque()) {

                        System.out.println("Estoque insuficiente!");
                        continue;

                    }

                    bebida.setQuantidadeEstoque(bebida.getQuantidadeEstoque() - qtd);
                    venda.adicionarItem(new ItemVenda(bebida, qtd));

                    System.out.println("Item adicionado :D");
                }
            }

            listaVendas.add(venda);
            System.out.println("Venda finalizada com sucesso! ID: " + venda.getId());

        }
    }





    // consultar vendas

    public void consultarVendas() {

        System.out.println("--- Lista de Vendas ---");

        if (listaVendas.isEmpty()) {

            System.out.println("Nenhuma venda cadastrada.");

        } else {

            for (Venda v : listaVendas) {

                System.out.println(v);

            }

        }

    }





    // alterar venda

    public void alterarVenda() {

        System.out.println("--- Alterar Venda buscando por ID ---");
        System.out.print("Digite o ID da venda: ");
        int idVenda = input.nextInt();
        input.nextLine();

        for (Venda v : listaVendas) {
            if (v.getId() == idVenda) {
                System.out.println("Venda encontrada :)");
                System.out.println(v);


                System.out.print("Deseja adicionar um item? (1-Sim / 0-Não): ");

                if (input.nextInt() == 1) {

                    input.nextLine();

                    System.out.print("Digite o ID da bebida: ");
                    int idBebida = input.nextInt();
                    input.nextLine();

                    Bebida bebida = null;

                    for (Bebida b : listaBebidas) {

                        if (b.getId() == idBebida) {
                            bebida = b;
                        }

                    }

                    if (bebida == null) {

                        System.out.println("Não encontrei a bebida :(");
                        return;

                    }

                    System.out.print("Quantidade: ");
                    int qtd = input.nextInt();
                    input.nextLine();

                    if (qtd > bebida.getQuantidadeEstoque()) {

                        System.out.println("Estoque insuficiente!");
                        return;

                    }

                    bebida.setQuantidadeEstoque(bebida.getQuantidadeEstoque() - qtd);
                    v.adicionarItem(new ItemVenda(bebida, qtd));
                    System.out.println("Item foi adicionado à venda :D");

                }

                return;

            }

        }

        System.out.println("Venda não encontrada :(");


    }

}
