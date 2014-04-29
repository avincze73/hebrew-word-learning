/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import entity.Word;
import java.util.*;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import service.WordService;

/**
 *
 * @author vincze.attila
 */
public class TestViewModel extends ViewModelBase{

    private ObservableList<Word> wordList;
    private List<Word> testList;
    private List<Word> solutionList;
    private List<List<Word>> resultList;
    
    public TestViewModel(ResourceBundle bundle) {
        super(bundle);
        wordList = ObservableCollections.observableList(new ArrayList<Word>());
        wordList.addAll(WordService.create().getAllWords());
        testList = new ArrayList<Word>();
        solutionList = new ArrayList<Word>();
        resultList = new ArrayList<List<Word>>();
    }
    
    public void createTest(String lesson) {
        testList.clear();
        solutionList.clear();
        resultList.clear();

        if (!"All".equals(lesson)) {
            for (Word word : wordList) {
                if (word.getLesson().equals(lesson)) {
                    solutionList.add(word);
                    testList.add(word);
                }
            }
        } else {
            solutionList.addAll(wordList);
            testList.addAll(wordList);
        }

        Random randomGenerator = new Random();
        randomGenerator.setSeed(new Date().getTime());
        try {
            for (int i = 0; i < 25; i++) {
                List<Word> actualTest = new ArrayList<Word>();
                Word word = solutionList.get(randomGenerator.nextInt(solutionList.size()));
                actualTest.add(word);
                solutionList.remove(word);
                testList.remove(word);
                word = testList.get(randomGenerator.nextInt(testList.size()));
                actualTest.add(word);
                resultList.add(actualTest);
            }
        } catch (Exception e) {
        }

    }

    public List<List<Word>> getResultList() {
        return resultList;
    }

    public void setResultList(List<List<Word>> resultList) {
        this.resultList = resultList;
    }

   

    public List<Word> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Word> solutionList) {
        this.solutionList = solutionList;
    }

    public List<Word> getTestList() {
        return testList;
    }

    public void setTestList(List<Word> testList) {
        this.testList = testList;
    }

    public ObservableList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(ObservableList<Word> wordList) {
        this.wordList = wordList;
    }
    
    
    
}
