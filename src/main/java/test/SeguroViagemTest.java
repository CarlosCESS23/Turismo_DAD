package test;

import servidor.helper.SeguroServiceHelper;

public class SeguroViagemTest {
    public static void main(String[] args) {
        SeguroServiceHelper seguroServiceHelper = new SeguroServiceHelper();
        System.out.println(seguroServiceHelper.consultarSeguroViagem("Pará"));
    }
}
