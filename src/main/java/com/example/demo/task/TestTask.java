package com.example.demo.task;

import com.example.demo.service.shiro.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Timer;
import java.util.TimerTask;
@Component
public class TestTask extends TimerTask {
    private ITUserService sss;

    private int s =1;
    private Timer timer;
    public  TestTask(ITUserService itUserService){
        this.sss = itUserService;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(this,0,3000);
    }
    @Override
    public void run() {
        sss.testInt(s);
    }
}
