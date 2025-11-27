package practice.CPUscheduling;

import java.util.*;

class Process {
    int Pid;
    int At;
    int Bt;
    int priority = -1;
    int tat = -1;
    int ct = -1;
    int wt = -1;
    int remainingBt;
    Boolean done = false;

    public Process(int Pid, int At, int Bt) {
        this.Pid = Pid;
        this.At = At;
        this.Bt = Bt;
        this.priority = -1;
        this.tat = -1;
        this.ct = -1;
        this.wt = -1;
        this.done = done;
        this.remainingBt = Bt;
    }
}

public class scheduling {
    public static void print(ArrayList<Process> Processes, int count) {
        float total_wt = 0, total_tat = -0;

        for (int i = 0; i < count; i++) {
            System.out.println("Process " + i + " Pid=" + Processes.get(i).Pid + " At=" + Processes.get(i).At + " Bt=" + Processes.get(i).Bt + " ct=" + Processes.get(i).ct + " tat=" + Processes.get(i).tat + " wt=" + Processes.get(i).wt);
            total_wt += Processes.get(i).wt;
            total_tat += Processes.get(i).tat;
        }
        System.out.println("Average waiting time= " + total_wt / count + " Average turn around time= " + total_tat / count);
    }

    public static void runFCFS(ArrayList<Process> Processes, int count) {
        int currentTime = 0;
        Collections.sort(Processes, Comparator.comparingInt(p -> p.At));
        for (int i = 0; i < count; i++) {
            Process p = Processes.get(i);
            if (p.At > currentTime) currentTime = p.At;
            currentTime += p.Bt;
            p.ct = currentTime;
            p.tat = p.ct - p.At;
            p.wt = p.tat - p.Bt;
        }
        for (Process p : Processes) {
            p.done = false;
            p.remainingBt = p.Bt;
        }
    }


    public static void sjf(ArrayList<Process> Processes, int count) {
        int currentTime = 0;
        int completed = 0;

        while (completed < count) {
            Process shortestJob = null;
            int minBt = Integer.MAX_VALUE;

            // Step 1: Find process with smallest BT that has arrived
            for (Process p : Processes) {
                if (!p.done && p.At <= currentTime && p.Bt < minBt) {
                    minBt = p.Bt;
                    shortestJob = p;
                }
            }

            // Step 2: If no process has arrived yet, increment currentTime
            if (shortestJob == null) {
                currentTime++;
            } else {
                // Step 3: Process selected job
                shortestJob.ct = currentTime + shortestJob.Bt;
                shortestJob.tat = shortestJob.ct - shortestJob.At;
                shortestJob.wt = shortestJob.tat - shortestJob.Bt;
                shortestJob.done = true;
                currentTime = shortestJob.ct;
                completed++;
            }
        }
        for (Process p : Processes) {
            p.done = false;
            p.remainingBt = p.Bt;
        }
    }

    public static void roundRobin(ArrayList<Process> Processes, int count, int timeQuantum) {
        Queue<Process> readyQueue = new LinkedList<>();
        int currentTime = 0;
        int completed = 0;
        Collections.sort(Processes, Comparator.comparingInt(p -> p.At));
        for (Process p : Processes) {
            p.remainingBt = p.Bt;
        }

        readyQueue.add(Processes.get(0));
        int index = 1;

        while (!readyQueue.isEmpty()) {
            Process curr = readyQueue.poll();

            if (curr.remainingBt > timeQuantum) {
                currentTime += timeQuantum;
                curr.remainingBt -= timeQuantum;
            } else {
                currentTime += curr.remainingBt;
                curr.remainingBt = 0;
                curr.ct = currentTime;
                curr.tat = curr.ct - curr.At;
                curr.wt = curr.tat - curr.Bt;
                curr.done = true;
                completed++;
            }
            while (index < count && Processes.get(index).At <= currentTime) {
                readyQueue.add(Processes.get(index));
                index++;
            }
            if (!curr.done) {
                readyQueue.add(curr);
            }
            if (readyQueue.isEmpty() && index < count) {
                readyQueue.add(Processes.get(index));
                currentTime = Processes.get(index).At;
                index++;
            }
        }
        for (Process p : Processes) {
            p.done = false;
            p.remainingBt = p.Bt;
        }
    }

    public static void priorityScheduling(ArrayList<Process> Processes, int count) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            System.out.print("Enter priority for Process " + Processes.get(i).Pid + ": ");
            Processes.get(i).priority = sc.nextInt();
        }
        Collections.sort(Processes, Comparator.comparingInt(p -> p.At));
        int currentTime = 0;
        int completed = 0;
        while (completed < count) {
            int idx = -1;
            int highestPriority = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                Process p = Processes.get(i);
                if (p.At <= currentTime && !p.done && p.priority < highestPriority) {
                    highestPriority = p.priority;
                    idx = i;
                }
            }
            if (idx != -1) {
                Process p = Processes.get(idx);
                currentTime += p.Bt;
                p.ct = currentTime;
                p.tat = p.ct - p.At;
                p.wt = p.tat - p.Bt;
                p.done = true;
                completed++;
            } else {
                currentTime++;
            }
        }
        for (Process p : Processes) {
            p.done = false;
            p.remainingBt = p.Bt;
        }
    }

    public static void callAlgo(ArrayList<Process> Processes , int count,String algo){
        Scanner sc = new Scanner(System.in);
        if (algo.equals("fcfs")) {
            runFCFS(Processes, count);
            print(Processes, count);
        } else if (algo.equals("sjf")) {
            sjf(Processes, count);
            print(Processes, count);
        } else if (algo.equals("roundrobin")) {
            System.out.println("enter time quantum");
            int quantum = sc.nextInt();
            roundRobin(Processes, count, quantum);
            print(Processes, count);
        } else if (algo.equals("priority")) {
            priorityScheduling(Processes, count);
            print(Processes, count);
        }
        System.out.println("Do you want for other algos too: Write the algos name or write exit");
        String cont= sc.next();
        if (cont.equals("fcfs")|| cont.equals("sjf")|| cont.equals("roundrobin")|| cont.equals("priority")){
            callAlgo(Processes,count,cont);
        }else {
            return;
        }
    }

    public static void main(String[] args) {
        ArrayList<Process> Processes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("enter pid of Process " + (i) + "= ");
            int pid = sc.nextInt();
            System.out.print("enter at of Process " + (i) + "= ");
            int at = sc.nextInt();
            System.out.print("enter bt of Process " + (i) + "= ");
            int bt = sc.nextInt();
            Process p = new Process(pid, at, bt);
            Processes.add(p);
        }
//        print(Processes,count);
        System.out.println("Enter what scheduling Algo you want to do: fcfs, sjf, roundrobin, priority");
        String algo = sc.next();
        callAlgo(Processes,count,algo);


    }
}
