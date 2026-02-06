/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tp.ucaouut.pooapplication.View;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class AjouterBateau extends javax.swing.JPanel {

    public AjouterBateau() {
        initComponents();
        
    }

    public void setBtnenregistrer(JButton btnenregistrer) {
        this.btnenregistrer = btnenregistrer;
    }

    public void setBuscheck(JCheckBox buscheck) {
        this.buscheck = buscheck;
    }

    public void setCapitainechamp(JTextField capitainechamp) {
        this.capitainechamp = capitainechamp;
    }

    public void setEcocheck(JCheckBox ecocheck) {
        this.ecocheck = ecocheck;
    }

    public void setjLabel23(JLabel jLabel23) {
        this.jLabel23 = jLabel23;
    }

    public void setjLabel26(JLabel jLabel26) {
        this.jLabel26 = jLabel26;
    }

    public void setjLabel28(JLabel jLabel28) {
        this.jLabel28 = jLabel28;
    }

    public void setjLabel29(JLabel jLabel29) {
        this.jLabel29 = jLabel29;
    }

    public void setjLabel30(JLabel jLabel30) {
        this.jLabel30 = jLabel30;
    }

    public void setjLabel31(JLabel jLabel31) {
        this.jLabel31 = jLabel31;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    public void setNbsieges(JSpinner nbsieges) {
        this.nbsieges = nbsieges;
    }

    public void setNombateau(JTextField nombateau) {
        this.nombateau = nombateau;
    }

    public void setVitessechamp(JSpinner vitessechamp) {
        this.vitessechamp = vitessechamp;
    }

    public JButton getBtnenregistrer() {
        return btnenregistrer;
    }

    public JCheckBox getBuscheck() {
        return buscheck;
    }

    public JTextField getCapitainechamp() {
        return capitainechamp;
    }

    public JCheckBox getEcocheck() {
        return ecocheck;
    }

    public JLabel getjLabel23() {
        return jLabel23;
    }

    public JLabel getjLabel26() {
        return jLabel26;
    }

    public JLabel getjLabel28() {
        return jLabel28;
    }

    public JLabel getjLabel29() {
        return jLabel29;
    }

    public JLabel getjLabel30() {
        return jLabel30;
    }

    public JLabel getjLabel31() {
        return jLabel31;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public JSpinner getNbsieges() {
        return nbsieges;
    }

    public JTextField getNombateau() {
        return nombateau;
    }

    public JSpinner getVitessechamp() {
        return vitessechamp;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnenregistrer = new javax.swing.JButton();
        nombateau = new javax.swing.JTextField();
        capitainechamp = new javax.swing.JTextField();
        ecocheck = new javax.swing.JCheckBox();
        buscheck = new javax.swing.JCheckBox();
        nbsieges = new javax.swing.JSpinner();
        vitessechamp = new javax.swing.JSpinner();

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("BATEAUX");

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel26.setText("NOM");

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel28.setText("CLASSE");

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel29.setText("VITESSE");

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel30.setText("CAPITAINE");

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel31.setText("NB_SIÈGES");

        btnenregistrer.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnenregistrer.setForeground(new java.awt.Color(204, 51, 0));
        btnenregistrer.setText("ENREGISTRER");
        btnenregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenregistrerActionPerformed(evt);
            }
        });

        nombateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombateauActionPerformed(evt);
            }
        });

        ecocheck.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        ecocheck.setText("ECONOMIQUE");
        ecocheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecocheckActionPerformed(evt);
            }
        });

        buscheck.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        buscheck.setText("BUSINESS");
        buscheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscheckActionPerformed(evt);
            }
        });

        nbsieges.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(capitainechamp, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(ecocheck)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                                .addComponent(buscheck))
                                            .addComponent(nombateau)
                                            .addComponent(vitessechamp))
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nbsieges, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel30))
                        .addGap(0, 62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnenregistrer)
                        .addGap(182, 182, 182))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombateau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbsieges, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecocheck, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscheck, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitessechamp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capitainechamp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnenregistrer)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnenregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenregistrerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnenregistrerActionPerformed

    private void nombateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombateauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombateauActionPerformed

    private void ecocheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecocheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecocheckActionPerformed

    private void buscheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnenregistrer;
    private javax.swing.JCheckBox buscheck;
    private javax.swing.JTextField capitainechamp;
    private javax.swing.JCheckBox ecocheck;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSpinner nbsieges;
    private javax.swing.JTextField nombateau;
    private javax.swing.JSpinner vitessechamp;
    // End of variables declaration//GEN-END:variables
}
