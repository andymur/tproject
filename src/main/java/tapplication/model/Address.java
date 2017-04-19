package tapplication.model;

import javax.persistence.*;

/**
 * Created by alexpench on 26.03.17.
 */
@Entity
public class Address {
    public static final String ID = "id";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String BUILDING = "building";
    public static final String APARTMENT = "apartment";
    public static final String ZIP_CODE = "zip_code";
    public static final String USER_ID = "user_id";
    public static final String ID1 = "id";
    public static final String USER_ENTITY = "user";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";
    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = COUNTRY)
    private String country;
    @Column(name = CITY)
    private String city;
    @Column(name = STREET)
    private String street;
    @Column(name = BUILDING)
    private String building;
    @Column(name = APARTMENT)
    private String apartment;
    @Column(name = ZIP_CODE)
    private Long zipCode;
    @Column(name = EMAIL)
    private String email;
    @Column(name = PHONE_NUMBER)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = USER_ID, referencedColumnName = ID1)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
