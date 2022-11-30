import java.util.ArrayList;
import com.google.gson.GsonBuilder; 

public class BruhCoin {
	public static ArrayList<Block> bruhChain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
		bruhChain.add(new Block("Hi im the first Block", "0"));
		bruhChain.add(new Block("Hi im the second Block", bruhChain.get(bruhChain.size()-1).hash));
		bruhChain.add(new Block("Hi im the third Block", bruhChain.get(bruhChain.size()-1).hash));
		
		String bruhChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(bruhChain);	
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
