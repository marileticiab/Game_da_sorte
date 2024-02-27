
import controller.JogoControl;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import modelo.Jogo;
import modelo.Player;

public class FramePrincipal extends javax.swing.JFrame {

    private Jogo partida;
    private JogoControl regraPartida;
    private Random gerador;
    
    public FramePrincipal() {
        //não modificar esse método
        initComponents();
        this.gerador = new Random();
        Player vetJog[] = {new Player("player 1", true), new Player("player 2", false)};
        this.partida = new Jogo(vetJog);
        this.regraPartida = new JogoControl(partida);
        
        atualizaJogadorVez();
    }
    
     private void atualizaJogadorVez() {
        
         if(partida.getJogadorVez().isHumano()){
             nomeplayer1txt.setForeground(Color.red);
             nomeplayer2txt.setForeground(Color.black);
             
             veztxt.setText("Humano");
             
             sortearbtn.setEnabled(true);
             guardarbtn.setEnabled(true);
         }else{
             nomeplayer1txt.setForeground(Color.black);
             nomeplayer2txt.setForeground(Color.red);
             
             veztxt.setText("CPU");
             
             sortearbtn.setEnabled(false);
             guardarbtn.setEnabled(false);
             
             menteCPU();
         }
    }
     
    private void sorteio(){
        int numeroDado = gerador.nextInt(6)+1;
        
        //altero a interface do usuario
        dadotxt.setText(numeroDado+"");
        
        this.regraPartida.sorteio(numeroDado);
        
        //atualizando o placar parcial
        //partida.getJogadorVez().addPlacarParcial(numeroDado);
        placarparcialtxt.setText(
                partida.getJogadorVez().getPalcarparc()+"");
        
        //add os ultimos 3 numeros sorteadas
        //partida.getJogadorVez().addNumeroSorteado(numeroDado);
        ultnumtxt.setText(partida.getJogadorVez().imprimeUltNumeros());
        
        atualizaJogadorVez();
    }
    
    private void guardar(){
        Player jogadorAtual = partida.getJogadorVez();
        
        boolean vencedor = this.regraPartida.guardarPlacar();
        
        if(vencedor == true){
            //alguem ganhou
            
            JOptionPane.showMessageDialog(this, 
                    "Jogador: "+jogadorAtual.getNome()+" foi o venc.", 
                    "Parabéns!!!", JOptionPane.INFORMATION_MESSAGE);
            
            //fechando a nossa aplicacao
            System.exit(0);
        }
        
        
        if(partida.getVez() == 1){
            player1txt.setText(jogadorAtual.getPlacartotal()+"");
        }else{
            player2txt.setText(jogadorAtual.getPlacartotal()+"");
        }
        placarparcialtxt.setText("0");
        atualizaJogadorVez();
    }
     
