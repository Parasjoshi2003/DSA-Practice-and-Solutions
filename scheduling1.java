//import java.util.*;
//
//class Process {
//    int pid, at, bt, priority = -1, tat = -1, ct = -1, wt = -1, remainingBt;
//    boolean done = false;
//    Process(int p, int a, int b) { pid = p; at = a; bt = remainingBt = b; }
//}
//
//class GanttEntry {
//    int pid, start, end;
//    GanttEntry(int p, int s, int e) { pid = p; start = s; end = e; }
//}
//
//public class scheduling1 {
//    static ArrayList<GanttEntry> gantt = new ArrayList<>();
//
//    static void printResults(ArrayList<Process> ps) {
//        float avgWt = 0, avgTat = 0;
//        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
//        for (Process p : ps) {
//            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n",
//                    p.pid, p.at, p.bt, p.ct, p.tat, p.wt);
//            avgWt += p.wt;
//            avgTat += p.tat;
//        }
//        System.out.printf("Avg WT: %.2f\tAvg TAT: %.2f\n", avgWt/ps.size(), avgTat/ps.size());
//    }
//
//    static void printGantt() {
//        System.out.print("\nGantt Chart:\n|");
//        for (GanttEntry e : gantt)
//            System.out.printf(" %s (%d-%d) |", e.pid == -1 ? "IDLE" : "P"+e.pid, e.start, e.end);
//        System.out.println("\n");
//        gantt.clear();
//    }
//
//    static void resetProcesses(ArrayList<Process> ps) {
//        for (Process p : ps) {
//            p.done = false;
//            p.remainingBt = p.bt;
//            p.priority = -1;
//        }
//    }
//
//    static void fcfs(ArrayList<Process> ps) {
//        ps.sort(Comparator.comparingInt(p -> p.at));
//        int time = 0;
//        for (Process p : ps) {
//            if (p.at > time) {
//                gantt.add(new GanttEntry(-1, time, p.at));
//                time = p.at;
//            }
//            gantt.add(new GanttEntry(p.pid, time, time + p.bt));
//            p.ct = time + p.bt;
//            p.tat = p.ct - p.at;
//            p.wt = p.tat - p.bt;
//            time = p.ct;
//        }
//    }
//
//    static void sjf(ArrayList<Process> ps) {
//        int time = 0, completed = 0;
//        while (completed < ps.size()) {
//            Process shortest = null;
//            for (Process p : ps)
//                if (!p.done && p.at <= time && (shortest == null || p.bt < shortest.bt))
//                    shortest = p;
//
//            if (shortest != null) {
//                gantt.add(new GanttEntry(shortest.pid, time, time + shortest.bt));
//                shortest.ct = time + shortest.bt;
//                shortest.tat = shortest.ct - shortest.at;
//                shortest.wt = shortest.tat - shortest.bt;
//                shortest.done = true;
//                time = shortest.ct;
//                completed++;
//            } else time++;
//        }
//    }
//
//    static void roundRobin(ArrayList<Process> ps, int quantum) {
//        ps.sort(Comparator.comparingInt(p -> p.at));
//        Queue<Process> q = new LinkedList<>();
//        int time = 0, idx = 1;
//        q.add(ps.get(0));
//
//        while (!q.isEmpty()) {
//            Process p = q.poll();
//            int execTime = Math.min(p.remainingBt, quantum);
//            gantt.add(new GanttEntry(p.pid, time, time + execTime));
//            time += execTime;
//            p.remainingBt -= execTime;
//
//            while (idx < ps.size() && ps.get(idx).at <= time)
//                q.add(ps.get(idx++));
//
//            if (p.remainingBt > 0) q.add(p);
//            else {
//                p.ct = time;
//                p.tat = p.ct - p.at;
//                p.wt = p.tat - p.bt;
//            }
//            if (q.isEmpty() && idx < ps.size()) {
//                q.add(ps.get(idx));
//                if (time < ps.get(idx).at)
//                    gantt.add(new GanttEntry(-1, time, ps.get(idx).at));
//                time = ps.get(idx++).at;
//            }
//        }
//    }
//
//    static void priority(ArrayList<Process> ps) {
//        Scanner sc = new Scanner(System.in);
//        for (Process p : ps) {
//            System.out.print("Priority for P" + p.pid + ": ");
//            p.priority = sc.nextInt();
//        }
//        ps.sort(Comparator.comparingInt(p -> p.at));
//        int time = 0, completed = 0;
//        while (completed < ps.size()) {
//            Process highest = null;
//            for (Process p : ps)
//                if (!p.done && p.at <= time && (highest == null || p.priority < highest.priority))
//                    highest = p;
//
//            if (highest != null) {
//                gantt.add(new GanttEntry(highest.pid, time, time + highest.bt));
//                highest.ct = time + highest.bt;
//                highest.tat = highest.ct - highest.at;
//                highest.wt = highest.tat - highest.bt;
//                highest.done = true;
//                time = highest.ct;
//                completed++;
//            } else time++;
//        }
//    }
//
//    static void compareAll(ArrayList<Process> ps, int quantum) {
//        ArrayList<Process>[] copies = new ArrayList[4];
//        for (int i = 0; i < 4; i++)
//            copies[i] = new ArrayList<>();
//        for (Process p : ps)
//            copies[i].add(new Process(p.pid, p.at, p.bt));
//
//        String[] names = {"FCFS", "SJF", "Round Robin", "Priority"};
//        Runnable[] algos = {
//                () -> fcfs(copies[0]),
//                () -> sjf(copies[1]),
//                () -> roundRobin(copies[2], quantum),
//                () -> priority(copies[3])
//        };
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println("\n=== " + names[i] + " ===");
//            algos[i].run();
//            printResults(copies[i]);
//            printGantt();
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Process> ps = new ArrayList<>();
//
//        System.out.print("Number of processes: ");
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            System.out.printf("P%d (AT BT): ", i+1);
//            ps.add(new Process(i+1, sc.nextInt(), sc.nextInt()));
//        }
//
//        System.out.print("\nAlgorithm (fcfs/sjf/rr/priority/compare): ");
//        String algo = sc.next();
//
//        if (algo.equals("compare")) {
//            System.out.print("Time quantum for RR: ");
//            compareAll(ps, sc.nextInt());
//        } else {
//            switch (algo) {
//                case "fcfs": fcfs(ps); break;
//                case "sjf": sjf(ps); break;
//                case "rr":
//                    System.out.print("Time quantum: ");
//                    roundRobin(ps, sc.nextInt());
//                    break;
//                case "priority": priority(ps); break;
//            }
//            printResults(ps);
//            printGantt();
//        }
//    }
//}