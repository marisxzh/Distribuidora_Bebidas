package service;

import java.util.List;
import java.util.Scanner;
import model.Bebida;
import repository.BebidaRepository;

public class BebidaService {

    private BebidaRepository repository;
    private Scanner input = new Scanner(System.in);

    public BebidaService(BebidaRepository repository) {
        this.repository = repository;
    }

    public void cadastrarBebida(String nome, int quantidadeEstoque, String volume, boolean alcoolica, double preco) {
        Bebida bebida = new Bebida(nome, quantidadeEstoque, volume, alcoolica, preco);
        repository.adicionar(bebida);
    }

    public void alterarBebida() {
        System.out.print("Digite o ID da bebida que deseja alterar: ");
        int id = input.nextInt();
        input.nextLine();

        Bebida bebida = repository.buscarPorId(id);
        if (bebida == null) {
            System.out.println("Bebida não encontrada :(");
            return;
        }

        System.out.println("Digite ENTER se quiser manter a informação anterior");

        System.out.print("Novo nome (" + bebida.getNome() + "): ");
        String nome = input.nextLine();
        if (!nome.isEmpty()) bebida.setNome(nome);

        System.out.print("Novo volume (" + bebida.getVolume() + "): ");
        String volume = input.nextLine();
        if (!volume.isEmpty()) bebida.setVolume(volume);

        System.out.print("Nova quantidade (" + bebida.getQuantidadeEstoque() + "): ");
        String quantidadeEstoque = input.nextLine();
        if (!quantidadeEstoque.isEmpty()) bebida.setQuantidadeEstoque(Integer.parseInt(quantidadeEstoque));

        System.out.print("Novo preço (" + bebida.getPreco() + "): ");
        String preco = input.nextLine();
        if (!preco.isEmpty()) bebida.setPreco(Double.parseDouble(preco));

        System.out.print("É alcoólica? (1 - Sim / 0 - Não): ");
        String alcoolica = input.nextLine();
        if (!alcoolica.isEmpty()) bebida.setAlcoolica(alcoolica.equals("1"));

        System.out.println("A bebida foi alterada! ;)");
    }

    public void consultarBebidas() {
        List<Bebida> lista = repository.listarTodos();
        System.out.println("--- Lista de Bebidas ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            for (Bebida b : lista) {
                System.out.println(b);
            }
        }
    }

    public void removerBebida(int id) {
        repository.remover(id);
    }

    public Bebida buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

}
