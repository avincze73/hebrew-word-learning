/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author vincze.attila
 */
public class HebrewWordTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value != null) {
            ((JLabel) cell).setHorizontalAlignment(RIGHT);
            Font f = ((JLabel) cell).getFont();
            ((JLabel) cell).setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
            ((JLabel) cell).setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 4));
        }
        return cell;
    }
}
