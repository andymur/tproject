package tapplication.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tapplication.model.Role;
import tapplication.service.RoleService;

/**
 * Created by alexpench on 08.04.17.
 */
@Component
public class UserRoleDto implements Converter<Object, Role> {

    static final Logger logger = LoggerFactory.getLogger(UserRoleDto.class);

    @Autowired
    RoleService userRoleService;

    public Role convert(Object element) {
        Long id = Long.parseLong((String)element);
        Role profile= userRoleService.findById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }
}
