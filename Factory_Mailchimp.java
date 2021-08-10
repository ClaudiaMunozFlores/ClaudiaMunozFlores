package Practica_Exámen;

import org.testng.annotations.Factory;

public class Factory_Mailchimp {

    @Factory
    public Object [] mailchimpFactoryTest(){
        return new Object[]{
                new prueba_mailchimp(),
                new prueba_mailchimp(),
        };
    }

}
