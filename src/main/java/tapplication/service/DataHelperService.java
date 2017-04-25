package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tapplication.dto.AddressDto;
import tapplication.dto.ProductAndAmount;
import tapplication.dto.ProductDto;
import tapplication.model.Category;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 25.04.17.
 */
@Service("dataService")
public class DataHelperService {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductServiceImpl productService;

    public String getUserName(){
        return userService.findBySSO(getPrincipal()).getName();
    }

    public List<AddressDto> getUserAddresses(){
        return userService.findBySSO(getPrincipal()).getAddresses().stream().map(AddressDto::new).collect(Collectors.toList());
    }

    public Map<Category, Integer> getCategoryMap() {
       return categoryService.getCategoryMap();
    }

    public List<ProductDto> getProducts(List<ProductAndAmount> productAndAmounts) {
        return productService.getProducts(productAndAmounts);
    }

    public String getPrincipal(){
        String ssoId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            ssoId = ((UserDetails)principal).getUsername();
        } else {
            ssoId = principal.toString();
        }
        return ssoId;
    }
}
