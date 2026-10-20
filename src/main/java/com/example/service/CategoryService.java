package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Category;
import com.example.repository.CategoryRepository;

@Service 
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }
     public List<Category> findAll(){
        return repo.findAll();
    }
    
    
    public Category findById(Long id){
        return repo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Category not found whit id" + id)
        );
    }
    
    public Category save(Category category){
        return repo.save(category);
    }
    
    public Category update(Long id, Category newCategory){
        Category categoryDb =findById(id);
        categoryDb.setName(newCategory.getName());
        return repo.save(categoryDb);
    }
    
    public void delete(Long id){
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException(
                "Category not found with id:" + id);
        }
        repo.deleteById(id);
    }
}
