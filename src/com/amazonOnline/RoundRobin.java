package com.amazonOnline;

public class RoundRobin {
	public float waitingTimeRoundRobin(int[] arrival, int[] run, int fixedTime,int n){
		float averageWaitTime = 0;
		int[] waitTime = new int[n];
		int[] lastFinishTime = new int[n];
		int numOfJobs = n;
		for(int i= 0;i<n;i++){
			lastFinishTime[i] = arrival[i];
		}
		int cpuTime = arrival[0]; // start with first job;
		while(numOfJobs>0){ // still jobs remaining to be processed
			for(int i=0;i<n;i++){ // schedule CPU
				if(arrival[i] <= cpuTime){
					if(run[i] > 0)
					{
						waitTime[i] += cpuTime -  lastFinishTime[i] ;
						int cpuUsed = 0;
						if(	run[i]<= fixedTime){
							cpuUsed = run[i];
							run[i] = 0;
							numOfJobs--;
						}else{
							cpuUsed = fixedTime;
							run[i] = run[i] - fixedTime;
						}
						cpuTime = cpuTime +  cpuUsed;
						lastFinishTime[i] = cpuTime;
					}
				}else{
					i = n; // when next job has not yet arrived , start again for previous jobs
				}
			}
		}
		for(int i=0;i<n;i++){
			averageWaitTime += (float)waitTime[i];
		}
		//averageWaitTime = (float) (averageWaitTime/n);
		return averageWaitTime;
	}

	public static void main(String[] args){
		RoundRobin r = new RoundRobin();
		int[] arrTime = {0,7,7};
		int[] runTime = {7,3,4};
		float average = r.waitingTimeRoundRobin(arrTime, runTime,2, 3);
		System.out.println("Hello world: Round robin scheduling "+ average);
	}
}
