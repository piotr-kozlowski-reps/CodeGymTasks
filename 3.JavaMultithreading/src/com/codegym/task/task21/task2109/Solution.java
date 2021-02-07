package com.codegym.task.task21.task2109;

/* 
Prevent cloning

*/


public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public int hashCode() {
            return getI() + getJ();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof A)) return false;

            A aToCompare = (A) obj;
            if (getI() != aToCompare.getI()) return false;
            if (getJ() != aToCompare.getJ()) return false;

            return true;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new  CloneNotSupportedException();
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);

            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof B)) return false;

            B bToCompare = (B) obj;
            if (getI() != bToCompare.getI()) return false;
            if (getJ() != bToCompare.getJ()) return false;
            if (getName() != null ? !getName().equals(bToCompare.getName()) : bToCompare.getName() != null) return false;

            return true;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            int iToBeCloned = super.getI();
            int jToBeCloned = super.getJ();
            String nameToBeCloned = super.getName();
            C cToBeCloned = new C(iToBeCloned, jToBeCloned, nameToBeCloned);

            return cToBeCloned;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static void main(String[] args) {

    }
}
