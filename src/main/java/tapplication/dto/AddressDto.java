package tapplication.dto;

import tapplication.model.Address;

/**
 * Created by alexpench on 25.04.17.
 */
public class AddressDto {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String building;
    private String appartment;
    private Long zipCode;
    private String email;
    private String phoneNumber;

    public AddressDto() {
    }

    public AddressDto(Address address) {
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.building = address.getBuilding();
        this.appartment = address.getAppartment();
        this.zipCode = address.getZipCode();
        this.email = address.getEmail();
        this.phoneNumber = address.getPhoneNumber();

    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", appartment='" + appartment + '\'' +
                ", zipCode=" + zipCode +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

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

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
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
}
