/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.curso.jpa2.dao;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Michel A. Medeiros
 */
public class FabricanteDAO implements Serializable{

    @Inject
    private EntityManager em;
    
    public void salvar(Fabricante fabricante){
        em.persist(fabricante);
    }

    public List<Fabricante> buscarTodos() {
        return em.createQuery("from Fabricante").getResultList();
    }

    @Transactional
    public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
        try {
            fabricanteSelecionado = em.find(Fabricante.class, fabricanteSelecionado.getCodigo());
            em.remove(fabricanteSelecionado);
            em.flush();
        } catch (Exception e) {
            throw new NegocioException("Erro ao excluir." +e.getMessage());
        }
    }
    
}
