package com.hlieb.task;

import com.hlieb.entity.User;
import com.hlieb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ScheduledTasks {

    private final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${monthly.contribution.size}")
    private Integer MONTHLY_CONTRIBUTION_SIZE;

    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "0 0 9 1 * ?")
    public void updateMonthlyBalance(){
        LOG.info("Monthly balance update task started! Monthly contribution size: " + MONTHLY_CONTRIBUTION_SIZE);
        Iterable<User> allUsers = userRepository.findAll();
        allUsers.forEach(u -> u.setBalance(u.getBalance() - MONTHLY_CONTRIBUTION_SIZE));
        userRepository.saveAll(allUsers);
        LOG.info("Monthly balance update task done!");
    }

}
