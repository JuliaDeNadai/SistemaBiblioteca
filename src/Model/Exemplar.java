package Model;

import Controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplar {
	protected int cod;
	protected String titulo;
        protected boolean status;
        protected String autor;
        protected String ano;
        protected String tipo;

        public Exemplar(String titulo, String autor, String ano, String tipo) {
            this.titulo = titulo;
            this.status = false;
            this.autor = autor;
            this.ano = ano;
            this.tipo = tipo;
        }
        
        public Exemplar() {
            
        }
        
        public void inserirExemplar(Exemplar ex)throws SQLException {
		Connection con = Conexion.connect();
                try{
                    Statement st = con.createStatement();
                    
                    if(ex.getTipo().equalsIgnoreCase("Artigo")){
                         st.executeUpdate("INSERT INTO EXEMPLAR (STATUS, TITULO, AUTOR, ANO, TIPO, EDITORA, EDICAO, INSTITUICAO, DEPARTAMENTO) VALUES ('"+ex.getStatus()+"', '"+ex.getTitulo()+"', '"+ex.getAutor()+"', '"+ex.getAno()+"', '"+ex.getTipo()+"',+'-', +'-', '"+((Artigo)ex).getInstituicao()+"', '"+((Artigo)ex).getDepartamento()+"')");
                    }else{
                         st.executeUpdate("INSERT INTO EXEMPLAR (STATUS, TITULO, AUTOR, ANO, TIPO, EDITORA, EDICAO, INSTITUICAO, DEPARTAMENTO) VALUES ('"+ex.getStatus()+"', '"+ex.getTitulo()+"', '"+ex.getAutor()+"', '"+ex.getAno()+"', '"+ex.getTipo()+"', '" +((Livro)ex).getEditora()+"','" +((Livro)ex).getEdicao()+"-"+"', '"+"-"+"')");
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
        
        public ResultSet getExemplares() throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		ResultSet result = null;
		try{
                    stmt = con.prepareStatement("SELECT * FROM EXEMPLAR"); 
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
        
        public Exemplar searchExemplarByID(String cod) throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		ResultSet result = null;
                Exemplar ex;
                String[] dadosExemplar = new String[8];
		try{
                    stmt = con.prepareStatement("SELECT * FROM EXEMPLAR WHERE id ="+cod); //criar conexão
                    result = stmt.executeQuery();
                    try {
                        while (result.next()){
                            dadosExemplar[0] = result.getString("TITULO");
                            dadosExemplar[1] = result.getString("AUTOR");
                            dadosExemplar[2] = result.getString("ANO");
                            dadosExemplar[3] = result.getString("TIPO");
                            dadosExemplar[4] = result.getString("EDITORA");
                            dadosExemplar[5] = result.getString("EDICAO");
                            dadosExemplar[6] = result.getString("INSTITUICAO");
                            dadosExemplar[7] = result.getString("DEPARTAMENTO");
                            
      
                            
                            if(result.getString("TIPO").equalsIgnoreCase("Livro")){
                               return ex = new Livro(dadosExemplar[5], dadosExemplar[4], dadosExemplar[0], dadosExemplar[1],dadosExemplar[2] );
                            }else{
                               return ex = new Artigo(dadosExemplar[6], dadosExemplar[7], dadosExemplar[0], dadosExemplar[1],dadosExemplar[2] );
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
        
        public void excluirExemplar(String cod)throws SQLException {
                Connection con = Conexion.connect();
		PreparedStatement stmt = null;
		try{
                    stmt = con.prepareStatement("DELETE FROM EXEMPLAR WHERE id="+cod);
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
        
        public void alterarUsuario (Exemplar ex, String cod) throws SQLException {
                Connection con = Conexion.connect();
                try{
                    Statement st = con.createStatement();
                    if(ex.getTipo().equalsIgnoreCase("Artigo")){
                        st.executeUpdate("UPDATE EXEMPLAR SET TITULO= '"+ex.getTitulo()+"', AUTOR = '"+ex.getAutor()+"', ANO =  '"+ex.getAno()+"', TIPO = '"+ex.getTipo()+"', INSTITUICAO = '"+((Artigo)ex).getInstituicao()+"', DEPARTAMENTO = '"+((Artigo)ex).getDepartamento()+"' WHERE ID="+cod);
                    }else{
                        st.executeUpdate("UPDATE EXEMPLAR SET TITULO= '"+ex.getTitulo()+"', AUTOR = '"+ex.getAutor()+"', ANO =  '"+ex.getAno()+"', TIPO = '"+ex.getTipo()+"', EDITORA = '"+((Livro)ex).getEditora()+"', EDICAO = '"+((Livro)ex).getEdicao()+"' WHERE ID="+cod);
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

	public int getCod() {
            return cod;
        }

        public void setCod(int p_cod) {
            this.cod = p_cod;
        }
        
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String p_titulo) {
            this.titulo = p_titulo;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean p_status) {
            this.status = p_status;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String p_autor) {
            this.autor = p_autor;
        }

        public String getAno() {
            return ano;
        }

        public void setAno(String p_ano) {
            this.ano = p_ano;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String p_tipo) {
            this.tipo = p_tipo;
        }
	
	
}
