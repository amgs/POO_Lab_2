package pt.ual.bank.models;

public interface Client {
    String getIdType();

    String getIdNumber();

    String getClientId();

    void setName(String name);

    void setBirthday(String birthday);

    void setAddress(String address);

    void setEmail(String email);

    void setPhoneNumber(String phoneNumber);
}
