package com.imber.sistema.repository;

import com.imber.sistema.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

		@Repository
		public interface ClienteRepository extends JpaRepository<Participante, Long> {
		    Optional<Participante> findByCpf(String cpf);

		}	
		