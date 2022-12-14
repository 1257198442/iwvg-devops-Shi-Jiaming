package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private  Fraction fraction;

    @BeforeEach
    void testData(){
        this.fraction=new Fraction(1,100);
    }

    @Test
    void testGet(){
        assertEquals(1,this.fraction.getNumerator());
        assertEquals(100,this.fraction.getDenominator());
    }

    @Test
    void testSet(){
        this.fraction.setNumerator(2);
        assertEquals(2,this.fraction.getNumerator());
        this.fraction.setDenominator(200);
        assertEquals(200,this.fraction.getDenominator());
    }

    @Test
    void testDecimal(){
        fraction=new Fraction(1,2);
        assertEquals(0.5,this.fraction.decimal());
    }
    @Test
    void  testIsproper(){
        assertEquals(true,this.fraction.isProper());
        this.fraction.setNumerator(200);
        assertEquals(false,this.fraction.isProper());
    }

    @Test
    void testisImproper(){
        assertEquals(false,this.fraction.isImproper());
        this.fraction.setNumerator(100);
        this.fraction.setDenominator(1);
        assertEquals(true,this.fraction.isImproper());
    }

    @Test
    void  testisEquivalent(){
        Fraction new_fraction1=new Fraction(10,1000);
        Fraction new_fraction2=new Fraction(10000,10);
        assertEquals(true,this.fraction.isEquivalent(new_fraction1));
        assertEquals(false,this.fraction.isEquivalent(new_fraction2));
    }


    @Test
    void  testAdd(){
        Fraction new_fraction1=new Fraction(99,100);
        Fraction new_fraction2=new Fraction(100,100);
        assertEquals(true,this.fraction.add(new_fraction1).isEquivalent(new_fraction2));
    }

    @Test
    void  testMultiply(){
        Fraction new_fraction1=new Fraction(2,3);
        Fraction new_fraction2=new Fraction(2,300);
        Fraction new_fraction3=new Fraction(5,4);
        assertEquals(true,this.fraction.multiply(new_fraction1).isEquivalent(new_fraction2));
        assertEquals(false,this.fraction.multiply(new_fraction3).isEquivalent(new_fraction2));
    }

    @Test
    void testDicide(){
        Fraction new_fraction1=new Fraction(1,100);
        Fraction new_fraction2=new Fraction(100,100);
        assertEquals(true,this.fraction.divide(new_fraction1).isEquivalent(new_fraction2));
    }

    @Test
    void testSimple(){
        Fraction test = this.fraction.Simple(new Fraction(50,100));
        assertEquals(true,test.getNumerator()==1&&test.getDenominator()==2);
        Fraction test1 = this.fraction.Simple(new Fraction(200,100));
        assertEquals(false,test.getNumerator()==2&&test.getDenominator()==1);
        Fraction test2 = this.fraction.Simple(new Fraction(4,6));
        assertEquals(false,test.getNumerator()==2&&test.getDenominator()==3);
    }
    @Test
    void testToString(){
        assertEquals("Fraction{numerator=1, denominator=100}",this.fraction.toString());
    }
}