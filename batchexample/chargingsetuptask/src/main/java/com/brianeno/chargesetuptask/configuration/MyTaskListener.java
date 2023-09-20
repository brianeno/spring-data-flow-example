package com.brianeno.chargesetuptask.configuration;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class MyTaskListener implements TaskExecutionListener {
    @Override
    public void onTaskStartup(TaskExecution taskExecution) {
        System.out.println("listener invoked for onTaskStartup");
    }

    @Override
    public void onTaskEnd(TaskExecution taskExecution) {
        System.out.println("listener invoked for onTaskEnd");
    }

    @Override
    public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("listener invoked for onTaskFailed");
    }
}
