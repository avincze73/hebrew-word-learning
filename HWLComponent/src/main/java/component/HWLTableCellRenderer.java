/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author vincze.attila
 */
public class HWLTableCellRenderer extends DefaultTableCellRenderer {


    public HWLTableCellRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) cell).setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 0));
        if (value instanceof Date && value != null) {
            ((JLabel) cell).setText(new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss").format(value));
        } else if (value instanceof Double) {
            ((JLabel) cell).setText(value.toString());
        } else if (value instanceof Integer) {
            ((JLabel) cell).setText(value.toString());
        } else if (value instanceof Long) {
            ((JLabel) cell).setText(value.toString());
        }
        return cell;

    }
}
