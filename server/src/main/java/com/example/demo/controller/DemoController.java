package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping(path="${api_prefix}/demo")
public class DemoController {
    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    public DemoController(RequestMappingHandlerMapping handlerMapping) {
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
	    return demoRepository.getAll();
    }
}
