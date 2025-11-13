package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Bebida;
import model.Cliente;
import model.ItemVenda;
import model.Venda;
import repository.BebidaRepository;
import repository.ClienteRepository;
import repository.VendaRepository;

public class VendaService {

    private VendaRepository vendaRepository = new VendaRepository();
    private ClienteRepository clienteRepository;
    private BebidaRepository bebidaRepository;
    private Scanner input = new Scanner(System.in);

    public VendaService(ClienteRepository clienteRepository, BebidaRepository bebidaRepository) {
        this.clienteRepository = clienteRepository;
        this.bebidaRepository = bebidaRepository;
    }

    public void cadastrarVenda(int idCliente, List<ItemVenda> itens) {
        Cliente cliente = clienteRepository.buscarPorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado :(");
            return;
        }
        Venda venda = new Venda(cliente);
        for (ItemVenda item : itens) {
            venda.adicionarItem(item);
            Bebida bebida = item.getProduto();
            bebida.setQuantidadeEstoque(bebida.getQuantidadeEstoque() - item.getQuantidade());
        }
        vendaRepository.adicionar(venda);
    }

    public void alterarVenda() {
        System.out.print("Digite o ID da venda: ");
        int idVenda = input.nextInt();
        input.nextLine();

        Venda venda = vendaRepository.buscarPorId(idVenda);
        if (venda == null) {
            System.out.println("Venda não encontrada :(");
            return;
        }

        System.out.println("Venda encontrada :)");
        System.out.println(venda);

        System.out.print("Deseja adicionar um item? (1-Sim / 0-Não): ");
        if (input.nextInt() == 1) {
            input.nextLine();
            System.out.print("Digite o ID da bebida: ");
            int idBebida = input.nextInt();
            input.nextLine();

            Bebida bebida = bebidaRepository.buscarPorId(idBebida);
            if (bebida == null) {
                System.out.println("Bebida não encontrada :(");
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
            venda.adicionarItem(new ItemVenda(bebida, qtd));
            System.out.println("Item foi adicionado à venda :D");
        }
    }

    public void consultarVendas() {
        List<Venda> lista = vendaRepository.listarTodos();
        System.out.println("--- Lista de Vendas ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            for (Venda v : lista) {
                System.out.println(v);
            }
        }
    }

    public void removerVenda(int id) {
        vendaRepository.remover(id);
    }

    public Venda buscarPorId(int id) {
        return vendaRepository.buscarPorId(id);
    }

}
