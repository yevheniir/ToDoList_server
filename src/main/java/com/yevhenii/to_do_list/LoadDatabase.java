package com.yevhenii.to_do_list;

import com.yevhenii.to_do_list.model.List;
import com.yevhenii.to_do_list.model.Task;
import com.yevhenii.to_do_list.repository.ListRepository;
import com.yevhenii.to_do_list.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

//    @Bean
//    CommandLineRunner initDatabase(ListRepository repository) {
//        return args -> {
//            repository.save(new List("mainList", false));
//            repository.save(new List("new list 2", false));
//        };
//    }

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {
        return args -> {
            repository.save(new Task("mainList", "first task", false));
            repository.save(new Task("mainList", "second task", false));
        };
    }
}
