package edu.bu.heptagon.upark.dao;

import java.util.UUID;

import edu.bu.heptagon.upark.entities.UserAccount;

public interface UserAccountDAO {
    public void addUserAccount(UserAccount ua);
    public void updateUserAccount(UserAccount ua);
    public UserAccount findUserbyName(String username);
    public void deleteAccount(UUID id);
}
