package com.example.employeeemail.mapper;

import com.example.employeeemail.dto.EmployeeRequestDto;
import com.example.employeeemail.dto.EmployeeResponseDto;
import com.example.employeeemail.dto.EmployeeWithEmailsRequestDto;
import com.example.employeeemail.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = { EmailMapper.class })
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequestDto dto);

    // Base-field-only mapping for the "with emails" flow - the emails
    // themselves are built and attached separately in the service, since
    // each child Email also needs its "employee" back-reference set, which
    // isn't available yet at mapping time.
    @Mapping(target = "emails", ignore = true)
    Employee toEntity(EmployeeWithEmailsRequestDto dto);

    EmployeeResponseDto toDto(Employee employee);

    List<EmployeeResponseDto> toDtoList(List<Employee> employees);

    void updateEntityFromDto(EmployeeRequestDto dto, @MappingTarget Employee employee);
}
