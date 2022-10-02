package ru.evanli.moretech.users.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.evanli.moretech.users.domain.Role;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserRoleListConverter implements AttributeConverter<List<Role>, String> {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleListConverter.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Role> attribute) {
        String dbData = null;
        try {
            dbData = objectMapper.writeValueAsString(
                    attribute.stream()
                        .map(r -> r.toString())
                        .collect(Collectors.toList())
            );
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return dbData;
    }

    @Override
    public List<Role> convertToEntityAttribute(String dbData) {
        List<Role> customerInfo = null;
        try {
            customerInfo = (List<Role>) objectMapper.readValue(dbData, List.class)
                    .stream()
                    .map(r -> Role.valueOf((String) r))
                    .collect(Collectors.toList());
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }

        return customerInfo;
    }
}
