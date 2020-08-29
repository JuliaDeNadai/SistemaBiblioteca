
package Model;


/**
 *
 * @author Edirlene
 */
public class Cliente extends Usuario {
    Emprestimo emprestimo;

    public Cliente(String nome, String cpf, Endereco end, Contato contato) {
        super(nome, cpf,"Cliente", end, contato);
    }

    
    
}
