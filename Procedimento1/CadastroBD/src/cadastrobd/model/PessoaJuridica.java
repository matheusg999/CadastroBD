package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super();
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cnpj = cnpj;
    }

    // Método Getter para CNPJ
    public String getCnpj() {
        return cnpj;
    }

    // Método Setter para CNPJ
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    @Override
    public void exibir() {
        super.exibir(); 
        System.out.println("CNPJ: " + cnpj);
    }
}