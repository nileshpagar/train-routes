/**
 * Created by NileshPagar at gmail dot com on 5/22/17.
 */
public class SimpleRouteParser implements RouteParser {
    public Route parse(String route, TrainNetwork trainNetwork) {
        if (route.length() >=3) {
            City sourceCity = new City(String.valueOf(route.charAt(0)), String.valueOf(route.charAt(0)));
            City destinationCity = new City(String.valueOf(route.charAt(1)), String.valueOf(route.charAt(1)));
            Long distance = Long.valueOf(route.substring(2, route.length()));
            return new Route(sourceCity, destinationCity, distance);
        }
        return null;
    }
}
