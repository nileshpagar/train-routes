import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by NileshPagar at gmail dot com on 5/22/17.
 */
public class TrainNetworkTest {

    @Test
    public void createEmptyKiwilandTrainNetwork(){
        TrainNetwork trainNetwork = new TrainNetwork("kiwiland", "Kiwiland Train Network");
        assertEquals("kiwiland", trainNetwork.getId());
        assertEquals("Kiwiland Train Network", trainNetwork.getName());
        assertEquals(0, trainNetwork.getCities().size());
        assertEquals(0, trainNetwork.getRoutes().size());
    }

    @Test
    public void acceptRoute(){
        TrainNetwork trainNetwork = new TrainNetwork("kiwiland", "Kiwiland Train Network");
        trainNetwork.createRoute("AB5");

        assertEquals(2, trainNetwork.getCities().size());
        City source = new City("A", "A");
        assertTrue(trainNetwork.getCities().contains(source));
        City destination = new City("B", "B");
        assertTrue(trainNetwork.getCities().contains(destination));

        assertEquals(1, trainNetwork.getRoutes().size());
        assertTrue(trainNetwork.getRoutes().contains(new Route(source, destination, 5L)));

        trainNetwork.createRoute("BC11");

        assertEquals(3, trainNetwork.getCities().size());
        source = new City("B", "B");
        assertTrue(trainNetwork.getCities().contains(source));
        destination = new City("C", "C");
        assertTrue(trainNetwork.getCities().contains(destination));

        assertEquals(2, trainNetwork.getRoutes().size());
        assertTrue(trainNetwork.getRoutes().contains(new Route(source, destination, 11L)));
    }

    @Test
    public void acceptFullNetwork(){
        TrainNetwork trainNetwork = TrainNetwork.createNetwork("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7", ",");

        assertEquals(5, trainNetwork.getCities().size());
        City A = new City("A", "A");
        assertTrue(trainNetwork.getCities().contains(A));
        City B = new City("B", "B");
        assertTrue(trainNetwork.getCities().contains(B));
        City C = new City("C", "C");
        assertTrue(trainNetwork.getCities().contains(C));
        City D = new City("D", "D");
        assertTrue(trainNetwork.getCities().contains(D));
        City E = new City("E", "E");
        assertTrue(trainNetwork.getCities().contains(E));

        assertEquals(9, trainNetwork.getRoutes().size());
        assertTrue(trainNetwork.getRoutes().contains(new Route(A, B, 5L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(B, C, 4L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(C, D, 8L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(D, C, 8L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(D, E, 6L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(A, D, 5L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(C, E, 2L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(E, B, 3L)));
        assertTrue(trainNetwork.getRoutes().contains(new Route(A, E, 7L)));
    }

}
