package services;

import model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findByName(String name);

    public User findById(Long id);

    public void delete(User user);

    public void update(User user);

    public void create(User user);
}
