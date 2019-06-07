package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping(path="${api_prefix}/demo")
public class DemoController {
    private final DemoRepository demoRepository;

    @Autowired
    //public DemoController(RequestMappingHandlerMapping handlerMapping, DemoRepository demoRepository) {
    public DemoController(RequestMappingHandlerMapping handlerMapping, DemoRepository demoRepository) {
        this.demoRepository = demoRepository;

        logger.info("--- Showing me all controllers endpoint ---");
        for(RequestMappingInfo info : handlerMapping.getHandlerMethods().keySet())
        {
            logger.info(info.toString());
        }
    }

	Logger logger = Logger.getLogger(DemoController.class);

	@GetMapping("/")
	public String index(){
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
