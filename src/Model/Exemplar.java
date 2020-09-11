package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exemplar {
	protected int cod;
         protected boolean status;
	protected String titulo;
        protected String autor;
        protected String ano;
        protected String tipo;

        public Exemplar(String titulo, String autor, String ano, String tipo) {
            this.status = false;
            this.titulo = titulo;
            this.autor = autor;
            this.ano = ano;
            this.tipo = tipo;
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
