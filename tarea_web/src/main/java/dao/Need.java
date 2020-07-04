/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Need<T> {
    abstract void crear(T o) throws Exception;
    abstract Boolean verificar(T o) throws Exception;
    abstract List<T> listar() throws Exception;
}
