/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.dac.service;

import ifpb.ads.dac.domain.Jogador;
import java.util.List;

/**
 *
 * @author jose
 */
public interface Service<T> {

    void add(T entity);

    T buscarPorId(int id);

    List<T> buscarTodos();

    void merge(int id, T entity);

    void remover(int id);
    
}
