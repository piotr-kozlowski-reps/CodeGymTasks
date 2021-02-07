package com.codegym.task.task32.task3209;

import com.codegym.task.task32.task3209.listeners.FrameListener;
import com.codegym.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.codegym.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    //fields
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();


    //constructor
    public View(){

        try{
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (UnsupportedLookAndFeelException e){
        }

    }



    //set/get
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UndoListener getUndoListener(){
        return undoListener;
    }



    //
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command){
            case "New":
                controller.createNewDocument();
                break;
            case "Open":
                controller.openDocument();
                break;
            case "Save":
                controller.saveDocument();
                break;
            case "Save as...":
                controller.saveDocumentAs();
                break;
            case "Exit":
                controller.exit();
                break;
            case "About":
                showAbout();
                break;
        }

    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }

    public void initMenuBar(){

        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);

        getContentPane().add(jMenuBar, BorderLayout.NORTH);


    }

    public void initEditor(){

        htmlTextPane.setContentType("text/html");

        JScrollPane jScrollPaneHTML = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPaneHTML);

        JScrollPane jScrollPanePlaneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Text", jScrollPanePlaneText);

        tabbedPane.setPreferredSize(new Dimension(800, 600));

        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){

        if (tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        } else if (tabbedPane.getSelectedIndex() == 1){
            plainTextPane.setText(controller.getPlainText());
        }

        resetUndo();

    }

    public void undo(){
        try{
            undoManager.undo();
        } catch (CannotUndoException e){ExceptionHandler.log(e);}

    }

    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e){ExceptionHandler.log(e);}

    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public boolean isHtmlTabSelected(){
        if (tabbedPane.getSelectedIndex() == 0){
            return true;
        } else {
            return false;
        }

    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update(){
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(tabbedPane, "Info o programie", "About", JOptionPane.INFORMATION_MESSAGE);
    }
    
}