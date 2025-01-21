/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.HangMan;

/**
 *
 * @author ignacio.campinofernandez
 */
public class MainWindow extends javax.swing.JFrame {

    private HangMan hangMan;

    private void startNewGame() {
        try {
            String options[] = new String[]{"Un jugador, generando la palabra al azar", "Dos jugadores, generando la palabra manualmente ", "Generar la palabra de una BD"};
            String selectedOption = (String) JOptionPane.showInputDialog(this, "Selecciona un modo de juego", "Modo de juego", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            WordGenerator wordGenerator = null;

            introduceLetraCaja.setEnabled(true);
            probar.setEnabled(true);

            if (selectedOption.equals(options[0])) {
                wordGenerator = new FileWordGenerator();
            } else if (selectedOption.equals(options[1])) { 
               wordGenerator = new GUIKeyboardWordGenerator();
            } else {
                wordGenerator = new DBWordGenerator();
            }

            String word = wordGenerator.generateWord();
            hangMan = new HangMan(word);
        } catch (GenerateWordException e) {
            System.out.println("Non se puido xerar a palabra");
            if (e.isVisible()) {
                JOptionPane.showMessageDialog(this, "Error", "Error", 1);
            }
        }
    }

    private void showGameStatus() {

        palabraAdivinarCaja1.setText(hangMan.showHiddenWord());

        letrasFalladasCaja.setText(hangMan.getStringFails());

        if (hangMan.isGameOver()) {

            if (hangMan.maxFailsExceeded()) {
                JOptionPane.showMessageDialog(this, "Final da partida,  a palabra oculta era " + hangMan.showFullWord(), "Perdiste", 1);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);

                jLabel1.setVisible(true);
                jLabel1.setVisible(true);
                jLabel1.setIcon(new ImageIcon("Hangman-0.png"));

                introduceLetraCaja.setEnabled(false);
                probar.setEnabled(false);
                palabraAdivinarCaja1.setText("");

                letrasFalladasCaja.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Ganaste, la palabra es " + hangMan.showFullWord(), "Ganaste", 1);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);

                jLabel1.setVisible(true);
                jLabel1.setVisible(true);
                jLabel1.setIcon(new ImageIcon("Hangman-0.png"));

                introduceLetraCaja.setEnabled(false);
                probar.setEnabled(false);
                palabraAdivinarCaja1.setText("");

                letrasFalladasCaja.setText("");

            }
        }
    }

    private void tryChar() {
        if (introduceLetraCaja.getText().isBlank() || !Character.isLetter(introduceLetraCaja.getText().trim().charAt(0))) {
            JOptionPane.showMessageDialog(this, "La palabra solo puede contener letras minúsculas de a a la z!", "Palabra Incorrecta", 1);
        } else {
            char c = introduceLetraCaja.getText().trim().charAt(0);
            hangMan.tryChar(c);

            switch (hangMan.getFails().size()) {
                case 1:
                    jLabel2.setVisible(true);
                    jLabel2.setIcon(new ImageIcon("Hangman-1.png"));
                    break;
                case 2:
                    jLabel3.setVisible(true);
                    jLabel3.setIcon(new ImageIcon("Hangman-2.png"));
                    break;
                case 3:
                    jLabel4.setVisible(true);
                    jLabel4.setIcon(new ImageIcon("Hangman-3.png"));
                    break;
                case 4:
                    jLabel5.setVisible(true);
                    jLabel5.setIcon(new ImageIcon("Hangman-4.png"));
                    break;
                case 5:
                    jLabel6.setVisible(true);
                    jLabel6.setIcon(new ImageIcon("Hangman-5.png"));
                    break;
                case 6:
                    jLabel7.setVisible(true);
                    jLabel7.setIcon(new ImageIcon("Hangman-6.png"));
                    break;
                case 7:
                    jLabel8.setVisible(true);
                    jLabel8.setIcon(new ImageIcon("Hangman-7.png"));
                    break;

            }
            showGameStatus();

        }

    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {

        initComponents();
        setLocationRelativeTo(null);
        introduceLetraCaja.setEnabled(false);
        probar.setEnabled(false);
        JLabel[] hangManLabels = new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8};

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        palabraAdivinar = new javax.swing.JLabel();
        letrasFalladas = new javax.swing.JLabel();
        introduceLetra = new javax.swing.JLabel();
        introduceLetraCaja = new javax.swing.JTextField();
        probar = new javax.swing.JButton();
        palabraAdivinarCaja1 = new javax.swing.JLabel();
        letrasFalladasCaja = new javax.swing.JLabel();
        jPnlBottom = new javax.swing.JPanel();
        nuevaPartida = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jPnlSup = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ahorcado");
        setMinimumSize(new java.awt.Dimension(750, 505));

        jPnlMain.setBackground(new java.awt.Color(153, 153, 153));
        jPnlMain.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.CardLayout());
        jPanel2.add(jLabel2, "card3");
        jPanel2.add(jLabel3, "card4");
        jPanel2.add(jLabel4, "card5");
        jPanel2.add(jLabel5, "card6");
        jPanel2.add(jLabel6, "card7");
        jPanel2.add(jLabel7, "card8");
        jPanel2.add(jLabel8, "card9");
        jPanel2.add(jLabel1, "card2");

