package src.repository;

import java.util.List;

public interface Repository<T> {
    public List<T> getAll();
    
}