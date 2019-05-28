package com.zycus.costSharing.repositories;

import com.zycus.costSharing.models.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ExpensesRepo extends MongoRepository<Expenses, String> {

    List<Expenses> findAllByFriendsID(long friendsID);
    List<Expenses> findAllByUser(long user);

}
