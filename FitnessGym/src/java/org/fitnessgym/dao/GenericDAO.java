package org.fitnessgym.dao;
import java.util.List;
import java.util.Map;

import org.fitnessgym.util.HibernateUtil;
import org.hibernate.Session;

public abstract class GenericDAO<E> implements IGenericDAO<E> {

//    private Class<E> persistenceClass; // generic class data type
    @Override
    public Object findById(Class<E> x, int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Object obj=s.get(x, id);
        s.close();
        return obj;
    }

    @Override
    public void add(E x) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.persist(x);      //  will enter generic type that will be object data type
        s.flush();
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Class<E> t, int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(s.get(t, id));
        s.flush();
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void edit(E t) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(t);
        s.flush();
        s.getTransaction().commit();
        s.close();

    }

    @Override
    public List<E> getList(String query) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List list = s.createQuery(query).list();
        s.clear();
        s.close();
        return list;
    }

    @Override
    public Map<String, String> getMap(String query) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List list = s.createQuery(query).list();
        s.clear();
        s.close();
        return null;
    }

}
