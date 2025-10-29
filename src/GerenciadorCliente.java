import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;



public class GerenciadorCliente {

    public ArrayList<Cliente> clientes = new ArrayList<>();
    public Scanner input = new Scanner(System.in);
    public static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");





    // buscar por id

    public Cliente buscarPorId(int id) {

        for (Cliente c : clientes) {

            if (c.getId() == id){
                return c;
            }

        }

        return null;

    }





    //inserir cliente
    public void inserirCliente() {

        int tipo;

        System.out.println("Tipo de cliente a ser inserido:");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        System.out.println();

        System.out.print("Digite o tipo de cliente: ");
        tipo = input.nextInt();
        input.nextLine();


        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        if (tipo == 1) {

            System.out.print("CPF: ");
            String cpf = input.nextLine();

            System.out.print("Data de nascimento (dd/MM/yyyy): ");
            String dataTexto = input.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataTexto, formato);


            PessoaFisica pf = new PessoaFisica(nome, telefone, email, cpf, dataNascimento);

            clientes.add(pf);
            System.out.println("Um cliente do tipo Pessoa Física foi adicionado! :)");
            System.out.println("ID: " + pf.getId());

        } else if (tipo == 2) {

            System.out.print("CNPJ: ");
            String cnpj = input.nextLine();


            PessoaJuridica pj = new PessoaJuridica(nome, telefone, email, cnpj);

            clientes.add(pj);
            System.out.println("Um cliente do tipo Pessoa Jurídica foi adicionado! :)");
            System.out.println("ID: " + pj.getId());

        } else {

            System.out.println("Tipo de cliente inválido!");

        }

    }





    // consultar cliente
    public void consultarClientes() {

        if (clientes.isEmpty()) {

            System.out.println("Nenhum cliente cadastrado.");
        
        } else {
        
            for (Cliente c : clientes) {
        
                c.consultar();
        
            }
        
        }
    
    }





    // alterar cliente
    public void alterarCliente() {

        int id;

        System.out.print("--- Alterando informações do cliente buscando por ID ---");
        System.out.println();


        System.out.print("Digite o ID do cliente que deseja alterar: ");
        id = input.nextInt();
        input.nextLine();


        Cliente cliente = buscarPorId(id);


        if (cliente == null) {

            System.out.println("Não encontrei o cliente :(");
            return;
        
        } else {

            System.out.print("Novo nome (ENTER para manter): ");
            String nome = input.nextLine();

            if (!nome.isEmpty()) {
                cliente.setNome(nome);
            }


            System.out.print("Novo telefone (ENTER para manter): ");
            String telefone = input.nextLine();
            
            if (!telefone.isEmpty()){
                cliente.setTelefone(telefone);
            } 


            System.out.print("Novo email (ENTER para manter): ");
            String email = input.nextLine();
            
            if (!email.isEmpty()) {
                cliente.setEmail(email);
            }


        
            if (cliente instanceof PessoaFisica pf) {
                
                System.out.print("Novo CPF (ENTER para manter): ");
                String cpf = input.nextLine();
                
                if (!cpf.isEmpty()) {
                    pf.setCpf(cpf);
                } 


                System.out.print("Nova data de nascimento (dd/MM/yyyy ou ENTER para manter): ");
                String dataTexto = input.nextLine();
            
                if (!dataTexto.isEmpty()) {

                    LocalDate novaData = LocalDate.parse(dataTexto, formato);
                    pf.setDataNascimento(novaData);
                
                }

            } else if (cliente instanceof PessoaJuridica pj) {

                System.out.print("Novo CNPJ (ENTER para manter): ");
                String cnpj = input.nextLine();
            
                if (!cnpj.isEmpty()) {
                    pj.setCnpj(cnpj);
                } 

            }

        System.out.println("Os dados foram atualizados com sucesso! :D");

        }
    }






    // remover cliente
    public void removerCliente() {

        int id;

        System.out.print("--- Removendo cliente por meio da busca por ID ---");
        System.out.println();


        System.out.print("Digite o ID do cliente que você deseja remover: ");
        id = input.nextInt();
        input.nextLine();

        Cliente cliente = buscarPorId(id);

        if (cliente != null) {

            clientes.remove(cliente);
            System.out.println("Cliente foi removido com sucesso! :)");

        } else {

            System.out.println("Não encontrei o cliente :(");
        
        }

    }



    public ArrayList getListaClientes(){

        return clientes;
        
    }


}