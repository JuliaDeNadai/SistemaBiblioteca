package Model;

import Controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Usuario {
	protected int cod;
	protected String nome;
        protected String cpf;
        protected String tipo;
        public Endereco end;
        public Contato contato;
        
        
        /teste teste
        public Usuario(String nome, String cpf, String tipo, Endereco end, Contato contato) {
            this.nome = nome;
            this.cpf = cpf;
            this.tipo = tipo;
            this.end = end;
            this.contato = contato;
        }
        public Usuario(){
            
        }
        
        public void inserirUsuario(Usuario user)throws SQLException {
		Connection con = Conexion.connect();
                try{
                    Statement st = con.createStatement();
                    if(user.getTipo().equalsIgnoreCase("Administrador")){
                         st.executeUpdate("INSERT INTO USUARIO (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, CIDADE, EMAIL, TELEFONE, TIPO, USER, SENHA) VALUES ('"+user.getNome()+"', '"+user.getCPF()+"', '"+user.end.getRua()+"', '"+user.end.getNumero()+"', '"+user.end.getBairro()+"', "
                            + "'"+user.end.getCEP()+"', '"+user.end.getCidade()+"', '"+user.contato.getEmail()+"', '"+user.contato.getTelefone()+"', '"+user.getTipo()+"', '"+((Administrador)user).getUser()+"', '"+((Administrador)user).getPassword()+"')");
                    }else{
                         st.executeUpdate("INSERT INTO USUARIO (NOME, CPF, RUA, NUMERO, BAIRRO, CEP, CIDADE, EMAIL, TELEFONE, TIPO, USER, SENHA) VALUES ('"+user.getNome()+"', '"+user.getCPF()+"', '"+user.end.getRua()+"', '"+user.end.getNumero()+"', '"+user.end.getBairro()+"', "
                            + "'"+user.end.getCEP()+"', '"+user.end.getCidade()+"', '"+user.contato.getEmail()+"', '"+user.contato.getTelefone()+"', '"+user.getTipo()+"', +'-', +'-')");
                    }
                   
                }catch(Exception e){
                    System.err.println("Error5" +e);
                }finally{
                    try{
                        con.close();
                    }catch(SQLException e){
                        System.err.println("Error6" +e);
                    }
                }
        }
	
        public ResultSet getUsuarios() throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try{
                    stmt = con.prepareStatement("SELECT * FROM USUARIO"); 
                    result = stmt.executeQuery();
                    
                }catch(Exception e){
                    System.err.println("Error1" +e);
                }finally{
                    try{
                        con.close();
                    }catch(SQLException e){
                        System.err.println("Error2" +e);
                    }
                }
		return result;
	}
        
        public Usuario searchUserByID(String cod)throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		ResultSet result = null;
                Usuario u;
                String[] dadosUser = new String[12];
		try{
                    stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE id ="+cod); //criar conexão
                    result = stmt.executeQuery();
                    try {
                        while (result.next()){
                            dadosUser[0] = result.getString("NOME");
                            dadosUser[1] = result.getString("CPF");
                            dadosUser[2] = result.getString("RUA");
                            dadosUser[3] = result.getString("NUMERO");
                            dadosUser[4] = result.getString("BAIRRO");
                            dadosUser[5] = result.getString("CEP");
                            dadosUser[6] = result.getString("CIDADE");
                            dadosUser[7] = result.getString("EMAIL");
                            dadosUser[8] = result.getString("TELEFONE");
                            dadosUser[9] = result.getString("TIPO");
                            dadosUser[10] = result.getString("USER");
                            dadosUser[11] = result.getString("SENHA");
                            
                            Endereco end = new Endereco(dadosUser[2], dadosUser[3], dadosUser[4], dadosUser[5], dadosUser[6]);
                            Contato contato = new Contato(dadosUser[8], dadosUser[7]);
                            String[] dadosLogin = new String[2];
                            
                            dadosLogin[0] = dadosUser[10];
                            dadosLogin[1] = dadosUser[11];
                            
                            if(result.getString("TIPO").equalsIgnoreCase("Administrador")){
                               return u = new Administrador(dadosLogin[0], dadosLogin[1], dadosUser[0], dadosUser[1], end, contato);
                            }else{
                               return u = new Cliente(dadosUser[0], dadosUser[1], end, contato);
                            }
                        }                     
                    }catch (SQLException e1){
                        System.err.println("Error11" +e1);
                    } 
                }catch(Exception err){
                     System.err.println("Error9" +err);
                }finally{
                    try{
                        con.close();
                    }catch(Exception e){
                         System.err.println("Error10" +e);
                    }
                }
		
		return null;
	}
        
        public void excluirUsuario(String cod)throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		try{
                    stmt = con.prepareStatement("DELETE FROM USUARIO WHERE id="+cod); //criar conexão
                    int i = stmt.executeUpdate();
                    System.out.println("i: "+i);
                }catch(Exception err){
                    System.err.println("Error5"+err);
                }finally{
                    try{
                        con.close();
                    }catch(Exception e){
                    System.err.println("Error6"+e);
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
