public class Sound{
    public static void main(String args[]){
        double sound_time;
        int travel_speed;
        double foot_to_meters;

        foot_to_meters = 0.3048;
        sound_time = 7.2;
        travel_speed = 1100;
        System.out.println("The lightning was in " + (sound_time * travel_speed) + " feets or " + (sound_time * travel_speed * foot_to_meters) + " meters.");
        System.out.println("For the echo sound, distance is: " + ((sound_time / 2) * travel_speed) + "feets");
    }
}