package com.manish.kafkalistener.batchProcessing;

import com.manish.kafkalistener.batchProcessing.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeItemProcessor implements ItemProcessor<Employee,Employee> {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeItemProcessor.class);
    @Override
    public Employee process(Employee employee) throws Exception {
        final String id = employee.getId();
        final String name = employee.getName().toUpperCase();
        final String designation = employee.getDesignation().toUpperCase();
        final Employee transformedEmployee = new Employee(id, name,designation);

        LOGGER.info("Converting (" + employee + ") into (" + transformedEmployee + ")");

        return transformedEmployee;
    }
}
