/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import clock.Clock;

/**
 *
 * @author Denmar Ermitano
 */
public class Test {
    public static void main(String[] args) {
        Clock c = new Clock(14, 55, 2);
        Clock c2 = new Clock(c);
        
        for (int i = 0; i < 10000; i++) {
            c.increaseSe();
            System.out.println(c);
            
        }

        Student stu1 = new Student("Yi", 35, "male",
                new Address("123", "35", "Main street", "Montreal", "QC", "A1A 1A1"));
        System.out.println(stu1);
        
        stu1.getAddress().setAptNum("223");
        stu1.getAddress().setStreetNum("122");
        stu1.getAddress().setZipcode("b2b 2b2");
        
        stu1.getAddress().setCity("Toronto");
        stu1.getAddress().setProvince("ON");
        
        System.out.println(stu1);
        
        stu1.checkDistance();
    }
}
