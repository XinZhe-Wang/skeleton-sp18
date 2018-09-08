import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet target){
        double dx = this.xxPos-target.xxPos;
        double dy = this.yyPos-target.yyPos;
        double r = Math.sqrt(dx*dx+dy*dy);
        return r;
    }

    public double calcForceExertedBy(Planet target){
        double Force = G * this.mass * target.mass/(this.calcDistance(target)*this.calcDistance(target));
        return Force;
    }

    public double calcForceExertedByX(Planet target){
        double F = this.calcForceExertedBy(target);
        double r = this.calcDistance(target);
        double dx = target.xxPos-this.xxPos;
        double Fx = F*dx/r;
        return Fx;
    }

    public double calcForceExertedByY(Planet target){
        double F = this.calcForceExertedBy(target);
        double r = this.calcDistance(target);
        double dy = target.yyPos-this.yyPos;
        double Fy = F*dy/r;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double Fx_net = 0;
        for (int i=0;i<allPlanets.length;i=i+1){
            if (!this.equals(allPlanets[i])){
                Fx_net = Fx_net + this.calcForceExertedByX(allPlanets[i]);
            }
        }
        return Fx_net;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double Fy_net = 0;
        for (int i=0;i<allPlanets.length;i=i+1){
            if (!this.equals(allPlanets[i])){
                Fy_net = Fy_net + this.calcForceExertedByY(allPlanets[i]);}
        }
        return Fy_net;
    }

    public void update(double dt,double fX,double fY){
        double a_x = fX/this.mass;
        double a_y = fY/this.mass;
        double vx_new = this.xxVel + a_x*dt;
        double vy_new = this.yyVel + a_y*dt;
        double px = this.xxPos + vx_new*dt;
        double py = this.yyPos + vy_new*dt;
        this.xxVel = vx_new;
        this.yyVel = vy_new;
        this.xxPos = px;
        this.yyPos = py;
    }

    public void draw(){
        //StdDraw.enableDoubleBuffering();
        StdDraw.picture(this.xxPos,this.yyPos,"images//"+this.imgFileName);
        //StdDraw.show();
        //StdDraw.pause(10);
    }

}