package uea.ap1_ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.ap1_ru.models.Refeicao;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long>{

}
