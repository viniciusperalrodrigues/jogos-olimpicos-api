	package com.jogos.olimpicos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jogos.olimpicos.entity.CompeticaoEntity;

public interface CompeticaoRepository extends JpaRepository<CompeticaoEntity, Integer> {

	@Query("SELECT c FROM CompeticaoEntity c WHERE c.id != :id_competicao AND c.local.id = :id_local AND (c.dataInicio <= :data AND c.dataTermino > :data) and c.modalidade.id = :id_modalidade ")
	List<CompeticaoEntity> findCompeticaoByLocalDataInicioAndModalidadeUpdate(@Param("id_competicao") Integer id,
			@Param("id_local") Integer idLocal, @Param("data") LocalDateTime data,
			@Param("id_modalidade") Integer idModalidade);

	@Query("SELECT c FROM CompeticaoEntity c WHERE c.local.id = :id_local AND (c.dataInicio <= :data AND c.dataTermino > :data) and c.modalidade.id = :id_modalidade ")
	List<CompeticaoEntity> findCompeticaoByLocalDataInicioAndModalidade(@Param("id_local") Integer idLocal,
			@Param("data") LocalDateTime data, @Param("id_modalidade") Integer idModalidade);

	@Query("SELECT c FROM CompeticaoEntity c WHERE c.modalidade.id = :id_modalidade ORDER BY c.dataInicio ASC")
	List<CompeticaoEntity> listByModalidade(@Param("id_modalidade") Integer id);

	@Query("SELECT c FROM CompeticaoEntity c WHERE c.local.id = :id_local AND (c.dataInicio >=  :data_inicio AND c.dataTermino <= :data_final)")
	List<CompeticaoEntity> listByLocalDia(@Param("id_local") Integer id, @Param("data_inicio") LocalDateTime dataInicio,
			@Param("data_final") LocalDateTime dataFinal);

}
