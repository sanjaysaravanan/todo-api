package com.todo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    @GetMapping(path= "/hell-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPathVariable(@PathVariable String name){
    	return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