    private void menteCPU() {
       
         SwingWorker<Object, Object> trabalhadorCPU = 
                new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    //simulando um tempo para pensar...
                    Thread.sleep(1000 + gerador.nextInt(1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

                //sortear ou guardar???
                int probabilidadeAcao = gerador.nextInt(100);

                if (probabilidadeAcao < 80
                        || partida.getJogadorVez().getPalcarparc() == 0) {
                    //sorteia
                    sorteio();
                } else {
                    //guardar
                    guardar();
                }
                
                //este retorno pode ser utilizado no método done
                return null;
            }
        };
                
        trabalhadorCPU.execute();
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        player1txt = new javax.swing.JLabel();
        nomeplayer2txt = new javax.swing.JLabel();
        nomeplayer1txt = new javax.swing.JLabel();
        player2txt = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ultnumtxt = new javax.swing.JLabel();
        placarparcialtxt = new javax.swing.JLabel();
        dadotxt = new javax.swing.JLabel();
        guardarbtn = new javax.swing.JButton();
        sortearbtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        veztxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        player1txt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        player1txt.setForeground(new java.awt.Color(255, 255, 255));
        player1txt.setText("0");

        nomeplayer2txt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nomeplayer2txt.setForeground(new java.awt.Color(255, 255, 255));
        nomeplayer2txt.setText("Player 2:");

        nomeplayer1txt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        nomeplayer1txt.setForeground(new java.awt.Color(255, 255, 255));
        nomeplayer1txt.setText("Player 1:");

        player2txt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        player2txt.setForeground(new java.awt.Color(255, 255, 255));
        player2txt.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(nomeplayer1txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(nomeplayer2txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player2txt)
                .addGap(119, 119, 119))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeplayer2txt)
                    .addComponent(player1txt)
                    .addComponent(nomeplayer1txt)
                    .addComponent(player2txt))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Placar parcial:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Últimos números:");

        ultnumtxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ultnumtxt.setText(". . . ");

        placarparcialtxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        placarparcialtxt.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(placarparcialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ultnumtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(placarparcialtxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ultnumtxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dadotxt.setFont(new java.awt.Font("Nachlieli CLM", 1, 120)); // NOI18N
        dadotxt.setText("2");

        guardarbtn.setBackground(new java.awt.Color(255, 204, 204));
        guardarbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        guardarbtn.setForeground(new java.awt.Color(153, 51, 255));
        guardarbtn.setText("Guardar");
        guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarbtnActionPerformed(evt);
            }
        });

        sortearbtn.setBackground(new java.awt.Color(255, 204, 204));
        sortearbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sortearbtn.setForeground(new java.awt.Color(153, 51, 255));
        sortearbtn.setText("Sortear");
        sortearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortearbtnActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Sua vez: ");

        veztxt.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        veztxt.setText("Player ...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(veztxt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(veztxt))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(158, 158, 158)
                        .addComponent(dadotxt)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sortearbtn)
                .addGap(126, 126, 126)
                .addComponent(guardarbtn)
                .addGap(187, 187, 187))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(178, Short.MAX_VALUE)
                        .addComponent(dadotxt)))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarbtn)
                    .addComponent(sortearbtn))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarbtnActionPerformed
       
        Player jogadorAtual = partida.getJogadorVez();
        
        this.regraPartida.guardarPlacar();
        
        if(partida.getVez() == 1){
            player1txt.setText(jogadorAtual.getPlacartotal() +"");
        }else{
            player2txt.setText(jogadorAtual.getPlacartotal() +"");
        }
        
        placarparcialtxt.setText("0");
        
    }//GEN-LAST:event_guardarbtnActionPerformed

    //clique do botão sortear(dois cliques no 'sortear' do design
    private void sortearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortearbtnActionPerformed
       
        Random gerador = new Random();
        //limite aberto [0,6[
        int numDado = gerador.nextInt(6)+1;
        
        //alterar interface
        dadotxt.setText(numDado + "");// + "" --> transforma para String
        this.regraPartida.sorteio(numDado);
        //***partida.getJogadorVez().addPlcarParc(numDado);
        //atualizando placar parcial
        placarparcialtxt.setText(partida.getJogadorVez().getPalcarparc()+"");
        
        //add novos 3 numeros sorteados
        //***partida.getJogadorVez().addNumeroSorteado(numDado);
        
        ultnumtxt.setText(partida.getJogadorVez().imprimeUltNumeros());
    }//GEN-LAST:event_sortearbtnActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dadotxt;
    private javax.swing.JButton guardarbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nomeplayer1txt;
    private javax.swing.JLabel nomeplayer2txt;
    private javax.swing.JLabel placarparcialtxt;
    private javax.swing.JLabel player1txt;
    private javax.swing.JLabel player2txt;
    private javax.swing.JButton sortearbtn;
    private javax.swing.JLabel ultnumtxt;
    private javax.swing.JLabel veztxt;
    // End of variables declaration//GEN-END:variables

    
}
