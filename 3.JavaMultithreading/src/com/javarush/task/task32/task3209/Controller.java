package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.UndoManager;
import java.io.*;
import java.nio.file.Paths;

/**
 * Created by work on 15.02.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String... args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {

        createNewDocument();//метод создания нового документа.
    }

    public void resetDocument() {
        if (this.document != null && view != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

        document = ((HTMLDocument) new HTMLEditorKit().createDefaultDocument());
        if (document.getUndoableEditListeners() == null) {
            this.document.addUndoableEditListener(view.getUndoListener());
        }
        view.update();


    }

    public void setPlainText(String text) {
        //Сбрось документ
        resetDocument();
        //Создай новый реадер StringReader на базе переданного текста
        StringReader stringReader = new StringReader(text);

        try {
            //Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document
            new HTMLEditorKit().read(stringReader, document, 0);

        } catch (Exception e) {
            //Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {

        view.selectHtmlTab();//Выбирать html вкладку у представления.

        resetDocument();//Сбрасывать текущий документ.
        //System.out.println(document.getUndoableEditListeners().length);

        view.setTitle("HTML редактор");//Устанавливать новый заголовок окна
        //System.out.println(view.getTitle());

        view.resetUndo();//Сбрасывать правки в Undo менеджере

        this.currentFile = null;//Обнулить переменную


    }

    public void openDocument() {

        view.selectHtmlTab();//Выбирать html вкладку у представления.
        JFileChooser jFileChooser = new JFileChooser();//Создавать новый объект для выбора файла JFileChooser
        //File file = jFileChooser.getSelectedFile();
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter);//Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int i = jFileChooser.showOpenDialog(view);//Показывать диалоговое окно «Save File» для выбора файла.
        if (i == JFileChooser.APPROVE_OPTION) {//Если пользователь подтвердит выбор файла:
            this.currentFile = jFileChooser.getSelectedFile();
            //Сбросить документ
            resetDocument();
            view.setTitle(this.currentFile.getName());//Устанавливать имя файла в качестве заголовка окна представления.
            try (FileReader fileReader = new FileReader(currentFile)) {//Создать FileReader, используя currentFile.
                //Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
                new HTMLEditorKit().read(fileReader, document, 0);

                view.resetUndo();//Сбросить правки (вызвать метод resetUndo представления).
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (this.currentFile == null) {
            saveDocumentAs();
        }
        else {
            //Переключать представление на html вкладку
            view.selectHtmlTab();

            //Создавать FileWriter на базе currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText()
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocumentAs() {

        view.selectHtmlTab();//Выбирать html вкладку у представления.
        JFileChooser jFileChooser = new JFileChooser();//Создавать новый объект для выбора файла JFileChooser
        //File file = jFileChooser.getSelectedFile();
        HTMLFileFilter fileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(fileFilter);//Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int i = jFileChooser.showSaveDialog(view);//Показывать диалоговое окно «Save File» для выбора файла.
        if (i == JFileChooser.APPROVE_OPTION) {//Если пользователь подтвердит выбор файла:
            this.currentFile = jFileChooser.getSelectedFile();
            /*if(!this.currentFile.getName().toLowerCase().endsWith(".html")||
                    !this.currentFile.getName().toLowerCase().endsWith(".htm")){
                this.currentFile.renameTo(Paths.get(this.currentFile+".html").toFile());
            }*/
            view.setTitle(this.currentFile.getName());//Устанавливать имя файла в качестве заголовка окна представления.
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());

            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void exit() {
        System.exit(0);
    }

}
