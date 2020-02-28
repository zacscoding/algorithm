package demo.springinterview.p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
[0] Properties injected with @Value may, among other sources, come from system properties and JVM arguments.
[x] As the values of threadCount and threadNameTemplate are private and have no setters, they cannot be set by Spring.
[x] Initialization will fail because the counter and executorService fields are not managed by Spring.
[o] If a property named "thread.count" is not made available to Spring (i.e. through property files), the value of threadCount field will be 10.
[o] The value of the field threadNameTemplate will always be set to the same value regardless of properties provided to Spring.
 */

@Component
public class TaskExecutor {

    @Value("${thread.count:10}")
    private int threadCount;
    @Value("worker.thread.name")
    private String threadNameTemplate;
    private AtomicInteger counter = new AtomicInteger();
    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        ThreadFactory threadFactory = (runnable) -> new Thread(threadNameTemplate + counter.incrementAndGet());
        executorService = Executors.newFixedThreadPool(threadCount, threadFactory);
    }
}