package ab1;

public class Counter {

	/**
 * the total count
 */
		private long count;
		
		public Counter(){
			count = 0;
		}
		
		/**
		 * increments the counter by 1
		 */
		public void increment(){
			count++;
		}
		
		/**
		 * increments the counter by {@code amount} amount
		 * @param amount the amount to add
		 */
		public void incrementBy(int amount){
			count += amount;
		}
		
		/**
		 * resets the counter to 0
		 */
		public void reset(){
			count = 0;
		}
		
		public long getCount(){
			return count;
		}
		
}