        jPnlMain.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        palabraAdivinar.setText("Palabra a adivinar:");

        letrasFalladas.setText("Letras Falladas:");

        introduceLetra.setText("Introduce una letra:");

        introduceLetraCaja.setPreferredSize(new java.awt.Dimension(80, 27));
        introduceLetraCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                introduceLetraCajaActionPerformed(evt);
            }
        });
        introduceLetraCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                introduceLetraCajaKeyPressed(evt);
            }
        });

        probar.setText("Probar");
        probar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(introduceLetra)
                        .addGap(26, 26, 26)
                        .addComponent(introduceLetraCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(probar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palabraAdivinar)
                            .addComponent(letrasFalladas))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palabraAdivinarCaja1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(letrasFalladasCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(palabraAdivinarCaja1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(palabraAdivinar))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(letrasFalladas, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(letrasFalladasCaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(introduceLetra))
                    .addComponent(introduceLetraCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(probar)))
        );

        jPnlMain.add(jPanel1, java.awt.BorderLayout.WEST);

        getContentPane().add(jPnlMain, java.awt.BorderLayout.CENTER);

        jPnlBottom.setBackground(new java.awt.Color(102, 102, 102));

        nuevaPartida.setText("Nueva Partida");
        nuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidaActionPerformed(evt);
            }
        });
        jPnlBottom.add(nuevaPartida);

        sair.setText("Salir");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPnlBottom.add(sair);

        getContentPane().add(jPnlBottom, java.awt.BorderLayout.SOUTH);

        jPnlSup.setBackground(new java.awt.Color(102, 102, 102));

        titulo.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        titulo.setText("Ahorcado");
        jPnlSup.add(titulo);

        getContentPane().add(jPnlSup, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void introduceLetraCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_introduceLetraCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_introduceLetraCajaActionPerformed

    private void nuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidaActionPerformed

        startNewGame();

        jLabel1.setVisible(true);
        jLabel1.setIcon(new ImageIcon("Hangman-0.png"));

    }//GEN-LAST:event_nuevaPartidaActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void probarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probarActionPerformed
        // TODO add your handling code here:
        this.tryChar();
        introduceLetraCaja.setText("");
    }//GEN-LAST:event_probarActionPerformed

    private void introduceLetraCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_introduceLetraCajaKeyPressed
        if (evt.getKeyCode() == 10) {
            probarActionPerformed(null);
        }
    }//GEN-LAST:event_introduceLetraCajaKeyPressed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel introduceLetra;
    private javax.swing.JTextField introduceLetraCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnlBottom;
    private javax.swing.JPanel jPnlMain;
    private javax.swing.JPanel jPnlSup;
    private javax.swing.JLabel letrasFalladas;
    private javax.swing.JLabel letrasFalladasCaja;
    private javax.swing.JButton nuevaPartida;
    private javax.swing.JLabel palabraAdivinar;
    private javax.swing.JLabel palabraAdivinarCaja1;
    private javax.swing.JButton probar;
    private javax.swing.JButton sair;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
