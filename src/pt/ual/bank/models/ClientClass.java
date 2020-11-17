package pt.ual.bank.models;

public class ClientClass implements Client {
    private String name;
    private String idNumber;
    private String idType;
    private String birthday;
    private String address;
    private String email;
    private String phoneNumber;
    private String clientId;

    public ClientClass(String clientId, String name, String idNumber, String idType, String birthday, String address, String email, String phoneNumber) {
        this.clientId = clientId;
        this.name = name;
        this.idNumber = idNumber;
        this.idType = idType;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdType() {
        return idType;
    }
}
