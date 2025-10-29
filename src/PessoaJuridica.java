//Classe-filha PessoaJuridica


public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String telefone, String email, String cnpj) {

        super (nome, telefone, email);
        
        this.cnpj = cnpj;

    }


    public PessoaJuridica() {
    }


    // getters

    public String getCnpj() {
        return this.cnpj;
    }


    // setters

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    @Override
    public void consultar() {

        super.consultar();

        System.out.println("CNPJ: " + cnpj);
        System.out.println("-----------");
        
    }
    
}