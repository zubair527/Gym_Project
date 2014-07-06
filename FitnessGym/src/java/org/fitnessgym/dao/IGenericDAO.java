package org.fitnessgym.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface IGenericDAO<E> {
    
    public Object findById(Class<E> x,int id);

    public void add(E x);

    public void delete(Class<E> x,int id);

    public void edit(E x);

    public List<E> getList(String query);
    
    public Map<String,String> getMap(String query);

}
