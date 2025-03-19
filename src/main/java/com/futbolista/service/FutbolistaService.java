package com.futbolista.service;

import java.util.List;

import com.futbolista.entity.Futbolista;

public interface FutbolistaService {
	
	//select que permite listar todos los futbolistas -- SELECT 
    public abstract List<Futbolista> listaTodos();
    
    //Select  que permite filtrar la busqueda por ID -- SELECT (ID)
    public abstract List<Futbolista> buscarFutbolistaPorId(int id);
    
    //Registrar Futbolista  -- INSERT
    public abstract Futbolista registraFutbolista(Futbolista obj);
    
    //Actualizar Futbolista -- UPDATE
    public abstract Futbolista actualizaFutbolista(Futbolista obj);
    
    //Eliminar Futbolista -- DROP
    public abstract void eliminaFutbolista(int id);
    
}
