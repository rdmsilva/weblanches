package br.com.rafael.weblanches.repository;

import br.com.rafael.weblanches.entity.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Integer> {

    Lanche getById(Integer id);

}
