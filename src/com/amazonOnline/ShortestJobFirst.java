package com.amazonOnline;

public class ShortestJobFirst {
	public float waitingTimeShortestJobFirst(int[] arrival, int[] run, int fixedTime,int n){
		float averageWaitTime = 0;
		int[] waitTime = new int[n];
		int[] lastFinishTime = new int[n];
		int numOfJobs = n;
		for(int i= 0;i<n;i++){
			lastFinishTime[i] = arrival[i];
		}
		int cpuTime = arrival[0]; // start with first job;
		while(numOfJobs>0){ // still jobs remaining to be processed
			int minDuration = Integer.MAX_VALUE;
			int appointedJob = 0;
			boolean cpuCanBeIdle = true;
			for(int i=0;i<n;i++){ // schedule CPU
				if(arrival[i] <= cpuTime){
					if(run[i] > 0)
					{
						if(minDuration > run[i]){
							minDuration = run[i];
							appointedJob = i;
						}
						cpuCanBeIdle = false;
					}
				}else{
					i = n; // when next job has not yet arrived , start again for previous jobs
				}
			}
			if(!cpuCanBeIdle)
			{
				waitTime[appointedJob] = cpuTime - arrival[appointedJob];
				cpuTime += minDuration;
				run[appointedJob] = 0;
				numOfJobs--;
			}else{
				for(int i=0;i<n;i++){
					if((run[i]>0) && (cpuTime <= arrival[i])){
						cpuTime = arrival[i];
						break;
					}
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
		ShortestJobFirst r = new ShortestJobFirst();
		int[] arrTime = {3,3,4,6,8};
		int[] runTime = {2,2,1,7,2};
		float average = r.waitingTimeShortestJobFirst(arrTime, runTime,2, 5);
		System.out.println("Hello world: Shortest Job First scheduling "+ average);
	}
}
