package com.desafio.bossabox.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.bossabox.repositoriries.FerramentaRepository;

@Configuration
@Profile("test")
public class TestImplementacion {
	
	@Autowired
	private FerramentaRepository ferramentaRepository;

	//@Override
	//public void run(String... args) throws Exception {
		//List<String> list1 = Arrays.asList("organization","planning","collaboration",
			//	"writing","calendar");
		
		//List<String> list2 = Arrays.asList("api","json","schema","node","github","rest");
		
		//Ferramenta f1 = new Ferramenta(null,"Notion","https://notion.so",
			//	"All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.",
			//	list1);
		
		//Ferramenta f2 = new Ferramenta(null,"json-server" , "https://github.com/typicode/json-server", 
			//	"Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges.", list2);
		
		//ferramentaRepository.saveAll(Arrays.asList(f1,f2));
	//}
	
	

}
