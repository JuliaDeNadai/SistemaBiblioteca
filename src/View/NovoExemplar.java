/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ExemplarController;
import Model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Edirlene
 */
public class NovoExemplar extends javax.swing.JFrame {

    /**
     * Creates new form NovoExemplar
     */
    ExemplarController controleExemplar;
    private String cod;
    
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    public NovoExemplar() {
        initComponents();
        setResizable(false);
        btnNovoExemplar.setVisible(true);
        btnAlterar.setVisible(false);
        tituloLabel.setText("Novo Exemplar");
        setCamposEditable(true);
        
        controleExemplar = new ExemplarController();
    }
    
    public NovoExemplar(String cod) {
        initComponents();
        
        btnNovoExemplar.setVisible(false);
        btnAlterar.setVisible(true);
        tituloLabel.setText("Alterar Exemplar");
        setCamposEditable(true);
        
        controleExemplar = new ExemplarController();
        try{
            Exemplar ex = controleExemplar.buscarExemplar(cod);
            preencheCampos(ex);
            System.out.println("autor " +ex.getAutor());
            setCod(cod);
        }catch (Exception e){
            System.err.println("Error25" +e);
        }
        
    }
    
    public NovoExemplar(String cod,int n) {
        initComponents();
        ExemplarController ex = new ExemplarController();
        btnNovoExemplar.setVisible(false);
        btnAlterar.setVisible(true);
        tituloLabel.setText("Visualizar Exemplar");
        setCamposEditable(false);
        
        try{
            Exemplar exemplar = ex.buscarExemplar(cod);
            preencheCampos(exemplar);
        }catch (Exception e){
            System.err.println("Error10" +e);
        }
        
    }
    
    public final void setCamposEditable(boolean bol){
        campoTitulo.setEditable(bol);
        campoAutor.setEditable(bol);
        campoAno.setEditable(bol);
        campoQntd.setEditable(bol);
        campoEditora.setEditable(bol);
        campoEdicao.setEditable(bol);
        campoInstituicao.setEditable(bol);
        campoDepartamento.setEditable(bol);
        //buttonGroup1.getSelection().
    }
    
