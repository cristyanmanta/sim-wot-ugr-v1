/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulator.Functions;

import jdistlib.*;
/**
 *
 * @author Cristyan
 */
public class FunctionModel {
    public static int CalculateMarkov(double[][] transition,int initState){
        int N = transition.length;                        // number of states
        int state = initState;                // current state
        double r = Math.random()-0.01;
        double sum = 0.0;        
        // determine next state
        for (int j = 0; j < N; j++) {
           sum += transition[state][j];
           if (r <= sum) {
              return j;
           }
        }
        return -1;
      }
    
    public static int calcNextSubSpace(int idsSubspaces[] ){
        int newid=-1;
        double transition[][]=new double[idsSubspaces.length][idsSubspaces.length];
        for (int i=0;i<idsSubspaces.length;i++){
            for (int j=0;j<idsSubspaces.length;j++){
                transition[i][j]=1d/idsSubspaces.length;
            }
        }        
        newid = CalculateMarkov(transition, 0);
        return idsSubspaces[newid];
    }   
    
    public static int calcNextFailure(int actualState){
        int newst=-1;
        double transition[][]={{0.99,0.01},
                               {0.5,0.5}};       
        newst = CalculateMarkov(transition, actualState);        
        return newst;
    }
    
    public static int measure(int PDF, int minValue, int maxValue, double param){
        int value;
        switch (PDF){
            case 0:
                value=(int)(minValue+(maxValue-minValue)*Math.random());
                break;
            case 1:
                Exponential exp=new Exponential(1d);                
                value=(int)(minValue+(maxValue-minValue)*exp.random());
                if(value>maxValue){
                    value=maxValue;
                }
                break;
            case 2:
                value=0;
                break;
            case 3:    
                value=0;
                break;
            default:
                value=0;
                break;
        }
        return value;                
    }
    
    public static int calcNextState (int actualState){
        int newst=-1;
        final double[][] transition = { {0.0,0.05,0.05},
                                        {0.8,0.0,0.1},
                                        {0.9,0.05,0.0}};
        newst = CalculateMarkov(transition, actualState);        
        return newst;    
    }
    
    
    
    
}
