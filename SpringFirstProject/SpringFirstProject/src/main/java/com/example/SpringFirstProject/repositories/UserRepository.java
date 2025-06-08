package com.example.SpringFirstProject.repositories;

import com.example.SpringFirstProject.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    public List<User> findByName(String name);

    public List<User> selectUserByEmail(String email);

    @NativeQuery("select * from tbl_user7 where address=?1")
    public  List<User> findUserByAddress(String address);

   // public  List<User> findUserByAddressAndSort(String address, Sort sort);
}
