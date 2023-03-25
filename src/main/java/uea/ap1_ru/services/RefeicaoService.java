package uea.ap1_ru.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.ap1_ru.models.Consumidor;
import uea.ap1_ru.models.Refeicao;
import uea.ap1_ru.repositories.ConsumidorRepository;
import uea.ap1_ru.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	
	@Autowired
	private ConsumidorRepository consumidorRepository;
	
	public Refeicao criar(Refeicao refeicao) {
		Consumidor consumidor = consumidorRepository.findById(refeicao.getConsumidor().getCodigo()).orElseThrow();
		return refeicaoRepository.save(refeicao);
	}
	
	public void deletar(Long codigo) {
		refeicaoRepository.deleteById(codigo);
	}
	
	public List<Refeicao> listar() {
		return refeicaoRepository.findAll();
	}
}
