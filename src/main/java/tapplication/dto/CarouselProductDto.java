package tapplication.dto;

/**
 * Created by alexpench on 13.05.17.
 */
public class CarouselProductDto {

    private String longpic;
    private String mainpic;
    private String name;
    private Long id;

    public CarouselProductDto(ProductDto product) {
        this.longpic = product.getLongpic();
        this.name = product.getName();
        this.id = product.getId();
        this.mainpic = product.getMainImage();
    }

    public CarouselProductDto() {
    }

    public String getLongpic() {
        return longpic;
    }

    public void setLongpic(String longpic) {
        this.longpic = longpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic;
    }
}
