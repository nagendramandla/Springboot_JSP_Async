package com.mkyong;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	 @Autowired
	 private AsyncService service;
	 

	@RequestMapping("/")
	public String welcome(Map<String, Object> model)  throws InterruptedException, ExecutionException {
		System.out.println("Asynch Start");
		 
        CompletableFuture<String> data = service.getData();
        // Wait until they are all done
        CompletableFuture.allOf(data).join();
        String dataValue = data.get();
        System.out.println("Asynch End : "+dataValue);
		model.put("message", dataValue);
		return "welcome";
	}

}