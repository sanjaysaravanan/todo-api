package com.example.demo.sample;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {

	/**
	 * @return
	 */
	@GetMapping(path= "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    /**
     * @return
     */
    @GetMapping(path= "/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    /**
     * @param name
     * @return
     */
    @GetMapping(path= "/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
    	//throw new RuntimeException("Something went wrong");
    	return new HelloWorldBean(String.format("Hello World, %s", name));
    	
    }

}
