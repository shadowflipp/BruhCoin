import java.util.ArrayList;
import com.google.gson.GsonBuilder; 

public class BruhCoin {
	
	public static ArrayList<Block> bruhChain = new ArrayList<Block>();
	public static int difficulty = 5;
	
	public static void main(String[] args) {
		
		bruhChain.add(new Block("Hi im the first Block", "0"));
		System.out.println("Trying to Mine block 1 ...");
		bruhChain.get(0).mineBlock(difficulty);
		
		bruhChain.add(new Block("Hi im the second Block", bruhChain.get(bruhChain.size()-1).hash));
		System.out.println("Trying to Mine block 2 ...");
		bruhChain.get(1).mineBlock(difficulty);
		
		bruhChain.add(new Block("Hi im the third Block", bruhChain.get(bruhChain.size()-1).hash));
		System.out.println("Trying to Mine block 1 ...");
		bruhChain.get(2).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String bruhChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(bruhChain);	
		System.out.println("\n The Block chain: ");
		System.out.println(bruhChainJson);
	}
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		
		for(int i = 1; i < bruhChain.size(); i++) {
			currentBlock = bruhChain.get(i);
			previousBlock = bruhChain.get(i - 1);
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash())){
				System.out.println("Current Hashes not equal");
				return false;
			}
			
			if(!previousBlock.hash.equals(currentBlock.previousHash)){
				System.out.println("Previous Hashes not equal");
				return false;
			}
			
		}
		return true;
	}
}
