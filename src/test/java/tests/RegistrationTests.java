package tests;


import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {


    @Test
    void successfulRegistrationTest() {
        String userName = "Vlad";
        String lastName = "Aleksev";
        String email = "vlad@aleksev.com";
        String gender = "Other";
        String mobile = "1234567890";
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String subjects = "Math";
        String hobbies = "Sports";
        String picture = "1.png";
        String currentAddress = "Some address 1";
        String state = "NCR";
        String City = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDayDate(dayBirth, monthBirth, yearBirth)
                .setSubject(subjects)
                .setHobbies(hobbies)
                .uploadPicture("img/"+picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(City)
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", userName+" "+lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", mobile)
                .verifyResults("Date of Birth", dayBirth+" "+monthBirth+","+yearBirth)
                .verifyResults("Subjects", subjects)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", picture)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state+" "+City);

    }

}



