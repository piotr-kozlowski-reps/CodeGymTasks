package com.codegym.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();

        Class clazz = map.getClass();
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        Set<E> setOfKeys = new HashSet<>(map.keySet());
        out.writeObject(loadFactor);
        out.writeObject(capacity);
        out.writeObject(setOfKeys);
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        float loadFactor = (float) in.readObject();
        int capacity = (int) in.readObject();
        Set<E> setOfKeys = (Set<E>) in.readObject();
        map = new HashMap(capacity, loadFactor);

        for (E entry : setOfKeys) {
            map.put(entry, PRESENT);
        }

    }

}