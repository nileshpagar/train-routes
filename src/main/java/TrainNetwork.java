import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by NileshPagar at gmail dot com on 5/22/17.
 */
public class TrainNetwork {
    private final String id;
    private final String name;
    private List<City> cities;
    private List<Route> routes;

    public TrainNetwork(String id, String name) {
        this.id = id;
        this.name = name;
        this.cities = new ArrayList<City>();
        this.routes = new ArrayList<Route>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void createRoute(String route) {
        RouteParser routeParser = new SimpleRouteParser();
        Route _route = routeParser.parse(route, this);
        this.addRoute(_route);
        this.addCity(_route.getSource());
        this.addCity(_route.getDestination());
    }

    private void addCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    private void addRoute(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);
        }
    }

    public static TrainNetwork createNetwork(String fullNetwork, String delimiter){
        if (fullNetwork != null && !"".equals(fullNetwork)) {
            TrainNetwork trainNetwork = new TrainNetwork("", "");
            StringTokenizer stringTokenizer = new StringTokenizer(fullNetwork, delimiter);
            while (stringTokenizer.hasMoreElements()) {
                trainNetwork.createRoute(stringTokenizer.nextToken().trim());
            }
            return trainNetwork;
        }
        return null;
    }

}
