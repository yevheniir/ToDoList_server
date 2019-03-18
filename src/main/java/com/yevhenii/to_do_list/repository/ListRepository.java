package com.yevhenii.to_do_list.repository;

import com.yevhenii.to_do_list.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List, Integer>{

}
