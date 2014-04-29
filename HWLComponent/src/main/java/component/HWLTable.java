/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import java.util.Date;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author vincze.attila
 */
public class HWLTable extends JXTable {

    public HWLTable() {
        super();
        addHighlighter(HighlighterFactory.createSimpleStriping());
        setSelectionBackground(Color.blue);
        setForeground(Color.black);
        setBackground(Color.WHITE);
        setShowVerticalLines(false);
        setShowHorizontalLines(false);
        setGridColor(Color.LIGHT_GRAY);
        setColumnMargin(0);

        setDefaultRenderer(String.class, new HWLTableCellRenderer());
        setDefaultRenderer(Date.class, new HWLTableCellRenderer());
        setDefaultRenderer(Boolean.class, new HWLTableCellRenderer());
        setDefaultRenderer(Double.class, new HWLTableCellRenderer());
        setDefaultRenderer(Integer.class, new HWLTableCellRenderer());
        setDefaultRenderer(Long.class, new HWLTableCellRenderer());
    }

    public Integer getSelectedIndex() {
        return getSelectedRow();
    }

    public void setSelectedIndex(Integer selectedIndex) {
        if (selectedIndex == null || selectedIndex == -1) {
            clearSelection();
        } else {
            getSelectionModel().setSelectionInterval(selectedIndex, selectedIndex);
        }
    }
}
