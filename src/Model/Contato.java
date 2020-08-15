/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Edirlene
 */
public class Contato {
    private String telefone;
    private String email;

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }
      
    
      
    public String getTelefone(){   return telefone;    }
    public void setTelefone(String p_telefone){ this.telefone = p_telefone; }
    public String getEmail(){  return email;   }
    public void setEmail(String p_email){   this.email = p_email;   }
}
