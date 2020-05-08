package tms.route;

import org.junit.Test;
import tms.intersection.Intersection;
import tms.intersection.IntersectionTest;
import tms.sensors.DemoPressurePad;
import tms.sensors.Sensor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestRoute {
    @Test
    public void testCompareSensors(){
        Sensor s1 = new DemoPressurePad(new int[] {1,2,3}, 40);
        Sensor s2 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s3 = new DemoPressurePad(new int[] {1,2,3,5}, 40);
        Sensor s4 = new DemoPressurePad(new int[] {1,2,3,9}, 40);
        Sensor s5 = new DemoPressurePad(new int[] {1,2,3,10}, 40);
        Sensor s6 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s7 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s8 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s9 = new DemoPressurePad(new int[] {1,2,3,4}, 40);

        List<Sensor> list1 = new ArrayList<>();
        List<Sensor> list2 = new ArrayList<>();

        Intersection A = new Intersection("A");
        Route r = new Route("ID", A, 40);

        list1.add(s1);

        assertFalse(r.compare(list1, list2));

        list2.add(s1);

        assertTrue(r.compare(list1,list2));

        list1.add(s2); list1.add(s3); list1.add(s4); list1.add(s5);
        list2.add(s2); list2.add(s3); list2.add(s4);
        boolean result = r.compare(list1, list2);
        System.out.print(result);
        assertFalse(result);
        list2.add(s5);

        assertTrue(r.compare(list1, list2));
    }

    @Test
    public void compareSensors2(){
        Sensor s1 = new DemoPressurePad(new int[] {1,2,3}, 40);
        Sensor s2 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s3 = new DemoPressurePad(new int[] {1,2,3,5}, 40);
        Sensor s4 = new DemoPressurePad(new int[] {1,2,3,9}, 40);
        Sensor s5 = new DemoPressurePad(new int[] {1,2,3,10}, 40);
        Sensor s6 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s7 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s8 = new DemoPressurePad(new int[] {1,2,3,4}, 40);
        Sensor s9 = new DemoPressurePad(new int[] {1,2,3,4}, 40);

        List<Sensor> list1 = new ArrayList<>();
        List<Sensor> list2 = new ArrayList<>();

        Intersection A = new Intersection("A");
        Route r = new Route("ID", A, 40);

        list1.add(s1);
        list2.add(s1); list2.add(s2);

        assertFalse(r.compare(list1, list2));
    }

}
