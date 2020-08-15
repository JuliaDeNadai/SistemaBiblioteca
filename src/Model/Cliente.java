
package Model;

import java.util.LinkedList;

/**
 *
 * @author Edirlene
 */
public class Cliente extends Usuario {

    public Cliente(String nome, String cpf, LinkedList<Emprestimo> emprestimos, Endereco end, Contato contato) {
        super(nome, cpf, emprestimos, end, contato);
    }

    
    
}
