import java.io.*;
import java.util.*;
import java.util.function.Function;

class Person implements Comparable<Person> {
	int reserve;
	int arrive;

	Person(int r, int a) {
		this.reserve = r;
		this.arrive = a;
	}

	@Override
	public String toString() {
		return "person = " + this.reserve + " " + this.arrive;
	}

	@Override
	public int compareTo(Person o) {
		if (this.arrive == o.arrive) {
			return this.reserve - o.reserve;
		}
		return this.arrive - o.arrive;
	}
}

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static Queue<Person> restaurant;
	static int[] reservation;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = stoi.apply(in.readLine());

		restaurant = new PriorityQueue<>();

		reservation = new int[(int) 3e5 + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			int reserveTime = stoi.apply(st.nextToken());
			int arriveTime = stoi.apply(st.nextToken());

			reservation[reserveTime] = arriveTime;

			restaurant.offer(new Person(reserveTime, arriveTime));
		}

		System.out.println(enter());
	}

	private static int enter() {
		int time = 1;
		int res = 0;

		back: while (!restaurant.isEmpty()) {
			int visit = reservation[time];

			if (visit == 0 || visit > time) {
				if (restaurant.peek().arrive <= time) {
					Person cur = restaurant.poll();

					while (reservation[cur.reserve] == 0) {
                        if (restaurant.isEmpty()){
                            break back;
                        }
						cur = restaurant.poll();
					}

					res = Math.max(res, time - cur.arrive);
					reservation[cur.reserve] = 0;
				}
			} else {
				res = Math.max(res, time - reservation[time]);
				reservation[time] = 0;
			}

			time++;
		}
		
		return res;
	}
}