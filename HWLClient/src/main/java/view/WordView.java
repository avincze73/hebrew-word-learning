/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import component.HebrewWordTableCellRenderer;
import org.jdesktop.beansbinding.BindingGroup;
import viewmodel.WordViewModel;

/**
 *
 * @author vincze.attila
 */
public class WordView extends javax.swing.JInternalFrame {

    private WordViewModel viewModel;

    /**
     * Creates new form WordView
     */
    public WordView() {
        viewModel = new WordViewModel(null);
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        createBindings();
        WordDetailsPanel detailsPanel = new WordDetailsPanel(viewModel);
        tpDetails.setContentContainer(detailsPanel);
        WordSearchPanel wordSearchPanel = new WordSearchPanel(viewModel);
        tpSearch.setContentContainer(wordSearchPanel);
        tblWord.getColumnModel().getColumn(0).setCellRenderer(new HebrewWordTableCellRenderer());
    }

    public WordViewModel getViewModel() {
        return viewModel;
    }

    private void createBindings() {
        BindingGroup bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${viewModel.wordList}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblWord);
//        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
//        columnBinding.setColumnName("Id");
//        columnBinding.setColumnClass(Long.class);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${inHebrew}"));
        columnBinding.setColumnName("In Hebrew");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${inEnglish}"));
        columnBinding.setColumnName("In English");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${inHungarian}"));
        columnBinding.setColumnName("In Hungarian");
        columnBinding.setColumnClass(String.class);
        
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${wordType.englishName}"));
        columnBinding.setColumnName("Type");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lesson}"));
        columnBinding.setColumnName("Lesson");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sex}"));
        columnBinding.setColumnName("Sex");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cardinality}"));
        columnBinding.setColumnName("Cardinality");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pronunciations}"));
        columnBinding.setColumnName("Pronunciations");
        columnBinding.setColumnClass(String.class);
//        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${note}"));
//        columnBinding.setColumnName("Note");
//        columnBinding.setColumnClass(String.class);

        bindingGroup.addBinding(jTableBinding);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${viewModel.selectedWord}"), tblWord, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${viewModel.selectedIndex}"), tblWord, org.jdesktop.beansbinding.BeanProperty.create("selectedIndex"));
        bindingGroup.addBinding(binding);

        jTableBinding.bind();
        bindingGroup.bind();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane2 = new javax.swing.JScrollPane();
        tblWord = new component.HWLTable();
        tpDetails = new component.HWLTitledPanel();
        tpSearch = new component.HWLTitledPanel();

        setBorder(null);

        tblWord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${viewModel.modeHandler.newButtonEnabled}"), tblWord, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(tblWord);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        tpDetails.setPreferredSize(new java.awt.Dimension(27, 160));
        tpDetails.setTitle("Details");
        getContentPane().add(tpDetails, java.awt.BorderLayout.PAGE_END);

        tpSearch.setPreferredSize(new java.awt.Dimension(27, 100));
        tpSearch.setTitle("Search");
        getContentPane().add(tpSearch, java.awt.BorderLayout.PAGE_START);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private component.HWLTable tblWord;
    private component.HWLTitledPanel tpDetails;
    private component.HWLTitledPanel tpSearch;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}