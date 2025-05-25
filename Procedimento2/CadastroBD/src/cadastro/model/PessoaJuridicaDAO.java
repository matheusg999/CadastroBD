package cadastro.model;

import cadastro.model.util.ConectorBD;
import cadastrobd.model.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {

    public PessoaJuridica getPessoa(int id) throws Exception {
        PessoaJuridica pessoa = null;
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        ResultSet resultado = null;

        String sql = "SELECT * FROM pessoa WHERE idpessoa = ? AND tipoPessoa = 'J'";

        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, id);
        resultado = ps.executeQuery();

        while (resultado.next()) {
            pessoa = new PessoaJuridica(
                resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf_cnpj") // aqui é CNPJ para jurídica
            );
        }

        ConectorBD.close(resultado);
        ConectorBD.close(ps);
        ConectorBD.close(con);
        return pessoa;
    }

    public List<PessoaJuridica> getPessoas() throws Exception {
        List<PessoaJuridica> lista = new ArrayList<>();
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        ResultSet resultado = null;

        String sql = "SELECT * FROM pessoa WHERE tipoPessoa = 'J'";

        ps = ConectorBD.getPrepared(sql, con);
        resultado = ps.executeQuery();

        while (resultado.next()) {
            lista.add(new PessoaJuridica(
                resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf_cnpj")
            ));
        }

        ConectorBD.close(resultado);
        ConectorBD.close(ps);
        ConectorBD.close(con);
        return lista;
    }

    public void incluir(PessoaJuridica pessoajuridica) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO pessoa (idpessoa, nome, logradouro, cidade, estado, telefone, email, cpf_cnpj, tipoPessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'J')";

        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, pessoajuridica.getId());
        ps.setString(2, pessoajuridica.getNome());
        ps.setString(3, pessoajuridica.getLogradouro());
        ps.setString(4, pessoajuridica.getCidade());
        ps.setString(5, pessoajuridica.getEstado());
        ps.setString(6, pessoajuridica.getTelefone());
        ps.setString(7, pessoajuridica.getEmail());
        ps.setString(8, pessoajuridica.getCnpj()); // cnpj no campo cpf_cnpj

        ps.execute();

        ConectorBD.close(ps);
        ConectorBD.close(con);
    }

    public void alterar(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;

        String sql = "UPDATE pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=?, cpf_cnpj=? WHERE idpessoa=? AND tipoPessoa='J'";

        ps = ConectorBD.getPrepared(sql, con);
        ps.setString(1, nome);
        ps.setString(2, logradouro);
        ps.setString(3, cidade);
        ps.setString(4, estado);
        ps.setString(5, telefone);
        ps.setString(6, email);
        ps.setString(7, cnpj);
        ps.setInt(8, id);

        ps.execute();

        ConectorBD.close(ps);
        ConectorBD.close(con);
    }

    public void excluir(int id) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;

        String sql = "DELETE FROM pessoa WHERE idpessoa=? AND tipoPessoa='J'";

        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, id);

        ps.execute();

        ConectorBD.close(ps);
        ConectorBD.close(con);
    }
}
