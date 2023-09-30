package com.vojtechjanovec;

import java.util.List;

public class MySimpleIterator<T> implements SimpleIterator<T> {

    private final List<T> list;
    private int index;

    public MySimpleIterator(List<T> list) {
        this.list = list;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return index < list.size() - 1;
    }
//
//    @Override
//    public T next() {
//        // move to the next element
//        index++;
//        // check bounds (if assertions are enabled)
//        assert index <= list.size() - 1;
//        return list.get(index);
//    }

    public T next(String className) {
        index++;
        if(list.get(index).getClass().getName().equals(className)) {
            return list.get(index);
        }
        return null;

//        index++;
//        while(!list.get(index).getClass().getName().equals(className) || index<list.size()) {
//            index++;
//        }
//
//        return null;
    }
}
