package com.micro.lcl.common.other;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 不需要返回参数，使用
 *使用阿里巴巴推荐的创建线程池的方式
 * 过ThreadPoolExecutor构造函数自定义参数创建
 * @author Administrator
 * @date 2021/2/2516:13
 */
@Component
public class TaskThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    private static ThreadPoolExecutor poolExecutor=null;
    /**
     * 执行任务，任务列表需要从外边构造好，然后传进来
     */
    public void execute(List<Runnable> commands) {
        poolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (Runnable command : commands) {
            poolExecutor.execute(command);
            System.out.println(command+"执行了！");
        }
        poolExecutor.shutdown();
    }

    public void shutdown() {
        poolExecutor.shutdown();
    }
    private boolean isTerminated() {
        return poolExecutor.isTerminated();
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TaskThreadPoolExecutor executorDemo = new TaskThreadPoolExecutor();
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            list.add(worker);
        }
        executorDemo.execute(list);
        //终止线程池
        executorDemo.shutdown();
        while (!executorDemo.isTerminated()) {
        }
        System.out.println("结束线程！耗时："+(System.currentTimeMillis()-start));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
