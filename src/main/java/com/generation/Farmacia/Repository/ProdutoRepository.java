package com.generation.Farmacia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.Farmacia.Model.ProdutoModel;


@Repository
	public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
	public List <ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
	

}
