/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import entity.WordType;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author vincze.attila
 */
public class HWLListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component cell = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof WordType) {
            WordType c = (WordType) value;
            if (c != null) {
                setText(c.getEnglishName());
            }
        }
        return this;
    }
}
