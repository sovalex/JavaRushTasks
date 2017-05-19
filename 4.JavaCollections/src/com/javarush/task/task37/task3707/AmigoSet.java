package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by work on 19.02.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable,Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet( Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size()/0.75f ));
        this.map = new HashMap<E,Object>(capacity);
        this.addAll(collection);
    }

    public AmigoSet() {
        map=new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() {

       try {
           AmigoSet<E> amigoClone = (AmigoSet)super.clone();
           amigoClone.map = (HashMap) map.clone();
           return amigoClone;
       }catch(Exception e){
           throw  new InternalError(e);
       }
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeInt(map.size());
        for(E e:map.keySet()){
            out.writeObject(e);
        }
        out.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        out.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)s.readObject());
        }
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }
    @Override
    public boolean add(E e) {
        return map.put(e,PRESENT)==null;
    }

    @Override
    public Iterator<E> iterator() {

        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
