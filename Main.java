public class CC {
    private boolean[] marked;   // Köşeyi gezdik mi?
    private int[] id;           // Hangi vertex hangi adada (component)
    private int count;          // Toplam kaç ada (component) bulduk

    // Constructor: Algoritma burada başlar
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0; // Java bunu otomatik 0 yapar ama netlik için yazdık

        // 1. ADIM: Tüm vertex'leri tek tek tara (Helikopter Taraması)
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {    // Eğer bu vertex daha önce boyanmadıysa
                dfs(G, v);       // 2. ADIM: Bu adanın her yerini gez ve boya
                count++;         // 3. ADIM: Bu ada bitti, bir sonraki ada numarasına geç
            }
        }
    }

    // Recursive DFS: Aynı adadaki herkesi aynı ID ile damgalar
    private void dfs(Graph G, int v) {
        marked[v] = true;        // Burayı ziyaret ettik
        id[v] = count;           // Bu vertex'e o anki grup numarasını ver

        for (int w : G.adj(v)) { // v'nin tüm komşularına (adjacent) bak
            if (!marked[w]) {    // Eğer komşu daha önce boyanmadıysa
                dfs(G, w);       // Derine git ve onu da aynı gruba dahil et
            }
        }
    }

    // QUERY: v ve w aynı adada mı?
    public boolean connected(int v, int w) {
        return id[v] == id[w];   // ID'leri aynıysa aynı gruptalar
    }

    // QUERY: v hangi adada?
    public int id(int v) {
        return id[v];
    }

    // QUERY: Toplam kaç ada var?
    public int count() {
        return count;
    }
}