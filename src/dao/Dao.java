package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    int create(T t);

    void update(int id, T t);

    void delete(T t);
}
