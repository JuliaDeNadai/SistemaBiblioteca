/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioController;
import Model.Administrador;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import Model.Usuario;
import javax.swing.JOptionPane;
public class NovoUsuario extends javax.swing.JFrame {

    UsuarioController controleUser;
    public NovoUsuario() {
        initComponents();
        setResizable(false);
        btnNovoUsuario.setVisible(true);
        btnAltera.setVisible(false);
        tituloLabel.setText("Novo Usuário");
        setCamposEditable(true);
        
        controleUser = new UsuarioController();
        
    }
    
    public NovoUsuario(String cod) {
        initComponents();
        
        btnNovoUsuario.setVisible(false);
        btnAltera.setVisible(true);
        tituloLabel.setText("Alterar Usuário");
        setCamposEditable(true);
        
        controleUser = new UsuarioController();
        Usuario user = controleUser.buscarUsuario(cod);
        preencheCampos(user);
        
    }
    
    public NovoUsuario(String cod, int n) {
        initComponents();
        UsuarioController u = new UsuarioController();
        btnNovoUsuario.setVisible(false);
        btnAltera.setVisible(false);
        tituloLabel.setText("Vizualizar Usuário");
        
        setCamposEditable(false);
        
        
        try{
            Usuario user = u.buscarUsuario(cod);
            //preencheCampos(user);
        }catch (Exception e){
            System.err.println("Error10" +e);
        }
        
    }
    
    
    public final void setCamposEditable(boolean bol){
        campoNome.setEditable(bol);
        campoCPF.setEditable(bol);
        campoTelefone.setEditable(bol);
        campoEmail.setEditable(bol);
        campoCidade.setEditable(bol);
        campoRua.setEditable(bol);
        campoNumero.setEditable(bol);
        campoBairro.setEditable(bol);
        campoCEP.setEditable(bol);
        campoUser.setEditable(bol);
        campoPassword.setEditable(bol);
    }

    public final void preencheCampos(Usuario user){
        campoNome.setText(user.getNome());
        campoCPF.setText(user.getCPF());
        campoTelefone.setText(user.contato.getTelefone());
        campoEmail.setText(user.contato.getEmail());
        campoCidade.setText(user.end.getCidade());
        campoRua.setText(user.end.getRua());
        campoNumero.setText(user.end.getNumero());
        campoBairro.setText(user.end.getBairro());
        campoCEP.setText(user.end.getCEP());
        tipoAdm.setEnabled(false);
        tipoCliente.setEnabled(false);
        if(user.getTipo().equals("Administrador")){
            tipoAdm.setSelected(true);
            campoUser.setText(((Administrador)user).getUser());
            campoPassword.setText(((Administrador)user).getPassword());
        }else{
            tipoCliente.setSelected(true);
            campoUser.setEditable(false);
            campoPassword.setEditable(false);
            
        }
    }
    
