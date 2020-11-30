package br.com.asw.si.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CepController {

	RestTemplate restTemplate;
	private String endpoint = "https://viacep.com.br/ws/";
	
	@GetMapping(path="/consultaCep")
	public ResponseEntity<EnderecoApi> consultaCep(@RequestParam String cep) {
		restTemplate = new RestTemplate();
		final EnderecoApi responseBody = restTemplate.getForObject(
				endpoint + cep + "/json", EnderecoApi.class);
		return ResponseEntity.ok().body(responseBody);
	}
}
