import java.io.*;
import java.util.*;
import java.util.function.Function;

class Trie {
	boolean end;
	Trie[] child;
//	Map<Character, Trie> child;

	Trie() {
		this.end = false;
		this.child = new Trie[26];
	}

	public void insert(Trie root, String color) {
		Trie cur = root;
		
		for (char c : color.toCharArray()) {
			if(cur.child[c - 97] == null) { 
				cur.child[c - 97] = new Trie();
			}
			
			cur = cur.child[c - 97];
		}

		cur.end = true;
	}
}

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;
	static Trie trie;
	static Set<String> nickName;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int c = stoi.apply(st.nextToken());
		int n = stoi.apply(st.nextToken());

		trie = new Trie();
		int colorMax = 0;
		for (int i = 0; i < c; i++) {
			String color = in.readLine();
			trie.insert(trie, color);

			colorMax = Math.max(colorMax, color.length());
		}

		int nameMin = (int) 2e9;
		int nameMax = 0;

		nickName = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String name = in.readLine();
			nickName.add(name);
			
			nameMax = Math.max(nameMax, name.length());
			nameMin = Math.min(nameMin, name.length());
		}

		StringBuilder sb = new StringBuilder();

		int q = stoi.apply(in.readLine());
		for (int i = 0; i < q; i++) {
			String team = in.readLine();
			boolean isIn = team.length() > nameMax + colorMax ? false : findTeam(team, nameMin);
			sb.append(isIn ? "Yes" : "No").append("\n");
		}
		System.out.print(sb);
	}

	private static boolean findTeam(String name, int len) {
		Trie cur = trie;
		for (int i = 0; i < name.length(); i++) {
			cur = cur.child[name.charAt(i) - 97];

			if (name.length() - i < len) {
				break;
			}
			
			if (cur == null) {
				break;
			}

			if (cur.end) {
				if (nickName.contains(name.substring(i + 1))) {
					return true;
				}
			}
		}

		return false;
	}
}