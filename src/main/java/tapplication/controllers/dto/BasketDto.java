package tapplication.controllers.dto;

import java.util.List;

/**
 * Created by alexpench on 11.04.17.
 */
public class BasketDto {
//    private Long amount;
    private List<ProductAndAmount> rows;

    public BasketDto() {
    }

//    public Long getAmount() {
//        return amount;
//    }

//    public void setAmount(Long amount) {
//        this.amount = amount;
//    }

    public List<ProductAndAmount> getRows() {
        return rows;
    }

    public void setRows(List<ProductAndAmount> rows) {
        this.rows = rows;
    }
}
