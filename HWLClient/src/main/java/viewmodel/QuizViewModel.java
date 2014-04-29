/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import entity.Word;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import service.WordService;

/**
 *
 * @author vincze.attila
 */
public class QuizViewModel extends ViewModelBase {

    private String name;
    private String selectedLesson;
    private Action saveAction;
    private ObservableList<Word> wordList;
    private List<Word> testList;
    private List<Word> solutionList;
    private List<List<Word>> quizList;

    public QuizViewModel(ResourceBundle bundle) {
        super(bundle);
        wordList = ObservableCollections.observableList(new ArrayList<Word>());
        wordList.addAll(WordService.create().getAllWords());
        testList = new ArrayList<Word>();
        solutionList = new ArrayList<Word>();
        quizList = new ArrayList<List<Word>>();

        saveAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                System.out.println(name);
            }
        };
    }

    
    
    public void createTest(String lesson) {
        testList.clear();
        solutionList.clear();
        quizList.clear();

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
            for (int i = 0; i < 20; i++) {
                List<Word> actualTest = new ArrayList<Word>();
                Word word = solutionList.get(randomGenerator.nextInt(solutionList.size()));
                actualTest.add(word);
                solutionList.remove(word);
                testList.remove(word);
                word = testList.get(randomGenerator.nextInt(testList.size()));
                actualTest.add(word);

                word = testList.get(randomGenerator.nextInt(testList.size()));
                actualTest.add(word);

                word = testList.get(randomGenerator.nextInt(testList.size()));
                actualTest.add(word);

                word = testList.get(randomGenerator.nextInt(testList.size()));
                actualTest.add(word);
                quizList.add(actualTest);
            }
        } catch (Exception e) {
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldValue, this.name);
    }

    public Action getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(Action saveAction) {
        this.saveAction = saveAction;
    }

    public ObservableList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(ObservableList<Word> wordList) {
        this.wordList = wordList;
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

    public String getSelectedLesson() {
        return selectedLesson;
    }

    public void setSelectedLesson(String selectedLesson) {
        String oldValue = this.selectedLesson;
        this.selectedLesson = selectedLesson;
        propertyChangeSupport.firePropertyChange("selectedLesson", oldValue, this.selectedLesson);
    }

    public List<List<Word>> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<List<Word>> quizList) {
        this.quizList = quizList;
    }
}
