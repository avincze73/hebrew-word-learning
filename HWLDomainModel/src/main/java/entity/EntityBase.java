/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.j256.ormlite.field.DatabaseField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

/**
 *
 * @author vincze.attila
 */
public class EntityBase implements Serializable {

    @DatabaseField(generatedId = true)
    private Long id;
    protected PropertyChangeSupport propertyChangeSupport;
    protected VetoableChangeSupport vetoableChangeSupport;

    public EntityBase() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        vetoableChangeSupport = new VetoableChangeSupport(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldValue = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldValue, this.id);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public EntityBase clone() throws CloneNotSupportedException {
        EntityBase result = (EntityBase) super.clone();
        return result;
    }

    @Override
    public boolean equals(Object object) {
        
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        }
        return (this.getId() == null) ? false : this.getId() == ((EntityBase) object).getId();
    }
}
