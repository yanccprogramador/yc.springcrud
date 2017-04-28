package br.com.yanccprogramador.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import 	br.com.yanccprogramador.model.*;
public interface PessoaRepository extends JpaRepository<ClienteModel, Long> {
	
		
}
