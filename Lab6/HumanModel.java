package com.company;

class HumanModel implements Model {
    String guid;
    String email;
    String birthday;
    String first;
    String last;
    String gender;
    String city;
    String state;

    @Override
    public void setData(String[] fields) {
        guid = fields[0];
        email = fields[1];
        birthday = fields[2];
        first = fields[3];
        last = fields[4];
        gender = fields[5];
        city = fields[6];
        state = fields[7];
    }

    @Override
    public String toString() {
        return guid + "\t" +
                email + "\t" +
                birthday + "\t" +
                first + "\t" +
                last + "\t" +
                gender + "\t"
                + city + "\t"
                + state;
    }

}
