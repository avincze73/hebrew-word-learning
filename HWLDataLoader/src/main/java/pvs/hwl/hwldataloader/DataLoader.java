/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pvs.hwl.hwldataloader;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import entity.Cardinality;
import entity.Sex;
import entity.Word;
import entity.WordType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vincze.attila
 */
public class DataLoader {

    private String databaseUrl = "jdbc:sqlite:hwl.db";

    public static DataLoader create() {
        return new DataLoader();
    }

    public void load() {
        loadTypes();
        loadWords();
    }

    private void loadWords() {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            Properties props = new java.util.Properties();
            props.put("separator", ";"); // separator is a bar
            props.put("fileExtension", ".txt"); // file extension is .txt
            props.put("charset", "utf-8"); // file extension is .txt
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            String path = new java.io.File(".").getCanonicalPath();
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + path, props);
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM words");
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            final Dao<WordType, String> wordTypeDao = DaoManager.createDao(connectionSource, WordType.class);
            while (results.next()) {
                
                //System.out.println(results.getString("inEnglish") + ", " + results.getString("inHungarian") + ", " + results.getString("inHebrew") + ", " +
                //         wordTypeDao.queryForEq("englishName",results.getString("wordType")).get(0).getEnglishName() + ", "  + results.getString("lesson") );
                System.out.println(results.getString("inEnglish"));
                Word word = new Word(results.getString("inHungarian"), results.getString("inEnglish"), 
                        results.getString("inHebrew"), results.getString("lesson"), wordTypeDao.queryForEq("englishName",results.getString("wordType")).get(0));
                if (!"".equals(results.getString("sex"))){
                    word.setSex(results.getString("sex"));
                }
                if (!"".equals(results.getString("cardinality"))){
                    word.setCardinality(results.getString("cardinality"));
                }
                wordDao.create(word);
            }
            results.close();
            stmt.close();
            conn.close();
        } catch (IOException ex) {
            Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTypes() {
        try {

            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
            final Dao<Word, String> wordDao = DaoManager.createDao(connectionSource, Word.class);
            final Dao<WordType, String> wordTypeDao = DaoManager.createDao(connectionSource, WordType.class);
            TableUtils.dropTable(connectionSource, Word.class, true);
            TableUtils.createTable(connectionSource, Word.class);

            TableUtils.dropTable(connectionSource, WordType.class, true);
            TableUtils.createTable(connectionSource, WordType.class);

            WordType miscellaneous = new WordType("miscellaneous", "kifejezés");
            wordTypeDao.create(miscellaneous);

            WordType noun = new WordType("noun", "főnév");
            wordTypeDao.create(noun);

            WordType werb = new WordType("verb", "ige");
            wordTypeDao.create(werb);

            WordType foreignWord = new WordType("foreign word", "idegen szó");
            wordTypeDao.create(foreignWord);

            WordType adjective = new WordType("adjective", "melléknév");
            wordTypeDao.create(adjective);

            WordType question = new WordType("question", "kérdőszó");
            wordTypeDao.create(question);
            
            WordType number = new WordType("number", "szám");
            wordTypeDao.create(number);

            WordType personalPronoun = new WordType("personal pronoun", "személyes névmás");
            wordTypeDao.create(personalPronoun);
            
            WordType demonstrativePronoun = new WordType("demonstrative pronoun", "mutató névmás");
            wordTypeDao.create(demonstrativePronoun);

            WordType particle = new WordType("particle", "toldalék");
            wordTypeDao.create(particle);

            WordType country = new WordType("country", "ország");
            wordTypeDao.create(country);

            WordType city = new WordType("city", "város");
            wordTypeDao.create(city);
            
            WordType other = new WordType("other", "egyéb");
            wordTypeDao.create(other);

            WordType notDefined = new WordType("not defined", "nem definiált");
            wordTypeDao.create(notDefined);

            Word word = new Word("békesség", "peace", "שלום", "I", miscellaneous);
            word.setCardinality(Cardinality.singular.name());
            word.setSex(Sex.male.name());
            //wordDao.create(word);

            word = new Word("bor", "wine", "יין", "I", miscellaneous);
            word.setCardinality(Cardinality.singular.name());
            word.setSex(Sex.male.name());
            //wordDao.create(word);


            TransactionManager.callInTransaction(connectionSource, new Callable<Void>() {

                public Void call() throws Exception {

                    return null;
                }
            });


        } catch (SQLException ex) {
            Logger.getLogger(DataLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
