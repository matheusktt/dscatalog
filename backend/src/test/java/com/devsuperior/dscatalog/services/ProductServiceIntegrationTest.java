package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 100L;
        countTotalProducts = 25;
    }

    @Test
    public void findAllPagedShouldReturnPageWhenPage0Size10() {

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<ProductDTO> pageProductDTO = service.findAllPaged(pageRequest);

        Assertions.assertFalse(pageProductDTO.isEmpty());

        Assertions.assertEquals(0, pageProductDTO.getNumber());
        Assertions.assertEquals(10, pageProductDTO.getSize());
        Assertions.assertEquals(countTotalProducts, pageProductDTO.getTotalElements());
    }

    @Test
    public void findAllPagedShouldReturnEmptyPageWhenPage0Size10() {

        PageRequest pageRequest = PageRequest.of(10, 10);

        Page<ProductDTO> pageProductDTO = service.findAllPaged(pageRequest);

        Assertions.assertTrue(pageProductDTO.isEmpty());
    }

    @Test
    public void findAllPagedShouldReturnSortedPageWhenSortByName() {

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("name"));

        Page<ProductDTO> pageProductDTO = service.findAllPaged(pageRequest);

        Assertions.assertFalse(pageProductDTO.isEmpty());

        Assertions.assertEquals("Macbook Pro", pageProductDTO.getContent().get(0).getName());
        Assertions.assertEquals("PC Gamer", pageProductDTO.getContent().get(1).getName());
        Assertions.assertEquals("PC Gamer Alfa", pageProductDTO.getContent().get(2).getName());
    }

    @Test
    public void deleteShouldDeleteResourceWhenIdExists() {

        service.delete(existingId);

        Assertions.assertEquals(countTotalProducts - 1, repository.count());
    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.delete(nonExistingId);
        });
    }
}