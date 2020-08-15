
package Model;

import java.util.LinkedList;

/**
 *
 * @author Edirlene
 */
public class Cliente extends Usuario {
    LinkedList<Emprestimo> emprestimos;

    public Cliente(String nome, String cpf, Endereco end, Contato contato) {
        super(nome, cpf, end, contato);
        this.emprestimos = new LinkedList<Emprestimo>();
    }

    
    
}
