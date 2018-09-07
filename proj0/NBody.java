public class NBody {

    public static double readRadius(String data_path){
        In in = new In(data_path);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }
}
