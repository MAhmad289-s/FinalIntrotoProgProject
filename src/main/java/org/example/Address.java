package org.example;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    int streetNo;
    String street;
    String city;
    Province province;
    String postalCode;
    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        }
        else {
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
    public enum Province{
        Ontario,Quebec, Nova ,Scotia, New_Brunswick, Manitoba, British_Columbia, Prince_Edward_Island, Saskatchewan, Alberta, Newfoundland, Labrador
    }
    /**
     * Checks to see if the postal code has one letter then one digit
     * @param postalCode The given postal code
     * @return true for a valid postal code and false for an invalid postal codee
     */
    public static boolean isPostalCodeValid(String postalCode){
        if (postalCode.length() != 6){
            return false;
        }
        for (int i = 0; i < 6;i++){
            char idx = postalCode.charAt(i);
            if (i % 2 == 0){
                if (Character.isDigit(idx)){
                    return false;
                }
            }
            else {
                if (Character.isLetter(idx)){
                    return false;
                }
            }
        }
        return true;
    }
}
