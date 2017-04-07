package tapplication.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexpench on 22.03.17.
 */
@Entity
@Table(name = Customer.CUSTOMER)
public class Customer {

    public static final String CUSTOMER = "customer";
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String BIRTH_DATE = "birth_date";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String PASSWORD = "password";
    public static final String ROLE_ID = "role_id";
    public static final String CUSTOMER1 = "customer";
    public static final String BASKET_ID = "basket_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = FIRST_NAME)
    private String name;

    @Column(name = LAST_NAME)
    private String secondName;

    @Temporal(TemporalType.DATE)
    @Column(name = BIRTH_DATE)
    private Date birthDate;

    @Column(name = EMAIL)
    private String email;

    @Column(name = PHONE_NUMBER)
    private String phoneNumber;

    @Column(name = PASSWORD)
    private String password;

    @OneToOne
    @JoinColumn(name = ROLE_ID)
    private Role role;

    @OneToMany(mappedBy = CUSTOMER1, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<BasketProduct> basketProducts;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer() {
    }

    public Customer(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }
}
