package com.example.employeeemail.mapper;

import com.example.employeeemail.dto.EmailRequestDto;
import com.example.employeeemail.dto.EmailResponseDto;
import com.example.employeeemail.model.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    // employee relationship is NOT set here - the service sets it explicitly
    // after looking up (or creating) the actual Employee entity.
    @Mapping(target = "employee", ignore = true)
    Email toEntity(EmailRequestDto dto);

    @Mapping(target = "employeeId", source = "employee.id")
    EmailResponseDto toDto(Email email);

    List<EmailResponseDto> toDtoList(List<Email> emails);

    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(EmailRequestDto dto, @MappingTarget Email email);
}
