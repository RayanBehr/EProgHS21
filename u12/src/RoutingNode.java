
import java.util.*;

// Implementieren Sie die noetigen Methoden.

public class RoutingNode implements Node {
	
	private Map<Integer, Node> routingTable;
	private Map<Integer, Integer> countTable; //id and the count 
	
	// Sie koennen Felder und Methoden hinzufuegen,
	// aber aendern Sie nicht die gegebenen Signaturen!
	
	RoutingNode(Map<Integer, Node> routingTable) {
		this.routingTable = routingTable;
		countTable = new HashMap<>();
		for(Integer id : routingTable.keySet())
			countTable.put(id, 0); //initialize all counts to 0
	}
	
	Map<Integer, Node> getRoutingTable() {
		return new HashMap<Integer, Node>(routingTable);
	}
	
	public Set<Integer> candidates(List<Set<Integer>> path) {		
		Set<Integer> validConnectionIds = new HashSet<>();
		// if connection id is in the 0-th set of path ( path.get(0) )
		// and if there exists an entry in routingTable
		for (Integer id : path.get(0))
			if(routingTable.containsKey(id))
				validConnectionIds.add(id);	
		return validConnectionIds;
	}
	
	public void incrementCount(int id) {
		countTable.put(id, countTable.get(id) + 1);
	}
	
	public int selectConnection(Set<Integer> candidates) {
		int minId = Integer.MAX_VALUE;
		int minCountId = Integer.MAX_VALUE; //if it's null then 
		for(Integer id : candidates)
		{
			if(minCountId > countTable.get(id))
			{
				minId = id;
				minCountId = countTable.get(id);	
				
			} else if (minCountId == countTable.get(id))
			{
				minId = Math.min(minId, id);
			}
		}
		return minId;
	}
	
	@Override
	public void receive(Message msg) {
		List<Set<Integer>> path = new LinkedList<Set<Integer>>(msg.getPath());
		if (path.isEmpty()) {
			process(msg);
		} else {
			Set<Integer> candidates = candidates(path);
			if (!candidates.isEmpty()) {
				Integer target = selectConnection(candidates);
				
				List<Set<Integer>> newPath = path.subList(1, path.size());
				Message newMsg = msg.withPath(newPath);
				incrementCount(target);
				
				routingTable.get(target).receive(newMsg);
			}
		}
	}
	
	public void process(Message msg) {
		if(msg instanceof UpdateMessage)
		{
			UpdateMessage msgDown = (UpdateMessage)msg; // down cast
			
			// routingTable eintrag hinzufügen
			int newId = msgDown.newId;
			routingTable.put(newId, msgDown.newNode);
			countTable.put(newId, 0);
		}
				
	}
	
}
