package br.com.birouska.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.birouska.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
