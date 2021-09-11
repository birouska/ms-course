package br.com.birouska.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.birouska.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
