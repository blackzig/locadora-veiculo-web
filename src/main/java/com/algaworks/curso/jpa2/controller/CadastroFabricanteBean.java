/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.curso.jpa2.controller;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Michel A. Medeiros
 */
@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable{
    
    @Inject
    private CadastroFabricanteService cadastroFabricanteService;
    
    private Fabricante fabricante;
    
    public void salvar(){
        try {
            this.cadastroFabricanteService.salvar(fabricante);
            FacesUtil.addSuccessMessage("Fabricante salvo com sucesso.");
            this.limpar();
        } catch (Exception e) {
            FacesUtil.addErrorMessage(e.getMessage());
        }
    }
    
    @PostConstruct
    public void init(){
        this.limpar();
    }
    
    public void limpar(){
        this.fabricante = new Fabricante();
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    
    
}
