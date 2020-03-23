package lines.reactive.sample.sample08.model;

public class Data {
    private String idInAtomize;
    private String idInPms;
    private String name;
    private String timezone;
    private String country;
    private String currency;
    private String user_first_name;
    private String user_last_tname;
    private String user_email;
    private String roomTypes_code;
    private String roomTypes_name;
    private String roomTypes_cnt;
    private String roomTypes_type_of_room;
    private String roomTypes_rate_code;

    public String getIdInAtomize() {
        return idInAtomize;
    }

    public void setIdInAtomize(String idInAtomize) {
        this.idInAtomize = idInAtomize;
    }

    public String getIdInPms() {
        return idInPms;
    }

    public void setIdInPms(String idInPms) {
        this.idInPms = idInPms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_tname() {
        return user_last_tname;
    }

    public void setUser_last_tname(String user_last_tname) {
        this.user_last_tname = user_last_tname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getRoomTypes_code() {
        return roomTypes_code;
    }

    public void setRoomTypes_code(String roomTypes_code) {
        this.roomTypes_code = roomTypes_code;
    }

    public String getRoomTypes_name() {
        return roomTypes_name;
    }

    public void setRoomTypes_name(String roomTypes_name) {
        this.roomTypes_name = roomTypes_name;
    }

    public String getRoomTypes_cnt() {
        return roomTypes_cnt;
    }

    public void setRoomTypes_cnt(String roomTypes_cnt) {
        this.roomTypes_cnt = roomTypes_cnt;
    }

    public String getRoomTypes_type_of_room() {
        return roomTypes_type_of_room;
    }

    public void setRoomTypes_type_of_room(String roomTypes_type_of_room) {
        this.roomTypes_type_of_room = roomTypes_type_of_room;
    }

    public String getRoomTypes_rate_code() {
        return roomTypes_rate_code;
    }

    public void setRoomTypes_rate_code(String roomTypes_rate_code) {
        this.roomTypes_rate_code = roomTypes_rate_code;
    }

    @Override
    public String toString() {

        String value = idInAtomize
                        + idInPms
                        + name
                        + timezone
                        + country
                        + currency
                        + user_first_name
                        + user_last_tname
                        + user_email
                        + roomTypes_code
                        + roomTypes_name
                        + roomTypes_cnt
                        + roomTypes_type_of_room
                        + roomTypes_rate_code;
        return value;
    }
}
