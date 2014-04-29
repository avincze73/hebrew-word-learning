/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author vincze.attila
 */
@DatabaseTable(tableName = "words")
public class Word extends EntityBase {

    @DatabaseField
    private String inHungarian;
    @DatabaseField
    private String inEnglish;
    @DatabaseField
    private String inHebrew;
    @DatabaseField
    private String lesson;
    @DatabaseField
    private String note;
    @DatabaseField
    private String sex;
    @DatabaseField
    private String pronunciations;
    @DatabaseField
    
    private String cardinality;
    @DatabaseField(canBeNull = false, foreign = true, columnName = "wordTypeId", foreignAutoRefresh=true)
    private WordType wordType;

    public Word() {
    }

    public Word(String lesson) {
        this.lesson = lesson;
    }

    public Word(String inHungarian, String inEnglish, String inHebrew, String lesson, WordType wordType) {
        this.inHungarian = inHungarian;
        this.inEnglish = inEnglish;
        this.inHebrew = inHebrew;
        this.lesson = lesson;
        this.wordType = wordType;
        //this.cardinality = Cardinality.notSet.name();
        //this.sex = Sex.notSet.name();
    }
    
    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(inEnglish);
        sb.append(";");
        sb.append(inHebrew);
        sb.append(";");
        sb.append(inHungarian);
        sb.append(";");
        sb.append(wordType.getEnglishName());
        sb.append(";");
        sb.append(lesson);
        sb.append(";");
        sb.append(sex == null ? "" : sex);
        sb.append(";");
        sb.append(cardinality == null ? "" : cardinality);
        return sb.toString();
    }
    public String getInEnglish() {
        return inEnglish;
    }

    public void setInEnglish(String inEnglish) {
        String oldValue = this.inEnglish;
        this.inEnglish = inEnglish;
        propertyChangeSupport.firePropertyChange("inEnglish", oldValue, this.inEnglish);
    }

    public String getInHebrew() {
        return inHebrew;
    }

    public void setInHebrew(String inHebrew) {
        String oldValue = this.inHebrew;
        this.inHebrew = inHebrew;
        propertyChangeSupport.firePropertyChange("inHebrew", oldValue, this.inHebrew);
    }

    public String getInHungarian() {
        return inHungarian;
    }

    public void setInHungarian(String inHungarian) {
        String oldValue = this.inHungarian;
        this.inHungarian = inHungarian;
        propertyChangeSupport.firePropertyChange("inHungarian", oldValue, this.inHungarian);
    }

    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        WordType oldValue = this.wordType;
        this.wordType = wordType;
        propertyChangeSupport.firePropertyChange("wordType", oldValue, this.wordType);
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        String oldValue = this.lesson;
        this.lesson = lesson;
        propertyChangeSupport.firePropertyChange("lesson", oldValue, this.lesson);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        String oldValue = this.note;
        this.note = note;
        propertyChangeSupport.firePropertyChange("note", oldValue, this.note);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        String oldValue = this.sex;
        this.sex = sex;
        propertyChangeSupport.firePropertyChange("sex", oldValue, this.sex);
    }

    public String getCardinality() {
        return cardinality;
    }

    public void setCardinality(String cardinality) {
        String oldValue = this.cardinality;
        this.cardinality = cardinality;
        propertyChangeSupport.firePropertyChange("cardinality", oldValue, this.cardinality);
    }

    public String getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(String pronunciations) {
        String oldValue = this.pronunciations;
        this.pronunciations = pronunciations;
        propertyChangeSupport.firePropertyChange("pronunciations", oldValue, this.pronunciations);
    }
    
    
}
