package com.futbolista.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolista.entity.Futbolista;
import com.futbolista.repository.FutbolistaRepository;

@Service
public class FutbolistaServiceImpl implements FutbolistaService{

	 	@Autowired
	    private FutbolistaRepository futbolistaRepository;

	 	@Override
	    public List<Futbolista> listaTodos() {
	        return futbolistaRepository.findAll();
	    }

	    @Override
	    public List<Futbolista> buscarFutbolistaPorId(int id) {
	        return futbolistaRepository.listaPorIdIgual(id);
	    }

		@Override
		public Futbolista registraFutbolista(Futbolista obj) {
			return futbolistaRepository.save(obj);
		}



		@Override
		public void eliminaFutbolista(int id) {
			futbolistaRepository.deleteById(id);
		}

		@Override
		public Futbolista actualizaFutbolista(Futbolista obj) {
			return futbolistaRepository.save(obj);
		}



}
