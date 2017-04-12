package tapplication.dto;

import tapplication.model.Category;

/**
 * Created by alexpench on 10.04.17.
 */
public class CategoryDto {
    private Long categoryId;
    private String name;
    private String imageUrl;

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        this.categoryId = category.getId();
        this.name = category.getName();
        this.imageUrl = category.getImageUrl();
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
