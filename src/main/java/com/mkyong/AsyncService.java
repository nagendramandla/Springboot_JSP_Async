package com.mkyong;

import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;

@Service
public class AsyncService {
	@Async("asyncExecutor")
    public CompletableFuture<String> getData() throws InterruptedException 
    {
        System.out.println("Returning string"+Thread.currentThread().getName());
        return CompletableFuture.completedFuture("ResponseData"+System.currentTimeMillis());
    }

}
