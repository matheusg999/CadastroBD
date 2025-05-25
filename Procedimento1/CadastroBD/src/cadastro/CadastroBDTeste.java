package cadastro;

import cadastro.model.PessoaFisicaDAO;
import cadastro.model.PessoaJuridicaDAO;
import cadastro.model.util.SequenceManager;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.List;

public class CadastroBDTeste {

    public static void main(String[] args) {

        
        try {
            System.out.println("Incluindo pessoa física...");
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            long idPF = SequenceManager.getValue("seq_pessoa_id");
            PessoaFisica pf = new PessoaFisica(
                (int) idPF, "Théo", "Rua 9", "São Paulo", "SP",
                "9999-9999", "theo@sp.com", "99999999999"
            );
            pfDao.incluir(pf);
            System.out.println("Pessoa física incluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("Alterando pessoa física...");
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            pfDao.alterar(4, "Théo Alterado", "Rua 99", "São Paulo", "SP",
                "9999-9999", "theo@spfc.com", "88888888888"
            );
            System.out.println("Pessoa física alterada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("Excluindo pessoa física...");
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            pfDao.excluir(4);
            System.out.println("Pessoa física excluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("--- Pessoas Físicas cadastradas ---");
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            List<PessoaFisica> pessoasFisicas = pfDao.getPessoas();
            for (PessoaFisica p : pessoasFisicas) {
                System.out.println("Id: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Logradouro: " + p.getLogradouro());
                System.out.println("Cidade: " + p.getCidade());
                System.out.println("Estado: " + p.getEstado());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("E-mail: " + p.getEmail());
                System.out.println("CPF: " + p.getCpf());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("Incluindo pessoa jurídica...");
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            long idPJ = SequenceManager.getValue("seq_pessoa_id");
            PessoaJuridica pj = new PessoaJuridica(
                (int) idPJ, "NINES Ltda", "Avenida Central, 999", "São Paulo", "SP",
                "2222-2222", "contato@nines.com", "12345678000199"
            );
            pjDao.incluir(pj);
            System.out.println("Pessoa jurídica incluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("--- Pessoas Jurídicas cadastradas ---");
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            List<PessoaJuridica> pessoasJuridicas = pjDao.getPessoas();
            for (PessoaJuridica p : pessoasJuridicas) {
                System.out.println("Id: " + p.getId());
                System.out.println("Razão Social: " + p.getNome());
                System.out.println("Logradouro: " + p.getLogradouro());
                System.out.println("Cidade: " + p.getCidade());
                System.out.println("Estado: " + p.getEstado());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("E-mail: " + p.getEmail());
                System.out.println("CNPJ: " + p.getCnpj());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("Alterando pessoa jurídica...");
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            pjDao.alterar(5, "NINES Comércio Ltda", "Av. Paulista, 1500", "São Paulo", "SP",
                "3333-3333", "contato@ninescomercial.com", "8765432000188"
            );
            System.out.println("Pessoa jurídica alterada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        try {
            System.out.println("--- Pessoas Jurídicas atualizadas ---");
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            List<PessoaJuridica> pessoasJuridicasAtualizadas = pjDao.getPessoas();
            for (PessoaJuridica p : pessoasJuridicasAtualizadas) {
                System.out.println("Id: " + p.getId());
                System.out.println("Razão Social: " + p.getNome());
                System.out.println("Logradouro: " + p.getLogradouro());
                System.out.println("Cidade: " + p.getCidade());
                System.out.println("Estado: " + p.getEstado());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("E-mail: " + p.getEmail());
                System.out.println("CNPJ: " + p.getCnpj());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        try {
            System.out.println("Excluindo pessoa jurídica...");
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            pjDao.excluir(5);
            System.out.println("Pessoa jurídica excluída com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
