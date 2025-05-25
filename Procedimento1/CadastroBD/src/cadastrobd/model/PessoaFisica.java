package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    // Construtor padrão
    public PessoaFisica() {
        super();
    }

    // Construtor completo
    public PessoaFisica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        super(id, nome, logradouro, cidade, estado, telefone, email);
        this.cpf = cpf;
    }

    // Método Getter para CPF
    public String getCpf() {
        return cpf;
    }

    // Método Setter para CPF (opcional, adicione se precisar modificar o CPF após a criação)
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
    }
}