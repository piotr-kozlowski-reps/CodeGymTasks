package com.codegym.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    //fields
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    //set/get
    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean isNameMatching = false;
        boolean isPartOfContentMatching = false;
        boolean isMinSizeMatching = false;
        boolean isMaxSizeMatching = false;

        byte[] content = Files.readAllBytes(file); // File size: content.length

        //nameChecking
        if (partOfName == null || file.getFileName().toString().contains(partOfName)) {
            isNameMatching = true;
        }

        //contentChecking
        String contentString = new String(content);
        if (partOfContent == null || contentString.contains(partOfContent)) {
            isPartOfContentMatching = true;
        }

        //minMaxSizeMatching
        int contentLenght = content.length;
        if (minSize == 0 || contentLenght >= minSize) {
            isMinSizeMatching = true;
        }
        if (maxSize == 0 || contentLenght <= maxSize) {
            isMaxSizeMatching = true;
        }

        if (isNameMatching && isPartOfContentMatching && isMinSizeMatching && isMaxSizeMatching) {
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
        //return super.visitFile(file, attrs);
    }
}


/*
package com.codegym.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private List<String> result;
        public GetFiles(List<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            String s = path.toAbsolutePath().toString();
            result.add(s);
            return FileVisitResult.CONTINUE;
        }
    }
}
*/
