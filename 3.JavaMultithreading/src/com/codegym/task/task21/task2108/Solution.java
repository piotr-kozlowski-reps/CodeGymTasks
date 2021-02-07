package com.codegym.task.task21.task2108;

/* 
Cloning plants

*/

//The Plant class should not implement the Cloneable interface
//Implement deep cloning for Tree.
//
//



//4. The Tree class must correctly implement the clone method.



public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            String[] branchesToBeCloned = new String[this.branches.length];

            for (int i = 0; i < this.branches.length; i++){
                branchesToBeCloned[i] = this.branches[i];
            }

            Tree treeToBeCloned = new Tree(getName(), branchesToBeCloned);
            return treeToBeCloned;
        }
    }
}
