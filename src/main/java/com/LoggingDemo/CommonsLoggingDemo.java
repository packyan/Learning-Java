package com.LoggingDemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingDemo {
    public static void main(String[] args) {
     StringSonSon stringSonSon = new StringSonSon("1234");
    StringSonSon stringSonSon2 = new StringSonSon("123456");
        System.out.println(stringSonSon.getson());
        System.out.println(stringSonSon2.getson());
    }
}
class StringSon{
    String son;
    protected final Log log = LogFactory.getLog(getClass());
    public StringSon(String son) {
        this.son = son;
    }

    public StringSon() {
    }

}

class StringSonSon extends StringSon{
    public StringSonSon(String son) {
        super(son);
    }

    public String getson(){
        if(super.son.length() > 5){
            return super.son;
        }
        else{
            log.error("string son legnth < 5");
            return super.son+" less < 5";
        }
    }

    public StringSonSon() {
    }
}
