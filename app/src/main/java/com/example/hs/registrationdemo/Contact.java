package com.example.hs.registrationdemo;

/**
 * Created by HS on 27-11-2015.
 */
public class Contact {
        //private variables
        int _id;
        String _first_name;
        String _last_name;
        String _date_birth;
        String _gender;
        String _email;
        String _phone_number;

        // Empty constructor
        public Contact(){

        }
        // constructor
        public Contact(int id, String firstName,String lastName,String dateOfBirth,String gender,String email, String _phone_number){
            this._id = id;
            this._first_name = firstName;
            this._last_name = lastName;
            this._date_birth = dateOfBirth;
            this._gender = gender;
            this._email = email;
            this._phone_number = _phone_number;
        }

        // constructor
        public Contact(String firstName,String lastName,String dateOfBirth,String gender,String email, String _phone_number){
            this._first_name = firstName;
            this._last_name = lastName;
            this._date_birth = dateOfBirth;
            this._gender = gender;
            this._email = email;
            this._phone_number = _phone_number;
        }
        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting name
        public String getFirstName(){
            return this._first_name;
        }

        // setting name
        public void setFirstName(String firstName){
            this._first_name = firstName;
        }

        // getting name
        public String getLastName(){
            return this._last_name;
        }

        // setting name
        public void setLastName(String lastName){
            this._last_name = lastName;
        }

        // getting name
        public String getDateOfBirth(){
            return this._date_birth;
        }

        // setting name
        public void setDateOfBirth(String dateOfBirth){
            this._date_birth = dateOfBirth;
        }

        // getting name
        public String getGender(){
            return this._gender;
        }

        // setting name
        public void setGender(String gender){
            this._gender = gender;
        }

        // getting name
        public String getEmail(){
            return this._email;
        }

        // setting name
        public void setEmail(String email){
            this._email = email;
        }
            // getting phone number
            public String getPhoneNumber(){
                return this._phone_number;
            }

        // setting phone number
        public void setPhoneNumber(String phone_number){
            this._phone_number = phone_number;
        }
    }

