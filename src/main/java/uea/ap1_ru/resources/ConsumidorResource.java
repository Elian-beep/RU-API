package uea.ap1_ru.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uea.ap1_ru.models.Consumidor;
import uea.ap1_ru.models.Refeicao;
import uea.ap1_ru.services.ConsumidorService;
import uea.ap1_ru.services.RefeicaoService;

@RestController
@RequestMapping("/consumidores")
public class ConsumidorResource {
	@Autowired
	private ConsumidorService consumidorService;
	
	@Autowired
	private RefeicaoService refeicaoService;
	
	@PostMapping
	public ResponseEntity<Consumidor> criar(@RequestBody Consumidor consumidor){
		Consumidor novaConsumidor = consumidorService.criar(consumidor);
		return ResponseEntity.ok().body(novaConsumidor);
	}
	
	@GetMapping
	public ResponseEntity<List<Consumidor>> listar(){
		List<Consumidor> consumidores = consumidorService.listar();
//		List<Refeicao> refeicoes = refeicaoService.listar();
//		ArrayList<Refeicao> refeicoesTemp = new ArrayList<>();
//		for(Consumidor consumidor : consumidores) {
//			for(Refeicao refeicao : refeicoes) {
//				if (consumidor.getCodigo().equals(refeicao.getConsumidor().getCodigo())) {
//					System.out.println("Consumidor: "+consumidor.getNome()+", Refeicao: "+refeicao.getTipo()+"\n");
//					refeicoesTemp.add(refeicao);
//				}
//			}
//			consumidor.setRefeicoes(refeicoesTemp);
//			refeicoesTemp.clear();
//		}
		return ResponseEntity.ok().body(consumidores);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Consumidor> buscarPorCodigo(@PathVariable Long codigo){
		Consumidor consumidor = consumidorService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(consumidor);
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Consumidor> atualizar(@PathVariable Long codigo, @RequestBody Consumidor consumidor){
		Consumidor consumidorSalvo = consumidorService.atualizar(codigo, consumidor);
		return ResponseEntity.ok().body(consumidorSalvo);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Consumidor> deletar(@PathVariable Long codigo){
		consumidorService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
