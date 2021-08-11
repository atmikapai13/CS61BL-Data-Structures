import java.util.*;

public class Graph implements Iterable<Integer> {

    private LinkedList<Edge>[] adjLists;
    private int vertexCount;

    /* Initializes a graph with NUMVERTICES vertices and no Edges. */
    public Graph(int numVertices) {
        adjLists = (LinkedList<Edge>[]) new LinkedList[numVertices];
        for (int k = 0; k < numVertices; k++) {
            adjLists[k] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    /* Adds a directed Edge (V1, V2) to the graph. That is, adds an edge
       in ONE directions, from v1 to v2. */
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 0);
    }

    /* Adds an undirected Edge (V1, V2) to the graph. That is, adds an edge
       in BOTH directions, from v1 to v2 and from v2 to v1. */
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, 0);
    }

    /* Adds a directed Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addEdge(int v1, int v2, int weight) {
        Edge added_edge = new Edge(v1, v2, weight);
        if (adjLists[v1].contains(added_edge)) {
            adjLists[v1].remove(retrieve(adjLists[v1], added_edge));
        }
        adjLists[v1].add(added_edge);
    }

    /* Retreives the index of and Edge in the linked list, assuming it exists. */
    private int retrieve(LinkedList<Edge> LinkedList, Edge edge) {
        for (int i = 0; i < LinkedList.size(); i++) {
            if (edge.equals(LinkedList.get(i))) return i;
        }
        throw new IllegalArgumentException();
    }

    /* Adds an undirected Edge (V1, V2) to the graph with weight WEIGHT. If the
       Edge already exists, replaces the current Edge with a new Edge with
       weight WEIGHT. */
    public void addUndirectedEdge(int v1, int v2, int weight) {
        Edge v1_v2 = new Edge(v1, v2, weight);
        Edge v2_v1 = new Edge(v2, v1, weight);

        if (adjLists[v1].contains(v1_v2)) {
            adjLists[v1].remove(retrieve(adjLists[v1], v1_v2));
        }

        if (adjLists[v2].contains(v2_v1)) {
            adjLists[v2].remove(retrieve(adjLists[v2], v2_v1));
        }

        adjLists[v1].add(v1_v2);
        adjLists[v2].add(v2_v1);
    }

    /* Returns true if there exists an Edge from vertex FROM to vertex TO.
       Returns false otherwise. */
    public boolean isAdjacent(int from, int to) {
        Iterator<Edge> edgeIterator = adjLists[from].iterator();
        Edge desire_edge = new Edge(from, to, 0);
        while (edgeIterator.hasNext()) {
            if (edgeIterator.next().equals(desire_edge)) {
                return true;
            }
        }
        return false;
    }

    /* Returns a list of all the vertices u such that the Edge (V, u)
       exists in the graph. */
    public List<Integer> neighbors(int v) {
        List<Integer> list_of_neighbors = new ArrayList<>();
        Iterator<Edge> edgeIterator = adjLists[v].iterator();
        while (edgeIterator.hasNext()) {
            list_of_neighbors.add(edgeIterator.next().to);
        }
        return list_of_neighbors;
    }
    /* Returns the number of incoming Edges for vertex V. */
    public int inDegree(int v) {
        int incoming = 0;
        for (int index = 0; index < vertexCount; index++) {
            Iterator<Edge> edgeIterator = adjLists[index].iterator();
            while (edgeIterator.hasNext()) {
                if (edgeIterator.next().to == v) {
                    incoming++;
                }
            }
        }
        return incoming;
    }

    /* Returns an Iterator that outputs the vertices of the graph in topological
       sorted order. */
    public Iterator<Integer> iterator() {
        return new TopologicalIterator(this);
    }

    /**
     *  A class that iterates through the vertices of this graph,
     *  starting with a given vertex. Does not necessarily iterate
     *  through all vertices in the graph: if the iteration starts
     *  at a vertex v, and there is no path from v to a vertex w,
     *  then the iteration will not include w.
     */
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            fringe = new Stack<>();
            visited = new HashSet<>();
            fringe.push(start);
        }

        public boolean hasNext() {
            if (!fringe.isEmpty()) {
                int i = fringe.pop();
                while (visited.contains(i)) {
                    if (fringe.isEmpty()) {
                        return false;
                    }
                    i = fringe.pop();
                }
                fringe.push(i);
                return true;
            }
            return false;
        }

        public Integer next() {
            int curr = fringe.pop();
            ArrayList<Integer> lst = new ArrayList<>();
            for (int i : neighbors(curr)) {
                lst.add(i);
            }
            lst.sort((Integer i1, Integer i2) -> -(i1 - i2));
            for (Integer e : lst) {
                fringe.push(e);
            }
            visited.add(curr);
            return curr;
        }

        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    /* Returns the collected result of performing a depth-first search on this
       graph's vertices starting from V. */
    public List<Integer> dfs(int v) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(v);

        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    /* Returns true iff there exists a path from START to STOP. Assumes both
       START and STOP are in this graph. If START == STOP, returns true. */
    public boolean pathExists(int start, int stop) {
        if (start == stop) {
            return true;
        }
        List<Integer> visited =  new ArrayList<>();
        return pathExistsHelper(start, stop, visited);
    }

    public boolean pathExistsHelper(int start, int stop, List<Integer> visited) {
        if (visited.contains(start)) {
            return false;
        }
        else if (start == stop) {
            return true;
        }
        else {
            visited.add(start);
        }

        boolean found = false;
        List<Integer> neighbors = neighbors(start);
        for (int neighbor : neighbors) {
            found = pathExistsHelper(neighbor, stop, visited);
            if (found) {
                break;
            }
        }
        return found;
    }


    /* Returns the path from START to STOP. If no path exists, returns an empty
       List. If START == STOP, returns a List with START. */
    public List<Integer> path(int start, int stop) {
        String path_string = pathHelper(start, stop, "");
        List<Integer> found_path = new ArrayList<>();
        if (path_string != "" && pathExists(start, stop)) {
            for (int index = 0; index < path_string.length(); index++) {
                Character current_digit = path_string.charAt(index);
                found_path.add(Character.getNumericValue(current_digit));
            }
        }
        return found_path;
    }

    public String pathHelper(int start, int stop, String path) {
        String current_vertex = Integer.toString(start);
        if (path.contains(current_vertex)) {
            return "";
        }
        else if (start == stop) {
            return path + current_vertex;
        }
        else {
            path += current_vertex;
        }

        List<Integer> neighbors = neighbors(start);
        for (int neighbor : neighbors) {
            String other = "";
            if (!path.contains(Integer.toString(neighbor))) {
                other = pathHelper(neighbor, stop, path);
            }

            if (other.contains(Integer.toString(stop))) {
                path = other;
                break;
            }
        }

        return path;
    }

    public List<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new TopologicalIterator(this);
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    private class TopologicalIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        boolean[] visited;
        private int size;
        private int counter = 0;


        TopologicalIterator(Graph reference) {
            fringe = new Stack<Integer>();
            size = reference.vertexCount;
            visited = new boolean[size];
            Arrays.fill(visited, false);
            for (int i = 0; i < size; i++) {
                if (!visited[i]) {
                    List<Integer> visitedNodes = new_dfs(i, visited, reference);
                    for (Integer j : visitedNodes) {
                        fringe.push(j);
                    }
                }
            }
        }

        public List<Integer> new_dfs(int index, boolean[] visited, Graph graph) {
            List<Integer> nodes = new ArrayList<>();
            visited[index] = true;
            List<Integer> neighbors = graph.neighbors(index);
            for (int new_index : neighbors) {
                if (!visited[new_index]) {
                    List<Integer> new_nodes = new_dfs(new_index, visited, graph);
                    for (int sub_index : new_nodes) {
                        nodes.add(sub_index);
                    }
                }
            }
            nodes.add(index);
            return nodes;
        }

        public boolean hasNext() {
            return counter < size;
        }

        public Integer next() {
            if (hasNext()) {
                counter++;
                return fringe.pop();
            }
            else {
                return null;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class Edge {

        private int from;
        private int to;
        private int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return "(" + from + ", " + to + ", weight = " + weight + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return from == edge.from && to == edge.to;
        }
    }

    private void generateG1() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG2() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(4, 3);
    }

    private void generateG3() {
        addUndirectedEdge(0, 2);
        addUndirectedEdge(0, 3);
        addUndirectedEdge(1, 4);
        addUndirectedEdge(1, 5);
        addUndirectedEdge(2, 3);
        addUndirectedEdge(2, 6);
        addUndirectedEdge(4, 5);
    }

    private void generateG4() {
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(4, 2);
    }

    private void printDFS(int start) {
        System.out.println("DFS traversal starting at " + start);
        List<Integer> result = dfs(start);
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printPath(int start, int end) {
        System.out.println("Path from " + start + " to " + end);
        List<Integer> result = path(start, end);
        if (result.size() == 0) {
            System.out.println("No path from " + start + " to " + end);
            return;
        }
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
    }

    private void printTopologicalSort() {
        System.out.println("Topological sort");
        List<Integer> result = topologicalSort();
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

    public ArrayList<Integer> shortestPath(int start, int stop) {
        class PathsObject{
            double distance;
            int from;
            boolean best_path;
            public PathsObject() {
                this.distance = Double.POSITIVE_INFINITY;
                best_path = false;
            }
        }
        PathsObject[] paths = new PathsObject[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            paths[i] = new PathsObject();
        }
        paths[start].distance = 0;
        paths[start].from = start;
        int reference = start;
        while (!paths[reference].best_path) {
            paths[reference].best_path = true;
            Iterator<Integer> reference_neighbors = neighbors(reference).iterator();
            while(reference_neighbors.hasNext()) {
                int current_check = reference_neighbors.next();
                Edge current_edge = getEdge(reference, current_check);
                if (paths[reference].distance + current_edge.weight < paths[current_check].distance) {
                    paths[current_check].distance = paths[reference].distance + current_edge.weight;
                    paths[current_check].from = reference;
                }
            }
            for (int i = 0; i < vertexCount; i++) {
                if (!paths[i].best_path) {
                    if (!paths[reference].best_path) {
                        if (paths[i].distance < paths[reference].distance) {
                            reference = i;
                        }
                    }
                    else {
                        reference = i;
                    }
                }
            }
            if (paths[reference].distance == Double.POSITIVE_INFINITY) {
                paths[reference].best_path = true;
            }
        }
        List<Integer> final_path_rev = new ArrayList<>();
        int curr = stop;
        boolean found_path = false;
        if (curr == start) {
            final_path_rev.add(curr);
            found_path = true;
        }
        while (!found_path) {
            if (paths[curr].distance == Double.POSITIVE_INFINITY) {
                break;
            }
            final_path_rev.add(curr);
            curr = paths[curr].from;
            if (curr == start) {
                final_path_rev.add(curr);
                found_path = true;
            }
        }
        ArrayList<Integer> final_path = new ArrayList<>();
        for (int i = final_path_rev.size() - 1; i >= 0; i--) {
            final_path.add(final_path_rev.get(i));
        }
        return final_path;
    }

    public Edge getEdge(int u, int v) {
        List<Integer> list_of_neighbors = new ArrayList<>();
        Edge desired_edge = null;
        Iterator<Edge> edgeIterator = adjLists[u].iterator();
        while (edgeIterator.hasNext()) {
            Edge new_edge = edgeIterator.next();
            if (new_edge.to == v) {
                desired_edge = new_edge;
            }
        }
        return desired_edge;
    }

    public void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.generateG1();
        g1.printDFS(0);
        g1.printDFS(2);
        g1.printDFS(3);
        g1.printDFS(4);

        g1.printPath(0, 3);
        g1.printPath(0, 4);
        g1.printPath(1, 3);
        g1.printPath(1, 4);
        g1.printPath(4, 0);

        Graph g2 = new Graph(5);
        g2.generateG2();
        g2.printTopologicalSort();
    }
}