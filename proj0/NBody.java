public class NBody {

    public static double readRadius(String data_path){
        In in = new In(data_path);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String planets_path){
        In in = new In(planets_path);
        int N = in.readInt();
        double R = in.readDouble();
        Planet allplanets[] = new Planet[N];
        for (int i = 0;i<allplanets.length;i=i+1){

                allplanets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(), in.readDouble(),in.readDouble(),in.readString());

        }
        return allplanets;
    }
}
