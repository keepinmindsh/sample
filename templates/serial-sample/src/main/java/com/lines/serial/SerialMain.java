package com.lines.serial;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

public class SerialMain {
    public static void main(String[] args) {

        try {
            Enumeration enumeration = CommPortIdentifier.getPortIdentifiers();

            System.out.println("Enumeration get()............... "+ enumeration.hasMoreElements());

            while (enumeration.hasMoreElements()) {
                CommPortIdentifier first = (CommPortIdentifier) enumeration.nextElement();
                System.out.println("COM name : " + first.getName());
            }

            Serial serial = new Serial();

            serial.connect("COM6");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
