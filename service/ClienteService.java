package service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import repository.ClienteRepository;


public class ClienteService {

    private ClienteRepository repository;
    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


    // cadastrar cliente

    public void cadastrarPessoaFisica(String nome, String telefone, String email, String cpf, LocalDate dataNascimento) {

        PessoaFisica pf = new PessoaFisica(nome, telefone, email, cpf, dataNascimento);

        repository.adicionar(pf);

    }

    public void cadastrarPessoaJuridica(String nome, String telefone, String email, String cnpj) {

        PessoaJuridica pj = new PessoaJuridica(nome, telefone, email, cnpj);

        repository.adicionar(pj);

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
    


    // consultar cliente
    public void consultarClientes() {


        List<Cliente> lista = repository.listarTodos();

        if (lista.isEmpty()) {

            System.out.println("Nenhum cliente cadastrado.");

        } else {

            for (Cliente c : lista) {

                c.consultar();

            }

        }

    }


    // remover cliente
    public void removerCliente(int id) {

        repository.remover(id);

    }


    // buscar por id
    public Cliente buscarPorId(int id) {

        return repository.buscarPorId(id);

    }






}