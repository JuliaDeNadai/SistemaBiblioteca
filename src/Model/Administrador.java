/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author Edirlene
 */
public class Administrador extends Usuario {
    private String user;
    private String password;

    public Administrador(String user, String password, String nome, String cpf, Endereco end, Contato contato) {
        super(nome, cpf, end, contato);
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
