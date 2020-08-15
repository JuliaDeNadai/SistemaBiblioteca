package Model;

public class Livro extends Exemplar  {
	private String editora;
        private String edicao;

    public Livro(String editora, String edicao, String titulo, String autor, String ano) {
        super(titulo, autor, ano, "Livro");
        this.editora = editora;
        this.edicao = edicao;
    }
        
    public String getEditora() {
        return editora;
    }

    public void setEditora(String p_editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String p_edicao) {
        this.edicao = p_edicao;
    }
	
}
