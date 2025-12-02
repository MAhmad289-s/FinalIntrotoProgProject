package org.example;

public class Address {
    int streetNo;
    String street;
    String city;
    Province province;



    public enum Province{
        Ontario,Quebec, Nova ,Scotia, New_Brunswick, Manitoba, British_Columbia, Prince_Edward_Island, Saskatchewan, Alberta, Newfoundland, Labrador
    }
    public static boolean isPostalCodeValid(String postalCode){
        if (postalCode.length() !=6 || postalCode == null){
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
