public class SimpleLocation{
    public double latitude;
    public double longitude;

    public SimpleLocation(){
        this.latitude = 32.9;
        this.longitude = -117.2;
    }
    
    public SimpleLocation(double lat, double lon){
        this.latitude = lat;
        this.longitude = lon;
    }

    public double distance(SimpleLocation other){
        return (getDist(this.latitude, this.longitude, other.latitude, other.longitude));
    }

    public double getDist(double lat1, double lon1, double lat2, double lon2){
        int r = 6371;
        double dLat = deg2rad(lat2 - lat1);
        double dLon = deg2rad(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d =  r * c;
        return d;
    }

    public double deg2rad(double deg){
        return deg * (Math.PI / 180);
    }
}