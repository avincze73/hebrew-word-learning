/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import component.HWLHebrewQuizPanel;
import component.HWLHebrewTestPanel;
import entity.Word;
import java.util.*;
import viewmodel.QuizViewModel;

/**
 *
 * @author vincze.attila
 */
public class QuizView extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuizView
     */
    private QuizViewModel viewModel;
    private List<HWLHebrewQuizPanel> quizList;
    private HashSet<Word> wordList;
    private HashSet<Word> testList;
    
    public QuizView() {
        viewModel = new QuizViewModel(null);
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        quizList = new ArrayList<HWLHebrewQuizPanel>();
        wordList = new HashSet<Word>();
        testList = new HashSet<Word>();
        createTest();
    }

    private void createTest() {
        quizList.clear();
        pnlQuiz.removeAll();
        lblResult.setText("");
//        Random randomGenerator = new Random();
//        randomGenerator.setSeed(new Date().getTime());
//        int size = viewModel.getWordList().size();
//        for (int i = 0; i < 25; i++) {
//            Word word = viewModel.getWordList().get(randomGenerator.nextInt(size));
//            while (!wordList.add(word)) {
//                word = viewModel.getWordList().get(randomGenerator.nextInt(size));
//            }
//            for (int j = 0; j < 4; j++) {
//                Word test = viewModel.getWordList().get(randomGenerator.nextInt(size));
//                while (test.equals(word) || !testList.add(test)) {
//                    test = viewModel.getWordList().get(randomGenerator.nextInt(size));
//                }
//            }
//
////            HWLHebrewQuizPanel p = new HWLHebrewQuizPanel("<html>" + word.getInEnglish() + "</html>", word.getInHebrew(),
////                    viewModel.getWordList().get(randomGenerator.nextInt(size)).getInHebrew(),
////                    viewModel.getWordList().get(randomGenerator.nextInt(size)).getInHebrew(),
////                    viewModel.getWordList().get(randomGenerator.nextInt(size)).getInHebrew(),
////                    viewModel.getWordList().get(randomGenerator.nextInt(size)).getInHebrew());
//            //Word[] tests = (Word[]) testList.toArray();
//            //Word[] tests = (Word[]) testList.ToArray(typeof(Word));
//            Word[] tests = new Word[testList.size()];
//            testList.toArray(tests);
//
//            HWLHebrewQuizPanel p = new HWLHebrewQuizPanel("<html>" + word.getInEnglish() + "</html>", word.getInHebrew(),
//                    tests[0].getInHebrew(),
//                    tests[1].getInHebrew(),
//                    tests[2].getInHebrew(),
//                    tests[3].getInHebrew());
//            quizList.add(p);
//            pnlTest.add(p);
//            testList.clear();
//        }
        viewModel.createTest(jComboBox1.getSelectedItem().toString());
        Random randomGenerator = new Random();
        randomGenerator.setSeed(new Date().getTime());
        for (List<Word> list : viewModel.getQuizList()) {
            HWLHebrewQuizPanel p = new HWLHebrewQuizPanel("<html>" + list.get(0).getInEnglish() + "</html>", list.get(0).getInHebrew(),
                    list.get(1).getInHebrew(),
                    list.get(2).getInHebrew(),
                    list.get(3).getInHebrew(),
                    list.get(4).getInHebrew(),
                    randomGenerator.nextInt(4));
            quizList.add(p);
            pnlQuiz.add(p);
            //testList.clear();
        }
        pnlQuiz.revalidate();
        repaint();
    }
    private void createTest2() {
        quizList.clear();
        pnlQuiz.removeAll();
        lblResult.setText("");
        viewModel.createTest(jComboBox1.getSelectedItem().toString());
        Random randomGenerator = new Random();
        randomGenerator.setSeed(new Date().getTime());
        for (List<Word> list : viewModel.getQuizList()) {
            HWLHebrewTestPanel p = new HWLHebrewTestPanel("<html>" + list.get(0).getInEnglish() + "</html>", list.get(0).getInHebrew());
            //quizList.add(p);
            pnlQuiz.add(p);
            //testList.clear();
        }
        pnlQuiz.revalidate();
        repaint();
    }

    public QuizViewModel getViewModel() {
        return viewModel;
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

        pnlHeader = new javax.swing.JPanel();
        pnlFunction = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnNewTest = new javax.swing.JButton();
        lblLesson = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        lblResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlQuiz = new javax.swing.JPanel();

        setBorder(null);

        pnlHeader.setPreferredSize(new java.awt.Dimension(100, 1));
        getContentPane().add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlFunction.setBackground(java.awt.Color.white);
        pnlFunction.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5), new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        pnlFunction.setPreferredSize(new java.awt.Dimension(100, 50));
        pnlFunction.setLayout(new java.awt.GridBagLayout());

        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        pnlFunction.add(btnCheck, gridBagConstraints);

        btnNewTest.setText("New Quiz");
        btnNewTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTestActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        pnlFunction.add(btnNewTest, gridBagConstraints);

        lblLesson.setText("Lesson");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlFunction.add(lblLesson, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "I", "II", "III", "IV", "V", "VI", "VII", "1", "2", "3" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        pnlFunction.add(jComboBox1, gridBagConstraints);

        lblResult.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        pnlFunction.add(lblResult, gridBagConstraints);

        getContentPane().add(pnlFunction, java.awt.BorderLayout.PAGE_END);

        pnlQuiz.setBackground(java.awt.Color.white);
        pnlQuiz.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlQuiz.setLayout(new java.awt.GridLayout(5, 5, 5, 5));
        jScrollPane1.setViewportView(pnlQuiz);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        int i = 0;
        for (HWLHebrewQuizPanel hWLHebrewQuizPanel : quizList) {
            if (hWLHebrewQuizPanel.isCorrect()) {
                i++;
            }
            hWLHebrewQuizPanel.showCorrect();
        }
        lblResult.setText(i + "/" + quizList.size() + " (" + i * 100/quizList.size() + "%)" );
        //JOptionPane.showMessageDialog(this, i + "/" + quizList.size());
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnNewTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTestActionPerformed
        // TODO add your handling code here:
        createTest();
    }//GEN-LAST:event_btnNewTestActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNewTest;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLesson;
    private javax.swing.JLabel lblResult;
    private javax.swing.JPanel pnlFunction;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlQuiz;
    // End of variables declaration//GEN-END:variables
}
