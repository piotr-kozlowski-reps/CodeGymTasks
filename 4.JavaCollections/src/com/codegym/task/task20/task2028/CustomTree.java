package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Build a tree (part 1)

*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    //fields
    List<Entry<String>> entriesList = new ArrayList<>();
    int entriesCount;
    Entry<String> root;

    public CustomTree() {
        root = new CustomTree.Entry<String>("0");
        entriesList.add(root);
        entriesCount = 0;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


    //
    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        int count = -1;

        while (!queue.isEmpty()) {
            Entry<String> tempNode = queue.poll();
            count++;

            if (tempNode.leftChild != null) queue.add(tempNode.leftChild);
            if (tempNode.rightChild != null) queue.add(tempNode.rightChild);
        }

        return count;
    }



    @Override
    public boolean add(String s) {

        Entry newEntry = new Entry(s);
        int lastCount = entriesCount;

        for (Entry entry : entriesList) {

            if (entry.leftChild == null) entry.availableToAddLeftChildren = true;
            if (entry.rightChild == null) entry.availableToAddRightChildren = true;

            if (entry.availableToAddLeftChildren) {
                entry.leftChild = newEntry;
                entry.availableToAddLeftChildren = false;
                entriesList.add(newEntry);
                newEntry.parent = entry;
                entriesCount++;
                break;
            } else if (entry.availableToAddRightChildren) {
                entry.rightChild = newEntry;
                entry.availableToAddRightChildren = false;
                entriesList.add(newEntry);
                newEntry.parent = entry;
                entriesCount++;
                break;
            }

        }

        if (entriesCount > lastCount)return true;
        else return false;
    }

    @Override
    public boolean remove(Object o) {

        int lastCount = entriesCount;

        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        for (Entry entry : entriesList) {

            if (entry.elementName.equals(o)) {

                if (entry.leftChild != null) {
                    removeRecursively(entry.leftChild);
                }
                if (entry.rightChild != null) {
                    removeRecursively(entry.rightChild);
                }

                entriesList.remove(entry);
                entry.parent.leftChild = null;
                entry.parent.rightChild = null;
                entry = null;
                entriesCount -= 2;
                break;
            }

        }

        if (entriesCount < lastCount) return true;
        else return false;
    }

    private void removeRecursively(Entry child) {

        if (child.leftChild != null) {
            removeRecursively(child.leftChild);
        }

        if (child.rightChild != null) {
            removeRecursively(child.rightChild);
        }

        entriesList.remove(child);
        child.parent.leftChild = null;
        child.parent.rightChild = null;
        child = null;
        entriesCount--;

    }

    public String getParent(String s) {

        for (Entry entry : entriesList) {
            if (entry.elementName.equals(s)) {
                return entry.parent.elementName;
            }
        }

        return null;

    }

    ////
    static class Entry<T> implements Serializable {

        //fields
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        boolean newLineRootElement;
        Entry<T> parent, leftChild, rightChild;

        //constr
        Entry(String name) {
            elementName = name;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }


        //
        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }

}