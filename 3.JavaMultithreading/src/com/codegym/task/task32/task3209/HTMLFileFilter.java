package com.codegym.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {

        if (file.getName().toLowerCase().endsWith(".html")
        || file.getName().toLowerCase().endsWith(".htm")
        || file.isDirectory()) return true;
        else return false;
    }

    @Override
    public String getDescription() {
        return "HTML and HTM files";
    }
}