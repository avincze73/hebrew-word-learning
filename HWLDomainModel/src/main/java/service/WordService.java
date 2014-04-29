/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import entity.Word;
import entity.WordType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vincze.attila
 */
public class WordService {

    //private String databaseUrl = "jdbc:sqlite:F:\\Teologia\\HWL\\sources\\HWLDataLoader\\hwl.db";
    private String databaseUrl = "jdbc:sqlite:hwl.db";

    public static WordService create() {
        return new WordService();
    }

    public List<Word> getAllWords() {
        List<Word> result = new ArrayList<Word>();
        try {

            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            result = wordDao.queryBuilder().query();

        } catch (SQLException ex) {
            Logger.getLogger(WordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<WordType> getAllWordTypes() {
        List<WordType> result = new ArrayList<WordType>();
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<WordType, String> wordDao = DaoManager.createDao(connectionSource, WordType.class);
            result = wordDao.queryBuilder().query();
        } catch (SQLException ex) {
            Logger.getLogger(WordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Word add(Word entity) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            wordDao.createOrUpdate(entity);
        } catch (SQLException ex) {
            Logger.getLogger(WordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
    public void delete(Word entity) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            wordDao.delete(entity);
        } catch (SQLException ex) {
            Logger.getLogger(WordService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Word> search(String inEnglish, String inHebrew, String inHungarian, WordType wordType) {
        List<Word> result = new ArrayList<Word>();
        try {

            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            QueryBuilder statement = wordDao.queryBuilder();
            Where<Word, String> where = null;
            if (inEnglish != null || inHebrew != null || inHungarian != null){
                where = statement.where()
                    .like("inEnglish", (inEnglish == null || "".equals(inEnglish)) ? "" : "%" + inEnglish + "%" )
                    .or()
                    .like("inHungarian", (inHungarian == null  || "".equals(inHungarian)) ? "" : "%" + inHungarian + "%" )
                    .or()
                    .like("inHebrew", (inHebrew == null  || "".equals(inEnglish))  ? "" : "%" + inHebrew + "%" );
            }
            if (wordType.getId() != 100L){
                if (where == null){
                    statement.where().eq("wordTypeId", wordType.getId());
                } else {
                    where.and().eq("wordTypeId", wordType.getId());
                }
            }
            result = statement.query();
        } catch (SQLException ex) {
            Logger.getLogger(WordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
