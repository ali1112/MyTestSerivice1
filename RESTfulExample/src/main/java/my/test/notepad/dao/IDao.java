package my.test.notepad.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T, ID extends Serializable> {
   
	T saveOrUpdate(T pobject, String collection);

    T getByID(String id, String collection);

    List<T> getAll(String collection);

    boolean delete(String id, String collection);

    void createCollection(String collection);
    
    T insert(T pobject, String collection);
}
