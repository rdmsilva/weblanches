package br.com.rafael.weblanches.repository;

import br.com.rafael.weblanches.entity.PedidoLanche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoLancheRepository extends JpaRepository<PedidoLanche, Integer> {
}
