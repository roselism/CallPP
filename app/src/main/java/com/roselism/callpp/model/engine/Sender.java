package com.roselism.callpp.model.engine;

/**
 * 命令发射器
 * 命令模式中的Invoker
 * Created by simon on 2016/4/30.
 */
public class Sender {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 发送命令
     */
    public void send() {
        if (command == null)
            throw new NullPointerException();

        command.excute(); // 命令执行
    }
}