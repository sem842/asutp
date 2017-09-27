package ido.tomsk.ru.asutp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Sensor s = new Sensor(1,2,3,4);
    	s.setMaxValue(100);
    	Alarm a = new Alarm();
    	System.out.println( "Hello World!" );
    	System.out.println( a );
    }
}
