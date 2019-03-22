package com.yevhenii.to_do_list.repository;

import com.yevhenii.to_do_list.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List, Integer>{

    List findById(String boo);

//    @Query("SELECT u FROM List u LEFT JOIN FETCH Task")
//    @Query("SELECT DISTINCT l FROM List l JOIN l.tasks t WHERE t.complete = false")
//    java.util.List<List> getListsAndNotSolvedTasks();



}
