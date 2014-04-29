/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import entity.Word;
import entity.WordType;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import service.WordService;
import view.DisplayMode;
import view.DisplayModeHandler;

/**
 *
 * @author vincze.attila
 */
public class WordViewModel extends ViewModelBase {

    private ObservableList<Word> wordList;
    private ObservableList<WordType> wordTypeList;
    private Word selectedWord;
    private Word detailedWord;
    private Integer selectedIndex;
    private Action newAction;
    private Action deleteAction;
    private Action editAction;
    private Action cancelAction;
    private Action saveAction;
    private Action searchAction;
    protected DisplayModeHandler modeHandler;
    private String searchInEnglish;
    private String searchInHebrew;
    private String searchInHungarian;
    private WordType searchWordType;
    private ObservableList<WordType> searchWordTypeList;

    public WordViewModel(ResourceBundle bundle) {
        super(bundle);
        modeHandler = new DisplayModeHandler();
        wordList = ObservableCollections.observableList(new ArrayList<Word>());
        wordTypeList = ObservableCollections.observableList(new ArrayList<WordType>());
        //setSelectedWord(new Word());
        
        searchWordTypeList = ObservableCollections.observableList(new ArrayList<WordType>());
        searchWordTypeList.add(new WordType("All", "Összes"));
        searchWordTypeList.get(0).setId(new Long(100));
        searchWordTypeList.addAll(WordService.create().getAllWordTypes());
        wordTypeList.addAll(WordService.create().getAllWordTypes());
        wordList.addAll(WordService.create().getAllWords());
        //detailedWord.setWordType(null);
        if (!wordList.isEmpty()) {
            //setSelectedIndex(null);
            setSelectedIndex(0);
            setDetailedWord(wordList.get(0));
            
            //detailedWord.setWordType(selectedWord.getWordType());
        }

        newAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                setDetailedWord(new Word());
                getDetailedWord().setWordType(wordTypeList.get(0));
                setSelectedIndex(null);
                modeHandler.setMode(DisplayMode.Insert);


            }
        };

        deleteAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                WordService.create().delete(selectedWord);
                setSelectedIndex(null);
                wordList.remove(selectedWord);
                setSelectedIndex(0);

            }
        };

        editAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                modeHandler.setMode(DisplayMode.Edit);
            }
        };

        cancelAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                modeHandler.setMode(DisplayMode.View);

            }
        };

        saveAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                WordService.create().add(detailedWord);
                if (modeHandler.getMode().equals(DisplayMode.Insert)) {
                    wordList.add(detailedWord);
                    setSelectedIndex(wordList.size() - 1);
                } else {
                    wordList.set(selectedIndex + 1, detailedWord);
                }
                modeHandler.setMode(DisplayMode.View);


            }
        };

        searchAction = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                wordList.clear();
                setSelectedWord(new Word());
                setSelectedIndex(null);

                wordList.addAll(WordService.create().search(searchInEnglish, searchInHebrew, searchInHungarian, searchWordType));
                if (!wordList.isEmpty()) {
                    setSelectedWord(wordList.get(0));
                    setSelectedIndex(0);
                }
            }
        };


    }

    public ObservableList<Word> getWordList() {
        return wordList;
    }

    public void setWordList(ObservableList<Word> wordList) {
        this.wordList = wordList;
    }

    public Word getSelectedWord() {
        return selectedWord;
    }

    public void setSelectedWord(Word selectedWord) {
        Word oldValue = this.selectedWord;
        this.selectedWord = selectedWord;
        propertyChangeSupport.firePropertyChange("selectedWord", oldValue, this.selectedWord);
        if (selectedWord != null) {
            setDetailedWord(selectedWord);
        }
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        Integer oldValue = this.selectedIndex;
        this.selectedIndex = selectedIndex;
        propertyChangeSupport.firePropertyChange("selectedIndex", oldValue, this.selectedIndex);
    }

    public Action getNewAction() {
        return newAction;
    }

    public void setNewAction(Action newAction) {
        this.newAction = newAction;
    }

    public Action getCancelAction() {
        return cancelAction;
    }

    public void setCancelAction(Action cancelAction) {
        this.cancelAction = cancelAction;
    }

    public Action getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(Action deleteAction) {
        this.deleteAction = deleteAction;
    }

    public Action getEditAction() {
        return editAction;
    }

    public void setEditAction(Action editAction) {
        this.editAction = editAction;
    }

    public Action getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(Action saveAction) {
        this.saveAction = saveAction;
    }

    public DisplayModeHandler getModeHandler() {
        return modeHandler;
    }

    public void setModeHandler(DisplayModeHandler modeHandler) {
        this.modeHandler = modeHandler;
    }

    public ObservableList<WordType> getWordTypeList() {
        return wordTypeList;
    }

    public void setWordTypeList(ObservableList<WordType> wordTypeList) {
        this.wordTypeList = wordTypeList;
    }

    public Action getSearchAction() {
        return searchAction;
    }

    public void setSearchAction(Action searchAction) {
        this.searchAction = searchAction;
    }

    public String getSearchInEnglish() {
        return searchInEnglish;
    }

    public void setSearchInEnglish(String searchInEnglish) {
        String oldValue = this.searchInEnglish;
        this.searchInEnglish = searchInEnglish;
        propertyChangeSupport.firePropertyChange("searchInEnglish", oldValue, this.searchInEnglish);
    }

    public String getSearchInHebrew() {
        return searchInHebrew;
    }

    public void setSearchInHebrew(String searchInHebrew) {
        String oldValue = this.searchInHebrew;
        this.searchInHebrew = searchInHebrew;
        propertyChangeSupport.firePropertyChange("searchInHebrew", oldValue, this.searchInHebrew);
    }

    public String getSearchInHungarian() {
        return searchInHungarian;
    }

    public void setSearchInHungarian(String searchInHungarian) {
        String oldValue = this.searchInHungarian;
        this.searchInHungarian = searchInHungarian;
        propertyChangeSupport.firePropertyChange("searchInHungarian", oldValue, this.searchInHungarian);
    }

    public Word getDetailedWord() {
        return detailedWord;
    }

    public void setDetailedWord(Word detailedWord) {
        Word oldValue = this.detailedWord;
        this.detailedWord = detailedWord;
        propertyChangeSupport.firePropertyChange("detailedWord", oldValue, this.detailedWord);
    }

    public WordType getSearchWordType() {
        return searchWordType;
    }

    public void setSearchWordType(WordType searchWordType) {
        WordType oldValue = this.searchWordType;
        this.searchWordType = searchWordType;
        propertyChangeSupport.firePropertyChange("searchWordType", oldValue, this.searchWordType);
    }

    public ObservableList<WordType> getSearchWordTypeList() {
        return searchWordTypeList;
    }

    public void setSearchWordTypeList(ObservableList<WordType> searchWordTypeList) {
        this.searchWordTypeList = searchWordTypeList;
    }
    
    
}
