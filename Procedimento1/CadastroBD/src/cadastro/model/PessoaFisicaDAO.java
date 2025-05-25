package cadastro.model;

import cadastro.model.util.ConectorBD;
import cadastrobd.model.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {

    public PessoaFisica getPessoa(int id) throws Exception {
        PessoaFisica pessoa = null;
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        
        // Buscando só as pessoas do tipo 'F' (física)
        String sql = "SELECT * FROM pessoa WHERE idpessoa = ? AND tipoPessoa = 'F'";
        
        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, id);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
            pessoa = new PessoaFisica(
                resultado.getInt("idpessoa"),
                resultado.getString("nome"),
                resultado.getString("logradouro"),
                resultado.getString("cidade"),
                resultado.getString("estado"),
                resultado.getString("telefone"),
                resultado.getString("email"),
                resultado.getString("cpf_cnpj") // Aqui usa o cpf_cnpj para cpf mesmo
            );
        }
        
        ConectorBD.close(resultado);
        ConectorBD.close(ps);
        ConectorBD.close(con);
        return pessoa;
    }
    
    public List<PessoaFisica> getPessoas() throws Exception {
        List<PessoaFisica> lista = new ArrayList<>();
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        ResultSet resultado = null;
        
        String sql = "SELECT * FROM pessoa WHERE tipoPessoa = 'F'";
        
        ps = ConectorBD.getPrepared(sql, con);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
            lista.add(new PessoaFisica(
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
    
    public void incluir(PessoaFisica pessoafisica) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO pessoa (idpessoa, nome, logradouro, cidade, estado, telefone, email, cpf_cnpj, tipoPessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'F')";
        
        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, pessoafisica.getId());
        ps.setString(2, pessoafisica.getNome());
        ps.setString(3, pessoafisica.getLogradouro());
        ps.setString(4, pessoafisica.getCidade());
        ps.setString(5, pessoafisica.getEstado());
        ps.setString(6, pessoafisica.getTelefone());
        ps.setString(7, pessoafisica.getEmail());
        ps.setString(8, pessoafisica.getCpf()); // cpf no campo cpf_cnpj
        
        ps.execute();
        
        ConectorBD.close(ps);
        ConectorBD.close(con);
    }
    
    public void alterar(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE pessoa SET nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=?, cpf_cnpj=? WHERE idpessoa=? AND tipoPessoa='F'";
        
        ps = ConectorBD.getPrepared(sql, con);
        ps.setString(1, nome);
        ps.setString(2, logradouro);
        ps.setString(3, cidade);
        ps.setString(4, estado);
        ps.setString(5, telefone);
        ps.setString(6, email);
        ps.setString(7, cpf);
        ps.setInt(8, id);
        
        ps.execute();
        
        ConectorBD.close(ps);
        ConectorBD.close(con);
    }
    
    public void excluir(int id) throws Exception {
        Connection con = ConectorBD.getConnection();
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM pessoa WHERE idpessoa=? AND tipoPessoa='F'";
        
        ps = ConectorBD.getPrepared(sql, con);
        ps.setInt(1, id);
        
        ps.execute();
        
        ConectorBD.close(ps);
        ConectorBD.close(con);
    }
}
