package com.example.demo.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping(path="${api_prefix}/demo")
public class DemoController {
	private Logger logger = Logger.getLogger(DemoController.class);

    private final DemoRepository demoRepository;

    @Autowired
    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

	@GetMapping("/")
	public String index() {
		logger.info("index");
		return "This is server index";
	}

	@GetMapping("/ping")
	public String ping(){
		return "this is ping";
	}

	@GetMapping("/all")
    public List<Demo> getAll(){
        logger.info("all");
	    return demoRepository.findAll();
    }


    @GetMapping("/lazy_create/{name}")
    public Demo getDummyById(@PathVariable String name){
        Demo demo = Demo.builder().name(name).build();
        return demoRepository.save(demo);
    }
}
