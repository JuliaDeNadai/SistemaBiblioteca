package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Usuario {
	protected int cod;
	protected String nome;
        protected String cpf;
        protected String tipo;
        Endereco end;
        Contato contato;
        

        public Usuario(String nome, String cpf, String tipo, Endereco end, Contato contato) {
            this.nome = nome;
            this.cpf = cpf;
            this.tipo = tipo;
            this.end = end;
            this.contato = contato;
        }
	
        public void inserirUsuario(Usuario user)throws SQLException {
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		sql = "INSERT INTO cliente (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, CIDADE, EMAIL, TELEFONE, TIPO, USER, SENHA) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		//stmt = conn.prepareStatement(sql); //criar conexão
		
		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getCPF());
		stmt.setString(3, user.end.getRua());
                stmt.setString(4, user.end.getNumero());
		stmt.setString(5, user.end.getBairro());
                stmt.setString(6, user.end.getCEP());
                stmt.setString(7, user.end.getCidade());
                stmt.setString(8, user.contato.getEmail());
                stmt.setString(9, user.contato.getTelefone());
                stmt.setString(10, user.getTipo());
                
                if(user.getTipo().equalsIgnoreCase("Administrador")){ 
                    stmt.setString(11, ((Administrador)user).getUser());
                    stmt.setString(12, ((Administrador)user).getPassword());
                }else{
                    stmt.setString(11, "-");
                    stmt.setString(12, "-");
                }
                
		stmt.execute();
	
        }
	
        public ResultSet getUsuarios()throws SQLException {
                //Connection con = new Connection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try{
                    sql = "SELECT * FROM 'PUBLIC'.USUARIO";
                    //stmt = con.prepareStatement(sql); //criar conexão
                    result = stmt.executeQuery();
                }catch(Exception err){
                    
                }finally{
                    try{
                        //con.close();
                    }catch(Exception e){
                    
                    }
                }
		
		return result;
	}
        
        public ResultSet searchUserByID(int cod)throws SQLException {
                //Connection con = new Connection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		try{
                    sql = "SELECT * FROM 'PUBLIC'.USUARIO WHERE cod="+cod;
                    //stmt = con.prepareStatement(sql); //criar conexão
                    result = stmt.executeQuery();
                }catch(Exception err){
                    
                }finally{
                    try{
                        //con.close();
                    }catch(Exception e){
                    
                    }
                }
		
		return result;
	}
        
        public void excluirUsuario(int cod)throws SQLException {
                //Connection con = new Connection();
		String sql = "";
		PreparedStatement stmt = null;
                
		try{
                    sql = "DELETE FROM 'PUBLIC'.USUARIO WHERE id="+cod;
                    //stmt = con.prepareStatement(sql); //criar conexão
                    stmt.execute();
                }catch(Exception err){
                    
                }finally{
                    try{
                        //con.close();
                    }catch(Exception e){
                    
                    }
                }
		
	}
        
	public int getCod() {
		return cod;
	}
	public void setCod(int p_cod) {
		this.cod = p_cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String p_nome) {
		this.nome = p_nome;
	}
        public String getCPF() {
		return cpf;
	}
	public void setCPF(String p_cpf) {
		this.cpf = p_cpf;
	}

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String p_tipo) {
            this.tipo = p_tipo;
        }
        
}
