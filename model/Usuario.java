// classe usuario

package model;

public class Usuario{

    private static int idAutomatico = 1;

    private int id;
    private String nome, email, senha, telefone;


    public Usuario(String nome, String email, String senha, String telefone){

        this.id = idAutomatico++;

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;

    }



    // getters

    public int getId() {
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelefone(){
        return this.telefone;
    }


    // setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }


    public void consultar() {

        System.out.println("--- Usuario ---");

        System.out.println("ID: " + getId() );
        System.out.println("Nome: " + getNome() );
        System.out.println("Email: " + getEmail() );
        System.out.println("Telefone: " + getTelefone() );

    } 

}