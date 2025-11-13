// classe-mãe Cliente

package model;

public class Cliente {

    private static int idAutomatico = 1;

    private int id;
    private String nome, telefone, email;

    public Cliente(String nome, String telefone, String email) {

        this.id = idAutomatico++;

        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

    }


    public Cliente() {

        this.id = idAutomatico++;

    }


    //getters

    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }


    //setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void consultar() {

        System.out.println("--- Cliente ---");

        System.out.println("ID: " + getId() );
        System.out.println("Nome: " + getNome() );
        System.out.println("Telefone: " + getTelefone() );
        System.out.println("Email: " + getEmail() );


    }

}