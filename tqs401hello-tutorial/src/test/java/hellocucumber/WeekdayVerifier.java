/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocucumber;

/**
 *
 * @author ico
 */
public class WeekdayVerifier {
    

    public static String isItFriday(String today) {
        if (today.equals("Friday")) {
            return "TGIF";
        } else return "Nope";
    }

    
}
