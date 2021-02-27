package com.codegym.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {

    //fields
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    //constr
    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {

        int initialCapacity = Math.max(16, (int) (Math.ceil(collection.size() / 0.75f)));
        this.map = new HashMap<>(initialCapacity);

        for (E itemFromCollection : collection) {
            map.put(itemFromCollection, PRESENT);
        }

    }


    //
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(Object e) {

        if (map.containsKey(e)) {
            return false;
        } else {
            map.put((E)e, PRESENT);
            return true;
        }

    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o) ? true : false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        if (map.containsKey(o)) {
            map.remove(o);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        try {

            AmigoSet<E> clonedAmigoSet = (AmigoSet<E>) super.clone();
            HashMap<E, Object> clonedMap = (HashMap<E, Object>) map.clone();
            return clonedAmigoSet;
        } catch (Exception exception) {
            throw new InternalError();
        }

    }


}