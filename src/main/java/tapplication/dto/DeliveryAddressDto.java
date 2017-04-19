package tapplication.dto;

import tapplication.model.Address;

/**
 * Created by alexpench on 12.04.17.
 */
public class DeliveryAddressDto {
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String email;
    private String phoneNumber;
    private Long zipCode;

    public DeliveryAddressDto() {
    }


    public DeliveryAddressDto(Address address) {
        this.country = address.getCountry();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.building = address.getBuilding();
        this.apartment = address.getApartment();
        this.zipCode = address.getZipCode();
        this.email = address.getEmail();
        this.phoneNumber = address.getPhoneNumber();
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

    @Override
    public String toString() {
        return "DeliveryAddressDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment='" + apartment + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