    public Exemplar verificacoes(){
        try{
            Exemplar ex;
//            String[] dadosCampo = new String[6];
//            dadosCampo[0] = campoTitulo.getText();
//            dadosCampo[1] = campoAutor.getText();
            //desisti dessa ideia
            
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            String ano = campoAno.getText();
            String qntd = campoQntd.getText();
            String tipo = buttonGroup1.getSelection().toString();

            if(titulo.isEmpty() || autor.isEmpty() || ano.isEmpty()){
                    throw new Exception("Preencha todos os campos.");
            }
            
            //if(!verificaString(titulo) || !verificaString(autor)){ throw new Exception("Valores inválidos.");}
            if(!verificaInteiro(ano) || ano.length() != 4){  throw new Exception("Campo 'Ano' inválido.");    }
            if(!verificaInteiro(qntd) || Integer.valueOf(qntd)< 1 || Integer.valueOf(qntd) > 20 ){  throw new Exception("Campo 'Qntd' inválido.");    }
            
            if(tipoLivro.isSelected()){
                String editora = campoEditora.getText();
                String edicao = campoEdicao.getText();
                
                if(editora.isEmpty() || edicao.isEmpty()){  throw new Exception("Preencha todos os campos.");   }
                //if(!verificaString(editora) || !verificaString(edicao)){ throw new Exception("Valores inválidos.");}
                
                ex = new Livro(editora, edicao, titulo, autor, ano);

            }else{
                String instituicao = campoInstituicao.getText();
                String departamento = campoDepartamento.getText();
                if(instituicao.isEmpty() || departamento.isEmpty()){    throw new Exception("Preencha todos os campos.");   }
                //if(!verificaString(instituicao) || !verificaString(departamento)){ throw new Exception("Valores inválidos.");}
                
                ex = new Artigo(instituicao, departamento, titulo, autor, ano);
                
            }
            return ex;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return null;
    }
    public final void preencheCampos(Exemplar ex){
            campoTitulo.setText(ex.getTitulo());
            campoAutor.setText(ex.getAutor());
            campoAno.setText(ex.getAno());
            tipoLivro.setEnabled(false);
            tipoArtigo.setEnabled(false);

            if(ex.getTipo().equals("Livro")){
                tipoLivro.setSelected(true);
                campoEditora.setText(((Livro)ex).getEditora());
                campoEdicao.setText(((Livro)ex).getEdicao());
                campoInstituicao.setEditable(false);
                campoDepartamento.setEditable(false);
            }else{
                tipoArtigo.setSelected(true);
                campoEditora.setEditable(false);
                campoEdicao.setEditable(false);
                campoInstituicao.setText(((Artigo)ex).getInstituicao());
                campoDepartamento.setText(((Artigo)ex).getDepartamento());
            }

    }
    
    public boolean verificaString(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isLetter(str.charAt(i))){ return false;}
        }
        return true;
    }
    
    public boolean verificaInteiro(String str){
        for(int i = 0; i< str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){ return false;}
        }
        return true;
    }
    
    public void cadastrarExemplar(){
        Exemplar ex = verificacoes();
        controleExemplar.adicionaExemplar(ex);
        
    }
    
    public void alteraCampos(int n){
        if( n == 1){
            campoEditora.setEnabled(true);
            campoEdicao.setEnabled(true);
            campoInstituicao.setEnabled(false);
            campoDepartamento.setEnabled(false);
        }else{
            campoEditora.setEnabled(false);
            campoEdicao.setEnabled(false);
            campoInstituicao.setEnabled(true);
            campoDepartamento.setEnabled(true);
        }
    }
    
    public void alterarExemplar(){
        Exemplar ex = verificacoes();
        controleExemplar.alteraExemplar(ex, getCod());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        campoAutor = new javax.swing.JTextField();
        campoAno = new javax.swing.JTextField();
        tipoLivro = new javax.swing.JRadioButton();
        tipoArtigo = new javax.swing.JRadioButton();
        campoEdicao = new javax.swing.JTextField();
        campoEditora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoDepartamento = new javax.swing.JTextField();
        campoInstituicao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoQntd = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnNovoExemplar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Título:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Ano:");

        jLabel4.setText("Tipo:");

        buttonGroup1.add(tipoLivro);
        tipoLivro.setSelected(true);
        tipoLivro.setText("Livro");
        tipoLivro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoLivroItemStateChanged(evt);
            }
        });
        tipoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoLivroActionPerformed(evt);
            }
        });

        buttonGroup1.add(tipoArtigo);
        tipoArtigo.setText("Artigo");
        tipoArtigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoArtigoItemStateChanged(evt);
            }
        });

        jLabel5.setText("Editora:");

        jLabel6.setText("Edição:");

        jLabel7.setText("Departamento:");

        jLabel8.setText("Instituição:");

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tituloLabel.setText("Novo Exemplar");

        jLabel10.setText("Qntd:");

        btnAlterar.setText("ALTERAR");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnNovoExemplar.setText("CADASTRAR");
        btnNovoExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoExemplarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(44, 44, 44)
                                            .addComponent(campoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tipoLivro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tipoArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(48, 48, 48)
                                .addComponent(campoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(28, 28, 28)
                                .addComponent(campoInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tituloLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoDepartamento))
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNovoExemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipoLivro)
                    .addComponent(tipoArtigo)
                    .addComponent(jLabel10)
                    .addComponent(campoQntd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoExemplar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoLivroActionPerformed

    private void tipoLivroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoLivroItemStateChanged
        if(tipoLivro.isSelected()){
            alteraCampos(1);
        }else{
            alteraCampos(0);
        }
    }//GEN-LAST:event_tipoLivroItemStateChanged

    private void tipoArtigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoArtigoItemStateChanged
        if(tipoArtigo.isSelected()){    
            alteraCampos(0);
        }else{  
            alteraCampos(1);
        }
    }//GEN-LAST:event_tipoArtigoItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(tipoArtigo.isSelected()){    
            alteraCampos(0);
        }else{  
            alteraCampos(1);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnNovoExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoExemplarActionPerformed
        cadastrarExemplar();
        dispose();
    }//GEN-LAST:event_btnNovoExemplarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarExemplar();
        dispose();
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(NovoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NovoExemplar().setVisible(true);
                
            }
        });
        
        
    }
    
    
    private javax.swing.ButtonGroup tipoGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnNovoExemplar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextField campoDepartamento;
    private javax.swing.JTextField campoEdicao;
    private javax.swing.JTextField campoEditora;
    private javax.swing.JTextField campoInstituicao;
    private javax.swing.JTextField campoQntd;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton tipoArtigo;
    private javax.swing.JRadioButton tipoLivro;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
