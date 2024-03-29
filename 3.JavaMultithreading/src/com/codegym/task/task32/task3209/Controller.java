package com.codegym.task.task32.task3209;

import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {


    //fields
    private View view;
    private HTMLDocument document;
    private File currentFile;

    //set/get
    public HTMLDocument getDocument(){
        return document;
    }


    //constructors
    public Controller(View view){
        this.view = view;
    }




    //
    public static void main(String[] args) {

        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);

        view.init();
        controller.init();

    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public void resetDocument(){

        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }

        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader, document, 0);
        } catch (BadLocationException e){
            ExceptionHandler.log(e);
        } catch (IOException e){
            ExceptionHandler.log(e);
        }

    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try{
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (BadLocationException e){
            ExceptionHandler.log(e);
        } catch (IOException e){
            ExceptionHandler.log(e);
        }

        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML editor");
        view.resetUndo();
        currentFile = null;

    }

    public void openDocument() {

        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        
        int returnedValue = jFileChooser.showOpenDialog(view);
        if (returnedValue == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try{
                FileReader fileReader = new FileReader(currentFile);

                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader, document, 0);
                view.resetUndo();
            } catch (FileNotFoundException e){
                ExceptionHandler.log(e);
            } catch (IOException e){
                ExceptionHandler.log(e);
            } catch (BadLocationException e){
                ExceptionHandler.log(e);
            }
        }


    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile == null){
            saveDocumentAs();
        } else {

            try{
                FileWriter fileWriter = new FileWriter(currentFile);
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e){
                ExceptionHandler.log(e);
            } catch (BadLocationException e){
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());

        int returnedValue = jFileChooser.showSaveDialog(view);
        if (returnedValue == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try{
                FileWriter fileWriter = new FileWriter(currentFile);

                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e){
                ExceptionHandler.log(e);
            } catch (BadLocationException e){
                ExceptionHandler.log(e);
            }
        }
    }
}