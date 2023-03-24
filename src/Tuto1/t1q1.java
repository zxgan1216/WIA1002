package Tuto1;

public class t1q1 {
    public static void main(String[] args) {
        Telephone[] tel = new Telephone[5];
        for (int i=0;i<tel.length;i++) {
            tel[i] = new Telephone("03", String.valueOf(79676300+i));
            System.out.println(tel[i].makeFullNumber());
        }
    }
}

class Telephone{
    private String areaCode;
    private String number;
    private static int numOfTelephoneObject;

    Telephone(String areaCode,String number){
        this.areaCode=areaCode;
        this.number=number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String makeFullNumber(){
        return this.areaCode+"-"+this.number;
    }
}
