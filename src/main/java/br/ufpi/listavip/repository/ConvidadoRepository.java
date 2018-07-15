package br.ufpi.listavip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufpi.listavip.model.Convidado;

/**
 * Interface que herda um CRUD pronto oferecido pelo Spring Boot
 * @author armandosoaressousa
 *
 */
@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

}