    public Usuario verificacoes(){
        String nome, cpf, telefone, email, cidade, rua, numero, bairro, cep,tipo;
        int[] num = {1,2,6,8}, str = {0,3,4,5,7};
        String[] dadosUser = new String[9];
        dadosUser[0] = campoNome.getText();
        dadosUser[1] = campoCPF.getText();
        dadosUser[2] = campoTelefone.getText();
        dadosUser[3] = campoEmail.getText();
        dadosUser[4] = campoCidade.getText();
        dadosUser[5] = campoRua.getText();
        dadosUser[6] = campoNumero.getText();
        dadosUser[7] = campoBairro.getText();
        dadosUser[8] = campoCEP.getText();
        
        try{
            Usuario nUser;
            Endereco end;
            Contato contato;
            
            if(verificaCamposVazios(dadosUser)){ throw new Exception("Preencha todos os campos."); }
            //if(!verificaInteiro(dadosUser, num)){  throw new Exception("Tipo de dados inválido."); }
            
            if(dadosUser[1].length() != 11) throw new Exception("CPF digitado é inválido.");
            if(dadosUser[8].length() != 8) throw new Exception("CEP digitado é inválido.");
            if(!dadosUser[3].endsWith("@gmail.com")) throw new Exception("Digite um email válido.");
           // if(!verificaString(dadosUser, str)){  throw new Exception("Tipo de dados inválido."); }
            
            tipo = buttonGroup1.getSelection().toString();
            if(tipoAdm.isSelected()){
                String user = campoUser.getText();
                String password = campoPassword.getText();
                String[] dadosLogin = new String[2];
                dadosLogin[0] = campoUser.getText();
                dadosLogin[1] = campoPassword.getText();
                
                if(verificaCamposVazios(dadosLogin)){ throw new Exception("Preencha todos os campos."); }
                
                end = new Endereco(dadosUser[5], dadosUser[6], dadosUser[7], dadosUser[8], dadosUser[4]);
                //String rua, String numero, String bairro, String CEP, String cidade
                contato = new Contato(dadosUser[2], dadosUser[3]);
                return nUser = new Administrador(dadosLogin[0], dadosLogin[1], dadosUser[0], dadosUser[1], end, contato);
                //String user, String password, String nome, String cpf, Endereco end, Contato contato
            }else{
                end = new Endereco(dadosUser[5], dadosUser[6], dadosUser[7], dadosUser[8], dadosUser[4]);
                contato = new Contato(dadosUser[2], dadosUser[3]);
                return nUser = new Cliente(dadosUser[0], dadosUser[1], end, contato);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public void alteraCampos(int n){
        if(n == 1){
            campoUser.setEnabled(true);
            campoPassword.setEnabled(true);
        }else{
            campoUser.setEnabled(false);
            campoPassword.setEnabled(false);
        }
    }
    
    public boolean verificaString(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){ return false;}
        }
        return true;
    }
    
    public boolean verificaString(String[] str, int[] n){
        for(int i = 0; i< n.length; i++){
            for(int j=0; j< str[n[i]].length();j++){    if(!Character.isLetter(str[n[i]].charAt(j))){ return false;}  }
        }
        return true;
    }
    
    public boolean verificaInteiro(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){ return false;}
        }
        return true;
    }
    
    public boolean verificaInteiro(String[] str, int[] n){
        for(int i = 0; i< n.length; i++){
            for(int j=0; j< str[n[i]].length();j++){    if(!Character.isDigit(str[n[i]].charAt(j))){ return false;}  }
        }
        return true;
    }
    
    public boolean verificaCamposVazios(String[] dados){
        for (String dado : dados) {
            if (dado.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    public void cadastrarUsuario(){
        Usuario user = verificacoes();
        controleUser.adicionaUsuario(user);
    }
    
    public void alterarUsuario(){
        Usuario user = verificacoes();
        controleUser.alteraUsuario(user);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        campoTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoCPF = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        tituloLabel = new javax.swing.JLabel();
        btnNovoUsuario = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        campoCEP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campoBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        campoPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tipoAdm = new javax.swing.JRadioButton();
        campoUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tipoCliente = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        btnAltera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Telefone");

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tituloLabel.setText("Novo Usuário");

        btnNovoUsuario.setText("CADASTRAR");
        btnNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuarioActionPerformed(evt);
            }
        });

        jLabel10.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setText("Bairro:");

        jLabel15.setText("CEP:");

        jLabel11.setText("Rua:");

        jLabel12.setText("Número:");

        jLabel13.setText("Cidade:");

        jLabel4.setText("Tipo:");

        jLabel7.setText("Senha:");

        buttonGroup1.add(tipoAdm);
        tipoAdm.setSelected(true);
        tipoAdm.setText("Administrador");
        tipoAdm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoAdmItemStateChanged(evt);
            }
        });
        tipoAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAdmActionPerformed(evt);
            }
        });

        jLabel8.setText("Usuário:");

        buttonGroup1.add(tipoCliente);
        tipoCliente.setText("Cliente");
        tipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoClienteItemStateChanged(evt);
            }
        });

        jLabel16.setText("Endereço:");

        btnAltera.setText("ALTERAR");
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(tipoAdm)
                                .addGap(32, 32, 32)
                                .addComponent(tipoCliente))
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel10))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                                .addComponent(campoTelefone))))
                                    .addGap(19, 19, 19))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(12, 12, 12)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoUser)
                                        .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tituloLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAltera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(9, 9, 9))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(4, 4, 4))
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btnNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tituloLabel)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoAdm)
                            .addComponent(tipoCliente)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoAdmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoAdmItemStateChanged
        if(tipoAdm.isSelected()){
            alteraCampos(1);
        }else{
            alteraCampos(0);
        }
    }//GEN-LAST:event_tipoAdmItemStateChanged

    private void tipoAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAdmActionPerformed
        if(tipoAdm.isSelected()){
            alteraCampos(1);
        }else{
            alteraCampos(0);
        }
    }//GEN-LAST:event_tipoAdmActionPerformed

    private void tipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoClienteItemStateChanged
        if(tipoCliente.isSelected()){
            alteraCampos(0);
        }else{
            alteraCampos(1);
        }
    }//GEN-LAST:event_tipoClienteItemStateChanged

    private void btnNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuarioActionPerformed
        cadastrarUsuario();
    }//GEN-LAST:event_btnNovoUsuarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        alteraCampos(1);
    }//GEN-LAST:event_formWindowOpened

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
        alterarUsuario();
        
    }//GEN-LAST:event_btnAlteraActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NovoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoCEP;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoPassword;
    private javax.swing.JTextField campoRua;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JTextField campoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton tipoAdm;
    private javax.swing.JRadioButton tipoCliente;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
