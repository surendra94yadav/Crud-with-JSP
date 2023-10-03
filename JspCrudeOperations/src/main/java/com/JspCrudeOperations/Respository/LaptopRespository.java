package com.JspCrudeOperations.Respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.JspCrudeOperations.Entity.Laptop;

public interface LaptopRespository extends JpaRepository<Laptop, Integer> {

}
