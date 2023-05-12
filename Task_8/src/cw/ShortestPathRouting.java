package cw;

import java.util.*;

public class ShortestPathRouting {
	
							//Task8//
	
    // Define a constant for infinity, to represent unreachable nodes
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Define the connectivity information for the network as a map of node addresses to sets of neighbor addresses
        Map<String, Set<String>> connectivityInfo = new HashMap<>();
        connectivityInfo.put("A", new HashSet<>(Arrays.asList("B", "C", "D")));
        connectivityInfo.put("B", new HashSet<>(Arrays.asList("A", "E")));
        connectivityInfo.put("C", new HashSet<>(Arrays.asList("A", "E", "F")));
        connectivityInfo.put("D", new HashSet<>(Arrays.asList("A", "F")));
        connectivityInfo.put("E", new HashSet<>(Arrays.asList("B", "C", "G")));
        connectivityInfo.put("F", new HashSet<>(Arrays.asList("C", "D", "G")));
        connectivityInfo.put("G", new HashSet<>(Arrays.asList("E", "F")));

        // Call the buildRoutingTables method to build the routing tables for the network and store them in a map
        Map<String, Map<String, String>> routingTables = buildRoutingTables(connectivityInfo);

        // Print out the routing tables for each node in the network
        for (String node : routingTables.keySet()) {
            System.out.println("Routing table for node " + node + ":");
            Map<String, String> routingTable = routingTables.get(node);
            for (String destination : routingTable.keySet()) {
                String nextHop = routingTable.get(destination);
                System.out.println(destination + ": " + nextHop);
            }
            System.out.println();
        }
    }

    public static Map<String, Map<String, String>> buildRoutingTables(Map<String, Set<String>> connectivityInfo) {
        // Create a map to store the routing tables for each node in the network
        Map<String, Map<String, String>> routingTables = new HashMap<>();
        // For each node in the network, initialize the distances and next-hop nodes to its neighbors
        for (String node : connectivityInfo.keySet()) {
            Map<String, Integer> distances = new HashMap<>();
            Map<String, String> nextHops = new HashMap<>();
            for (String neighbor : connectivityInfo.get(node)) {
                distances.put(neighbor, 1);
                nextHops.put(neighbor, neighbor);
            }
            // Set the distances and next-hop nodes to infinity and null for all other nodes in the network
            for (String n : connectivityInfo.keySet()) {
                if (!distances.containsKey(n)) {
                    distances.put(n, INF);
                    nextHops.put(n, null);
                }
            }
            // Use Dijkstra's algorithm to calculate the shortest paths to all nodes in the network from the current node
            Set<String> visited = new HashSet<>();
            visited.add(node);
            while (visited.size() < connectivityInfo.keySet().size()) {
                String minNode = null;
                int minDist = INF;
                for (String n : distances.keySet()) {
                    if (!visited.contains(n) && distances.get(n) < minDist) {
                        minNode = n;
                        minDist = distances.get(n);
                    }
                }
                if (minNode == null) {
                    break;
                }
                visited.add(minNode);
                for (String neighbor : connectivityInfo.get(minNode)) {
                    int altDist = distances.get(minNode) + 1;
                    if (altDist < distances.get(neighbor)) {
                        distances.put(neighbor, altDist);
                        nextHops.put(neighbor, nextHops.get(minNode));
                    }
                }
            }
            // Store the resulting routing table for the current node in the routingTables map
            routingTables.put(node, nextHops);
        }
        // Return the routingTables map containing the routing tables for all nodes in the network
        return routingTables;
    }
}