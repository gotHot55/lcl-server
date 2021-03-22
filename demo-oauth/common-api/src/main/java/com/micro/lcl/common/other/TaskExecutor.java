package com.micro.lcl.common.other;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程池，需要返回参数使用
 *  任务执行服务
 * @author Administrator
 * @date 2021/2/2516:38
 */
//@Component
@Slf4j
public class TaskExecutor {
    /**
     * 线程池  使用自定义的线程池  见TaskThreadPoolExecutor类下的getPoolExecutor
     */
    private final ExecutorService executorService;

    public TaskExecutor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    /**
     * 执行任务，任务列表需要从外边构造好，然后传进来
     */
    public List<UserModel> execute(List<Callable<UserModel>> commands) {
        //创建异步执行对象
        CompletionService<UserModel> completionService = new ExecutorCompletionService<>(executorService);
        for (Callable<UserModel> command : commands) {
            completionService.submit(command);
        }
        //响应参数
        int taskCount = commands.size();
        List<UserModel> params = new ArrayList<>(taskCount);
        try {
            for (int i = 0; i < taskCount; i++) {
                Future take = completionService.take();
                params.add((UserModel) take.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            UserModel userModel = new UserModel();
            userModel.setId(0);
            params.add(userModel);
            System.out.println("返回执行失败");
            log.error(e.getMessage());
        }
        return params;
    }
    /**
     * 若使用于spring项目中，请参考ExecuteConcurrentBatchTask
     * 1.先将@Component注解打开
     */
    /*public static void main(String[] args) {

        TaskExecutor executor = new TaskExecutor(new ScheduledThreadPoolExecutor(10));
        List<Callable<UserModel>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Callable<UserModel> callable = new MyCallable("key", null);
            list.add(callable);
        }
        executor.execute(list);
    }*/
}
