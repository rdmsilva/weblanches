package br.com.rafael.weblanches.repository;

import br.com.rafael.weblanches.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    Ingrediente getById(Integer id);

}
