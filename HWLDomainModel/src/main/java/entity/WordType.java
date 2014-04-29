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
@DatabaseTable(tableName = "wordtypes")
public class WordType extends EntityBase {

    @DatabaseField
    private String englishName;
    @DatabaseField
    private String hungarianName;
    @DatabaseField
    private String hebrewName;

    public WordType() {
    }

    public WordType(String englishName, String hungarianName) {
        this.englishName = englishName;
        this.hungarianName = hungarianName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getHungarianName() {
        return hungarianName;
    }

    public void setHungarianName(String hungarianName) {
        this.hungarianName = hungarianName;
    }

    public String getHebrewName() {
        return hebrewName;
    }

    public void setHebrewName(String hebrewName) {
        this.hebrewName = hebrewName;
    }
}
