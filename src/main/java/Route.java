/**
 * Created by NileshPagar at gmail dot com on 5/22/17.
 */
public class Route {

    private final City source;
    private final City destination;
    private final Long distance;

    public Route(City source, City destination, Long distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public City getSource() {
        return source;
    }


    public City getDestination() {
        return destination;
    }

    public Long getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (source != null ? !source.equals(route.source) : route.source != null) return false;
        if (destination != null ? !destination.equals(route.destination) : route.destination != null) return false;
        return distance != null ? distance.equals(route.distance) : route.distance == null;
    }

    @Override
    public int hashCode() {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }
}
