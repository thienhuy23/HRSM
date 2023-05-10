/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrsm.DAO;

import java.util.List;

/**
 *
 * @author lenovo
 */
public abstract class HRSMDAO<E,K> {
    abstract public void insert(E entity);

    abstract public void update(E entity);

    abstract public void delete(E entity);

    abstract public List<E> selectAll();

    abstract public E selectById(K key);

    abstract protected List<E> selectBySql(String sql, Object...args);
}
