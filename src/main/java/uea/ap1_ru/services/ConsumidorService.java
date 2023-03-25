package uea.ap1_ru.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.ap1_ru.models.Consumidor;
import uea.ap1_ru.repositories.ConsumidorRepository;

@Service
public class ConsumidorService {
	@Autowired
	private ConsumidorRepository consumidorRepository;
	
	public Consumidor criar(Consumidor consumidor) {
		return consumidorRepository.save(consumidor);
	}
	
	public List<Consumidor> listar() {
		return consumidorRepository.findAll();
	}
	
	public Consumidor buscarPorCodigo(Long codigo) {
		Consumidor consumidor = consumidorRepository.findById(codigo).orElseThrow();
		return consumidor;
	}
	
	public Consumidor atualizar(Long codigo, Consumidor consumidor) {
		Consumidor consumidorSalvo = consumidorRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(consumidor, consumidorSalvo, "codigo");
		return consumidorRepository.save(consumidorSalvo);
	}
	
	public void deletar(Long codigo) {
		consumidorRepository.deleteById(codigo);
	}
}
