//Classe-filha PessoaJuridica


//importando tratamento de datas (para idade e data de nascimento)

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class PessoaFisica extends Cliente {

    private String cpf;
    private LocalDate dataNascimento;

    //formatar data de nascimento
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public PessoaFisica (String nome, String telefone, String email, String cpf, LocalDate dataNascimento) {

        super (nome, telefone, email);

        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }

    public PessoaFisica() {
    }


    // getters

    public String getCpf() {
        return this.cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }


    // setters

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    //idade automatica
    public int getIdade() {

        if (dataNascimento == null){

            return 0;

        } else{

            return Period.between(dataNascimento, LocalDate.now()).getYears();

        }

    }


    @Override
    public void consultar() {
        
        super.consultar();
        
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + dataNascimento.format(formato));
        System.out.println("Idade: " + getIdade() + " anos");
        System.out.println("-----------");
    }
    

}