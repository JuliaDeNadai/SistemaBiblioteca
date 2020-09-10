package Model;

import java.util.LinkedList;

public class Administrador extends Usuario {
    private String user;
    private String password;

    public Administrador(String user, String password, String nome, String cpf, Endereco end, Contato contato) {
        super(nome, cpf, "Administrador", end, contato);
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String p_user) {
        this.user = p_user;
    }

    public void setPassword(String p_password) {
        this.password = p_password;
    }
    
}
