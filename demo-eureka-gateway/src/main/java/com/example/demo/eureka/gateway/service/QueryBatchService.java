package com.example.demo.eureka.gateway.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

@Service
public class QueryBatchService {

    class Request {
        String code;
        CompletableFuture<Request> future;
    }

    public BlockingDeque<Request> queue = new LinkedBlockingDeque();

    @PostConstruct
    public void init() {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(() -> {

            Request request = queue.poll();

            request.future.complete(request);

        }, 10, 10, TimeUnit.MILLISECONDS);
    }

}
