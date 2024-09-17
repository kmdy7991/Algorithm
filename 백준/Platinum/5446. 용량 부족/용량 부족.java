import java.io.*;
import java.util.*;
import java.util.function.Function;

class Trie {
	Trie[] words;
	boolean end;
	boolean not;

	Trie() {
		this.words = new Trie[63];
		this.end = false;
		this.not = true;
	}

	public void insert(String word) {
		Trie cur = this;

		for (int i = 0; i < word.length(); i++) {
			int idx = findIdx(word.charAt(i));

			if (cur.words[idx] == null) {
				cur.words[idx] = new Trie();
			}

			cur = cur.words[idx];
		}

		cur.end = true;
	}

	public void search(String word) {
		Trie cur = this;

		for (int i = 0; i < word.length(); i++) {
			int idx = findIdx(word.charAt(i));

			if (cur.words[idx] == null) {
				return;
			}

			cur.words[idx].not = false;
			cur = cur.words[idx];
		}
	}

	public int result() {
		Trie cur = this;
		int res = 0;

		for (int i = 0; i < 63; i++) {
			if (cur.words[i] != null) {
				if (cur.words[i].end && !cur.words[i].not) {
					res++;
				}

				if (cur.words[i].not) {
					res++;
				} else {
					res += cur.words[i].result();
				}
			}
		}
		return res;
	}

	public int findIdx(char c) {
		if (c == '.') {
			return 0;
		} else if (Character.isDigit(c)) {
			return (c - '0') + 1;
		} else if (c < 97) {
			return c - 54;
		}

		return c - 60;
	}
}

public class Main {
	static Function<String, Integer> stoi = Integer::parseInt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = stoi.apply(in.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			Trie trie = new Trie();

			int n = stoi.apply(in.readLine());
			for (int i = 0; i < n; i++) {
				trie.insert(in.readLine());
			}

			int m = stoi.apply(in.readLine());
			for (int i = 0; i < m; i++) {
				trie.search(in.readLine());
			}

			if (m == 0) {
                sb.append(1).append("\n");
                continue;
			}
            
			sb.append(trie.result()).append("\n");
		}

		System.out.println(sb);
	}
}
