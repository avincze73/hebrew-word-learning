/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import java.awt.ComponentOrientation;

/**
 *
 * @author vincze.attila
 */
public class HWLHebrewTestPanel extends javax.swing.JPanel {

    private String solution;
    
    /**
     * Creates new form HWLHebrewTestPanel
     */
    public HWLHebrewTestPanel() {
        initComponents();
        txtTest.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    
    public HWLHebrewTestPanel(String word, String solution) {
        this();
        this.solution = solution;
        lblWord.setText(word);
        lblWord.setToolTipText(solution);
    }

    public boolean isCorrect() {
        return txtTest.getText().equals(solution);
    }
    
    public void showCorrect(){
        if (txtTest.getText().equals(solution)){
            txtTest.setForeground(Color.blue);
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblWord = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTest = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(210, 50));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lblWord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblWord.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(lblWord, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        txtTest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTest.setPreferredSize(new java.awt.Dimension(100, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel2.add(txtTest, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblWord;
    private javax.swing.JTextField txtTest;
    // End of variables declaration//GEN-END:variables
}