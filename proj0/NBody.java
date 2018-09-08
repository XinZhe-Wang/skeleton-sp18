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

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet allplanets[] = readPlanets(filename);
        double R = readRadius(filename);


        StdDraw.setScale(-R,R);

        //StdDraw.enableDoubleBuffering();

        //StdDraw.clear();

        //StdDraw.picture(0,0, "images//starfield.jpg");

        //StdDraw.pause(2000);

        double[] xForces = new double[allplanets.length];
        double[] yforces = new double[allplanets.length];

        StdDraw.enableDoubleBuffering();

        /*double time;
        int numPlanets = allplanets.length;
        for (time = 0; time < T; time += dT) {
            double[] xForces = new double[numPlanets];
            double[] yForces = new double[numPlanets];
            int index = 0;
            for (Planet p : allplanets) {
                xForces[index] = p.calcNetForceExertedByX(allplanets);
                yForces[index] = p.calcNetForceExertedByY(allplanets);
                index++;
            }
            index = 0;
            for (Planet p : allplanets) {
                p.update(dT, xForces[index], yForces[index]);
                index++;
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : allplanets)
                p.draw();
            StdDraw.show();
            StdDraw.pause(10);
        }*/

        for (double time = 0;time<T;time=time+dT){

            StdDraw.picture(0,0, "images//starfield.jpg");

            for (int i = 0;i<allplanets.length;i=i+1){
                xForces[i] = allplanets[i].calcNetForceExertedByX(allplanets);
                yforces[i] = allplanets[i].calcNetForceExertedByY(allplanets);
            }

            for (int i = 0;i<allplanets.length;i=i+1){
                allplanets[i].update(dT,xForces[i],yforces[i]);
            }

            StdDraw.picture(0,0, "images//starfield.jpg");

            for (int i = 0;i<allplanets.length;i=i+1){
                allplanets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(5);
            }
        }
    }
