import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorBebida {

    public ArrayList<Bebida> bebidas = new ArrayList<>();
    public Scanner input = new Scanner(System.in);

    
    // inserir bebida

    public void inserirBebida() {
    
        System.out.println("--- Inserir Bebida ---");
        
        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Volume (ex: 600ml, 1L): ");
        String volume = input.nextLine();

        System.out.print("Quantidade em estoque: ");
        int qtd = input.nextInt();

        System.out.print("Preço (R$): ");
        double preco = input.nextDouble();

        System.out.print("É alcoólica? (1 - Sim / 0 - Não): ");
        boolean alcoolica = (input.nextInt() == 1);
        input.nextLine();


        Bebida bebida = new Bebida(nome, qtd, volume, alcoolica, preco);
        bebidas.add(bebida);

        System.out.println("Bebida adicionada com sucesso! :D");
    
    }





    // consultar bebida    

    public void consultarBebidas() {

        System.out.println("--- Lista de Bebidas ---");
        
        if (bebidas.isEmpty()) {
        
            System.out.println("Nenhuma bebida cadastrada.");
        
        } else {
        
            for (Bebida b : bebidas) {
        
                System.out.println(b);
        
            }
        
        }
    
    }





    // alterar bebida

    public void alterarBebida() {

        int id;

        System.out.print("--- Alterando informações da bebida buscando por ID ---");
        System.out.println();


        System.out.print("Digite o ID da bebida que deseja alterar: ");
        id = input.nextInt();
        input.nextLine();


        for (Bebida bebida : bebidas) {

            if (bebida.getId() == id) {

                System.out.println("Digite ENTER se quiser manter a informação anterior");

            
                System.out.print("Novo nome (" + bebida.getNome() + "): ");
                String nome = input.nextLine();

                if (!nome.isEmpty()){
                    bebida.setNome(nome);
                }


                System.out.print("Novo volume (" + bebida.getVolume() + "): ");
                String volume = input.nextLine();

                if (!volume.isEmpty()){
                    bebida.setVolume(volume);
                }


                System.out.print("Nova quantidade (" + bebida.getQuantidadeEstoque() + "): ");
                String quantidadeEstoque = input.nextLine();
                
                if (!quantidadeEstoque.isEmpty()){
                    bebida.setQuantidadeEstoque(Integer.parseInt(quantidadeEstoque));
                } 


                System.out.print("Novo preço (" + bebida.getPreco() + "): ");
                String preco = input.nextLine();

                if (!preco.isEmpty()) {
                    bebida.setPreco(Double.parseDouble(preco));
                } 


                System.out.print("É alcoólica? (1 - Sim / 0 - Não): ");
                String alcoolica = input.nextLine();
                
                if (!alcoolica.isEmpty()) {
                    bebida.setAlcoolica(alcoolica.equals("1"));
                }

                System.out.println("A bebida foi alterada! ;)");
                return;
         
            }
        
        }

        System.out.println("Não encontrei a bebida :(");

    }





    // remover bebida

    public void removerBebida() {

        int id;

        System.out.print("--- Removendo bebida por meio da busca por ID ---");
        System.out.println();


        System.out.print("Digite o ID da bebida que você deseja remover: ");
        id = input.nextInt();
        input.nextLine();

        Bebida bebida = buscarPorId(id);

        if (bebida != null) {

            bebidas.remove(bebida);
            System.out.println("Bebida foi removido com sucesso! :)");

        } else {

            System.out.println("Não encontrei a bebida :(");

        }

    }

    public Bebida buscarPorId(int id) {

        for (Bebida b : bebidas) {

            if (b.getId() == id){

                return b;

            }

        }

        return null;

    }


    public ArrayList getListaBebidas(){

        return bebidas;
        
    }

}


