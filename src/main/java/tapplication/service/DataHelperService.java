package tapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tapplication.dto.AddressDto;
import tapplication.dto.CarouselProductDto;
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

    @Autowired
    private AddressService addressService;

    @Autowired
    private StatisticService statisticService;


    public AddressDto getShopAddress(){
        return new AddressDto(addressService.findOne(1L));
    }

    public String getUserName(){
        String ssoId = "";
        if(getPrincipal().equals("anonymousUser")) {
            return ssoId;
        }

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

    public List<CarouselProductDto> getCarouselProductDtoList(){
        return productService.getAllProductsDtoList().stream().map(CarouselProductDto::new).collect(Collectors.toList());
    }

    public List<CarouselProductDto> getBestSellers(){
        return statisticService.getTopOrderedProducts().stream().map(CarouselProductDto::new).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProducts() {
        return productService.getAllProductsDtoList();
    }
}
