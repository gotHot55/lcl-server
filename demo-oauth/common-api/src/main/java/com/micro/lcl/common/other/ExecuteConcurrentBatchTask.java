package com.micro.lcl.common.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2517:02
 */
@Component
@Slf4j
public class ExecuteConcurrentBatchTask {
    private final Object xxxService;
    private final TaskExecutor taskExecutor;
    private final TaskThreadPoolExecutor taskThreadPoolExecutor;

    /**
     * 添加需要的bean(带有spring注解的bean  eg:@Component @Service )
     * @param xxxService
     * @param taskExecutor
     * @param taskThreadPoolExecutor
     */
    public ExecuteConcurrentBatchTask(Object xxxService, TaskExecutor taskExecutor, TaskThreadPoolExecutor taskThreadPoolExecutor) {
        this.xxxService = xxxService;
        this.taskExecutor = taskExecutor;
        this.taskThreadPoolExecutor = taskThreadPoolExecutor;
    }

    /**
     * 多线程任务调用的方法
     * @return 返回值
     */
    public UserModel executeConcurrentTask() {
        List<Callable<UserModel>> taskExcutorList = new ArrayList<>();
        Callable<UserModel> myCallable = new MyCallable("xxx_ss", null);
        taskExcutorList.add(myCallable);

        List<UserModel> execute = taskExecutor.execute(taskExcutorList);
        execute.stream().forEach(x -> log.info(x.toString()));
        for (UserModel userModel : execute) {
            if (userModel.getId().equals(1)) {
                return userModel;
            }else {
                return null;
            }

        }
        return new UserModel();
    }
}
